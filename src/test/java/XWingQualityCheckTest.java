import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
 
public class XWingQualityCheckTest extends BaseTest{ 
	private static Ship ship = new Ship();
	
	@BeforeClass
	public static void setUp()
	{			
		Response response = getRequestResponse("starships/12/");
		ship.name=response.path("name");
		ship.filmCount=response.path("films.size()");
	}
		
	@Test
	public void shipIsXWingTest()
	{
		Assert.assertEquals("X-wing",ship.name);
	}

	@Test
	public void shipWereInMoreThan3FilmsTest()
	{
		Assert.assertTrue(ship.filmCount>=3);
	}
}
	
	