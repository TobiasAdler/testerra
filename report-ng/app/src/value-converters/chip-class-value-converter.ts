/*
 * Testerra
 *
 * (C) 2023, Selina Natschke, Deutsche Telekom MMS GmbH, Deutsche Telekom AG
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

import {autoinject} from "aurelia-framework";
import {ChipType} from "../services/common-models";

@autoinject()
export class ChipClassValueConverter {
    // all other Chip types use the default class configurations for Chips from mdc
    toView(chipType: ChipType) {
        switch (chipType) {
            case ChipType.STATUS:
                return "status";
            case ChipType.CLASS:
                return "class";
            case ChipType.CUSTOM_TEXT:
                return "text";
        }
    }
}
