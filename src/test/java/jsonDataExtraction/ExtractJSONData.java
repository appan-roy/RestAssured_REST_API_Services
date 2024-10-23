package jsonDataExtraction;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;

public class ExtractJSONData {
	
	@Test
	public void getUsers() {
		
		baseURI = "http://localhost:3000";
		
		basePath = "/users";
		
		for(int i=1; i<=20; i++) {
			
			Response res = given().contentType(ContentType.JSON).log().all().get("/"+i);
			
			String fname = res.then().extract().path("firstName");
			
			System.out.println("The first name is "+fname);
			
			String lname = res.then().extract().path("lastName");
			
			System.out.println("The last name is "+lname);
			
			int rating = res.then().extract().path("fideRating");
			
			System.out.println("The fide rating is "+rating);
			
		}
		
	}
	
	@Test
	public void getStudents() {
		
		baseURI = "http://localhost:3000";
		
		basePath = "/students";
		
		for(int i=1; i<=5; i++) {
			
			Response res = given().contentType(ContentType.JSON).log().all().get("/"+i);
			
			String fname = res.then().extract().path("firstName");
			
			System.out.println("The first name is "+fname);
			
			String lname = res.then().extract().path("lastName");
			
			System.out.println("The last name is "+lname);
			
			long mobile = res.then().extract().path("mobileNo");
			
			System.out.println("The mobile number is "+mobile);
			
			ArrayList<String> subjects = res.then().extract().path("subjects");
			
			for(String s:subjects) {
				
				System.out.println("The subject is "+s);
				
			}
			
		}
		
	}
	
}
