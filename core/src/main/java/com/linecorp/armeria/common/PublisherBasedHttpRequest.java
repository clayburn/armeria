/*
 * Copyright 2016 LINE Corporation
 *
 * LINE Corporation licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.linecorp.armeria.common;

import java.util.concurrent.CompletableFuture;

import org.reactivestreams.Publisher;

import com.linecorp.armeria.common.stream.PublisherBasedStreamMessage;

final class PublisherBasedHttpRequest extends PublisherBasedStreamMessage<HttpObject> implements HttpRequest {

    private final RequestHeaders headers;

    PublisherBasedHttpRequest(RequestHeaders headers, Publisher<? extends HttpObject> publisher) {
        super(publisher);
        this.headers = headers;
    }

    @Override
    public RequestHeaders headers() {
        return headers;
    }

    @SuppressWarnings("unchecked")
    @Override
    public CompletableFuture<AggregatedHttpRequest> aggregate(AggregationOptions options) {
        return super.aggregate(options);
    }
}
