import org.json.simple.JSONObject;
import org.testng.Assert;
import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Test_Post {
	@Test()
	public void test_post() {
              
		Map<String, Object> map = new HashMap<String, Object>();  //Map thi bhi thaay and Direct JSONObject thi bhi data Put thaay.
		map.put("name", "Raghav");
		map.put("job", "Teacher");
		
		System.out.println(map);
		
		JSONObject request = new JSONObject();  // Je data Put krya che aene JSON forman ma set krva maate
		request.put("name ", "Rohit");
		request.put("job","Physio");              
		
		System.out.println(request);
	
		//	System.out.println(request.toJSONString()); // if there is any error something like a centralization error then use this syntax
		
		given()
		.header("content-type", "application/json").accept(ContentType.JSON).contentType(ContentType.JSON)
		.body(request.toJSONString())  //Post request ma given pachi Body valu Syntax lkhvu necessary che otherwise post ae JSON format ma no thaay 
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.statusCode(201);
		
	}
	    
}
