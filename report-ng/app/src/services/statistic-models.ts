/*
 * Testerra
 *
 * (C) 2020, Mike Reiche, T-Systems Multimedia Solutions GmbH, Deutsche Telekom AG
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

import {data} from "./report-model";
import {Container} from "aurelia-framework";
import {StatusConverter} from "./status-converter";
import ResultStatusType = data.ResultStatusType;
import ExecutionAggregate = data.ExecutionAggregate;
import MethodType = data.MethodType;
import IMethodContext = data.IMethodContext;
import IClassContext = data.IClassContext;
import IErrorContext = data.IErrorContext;

class Statistics {
    private _statusConverter: StatusConverter
    constructor() {
        this._statusConverter = Container.instance.get(StatusConverter);
    }

    private _resultStatuses: { [key: number]: number } = {};

    addResultStatus(status: ResultStatusType) {
        if (!this._resultStatuses[status]) {
            this._resultStatuses[status] = 0;
        }
        this._resultStatuses[status]++;
    }

    get availableStatuses() {
        const statuses = [];
        for (const status in this._resultStatuses) {
            statuses.push(status);
        }
        return statuses;
    }

    get overallTestCases() {
        return this.getStatusesCount(this._statusConverter.relevantStatuses);
    }

    get overallPassed() {
        return this.getStatusesCount(this._statusConverter.passedStatuses);
    }

    get overallSkipped() {
        return this.getStatusCount(ResultStatusType.SKIPPED);
    }

    get overallFailed() {
       return this.getStatusesCount(this._statusConverter.failedStatuses);
    }

    getStatusCount(status: ResultStatusType) {
        return this._resultStatuses[status] | 0;
    }

    getStatusesCount(statuses:number[]) {
        let count = 0;
        statuses.forEach(value => {
            count += this.getStatusCount(value);
        })
        return count;
    }

    protected addStatistics(statistics: Statistics) {
        for (const status in statistics._resultStatuses) {
            if (!this._resultStatuses[status]) {
                this._resultStatuses[status] = 0;
            }
            this._resultStatuses[status] += statistics._resultStatuses[status];
        }
    }

    get statusConverter() {
        return this._statusConverter;
    }
}

export class ExecutionStatistics extends Statistics {
    private _executionAggregate: ExecutionAggregate;
    private _classStatistics: ClassStatistics[] = [];
    private _failureAspectStatistics:FailureAspectStatistics[] = [];

    setExecutionAggregate(executionAggregate: ExecutionAggregate) {
        this._executionAggregate = executionAggregate;
        return this;
    }

    addClassStatistics(classStatistics: ClassStatistics) {
        this._classStatistics.push(classStatistics);
    }

    updateStatistics() {
        this._classStatistics.forEach(classStatistics => this.addStatistics(classStatistics));
    }

    private _addUniqueFailureAspect(errorContext:IErrorContext, methodContext:IMethodContext) {
        let failureAspectStatistics = new FailureAspectStatistics().setErrorContext(errorContext);

        const foundFailureAspectStatistics = this._failureAspectStatistics.find(existingFailureAspectStatistics => {
            return existingFailureAspectStatistics.name == failureAspectStatistics.name;
        });

        if (foundFailureAspectStatistics) {
            failureAspectStatistics = foundFailureAspectStatistics;
        } else {
            this._failureAspectStatistics.push(failureAspectStatistics);
        }
        failureAspectStatistics.addMethodContext(methodContext);
    }

    protected addStatistics(classStatistics: ClassStatistics) {
        super.addStatistics(classStatistics);
        classStatistics.methodContexts
            .forEach(methodContext => {

                if (methodContext.errorContext) {
                    this._addUniqueFailureAspect(methodContext.errorContext, methodContext);
                }

                methodContext.testSteps
                    .flatMap(value => value.actions)
                    .flatMap(value => value.entries)
                    .filter(value => value.assertion)
                    .map(value => value.assertion)
                    .forEach(value => {
                        this._addUniqueFailureAspect(value, methodContext);
                    })

                // const exitPointStatistics = new ExitPointStatistics().addMethodContext(methodContext);
                //
                // const foundExitPointStatistics = this._exitPointStatistics.find(existingExitPointStatistics => {
                //     return existingExitPointStatistics.fingerprint == exitPointStatistics.fingerprint;
                // });
                // if (foundExitPointStatistics) {
                //     foundExitPointStatistics.addMethodContext(exitPointStatistics.methodContext);
                // } else {
                //     this._exitPointStatistics.push(exitPointStatistics);
                // }
            })

        // Sort failure aspects by fail count
        this._failureAspectStatistics = this._failureAspectStatistics.sort((a, b) => b.overallFailed-a.overallFailed);

        for (let i = 0; i < this._failureAspectStatistics.length; ++i) {
            this._failureAspectStatistics[i].index = i;
        }
    }

    get executionAggregate() {
        return this._executionAggregate;
    }

    get classStatistics() {
        return this._classStatistics;
    }
    //
    // get exitPointStatistics() {
    //     return this._exitPointStatistics;
    // }

    get failureAspectStatistics() {
        return this._failureAspectStatistics;
    }
}

export class ClassStatistics extends Statistics {
    private _configStatistics = new Statistics();
    private _methodContexts:IMethodContext[] = [];
    private _classContext:IClassContext;
    private _classIdentifier;

    setClassContext(classContext : IClassContext) {
        this._classContext = classContext;
        this._classIdentifier = classContext.testContextName || this.statusConverter.separateNamespace(classContext.fullClassName).class;
        return this;
    }

    addMethodContext(methodContext : IMethodContext) {
        if (methodContext.methodType == MethodType.CONFIGURATION_METHOD) {
            this._configStatistics.addResultStatus(methodContext.resultStatus);
        } else {
            this.addResultStatus(methodContext.resultStatus);
        }
        this._methodContexts.push(methodContext);
        return this;
    }

    get classContext() {
        return this._classContext;
    }

    get methodContexts() {
        return this._methodContexts;
    }

    get configStatistics() {
        return this._configStatistics;
    }

    get classIdentifier() {
        return this._classIdentifier;
    }
}


export class FailureAspectStatistics extends Statistics {

    private _methodContexts:IMethodContext[] = [];
    private _name:string;
    public index:number;

    constructor() {
        super();
    }

    setErrorContext(errorContext:IErrorContext) {
        if (errorContext.description) {
            this._name = errorContext.description;
        } else {
            const cause = errorContext.stackTrace[0];
            const namespace = this.statusConverter.separateNamespace(cause.className);
            this._name = namespace.class + (cause.message ? ": " + cause.message.trim() : "");
        }

        return this;
    }

    addMethodContext(methodContext:IMethodContext) {
        this._methodContexts.push(methodContext);
        this.addResultStatus(methodContext.resultStatus);
        return this;
    }

    /**
     * A failure aspect is minor when it has no statuses in failed state
     */
    get isMinor() {
        return this.getStatusesCount(this.statusConverter.failedStatuses) == 0;
    }

    get name() {
        return this._name;
    }

    get methodContexts() {
        return this._methodContexts;
    }
}
