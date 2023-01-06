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

public class DataDrivenTesting extends DataForTest_DataProvider{

	  
//}
     @Test(enabled=false,dataProvider="DataForPost")            //   
     public void test_post2(String firstName, String lastName, int SubjectId) {
	
		Map<String, Object> map = new HashMap<String, Object>();  //Map thi bhi thaay and Direct JSONObject thi bhi data Put thaay.
        map.put("firstName", firstName);
		map.put("lastName", lastName);
    	map.put("subjectId", SubjectId);
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
		.post("/users")
		.then()
		.statusCode(201)                // Post has successCode 201
		.log().all();
		
	}
     
    
     @Test(enabled=true, dataProvider="DeleteData")
     public void test_delete(int userId) {
    
    	
    		
    		given()
    		.baseUri("http://localhost:3000/")
    		.when()
    		.delete("/users/"+userId)
    		.then()
    		.statusCode(200)
    		.log().all();
	 }
     
     
}
