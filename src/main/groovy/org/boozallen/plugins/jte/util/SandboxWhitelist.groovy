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
package org.boozallen.plugins.jte.util

import hudson.Extension
import org.jenkinsci.plugins.scriptsecurity.sandbox.whitelists.AbstractWhitelist

import java.lang.reflect.Method

/**
 * Whitelists JTE primitives as permitted within the Jenkins pipeline sandbox.
 */
@Extension class SandboxWhitelist extends AbstractWhitelist {

    private final ArrayList permittedReceivers = [
        "org.boozallen.plugins.jte.init.primitives.injectors.ApplicationEnvironment",
        "org.boozallen.plugins.jte.init.primitives.injectors.StepWrapper",
        "org.boozallen.plugins.jte.init.primitives.injectors.Stage",
        "org.boozallen.plugins.jte.init.primitives.hooks.Hooks"
    ]

    @Override
    boolean permitsMethod(Method method, Object receiver, Object[] args) {
        return receiver.getClass().getName() in permittedReceivers
    }

    @Override
    boolean permitsStaticMethod(Method method, Object[] args){
        return method.getDeclaringClass().getName() in permittedReceivers
    }

}
