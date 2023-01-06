package utils;

import org.testng.annotations.Test;
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

public class ExcelUtilsTest {

	Map<String, Object> map2 = new HashMap<String, Object>();
    
	@Test
	public void test_var1() {

		ExcelUtilsTest ext = new ExcelUtilsTest();

		String excelPath = "./DATA/DataDrivenUsingExcel.xlsx";
		String sheetName = "Sheet1";
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

		excel.getRowCount();

		String[] name_fild = { "firstnma", "lastnm", "subId" };
		Map<String, Object> map21 = new HashMap<String, Object>();

		for (int i = 1; i < 9; i++) {
			for (int j = 0; j < 3; j++) {

				String nmfm = name_fild[j];
				String nm = excel.getCellData(i, j);
				map21.put(nmfm, nm);
				JSONObject request = new JSONObject(map21);

				given().baseUri("http://localhost:3000/").contentType(ContentType.JSON) // This implies the given
																						// content is in
						// JSON
						.accept(ContentType.JSON) // This implies I will only accept content is in JSON
						.header("Content-Type", "application/json").body(request.toJSONString()) // This implies the
																									// given
						// content will be fitted
						// inside JSON String
						.when()
// I will update this data in the USERS Array
						.post("/users").then().statusCode(201) // Post has successCode 201
						.log().all();

				// ext.test_post_Excel(nm);
			}
		}

	}

////	@Test
////	public void test_post_Excel(String nm) {
////
////		Map<String, Object> map = new HashMap<String, Object>(); // Map thi bhi thaay and Direct JSONObject thi bhi data
////																	// Put thaay.
////		map.put("firstName", nm);
////		map.put("lastName", "Coper");
////		map.put("subjectId", 44);
////		map.put("id", 100); // aa line self generate thse I don't know why ?
//////		
////
////		JSONObject request = new JSONObject(map);
//////		
//////		request.put("firstName","Tom");
//////		request.put("lastName","Cooper");
//////		request.put("subjectId",1);
//////		request.put("id", 1);
////
////		given().baseUri("http://localhost:3000/").contentType(ContentType.JSON) // This implies the given content is in
////																				// JSON
////				.accept(ContentType.JSON) // This implies I will only accept content is in JSON
////				.header("Content-Type", "application/json").body(request.toJSONString()) // This implies the given
////																							// content will be fitted
//																							// inside JSON String
//				.when()
//				// I will update this data in the USERS Array
//				.post("/users").then().statusCode(201) // Post has successCode 201
//				.log().all(); }

	}


