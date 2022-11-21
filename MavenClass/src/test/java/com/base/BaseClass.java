package com.base;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	RequestSpecification reqSpec;
	Response response;
	
	
public void addheader(String key,String value) {
 reqSpec = RestAssured.given().header(key,value);
}

public void addHeader(Headers headers) {
 reqSpec = RestAssured.given().headers(headers);
}

public void basicAuth(String username,String password) {
	reqSpec = reqSpec.auth().preemptive().basic(username, password);
}

public void quaryParameter(String key,String value) {
 reqSpec = reqSpec.queryParam(key, value);
}

public void addBody(String body) {
	reqSpec = reqSpec.body(body);
}

public Response requestType(String type,String endpoint) {
switch (type) {
case "GET":
	 response = reqSpec.get(endpoint);
	break;
case "POST":
	 response = reqSpec.post(endpoint);
	break;
case "PUT":
	 response = reqSpec.put(endpoint);
	break;
case "DELETE":
	 response = reqSpec.delete(endpoint);
	break;

	
default:
	break;
}
return response;
}

public int getResponseCode(Response response) {
int statusCode = response.getStatusCode();
return statusCode;
}

public String getBodyasString(Response response) {
String asString = response.asString();
return asString;
}

public String bodyPretty(Response response) {
String pretty = response.asPrettyString();
return pretty;
}












}
