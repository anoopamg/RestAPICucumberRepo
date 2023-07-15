package stepDefs;


import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class RestAPIGetEmployee {
	RequestSpecification request;
	Response response;
	
	
	@Given("I have the endpoint as {string}")
	public void i_have_the_endpoint_as(String endPointURL) {
	    
		request = RestAssured.given()
					.baseUri(endPointURL);
		
	}

	@When("I perform the get operation")
	public void i_perform_the_get_operation() {
	   response = request.get();
	}

	@Then("I should get the response as {int}")
	public void i_should_get_the_response_as(int responseCode) {
	   Assert.assertEquals(responseCode, response.getStatusCode());
	}

}
