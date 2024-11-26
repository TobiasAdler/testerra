/*
 * Testerra
 *
 * (C) 2024, Tobias Adler, Deutsche Telekom MMS GmbH, Deutsche Telekom AG
 *
 * Deutsche Telekom AG and all other contributors /
 * copyright owners license this file to you under the Apache
 * License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import {autoinject, bindable, observable} from "aurelia-framework";
import {AbstractViewModel} from "../abstract-view-model";
import {
    IntlDateFormatValueConverter
} from "t-systems-aurelia-components/src/value-converters/intl-date-format-value-converter";
import {
    DurationFormatValueConverter
} from "t-systems-aurelia-components/src/value-converters/duration-format-value-converter";
import {MethodHistoryStatistics} from "../../services/statistic-models";
import {ECharts, EChartsOption} from "echarts";
import {StatusConverter} from "../../services/status-converter";
import {StatisticsGenerator} from "../../services/statistics-generator";
import {Container} from "aurelia-dependency-injection";
import "./method-history-chart.scss"
import {ResultStatusType} from "../../services/report-model/framework_pb";

@autoinject()
export class MethodHistoryChart extends AbstractViewModel {
    private _dateFormatter: IntlDateFormatValueConverter;
    private _durationFormatter: DurationFormatValueConverter;
    @observable() private _chart: ECharts;
    @bindable method_history_statistics: MethodHistoryStatistics;
    private _option: EChartsOption;
    private _data: any[] = [];
    private _lineStart: number[] = [];
    private _lineEnd: number[] = [];
    private _opacityOfInactiveElements = 0.38;  // Default opacity of disabled elements https://m2.material.io/design/interaction/states.html#disabled

    constructor(
        private _statusConverter: StatusConverter,
        private _statisticsGenerator: StatisticsGenerator,
    ) {
        super();
        this._option = {};
    }

    async attached() {
        this._initDateFormatter();
        this._initDurationFormatter();
        this._prepareChartData();
        this._setChartOption();
    };

    private _initDurationFormatter() {
        const container = new Container();
        this._durationFormatter = container.get(DurationFormatValueConverter);
        this._durationFormatter.setDefaultFormat("h[h] m[min] s[s] S[ms]");
    }

    private _initDateFormatter() {
        const container = new Container();
        this._dateFormatter = container.get(IntlDateFormatValueConverter);
        this._dateFormatter.setLocale('en-GB');
        this._dateFormatter.setOptions('date', {year: 'numeric', month: 'short', day: 'numeric'});
        this._dateFormatter.setOptions('time', {hour: 'numeric', minute: 'numeric', second: 'numeric', hour12: false});
        this._dateFormatter.setOptions('full', {
            year: 'numeric',
            month: 'short',
            day: 'numeric',
            hour: 'numeric',
            minute: 'numeric',
            second: 'numeric',
            hour12: false
        });
    }

    private _prepareChartData() {
        const style = new Map<number, string>();
        style.set(ResultStatusType.PASSED, this._statusConverter.getColorForStatus(ResultStatusType.PASSED));
        style.set(ResultStatusType.REPAIRED, this._statusConverter.getColorForStatus(ResultStatusType.REPAIRED));
        style.set(ResultStatusType.PASSED_RETRY, this._statusConverter.getColorForStatus(ResultStatusType.PASSED_RETRY));
        style.set(ResultStatusType.SKIPPED, this._statusConverter.getColorForStatus(ResultStatusType.SKIPPED));
        style.set(ResultStatusType.FAILED, this._statusConverter.getColorForStatus(ResultStatusType.FAILED));
        style.set(ResultStatusType.FAILED_EXPECTED, this._statusConverter.getColorForStatus(ResultStatusType.FAILED_EXPECTED));
        style.set(ResultStatusType.FAILED_MINOR, this._statusConverter.getColorForStatus(ResultStatusType.FAILED_MINOR));
        style.set(ResultStatusType.FAILED_RETRIED, this._statusConverter.getColorForStatus(ResultStatusType.FAILED_RETRIED));

        this.method_history_statistics.getRuns().forEach(run => {

            const startTime = run.context.contextValues.startTime;
            const endTime = run.context.contextValues.endTime;
            const status = run.context.resultStatus;
            let errorMessage = "";

            if (status != ResultStatusType.PASSED) {
                run.context.testSteps.flatMap(value => value.actions)
                    .forEach(actionDetails => {
                        actionDetails.entries.forEach(entry => {
                            const errorContext = entry.errorContext;
                            errorContext.stackTrace.forEach(stackTrace => {
                                // TODO: How to handle multiple errorMessages
                                errorMessage = errorMessage.concat(stackTrace.className + ": " + stackTrace.message + " ");
                            })
                        })
                    });
            }

            this._data.push({
                status: status,
                statusName: this._statusConverter.getLabelForStatus(status),
                errorMessage: errorMessage,
                itemStyle: {
                    color: style.get(status),
                    opacity: 1
                },
                startTime: startTime,
                endTime: endTime,
                duration: endTime - startTime,
                value: [run.historyIndex, 0]
            });
        });

        this._lineStart = this._data[0].value;
        this._lineEnd = this._data[this._data.length - 1].value;
    }

    private _setChartOption() {
        const dateFormatter = this._dateFormatter;
        const durationFormatter = this._durationFormatter;

        this._option = {
            grid: {
                top: '20%',
                bottom: '40%',
                left: '2%',
                right: '2%'
            },
            tooltip: {
                trigger: 'item',
                formatter: function (params) {
                    let tooltip = '<div class="header" style="background-color: ' +
                        params.color + ';">Run ' + params.value[0] + ": " + params.data.statusName + '</div>'

                    if (params.data.errorMessage) {
                        tooltip += '<br><div class="tooltip-content">' + params.data.errorMessage + '</div>';
                    }

                    tooltip += '<br>Start time: ' + dateFormatter.toView(params.data.startTime, 'full')
                        + '<br>End time: ' + dateFormatter.toView(params.data.endTime, 'full')
                        + '<br>Duration: ' + durationFormatter.toView(params.data.duration);

                    return tooltip;
                }
            },
            xAxis: {
                type: 'category',
                show: true
            },
            yAxis: {
                type: 'category',
                show: false
            },
            series: [
                {
                    type: 'scatter',
                    symbolSize: 20,
                    data: this._data,
                    z: 2
                },
                {
                    // This series represents a static line for visual reference, with no interaction or tooltip.
                    type: 'line',
                    data: [
                        this._lineStart, this._lineEnd
                    ],
                    lineStyle: {
                        color: '#A0A0A0',
                        width: 1
                    },
                    markLine: {
                        symbol: 'none'
                    },
                    z: 1,
                    silent: true
                }
            ]
        };
    }
}