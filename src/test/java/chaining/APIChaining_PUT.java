package chaining;

import org.json.simple.JSONObject;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


public class APIChaining_PUT {
	
	@Test
	public void updateUsers() {
		
		baseURI = "http://localhost:3000";
		
		int rating [] = {1736, 1478, 1397, 1104, 1568};
		
		for(int i=0; i<5; i++) {
			
			Response res = given().contentType(ContentType.JSON).log().all().get("/students/"+(i+6));
			
			String fname = res.then().extract().path("firstName");
			String lname = res.then().extract().path("lastName");
			
			JSONObject json = new JSONObject();
			
			json.put("firstName", fname);
			json.put("lastName", lname);
			json.put("fideRating", rating[i]);
			
			given()
				.header("Content-Type", "application/json")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(json.toJSONString()).
			when()
				.put("/users/"+(i+21)).
			then()
				.statusCode(200)
				.log().all();

		}
		
	}

}
