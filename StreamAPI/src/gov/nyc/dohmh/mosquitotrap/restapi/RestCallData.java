package gov.nyc.dohmh.mosquitotrap.restapi;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import gov.nyc.dohmh.mosquitotrap.dto.MosquitoTypeDTO;

public class RestCallData {

	public void getRestData(){
		
		final String uri = "http://localhost:8001/api/v1/mosquitotype";
		 //System.out.println("Hi");
		RestTemplate restTemplate = new RestTemplate();
		
		String result = restTemplate.getForObject(uri, String.class); 
		
		 System.out.println("Hi"); 
	    System.out.println(result);
	}
}
