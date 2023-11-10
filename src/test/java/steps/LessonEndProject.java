package steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class LessonEndProject {
	
	@Test
	@Given("User send a Post request to create a user and validates status")
	public void user_send_a_post_request_to_create_a_user_and_validates_status() {
	    
		JSONObject body = new JSONObject();
		body.put("name", "vijay");
		body.put("job", "developer");
		
		RestAssured.given()
		.baseUri("https://reqres.in")
		.basePath("/api/users")
		.contentType(ContentType.JSON)
		.body(body.toString())
		.when().post()
		.then().statusCode(201).log().ifError();
		
	}
	
	@Test
	@Given("User sends a Get request to get a user and validates status")
	public void user_sends_a_get_request_to_get_a_user_and_validates_status() {
		  
		JSONObject body = new JSONObject(); body.put("email", "vijay@gmail.com");
		body.put("password", "abc123");
		
		RestAssured.given() .baseUri("https://reqres.in")
		.basePath("/api/register")
		.contentType(ContentType.JSON) .body(body.toString())
		
		.when().get() 
		.then().statusCode(200)
		.log().all();
	}
		 
	 @Test
	@Given("User sends a get request to get list of users and validates status")
	public void user_sends_a_get_request_to_get_list_of_users_and_validates_status() {
		 
		 Logger logger = LogManager.getLogger(LessonEndProject.class);
		RestAssured.given()
		.baseUri("https://reqres.in")
		.basePath("/api/unknown")
		
		.when().get()
		.then().statusCode(200).log().all();
		
		logger.trace(" This is trace method");
		
		logger.info(" this is information message");
		
		logger.error(" this is an error message");
		
		logger.fatal(" this is a fatal messgae");
		
		logger.warn(" this is a warning message");
		
	}
}
