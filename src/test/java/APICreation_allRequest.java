import org.json.simple.JSONObject;
import org.testng.Assert;
import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class APICreation_allRequest {
    @Test(enabled = false)
 	public void test_get() {
		
	  given()
		  .baseUri("http://localhost:3000/")
		  
		  .params("firstName", "Pratik")
		  .get("/users")
		  
	      .then()
		  .statusCode(200)
		  .log().all();
	}
	
	@Test(enabled=false)
	public void test_post() {
		
		Map<String, Object> map = new HashMap<String, Object>();  //Map thi bhi thaay and Direct JSONObject thi bhi data Put thaay.
        map.put("firstName", "Happy");
		map.put("lastName", "Coper");
    	map.put("subjectId", 44);
    	map.put("id", 100);   // aa line self generate thse I don't know why ?
//		
		
		JSONObject request = new JSONObject(map);
//		
//		request.put("firstName","Tom");
//		request.put("lastName","Cooper");
//		request.put("subjectId",1);
//		request.put("id", 1);
		
  	given() 
        .baseUri("http://localhost:3000/")
		.contentType(ContentType.JSON)   // This implies the given content is in JSON
		.accept(ContentType.JSON)        // This implies I will only accept  content is in JSON
		.header("Content-Type","application/json")
		.body(request.toJSONString())    // This implies the given content will be fitted inside JSON String
		.when()
                  // I will update this data in the USERS Array 
		.post("/users")
		.then()
		.statusCode(201)                // Post has successCode 201
		.log().all();
		
	}
	
	@Test(enabled = false)
	public void test_patch() {
		
		Map<String, Object> map = new HashMap<String, Object>();  //Map thi bhi thaay and Direct JSONObject thi bhi data Put thaay.
        
		map.put("lastName", "Shepard");
   
//   	map.put("id", 1);   // aa line self generate thse I don't know why ?
//		
		
		JSONObject request = new JSONObject(map);
//		
//		request.put("firstName","Tom");
//		request.put("lastName","Cooper");
//		request.put("subjectId",1);
//		request.put("id", 1);
		
  	given()
        .baseUri("http://localhost:3000/")
		.contentType(ContentType.JSON)   // This implies the given content is in JSON
		.accept(ContentType.JSON)        // This implies I will only accept  content is in JSON
		.header("Content-Type","application/json")
		.body(request.toJSONString())    // This implies the given content will be fitted inside JSON String
		.when()
                  // I will update this data in the USERS Array 
		.patch("/users/4")
		.then()
		.statusCode(200)                // Post has successCode 201
		.log().all();
}
	
    @Test(enabled = false)
    public void test_put() {
	Map<String, Object> map = new HashMap<String, Object>();  //Map thi bhi thaay and Direct JSONObject thi bhi data Put thaay.
    map.put("firstName", "Marry");
	map.put("lastName", "Jane");
	map.put("subjectId", 1 );
//	map.put("id", 1);   // aa line self generate thse I don't know why ?
//	
	
	JSONObject request = new JSONObject(map);
//	
//	request.put("firstName","Tom");
//	request.put("lastName","Cooper");
//	request.put("subjectId",1);
//	request.put("id", 1);
	
	given()
    .baseUri("http://localhost:3000/")
	.contentType(ContentType.JSON)   // This implies the given content is in JSON
	.accept(ContentType.JSON)        // This implies I will only accept  content is in JSON
	.header("Content-Type","application/json")
	.body(request.toJSONString())    // This implies the given content will be fitted inside JSON String
	.when()
              // I will update this data in the USERS Array 
	.post("/users")
	.then()
	.statusCode(201)                // Post has successCode 201
	.log().all();
	
}
    @DataProvider(name="Api-Creation")
	public Object[] test_delete1() {

		return new Object[] { 3, 100,455, 4
		};
	}
	@Test(enabled = true, dataProvider="Api-Creation")
	public void test_delete(int userId) {
		given()
		.baseUri("http://localhost:3000/")
		.when()
		.delete("users/"+userId)
		.then()
		.statusCode(200)
		.log().all();
		
		
	}
	
}