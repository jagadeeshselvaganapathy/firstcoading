package com.apifive;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

//post

public class Sample {
public static void main(String[] args) {
	RequestSpecification reqSpec; 
	 reqSpec = RestAssured.given();
	 reqSpec.header("Content-Type","application/json");
	 reqSpec = reqSpec.body("{\r\n" + 
	 		"    \"name\": \"morpheus\",\r\n" + 
	 		"    \"job\": \"leader\",\r\n" + 
	 		"    \"id\": \"145\",\r\n" + 
	 		"    \"createdAt\": \"2022-07-25T23:54:32.422Z\"\r\n" + 
	 		"}");
	 Response r = reqSpec.get("https://reqres.in/api/users");
	 int statusCode = r.getStatusCode();
	 System.out.println(statusCode);
	 ResponseBody body = r.getBody();
	 String asString = body.asString();
	 System.out.println(asString);
	 String a = r.asPrettyString();
	 System.out.println(a);
	 
}
}
