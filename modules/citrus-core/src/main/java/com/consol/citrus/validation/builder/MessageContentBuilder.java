/*
 * Copyright 2006-2010 the original author or authors.
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

package com.consol.citrus.validation.builder;

import org.springframework.integration.core.Message;

import com.consol.citrus.context.TestContext;

/**
 * Interface for classes beeing able to build control messages for validation.
 * 
 * @author Christoph Deppisch
 */
public interface MessageContentBuilder<T> {
    
    /**
     * Builds the control message. 
     * @param context the current test context.
     * @return the constructed message object.
     */
    public Message<T> buildMessageContent(TestContext context);
}