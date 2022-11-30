package com.apisix;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.endpoint.Endpoint;
import com.pojo.Login_Output_Pojo;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import junit.framework.Assert;

public class Sample extends BaseClass {

	@Test
	private void firstName() {
		addheader("accept", "application/json");
		basicAuth("jagadeeshpragadeesh@gmail.com", "Jaga@praga123");
		Response response = requestType("POST", Endpoint.POSTMANBASICAUTHLOGIN);
		int responseCode = getResponseCode(response);
		// Desrialization
		Assert.assertEquals("verify status code", 200, responseCode);
		Login_Output_Pojo output_Pojo = response.as(Login_Output_Pojo.class);
		String first_name = output_Pojo.getData().getFirst_name();
		Assert.assertEquals("verify first name", "Greens", first_name);
	}

	/*
	 * @Test private void login() { List<Header>h = new ArrayList<>(); Header h1 =
	 * new Header("accept", "application/json"); Header h2 = new
	 * Header("Content-Type", "application/json"); h.add(h1); h.add(h2); Headers
	 * header = new Headers(h); addHeader(header);
	 * 
	 * }
	 */
}
