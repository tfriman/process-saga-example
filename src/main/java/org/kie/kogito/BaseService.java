/**
 *  Copyright 2021 Red Hat, Inc. and/or its affiliates.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.kie.kogito;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private MockService mockService;

    private String resourceName;

    BaseService() {
    }

    public BaseService(MockService mockService, String resourceName) {
        this.mockService = mockService;
        this.resourceName = resourceName;
    }

    public Response create(String id, String failService) {
        final Response response = mockService.execute(failService, resourceName);
        logger.info("Created {} for {} with Id: {}", resourceName, id, response.getResourceId());
        return response;
    }

    public Response cancel(String id) {
        logger.warn("Cancel {} for {}", resourceName, id);
        return new Response(Response.Type.SUCCESS, id);
    }
}
