package stepDefs;

import java.util.Map;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAPIPostEmployee {

	RequestSpecification request;
	Response response;

	@Given("I have the post endpoint as {string}")
	public void i_have_the_post_endpoint_as(String endPointURL) {
		request = RestAssured.given().baseUri(endPointURL);

	}

	@When("I give the body as")
	public void i_give_the_body_as(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> reqBody = dataTable.asMap(String.class, String.class);
		request.contentType(ContentType.JSON).accept(ContentType.JSON).body(reqBody);
	}

	@When("I perform the post operation")
	public void i_perform_the_post_operation() {
		response = request.post();
	}

	@Then("I should get the post response code as {int}")
	public void i_should_get_the_post_response_code_as(int responseCode) {
		Assert.assertEquals(responseCode, response.getStatusCode());
	}
	@Then("The first name should be {string}")
	public void the_first_name_should_be(String firstName) {
		Assert.assertEquals(firstName, response.jsonPath().get("firstName"));
	}

	@Then("The email should be {string}")
	public void the_email_should_be(String email) {
		Assert.assertEquals(email, response.jsonPath().get("email"));
	}


}
