package com.example.workflow;

import java.net.*;



import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;


public class postnet {
	
	public static void main(String[] args) throws Exception {
		
		
		
	}
	

	public static int post1(String json) throws Exception {
		
		
			String uri = String.format("https://localhost:7292/api/xjava");
		    HttpClient client = HttpClient.newBuilder().build();
		    HttpRequest request = HttpRequest.newBuilder()
		            .uri(URI.create(uri))
		            .header("Content-Type", "application/json")
		            .POST(BodyPublishers.ofString(json))
		            .build();

		    HttpResponse<?> response = client.send(request, BodyHandlers.discarding());
		    
		    System.out.println(response.statusCode());
		    System.out.println(json);
		    
		    
		    return response.statusCode();
		    
		   
		}
	public static int post2(String json) throws Exception {
		
		
		String uri = String.format("https://localhost:7292/api/xjava/amount");
	    HttpClient client = HttpClient.newBuilder().build();
	    HttpRequest request = HttpRequest.newBuilder()
	            .uri(URI.create(uri))
	            .header("Content-Type", "application/json")
	            .POST(BodyPublishers.ofString(json))
	            .build();

	    HttpResponse<?> response = client.send(request, BodyHandlers.discarding());
	    
	    System.out.println(response.statusCode());
	    
	    
	    
	    return response.statusCode();
	    
	   
	}
	
	
		public static int post3(String json) throws Exception {
		
		
			String uri = String.format("https://localhost:7292/api/Log");
		    HttpClient client = HttpClient.newBuilder().build();
		    HttpRequest request = HttpRequest.newBuilder()
		            .uri(URI.create(uri))
		            .header("Content-Type", "application/json")
		            .POST(BodyPublishers.ofString(json))
		            .build();
	
		    HttpResponse<?> response = client.send(request, BodyHandlers.discarding());
		    
		    System.out.println(response.statusCode());
		    
		    
		    
		    return response.statusCode();
	    
	   
	}


	
		        
		  
		

}
