package StepsApi;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hamcrest.Matchers;

import BaseAPI.EmpBaseAPI;
import Endpoints.EmpEndPoints;
import Reader.EmpJsonReader;
import Reader.EmpPropertyReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class EmployeeSteps extends EmpBaseAPI{
	Response response;
	static String id;
	ValidatableResponse validateresponse;

	@Given("set base uri")
	public void set_base_uri() {
		RestAssured.baseURI=EmpPropertyReader.getPropery("BASE_URI");
	}

	@Given("get the request specification object")
	public void get_the_request_specification_object() {
		EmpBaseAPI.reqSpec();
	}

	@And("attach request payload to http post request")
	public void attach_request_payload_to_http_post_request() {
		String requestPayload =EmpJsonReader.readJsonFile("EmployeePayload", "createemployee");
		httpRequest.body(requestPayload);
	}

	@When("select http post request")
	public void select_http_post_request() {
		response=httpRequest.post(EmpEndPoints.POST_EMPLOYEE);
	}

	@Then("get employee id from response payload")
	public void get_employee_id_from_response_payload() {
		response.jsonPath().get("id");
	}

	@And("get validatable response object")
	public void get_validatable_response_object() {
		validateresponse= response.then().assertThat();
	}

	@And("validate status code {int}")
	public void validate_status_code(Integer code) {
		validateresponse.statusCode(Matchers.equalTo(code));
	}

	@And("validate status line {string}")
	public void validate_status_line(String Status_Line) {
		validateresponse.statusLine(Matchers.containsString(Status_Line));
	}

	@And("validate time below {int} ms")
	public void validate_time_below_ms(Integer time) {
		validateresponse.time(Matchers.lessThan((long) time));
	}

	@And("validate {string} and {string} header")
	public void validate_and_header(String key, String value) {
		validateresponse.header(key, Matchers.containsString(value));
	}

	@And("validate {string} and current time header")
	public void validate_and_current_time_header(String key) {
		String date = new SimpleDateFormat("MMM yyyy").format(new Date());
		validateresponse.header(key, Matchers.containsString(date));
	}

	@And("validate json schema")
	public void validate_json_schema() throws FileNotFoundException {
		String path = System.getProperty("user.dir") + "/src/test/resources/JsonSchema/EmployeeSchema.json";
		FileReader file = new FileReader(path);
		validateresponse.body(JsonSchemaValidator.matchesJsonSchema(file));
	}

	@And("generate response logs")
	public void generate_response_logs() {
		validateresponse.log().all();
	}


}
