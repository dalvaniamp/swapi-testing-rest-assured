package SafeTripToKamino;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
 
public class SafeTripToKaminoTests { 
	final static String BASE_URL = "http://swapi.co/api/";		
	private static Planet planet = new Planet();
	
	@BeforeClass
	public static void SetUp()
	{				
		RestAssured.baseURI = BASE_URL;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("planets/?search=Kamino");
		Assert.assertEquals(response.statusCode(), 200);		
		planet.name=response.path("results[0].name");
		
		planet.gravity=response.path("results[0].gravity");
		planet.diameter=Integer.parseInt(response.path("results[0].diameter"));
	}

	@Test
	public void PlanetIsKamino()
	{
		Assert.assertEquals("Kamino", planet.name);
	}
	
	@Test
	public void DiameterIsLessThan20000()
	{
		Assert.assertTrue(planet.diameter<20000);
	}
	
	@Test
	public void GravityIsStandard()
	{
		Assert.assertEquals("1 standard", planet.gravity);
	}	
}