package nasaAPI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class MarsRover {

	static String apiKey = "cQQBex9htxH1fieiwmiH9ZtY7iGgLY2k97uTS54p";
	
	static String projDir = System.getProperty("user.dir");
	
	static String driverPath = projDir+"/Drivers/chromedriver.exe";
	
	@Test
	public void testAsteroids() throws Exception {
		
		
		// Get the Mars rover URL
		
		baseURI = "https://api.nasa.gov";
		
		Response res = null;
		
		res = 	given().
				when()
					.queryParams("sol", 10)
					.queryParams("api_key", apiKey)
					.get("/mars-photos/api/v1/rovers/curiosity/photos");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		
		System.out.println("Response Status Code: "+res.getStatusCode());
		
		String imgURL = res.getBody().jsonPath().get("photos[0].img_src");
		
		
		// Open browser and check the Mars rover image
		
		System.setProperty("webdriver.chrome.driver",driverPath);
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(imgURL);
		
		Thread.sleep(5000);
		
		driver.quit();
		
	}
	
}
