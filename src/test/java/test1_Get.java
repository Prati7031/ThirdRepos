import org.testng.Assert;
import static io.restassured.RestAssured.given;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
public class test1_Get {
	@Test
	public void test_01Get() {
	Object r1 =	given()
			.header("content-type","application/json")
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.body("data.id[0]", equalTo(7))
//		.body("data.first_name",hasItems("Micheal","Lindsay"))  // if we want to check multiple items
		.log().all();
		System.out.println(r1);
		
	}
	
	
}
