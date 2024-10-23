package parameterization;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


public class PathParameter {

	@Test
    public void filterUser() {

        baseURI = "http://localhost:3000";
    	
    	Response response = null;

        response = 	given()
        				.pathParam("id", "26")
            			.contentType("application/json").
            		when()
            			.get("/users/{id}");
        
        System.out.println("Response: "+response.asString());
        
        System.out.println("Status Code : " + response.getStatusCode());
        
    }
	
}
