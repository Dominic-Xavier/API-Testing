package com.restapi;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.*;

public class GetRequest {
	
	
String uri = "https://reqres.in/api/users?page=2";
	
  @Test
  private void test1() {
	  
	  Response response = get(uri);
	  System.out.println(response.asString());
	  System.out.println(response.getBody().asString());
	  System.out.println(response.getStatusCode());
	  System.out.println(response.getStatusLine());
	  System.out.println(response.getHeader("content-type"));
	  System.out.println(response.getTime());
	  
	  int statusCode = response.getStatusCode();
	  
	  Assert.assertEquals(statusCode, 200);
  }
  
  @Test
  private void test2() {
	  ValidatableResponse statusCode = given().get(uri)
	  	.then()
	  	.statusCode(200)
	  	.body("data[0].first_name", equalTo("michael"));
  }
}
