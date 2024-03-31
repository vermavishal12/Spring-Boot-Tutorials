package com.CN.PharmaLink.communicator;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.CN.PharmaLink.dto.MedicalStoreDto;

@Service
public class StoreFinderCommunicator {
	
	private final RestTemplate restTemplate;
	
	@Autowired
	public StoreFinderCommunicator(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	public List<MedicalStoreDto> getNearestMedicalStores(Long userId, Long distance,
			String jwtToken) {
		
		String url = "http://localhost:8081/getNearestStores/";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer "+jwtToken);
		HttpEntity<Map<String,Long>> requestEntity = new HttpEntity(headers);
		ResponseEntity<MedicalStoreDto> medicalStoreResponse = restTemplate.exchange(url+userId+"/"+distance,HttpMethod.GET, requestEntity, MedicalStoreDto.class);
		return (List<MedicalStoreDto>) medicalStoreResponse.getBody();
		
	}
	
	public List<MedicalStoreDto> getMedicalStoresWithMedicine(String medicine, 
			String jwtToken) {
		String url = "http://localhost:8081/getStoresWithMedicine/";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer "+jwtToken);
		HttpEntity<Map<String,Long>> requestEntity = new HttpEntity(headers);
		ResponseEntity<MedicalStoreDto> medicalStoreResponse = restTemplate.exchange(url+medicine,HttpMethod.GET, requestEntity, MedicalStoreDto.class);
		
		return (List<MedicalStoreDto>) medicalStoreResponse.getBody();
	}
	
}
