/*
    Copyright 2018 Booz Allen Hamilton

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/
package org.boozallen.plugins.jte.init.governance.libs

import hudson.model.AbstractDescribableImpl
import hudson.model.Descriptor
import org.jenkinsci.plugins.workflow.flow.FlowExecutionOwner

/**
 * base class for different mechanisms to load a library
 */
abstract class LibraryProvider extends AbstractDescribableImpl<LibraryProvider>{

    public static final String CONFIG_FILE = "library_config.groovy"

    abstract Boolean hasLibrary(FlowExecutionOwner flowOwner, String libraryName)
    abstract String getLibrarySchema(FlowExecutionOwner flowOwner, String libraryName)
    abstract void loadLibrary(FlowExecutionOwner flowOwner, Binding binding, String libName, Map libConfig)

    static class LibraryProviderDescriptor extends Descriptor<LibraryProvider> {}

}
