import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public abstract class BaseTest {
	protected final static String BASE_URL = "http://swapi.co/api/";		
	
	protected static Response getRequestResponse (String request)
	{
		RestAssured.baseURI = BASE_URL;
		RequestSpecification httpRequest = RestAssured.given();
		return httpRequest.get(request);
	}	
}
