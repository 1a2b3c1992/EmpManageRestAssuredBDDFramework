package BaseAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class EmpBaseAPI {
	
	protected static RequestSpecification httpRequest;
	
	public static void reqSpec()
	{	
		httpRequest = RestAssured.given();
		httpRequest.contentType(ContentType.JSON);
		httpRequest.log().all();
		
	}

}
