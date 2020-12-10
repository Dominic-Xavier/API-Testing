package com.restapi;

import org.testng.annotations.Test; 
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class TestsGet {
	
	String uri = "https://reqres.in/api/users?page=2";
	JSONObject data;
	
  @Test
  public void test_1_get() {
	  baseURI = uri;
	  given()
	  	.get(uri)
	  .then()
	  	.statusCode(200)
	  .body("data.last_name[0]", equalTo("Lawson"))
	  	.body("data.first_name", hasItems("Lindsay", "Tobias", "Byron"))
	  	.log()
	  	.all();
  }
  
  @Test
  private void test_2_post() {
	  data = new JSONObject();
	  data.put("name", "Dominic");
	  data.put("job", "Automation Tester");
	  given()
		.header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(data.toJSONString()).
	  when()
		.post("https://reqres.in/api/users").
	  then()
	  	.statusCode(201);
  }
  
  @Test
  private void test_3_put() {
	  data = new JSONObject();
	  data.put("name", "Dominic");
	  data.put("job", "Tester");
	  given()
	  	.header("Content-Type","application/json")
	  	.contentType(ContentType.JSON)
	  	.accept(ContentType.JSON)
	  	.body(data.toJSONString()).   
	  when()
	  	.put("https://reqres.in/api/users/2").
	  then()
	  	.statusCode(200)
	  	.log()
	  	.all();
  }
}
