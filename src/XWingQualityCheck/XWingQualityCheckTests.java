package XWingQualityCheck;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
 
public class XWingQualityCheckTests { 
	final static String BASE_URL = "http://swapi.co/api/";		
	private static Ship ship = new Ship();
	
	@BeforeClass
	public static void SetUp()
	{				
		RestAssured.baseURI = BASE_URL;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("starships/?search=T-65 X-wing");
		Assert.assertEquals(response.statusCode(), 200);		
		
		ship.name=response.path("results[0].name");
		ship.filmCount=response.path("results[0].films.size()");
	}
	
	@Test
	public void ShipIsXWing()
	{
		Assert.assertEquals("X-wing",ship.name);
	}

	@Test
	public void ShipWereInMoreThan3Films()
	{
		Assert.assertTrue(ship.filmCount>=3);
	}
}
	
	