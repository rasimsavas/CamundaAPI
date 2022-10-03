package org.camunda.bpm.getstarted.request;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

import camundajar.impl.scala.runtime.NonLocalReturnControl;

public class RequestDotnet {
	
	public static final String DOTNETURL = "https://localhost:7292/api/xjava";
	public static int postJson(String json) throws Exception {
		
		HttpClient client = HttpClient.newBuilder().build();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(DOTNETURL))
				.header("Content-Type", "application/json")
	            .POST(BodyPublishers.ofString(json))
	            .build();
		
		HttpResponse<?> response = client.send(request, BodyHandlers.discarding());
		
		return response.statusCode();
	}
	
	public static int postJsonAmount(String json) throws Exception {
		
		HttpClient client = HttpClient.newBuilder().build();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(DOTNETURL+"/amount"))
				.header("Content-Type", "application/json")
	            .POST(BodyPublishers.ofString(json))
	            .build();
		
		HttpResponse<?> response = client.send(request, BodyHandlers.discarding());
		
		return response.statusCode();
	}
	
	
	public static int postJsonDeposit(String json) throws Exception {
		
		HttpClient client = HttpClient.newBuilder().build();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(DOTNETURL+"/deposit"))
				.header("Content-Type", "application/json")
	            .POST(BodyPublishers.ofString(json))
	            .build();
		
		HttpResponse<?> response = client.send(request, BodyHandlers.discarding());
		
		return response.statusCode();
	}
}
