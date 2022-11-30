package com.stepDefinition;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoint.Endpoint;
import com.pojo.Root;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class TC_2Login extends BaseClass{
	
	int responseCode;
	Response response;
	
	
	@Given("user add header")
	public void userAddHeader() {
		
		addHeader("accept", "application/json");
	}

	@Given("user add basic authentication for login")
	public void userAddBasicAuthenticationForLogin() {

		basicAuth("jagadeesh@gmail.com", "123456789");
	
	}

	@When("user sent POST request for login request")
	public void userSentPOSTRequestForLoginRequest() throws IOException {
		
		response = requestType(valueFromProperty("type1"), Endpoint.POSTMANBASICAUTHLOGIN);
		
	}

	@Then("user verify the status code is {int}")
	public void userVerifyTheStatusCodeIs(Integer int1) {
		
		responseCode = getResponseCode(response);
		Assert.assertEquals("verify status code", 200, responseCode);
		System.out.println(responseCode);

	}

	@Then("user verify the login respose body type is {string} and get logtok+en should saved")
	public void userVerifyTheLoginResposeBodyTypeIsAndGetLogtokEnShouldSaved(String string) {

		String prettyString = getPrettyString(response);
		System.out.println(prettyString);
		Root as = response.as(Root.class);
		String type = as.getType();
		System.out.println(type);
	}



}
