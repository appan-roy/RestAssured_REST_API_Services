package parameterization;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

 
public class QueryParameter {
 
    @Test
    public void filterUser() {
 
        baseURI = "https://reqres.in";
 
        Response response = null;
 
        try {
            response = 	given()
            			.when()
            				.queryParam("page", "2").queryParam("id", 5)
            				.get("/api/users");
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        System.out.println("Response : " + response.asString());
        
        System.out.println("Response : " + response.getBody().jsonPath().prettify());
        
        System.out.println("Status Code : " + response.getStatusCode());
 
    }
    
}
