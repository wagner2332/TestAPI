package com.theCat.TesteAPI;


import org.junit.Test;


import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TesteApi {
	
	@Test
	public void cadastro() {
		String url = "https://api.thecatapi.com/v1/user/passwordlesssignup";
		String corpo = "{\"email\": \"wagner_silva3223@hotmail.com\", \"appDescription\": \"Test The Cat API\"}";
		
	
		Response response = 
		given().contentType("application/json").body(corpo).
		when().post(url); 
		response.then().statusCode(200);
		
		System.out.println("RETORNO => "+ response.body().asString());
}




	
	@Test
	public void votacao() {
		String url = "https://api.thecatapi.com/v1/votes/";
		String corpo = "{\"image_id\": \"61h\", \"value\": \"true\", \"sub_id\": \"demo-c26f9f\"}";
		
	
		Response response = 
		given().contentType("application/json").body(corpo).
		when().post(url); 
		response.then().statusCode(200);
		
		System.out.println("RETORNO => "+ response.body().asString());
		
		String id = response.jsonPath().getString("id");
		
		System.out.println("ID => " + id);
}



	@Test
	public void deletavotacao() {
		votacao();
		deletavoto();
		
	}
	public void deletavoto() {
		String url = "https://api.thecatapi.com/v1/votes/{vote_id}";

		
		Response response = 
				given().contentType("application/json")
				
				.when().delete(url);
		
		response.then().statusCode(200);

	}

	
	}