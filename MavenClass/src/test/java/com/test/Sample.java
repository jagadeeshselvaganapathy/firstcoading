package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pojo.Login_Output_Pojo;

import io.restassured.response.Response;

public class Sample extends BaseClass {
	@Test

	public void getUser() {

		addheader("accept", "application/json");
		basicAuth("jagadeeshpragadeesh@gmail.com", "Jaga@praga123");
		Response response = requestType("POST", "https://omrbranch.com/api/postmanBasicAuthLogin");
		int responseCode = getResponseCode(response);
		System.out.println(responseCode);
		Assert.assertEquals(responseCode, 200,"Verified status code");
		Login_Output_Pojo pojo = response.as(Login_Output_Pojo.class);
		String name = pojo.getData().getLast_name();
		Assert.assertEquals(name, "selvaganapathy","verify last name");
		System.out.println(name);
		

	}}
