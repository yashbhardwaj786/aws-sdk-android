/*
 * Copyright 2010-2020 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.services.autoscaling.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

/**
 * StAX request marshaller for DetachLoadBalancerTargetGroupsRequest
 */
public class DetachLoadBalancerTargetGroupsRequestMarshaller
        implements
        Marshaller<Request<DetachLoadBalancerTargetGroupsRequest>, DetachLoadBalancerTargetGroupsRequest> {

    public Request<DetachLoadBalancerTargetGroupsRequest> marshall(
            DetachLoadBalancerTargetGroupsRequest detachLoadBalancerTargetGroupsRequest) {
        if (detachLoadBalancerTargetGroupsRequest == null) {
            throw new AmazonClientException(
                    "Invalid argument passed to marshall(DetachLoadBalancerTargetGroupsRequest)");
        }

        Request<DetachLoadBalancerTargetGroupsRequest> request = new DefaultRequest<DetachLoadBalancerTargetGroupsRequest>(
                detachLoadBalancerTargetGroupsRequest, "AmazonAutoScaling");
        request.addParameter("Action", "DetachLoadBalancerTargetGroups");
        request.addParameter("Version", "2011-01-01");

        String prefix;
        if (detachLoadBalancerTargetGroupsRequest.getAutoScalingGroupName() != null) {
            prefix = "AutoScalingGroupName";
            String autoScalingGroupName = detachLoadBalancerTargetGroupsRequest
                    .getAutoScalingGroupName();
            request.addParameter(prefix, StringUtils.fromString(autoScalingGroupName));
        }
        if (detachLoadBalancerTargetGroupsRequest.getTargetGroupARNs() != null) {
            prefix = "TargetGroupARNs";
            java.util.List<String> targetGroupARNs = detachLoadBalancerTargetGroupsRequest
                    .getTargetGroupARNs();
            int targetGroupARNsIndex = 1;
            String targetGroupARNsPrefix = prefix;
            for (String targetGroupARNsItem : targetGroupARNs) {
                prefix = targetGroupARNsPrefix + ".member." + targetGroupARNsIndex;
                if (targetGroupARNsItem != null) {
                    request.addParameter(prefix, StringUtils.fromString(targetGroupARNsItem));
                }
                targetGroupARNsIndex++;
            }
            prefix = targetGroupARNsPrefix;
        }

        return request;
    }
}
