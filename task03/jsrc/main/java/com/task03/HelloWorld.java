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

	public Map<String, Object> handleRequest(Object request, Context context) {
		Map<String, Object> responseMap = new HashMap<>();
        
      
        responseMap.put("statusCode", 200);

     
        responseMap.put("headers", Collections.singletonMap("Content-Type", "application/json"));
        
     
        Map<String, String> bodyMap = new HashMap<>();
        bodyMap.put("message", "Hello from Lambda");
        responseMap.put("body", bodyMap);

   
        return responseMap;}
}
