/*
 * (C) Copyright T-Systems Multimedia Solutions GmbH 2018, ..
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Peter Lehmann <p.lehmann@t-systems.com>
 *     pele <p.lehmann@t-systems.com>
 */
/*
 * Created on 04.01.2013
 *
 * Copyright(c) 2011 - 2012 T-Systems Multimedia Solutions GmbH
 * Riesaer Str. 5, 01129 Dresden
 * All rights reserved.
 */
package eu.tsystems.mms.tic.testframework.pageobjects;

import eu.tsystems.mms.tic.testframework.pageobjects.internal.asserts.IImageAssertion;

/**
 * Components implementation
 * @author Mike Reiche
 */
public abstract class Component<SELF extends Component<SELF>> extends AbstractFluentPage<SELF> implements IComponent {

    protected final IGuiElement rootElement;
    private final Finder defaultFinder;

    public Component(IGuiElement rootElement) {
        super(rootElement.getWebDriver());
        this.rootElement = rootElement;
        defaultFinder = withAncestor(rootElement);
    }

    public IImageAssertion screenshot() {
        return rootElement.screenshot();
    }

    protected IGuiElement findOne(Locate locator) {
        return defaultFinder.findOne(locator);
    }

    @Override
    @Deprecated
    public Page refresh() {
        return super.refresh();
    }
}