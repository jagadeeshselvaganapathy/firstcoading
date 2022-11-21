package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoint.Endpoint;
import com.pojo.Root;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Tc1_LoginStep extends BaseClass {
	int responseCode;
	Response response;
	static String logtoken;

	@Given("user add header")
	public void user_add_header() {
		addHeader("accept", "application/json");

	}

	@Given("user add basic authentication for login")
	public void user_add_basic_authentication_for_login() {
		basicAuth("jagadeeshpragadeesh@gmail.com", "Jaga@praga123");
	}

	@When("user sent POST request for login request")
	public void user_sent_POST_request_for_login_request() {
		response = requestType("POST", Endpoint.POSTMANBASICAUTHLOGIN);

	}

	@Then("user verify the status code is {int}")
	public void user_verify_the_status_code_is(Integer int1) {
		responseCode = getResponseCode(response);
		Assert.assertEquals("verify status code", 200, responseCode);
		System.out.println(responseCode);

	}

	@Then("user verify the login respose body first name is {string} and get logtok+en should saved")
	public void user_verify_the_login_respose_body_first_name_is_and_get_logtok_en_should_saved(String string) {

		Root as = response.as(Root.class);
		String first_name = as.getData().getFirst_name();
		Assert.assertEquals("Login successfully", "jagadeesh", first_name);
		System.out.println(first_name);
	    logtoken = as.getData().getLogtoken();

	}
}
