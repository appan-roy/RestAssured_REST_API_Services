package nasaAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class APOD {

	static String apiKey = "cQQBex9htxH1fieiwmiH9ZtY7iGgLY2k97uTS54p";
	
	@Test
	public void testAPODUsingPathParams() {
		
		baseURI = "https://api.nasa.gov";
		
		Response res = null;
		
		res = 	given()
					.pathParam("api_key", apiKey).
				when()
					.get("/planetary/apod?api_key={api_key}");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		
		String title = res.getBody().jsonPath().get("title");
		
		String date = res.getBody().jsonPath().get("date");
		
		System.out.println("The title of APOD is "+title+" on the date "+date);
		
		System.out.println("Response Status Code: "+res.getStatusCode());
		
		System.out.println("Response Body: "+res.getBody().jsonPath().prettify());
		
	}
	
	@Test
	public void testAPODUsingQueryParams() {
		
		baseURI = "https://api.nasa.gov";
		
		Response res = null;
		
		res = 	given().
				when()
					.queryParams("date", "2020-07-19")
					.queryParams("hd", "False")
					.queryParams("api_key", apiKey)
					.get("/planetary/apod");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		
		String title = res.getBody().jsonPath().get("title");
		
		String date = res.getBody().jsonPath().get("date");
		
		System.out.println("The title of APOD is "+title+" on the date "+date);
		
		System.out.println("Response Status Code: "+res.getStatusCode());
		
		System.out.println("Response Body: "+res.getBody().jsonPath().prettify());
		
	}
	
}
