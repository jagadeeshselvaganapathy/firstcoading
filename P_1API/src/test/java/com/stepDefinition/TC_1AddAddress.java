package com.stepDefinition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoint.Endpoint;
import com.pojo.AddAddress_Input_pojo;
import com.pojo.AddAddress_Output_pojo;
import com.pojo.DeleteAddress_Input_Pojo;
import com.pojo.UpdateAddress_Input_Pojo;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class TC_1AddAddress extends BaseClass {

	Response response2;
	Response response3;
	Response response4;
	Response response5;

	@When("User add headers for add address endpoint")
	public void user_add_headers_for_add_address_endpoint() throws IOException {

		List<Header> l = new ArrayList<>();
		Header h = new Header("accept", "application/json");
		Header h1 = new Header("Authorization", "Bearer " + valueFromProperty("logtoken"));
		Header h2 = new Header("Content-Type", "application/json");
		l.add(h);
		l.add(h1);
		l.add(h2);
		Headers h3 = new Headers(l);
		addHeaders(h3);

	}

	@When("User add the payload{string},{string},{string},{string},{string} for adding address")
	public void user_add_the_payload_for_adding_address(String id, String name, String email, String gender,
			String status) {

		AddAddress_Input_pojo add = new AddAddress_Input_pojo(id, name, email, gender, status);
		addBody(add);

	}

	@When("User send POST request for Addaddress Endpoint")
	public void user_send_POST_request_for_Addaddress_Endpoint() throws IOException {

		response2 = requestType(valueFromProperty("type"), Endpoint.ADDADDDRESS);

	}

	@Then("User verify the status code is {int} for adding address")
	public void user_verify_the_status_code_is_for_adding_address(Integer int1) {

		int code = getResponseCode(response2);
		Assert.assertEquals("verify", 201, code);
		System.out.println(code);

	}

	@Then("User verify the address response body message {string} and save the address id")
	public void user_verify_the_address_response_body_message_and_save_the_address_id(String string) {

		AddAddress_Output_pojo as = response2.as(AddAddress_Output_pojo.class);
		int id = as.getId();
		System.out.println(id);
		String name = as.getName();
		System.out.println(name);
		String email = as.getEmail();
		System.out.println(email);
		String gender = as.getGender();
		System.out.println(gender);
		String status = as.getStatus();
		System.out.println(status);
		

	}

	@When("User add headers for get address endpoint")
	public void userAddHeadersForGetAddressEndpoint() throws IOException {

		List<Header> l = new ArrayList<>();
		Header h = new Header("accept", "application/json");
		Header h1 = new Header("Authorization", "Bearer " + valueFromProperty("logtoken"));
		Header h2 = new Header("Content-Type", "application/json");
		l.add(h);
		l.add(h1);
		l.add(h2);
		Headers h3 = new Headers(l);
		addHeaders(h3);

	}

	@When("user sent GET request for GET endpoints")
	public void userSentGETRequestForGETEndpoints() throws IOException {

		response3 = requestType(valueFromProperty("type1"), Endpoint.GETADDRESS);

	}

	@Then("User verify the status code is {int} for get address")
	public void userVerifyTheStatusCodeIsForGetAddress(Integer int1) {

		int code = getResponseCode(response3);
		Assert.assertEquals("verify", 200, code);
		System.out.println(code);

	}

	@Then("User verify the get address response body message")
	public void userVerifyTheGetAddressResponseBodyMessage() {

		String prettyString = getPrettyString(response3);
		System.out.println(prettyString);

	}

	@When("User add headers for update address endpoint")
	public void userAddHeadersForUpdateAddressEndpoint() throws IOException {

		List<Header> l = new ArrayList<>();
		Header h = new Header("accept", "application/json");
		Header h1 = new Header("Authorization", "Bearer " + valueFromProperty("logtoken"));
		Header h2 = new Header("Content-Type", "application/json");
		l.add(h);
		l.add(h1);
		l.add(h2);
		Headers h3 = new Headers(l);
		addHeaders(h3);

	}

	@When("User update the payload{string},{string},{string},{string},{string} for adding address")
	public void userUpdateThePayloadForAddingAddress(String id, String name, String email, String gender,
			String status) {

		UpdateAddress_Input_Pojo input = new UpdateAddress_Input_Pojo(id, name, email, gender, status);
		addBody(input);

	}

	@When("user sent PUT request for Update endpoints")
	public void userSentPUTRequestForUpdateEndpoints() throws IOException {

		response4 = requestType(valueFromProperty("type2"), Endpoint.UPDATEADDRESS);

	}

	@Then("User verify the status code is {int} for update address")
	public void userVerifyTheStatusCodeIsForUpdateAddress(Integer int1) {

		int code = getResponseCode(response4);
		Assert.assertEquals("verify", 200, code);
		System.out.println(code);

	}

	@Then("User verify the update address response body message")
	public void userVerifyTheUpdateAddressResponseBodyMessage() {

		String prettyString = getPrettyString(response4);
		System.out.println(prettyString);

	}

	@When("User add headers for delete address")
	public void userAddHeadersForDeleteAddress() throws IOException {

		List<Header> l = new ArrayList<>();
		Header h = new Header("accept", "application/json");
		Header h1 = new Header("Authorization", "Bearer " + valueFromProperty("logtoken"));
		Header h2 = new Header("Content-Type", "application/json");
		l.add(h);
		l.add(h1);
		l.add(h2);
		Headers h3 = new Headers(l);
		addHeaders(h3);

	}

	@When("User add the payload for deleting the address with {string}")
	public void userAddThePayloadForDeletingTheAddressWith(String Address_id) {

		DeleteAddress_Input_Pojo delete = new DeleteAddress_Input_Pojo(Address_id);
		System.out.println(Address_id);
		addBody(delete);

	}

	@When("user sent DELETE request for delete endpoints")
	public void userSentDELETERequestForDeleteEndpoints() throws IOException {

		response5 = requestType(valueFromProperty("type3"), Endpoint.DELETEADDRESS);

	}

	@Then("User verify the status code is {int} for deleting address")
	public void userVerifyTheStatusCodeIsForDeletingAddress(Integer int1) {

		int code = getResponseCode(response5);
		System.out.println(code);
		Assert.assertEquals("verify", 204, code);
		System.out.println(code);

	}

	@Then("User verify the delete address response body message")
	public void userVerifyTheDeleteAddressResponseBodyMessage() {

		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.header("Content-Type", "application/json");
		Response response2 = reqSpec.get("https://reqres.in/api/users/4260");

		int statusCode = response2.getStatusCode();
		System.out.println(statusCode);
		ResponseBody body = response2.getBody();
		String asString = body.asString();
		System.out.println(asString);
		String string = response2.asPrettyString();
		System.out.println(string);

	}

}