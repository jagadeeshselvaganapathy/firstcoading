package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoint.Endpoint;
import com.pojo.ProfilePic_Output_Pojo;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;

public class Tc3_Profilepic extends BaseClass{

	@When("User add headers for change profile picture endpoint")
	public void userAddHeadersForChangeProfilePictureEndpoint() {
		List<Header> l = new ArrayList<>();
		Header h = new Header("accept", "application/json");
		Header h1 = new Header("Authorization", "Bearer " + Tc1_LoginStep.logtoken);
		Header h2 = new Header("Content-Type", "multipart/form-data");
		l.add(h);
		l.add(h1);
		l.add(h2);
		Headers h3 = new Headers(l);
		addHeaders(h3);

	}

	@Then("User add  the pay load for adding the profile pic")
	public void userAddThePayLoadForAddingTheProfilePic() {
		formData();
	}

	@Then("User send POST request for Change profile pic  Endpoint")
	public void userSendPOSTRequestForChangeProfilePicEndpoint() {
		requestType("POST", Endpoint.PROFILEPIC);
	}

	@Then("User verify the status code is {int} for changing profile picture")
	public void userVerifyTheStatusCodeIsForChangingProfilePicture(Integer int1) {
		int code = getResponseCode(response);
		Assert.assertEquals("verify", 200, code);
		System.out.println(code);
	}

	@Then("User verify the change profile pic response body message {string}")
	public void userVerifyTheChangeProfilePicResponseBodyMessage(String string) {
		ProfilePic_Output_Pojo out = response.as(ProfilePic_Output_Pojo.class);
		String message = out.getMessage();
		System.out.println(message);
		Assert.assertEquals("Verify profile picture ", "Profile updated Successfully", message);
		
	}
}
