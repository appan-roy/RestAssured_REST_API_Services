package reqres.in;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;

public class GET {
	
	String req1 = "https://reqres.in/api/users?page=1";
	
	Response res1 = get(req1);
	
	String req2 = "https://reqres.in/api/users?page=2";
	
	Response res2 = get(req2);
	
	@Test
	public void printResponseAttributes_REQ1() {
		
		System.out.println(res1.asString());
		
		System.out.println(res1.getBody().asString());
		
		System.out.println(res1.getStatusCode());
		
		System.out.println(res1.getStatusLine());
		
		System.out.println(res1.getHeader("content-type"));
		
		System.out.println(res1.getTime());
		
	}
	
	@Test
	public void printResponseAttributes_REQ2() {
		
		System.out.println(res2.asString());
		
		System.out.println(res2.getBody().asString());
		
		System.out.println(res2.getStatusCode());
		
		System.out.println(res2.getStatusLine());
		
		System.out.println(res2.getHeader("content-type"));
		
		System.out.println(res2.getTime());
		
	}
	
	@Test
	public void checkStatusCode1_REQ1() {
		
		int statusCode1 = res1.getStatusCode();
		
		Assert.assertEquals(statusCode1, 200);
		
	}
	
	@Test
	public void checkStatusCode1_REQ2() {
		
		
		int statusCode2 = res2.getStatusCode();
		
		Assert.assertEquals(statusCode2, 200);
		
	}
	
	@Test
	public void logResponse_REQ1() {
				
		given()
			.get(req1)
		.then()
			.log().all();
			
	}
	
	@Test
	public void logResponse_REQ2() {
	
		given()
			.get(req2)
		.then()
			.log().all();
			
	}

	@Test
	public void checkStatusCode2_REQ1() {
		
		given().
			get(req1).
		then().
			statusCode(200);
	
	}
	
	@Test
	public void checkStatusCode2_REQ2() {
		
		given().
			get(req2).
		then().
			statusCode(200);
		
	}
	
	@Test
	public void checkDataElements1_REQ1() {
		
		int arr_id[] = {1, 2, 3, 4, 5, 6};
		
		String arr_email[] = {"george.bluth@reqres.in", "janet.weaver@reqres.in", "emma.wong@reqres.in", "eve.holt@reqres.in", "charles.morris@reqres.in", "tracey.ramos@reqres.in"};
		
		String arr_firstname[] = {"George", "Janet", "Emma", "Eve", "Charles", "Tracey"};
		
		String arr_lastname[] = {"Bluth", "Weaver", "Wong", "Holt", "Morris", "Ramos"};
		
		for(int i=0; i<6; i++) {
			
			given()
				.get(req1).
			then()
				.body("data.id["+i+"]", equalTo(arr_id[i]))
				.body("data.email["+i+"]", equalTo(arr_email[i]))
				.body("data.first_name["+i+"]", equalTo(arr_firstname[i]))
				.body("data.last_name["+i+"]", equalTo(arr_lastname[i]));
			
		}
	
	}
	
	@Test
	public void checkDataElements1_REQ2() {
		
		int arr_id[] = {7, 8, 9, 10, 11, 12};
		
		String arr_email[] = {"michael.lawson@reqres.in", "lindsay.ferguson@reqres.in", "tobias.funke@reqres.in", "byron.fields@reqres.in", "george.edwards@reqres.in", "rachel.howell@reqres.in"};
		
		String arr_firstname[] = {"Michael", "Lindsay", "Tobias", "Byron", "George", "Rachel"};
		
		String arr_lastname[] = {"Lawson", "Ferguson", "Funke", "Fields", "Edwards", "Howell"};
		
		for(int i=0; i<6; i++) {
			
			given()
				.get(req2).
			then()
				.body("data.id["+i+"]", equalTo(arr_id[i]))
				.body("data.email["+i+"]", equalTo(arr_email[i]))
				.body("data.first_name["+i+"]", equalTo(arr_firstname[i]))
				.body("data.last_name["+i+"]", equalTo(arr_lastname[i]));
			
		}
	
	}
	
	@Test
	public void checkDataElements2_REQ1() {
		
		given()
			.get(req1).
		then()
			.body("data.id", hasItems(1, 2, 3, 4, 5, 6))
			.body("data.email", hasItems("george.bluth@reqres.in", "janet.weaver@reqres.in", "emma.wong@reqres.in", "eve.holt@reqres.in", "charles.morris@reqres.in", "tracey.ramos@reqres.in"))
			.body("data.first_name", hasItems("George", "Janet", "Emma", "Eve", "Charles", "Tracey"))
			.body("data.last_name", hasItems("Bluth", "Weaver", "Wong", "Holt", "Morris", "Ramos"));
			
	}
	
	@Test
	public void checkDataElements2_REQ2() {
		
		given()
			.get(req2).
		then()
			.body("data.id", hasItems(7, 8, 9, 10, 11, 12))
			.body("data.email", hasItems("michael.lawson@reqres.in", "lindsay.ferguson@reqres.in", "tobias.funke@reqres.in", "byron.fields@reqres.in", "george.edwards@reqres.in", "rachel.howell@reqres.in"))
			.body("data.first_name", hasItems("Michael", "Lindsay", "Tobias", "Byron", "George", "Rachel"))
			.body("data.last_name", hasItems("Lawson", "Ferguson", "Funke", "Fields", "Edwards", "Howell"));
			
	}
		
}
