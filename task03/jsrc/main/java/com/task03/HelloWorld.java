package com.task03;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.syndicate.deployment.annotations.lambda.LambdaHandler;
import com.syndicate.deployment.model.RetentionSetting;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@LambdaHandler(
    lambdaName = "hello_world",
	roleName = "hello_world-role",
	isPublishVersion = false,

	logsExpiration = RetentionSetting.SYNDICATE_ALIASES_SPECIFIED
)
public class HelloWorld implements RequestHandler<Object, Map<String, Object>> {

	@Override
	public Map<String, Object> handleRequest(Object request, Context context) {
		Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("statusCode", 200);
        responseBody.put("message", "Hello from Lambda");

        // Convert the response body map to JSON string
        String bodyJson = "{\"statusCode\":" + responseBody.get("statusCode") + ", \"message\":\"" + responseBody.get("message") + "\"}";

        // Construct the result map with status code, body, and headers
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("statusCode", 200);
        resultMap.put("body", bodyJson);
        resultMap.put("headers", Collections.singletonMap("Content-Type", "application/json"));

		return resultMap;
	}
}
