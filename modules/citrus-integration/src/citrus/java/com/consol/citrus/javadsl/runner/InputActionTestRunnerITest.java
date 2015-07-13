/*
 * Copyright 2006-2015 the original author or authors.
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
 */

package com.consol.citrus.javadsl.runner;

import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.dsl.definition.InputActionDefinition;
import com.consol.citrus.dsl.runner.TestActionConfigurer;
import com.consol.citrus.dsl.testng.TestNGCitrusTestRunner;
import org.testng.annotations.Test;

/**
 * @author Christoph Deppisch
 */
@Test
public class InputActionTestRunnerITest extends TestNGCitrusTestRunner {
    
    @CitrusTest
    public void InputActionTestRunnerITest() {
        variable("userinput", "");
        variable("userinput1", "");
        variable("userinput2", "y");
        variable("userinput3", "yes");
        variable("userinput4", "");
        
        input(new TestActionConfigurer<InputActionDefinition>() {
            @Override
            public void configure(InputActionDefinition definition) {
            }
        });
        echo("user input was: ${userinput}");
        input(new TestActionConfigurer<InputActionDefinition>() {
            @Override
            public void configure(InputActionDefinition definition) {
                definition.message("Now press enter:").result("userinput1");
            }
        });
        echo("user input was: ${userinput1}");
        input(new TestActionConfigurer<InputActionDefinition>() {
            @Override
            public void configure(InputActionDefinition definition) {
                definition.message("Do you want to continue?").answers("y", "n").result("userinput2");
            }
        });
        echo("user input was: ${userinput2}");
        input(new TestActionConfigurer<InputActionDefinition>() {
            @Override
            public void configure(InputActionDefinition definition) {
                definition.message("Do you want to continue?").answers("yes", "no").result("userinput3");
            }
        });
        echo("user input was: ${userinput3}");
        input(new TestActionConfigurer<InputActionDefinition>() {
            @Override
            public void configure(InputActionDefinition definition) {
                definition.result("userinput4");
            }
        });
        echo("user input was: ${userinput4}");
    }
}