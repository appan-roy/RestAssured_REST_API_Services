package authentication;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class OAuth2_AuthDemo {

	String accessToken = "83c56f972e88b8edaacc7856850bc9ac9c99c39b";
	
	int userId = 1198;
	
	@Test
	public void testChickensFeed() {
		
		baseURI = "http://coop.apps.symfonycasts.com";
		
		Response res = null;
		
		res = given().auth().oauth2(accessToken).post("/api/"+userId+"/chickens-feed");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		
		Assert.assertEquals(res.getBody().jsonPath().get("action"), "chickens-feed");
		
		System.out.println("Response Status Code: "+res.getStatusCode());
		
		System.out.println("Response Body: "+res.getBody().jsonPath().prettify());
		
	}
	
}
