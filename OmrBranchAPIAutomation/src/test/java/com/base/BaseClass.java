package com.base;

import java.io.File;

import com.pojo.AddAddress_Input_pojo;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {

	RequestSpecification req;
	protected Response response;
	
	/**
	 * 
	 * @param key
	 * @param value
	 */

	public void addHeader(String key, String value) {

		req = RestAssured.given().header(key, value);

	}
	
	/**
	 * 
	 * @param header
	 */

	public void addHeaders(Headers header) {
		req = RestAssured.given().headers(header);
	}
	
	/**
	 * 
	 * @param type
	 * @param endpoint
	 * @return
	 */

	public Response requestType(String type, String endpoint) {
		switch (type) {
		case "GET":
			response = req.get(endpoint);
			break;
		case "POST":
			response = req.post(endpoint);
			break;
		case "PUT":
			response = req.put(endpoint);
			break;
		case "DELETE":
			response = req.delete(endpoint);
			break;

		default:
			break;
		}
		return response;
	}
	
	/**
	 * 
	 * @param json
	 */

	public void addBody(Object json) {
		req = req.body(json);
	}
	
	/**
	 * 
	 * @param response
	 * @return
	 */

	public int getResponseCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;
	}
	
	/**
	 * 
	 * @param response
	 * @return
	 */

	public String getPrettyString(Response response) {
		String pretty = response.asPrettyString();
		return pretty;
	}
	
	/**
	 * 
	 * @param username
	 * @param password
	 */

	public void basicAuth(String username, String password) {
		req = req.auth().preemptive().basic(username, password);
	}
	
	/**
	 * 
	 * @param s
	 * @return
	 */

	public int parse(String s) {
		int int1 = Integer.parseInt(s);
		return int1;
	}
	
	/**
	 * @
	 * @param i
	 * @return
	 */

	public String id(int i) {
		String string = String.valueOf(i);
		return string;

	}
	
	/**
	 * 
	 */

	public void formData() {

		req.multiPart("profile_picture", new File("D:\\tnd.png"));
	}

}
