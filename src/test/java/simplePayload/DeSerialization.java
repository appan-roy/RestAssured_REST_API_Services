package simplePayload;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class DeSerialization {

    @Test
    public void JSON_to_POJO() {

    	baseURI = "http://localhost:3000";
    	
    	Response response = null;
    	
    	response = 	given().
    				when()
    					.get("/users/21");
    	
    	Users user = response.getBody().as(Users.class);

        System.out.println(user.toString());
        
    }

}
