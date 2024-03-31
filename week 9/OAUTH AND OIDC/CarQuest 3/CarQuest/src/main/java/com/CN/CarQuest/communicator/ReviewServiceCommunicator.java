package com.CN.CarQuest.communicator;

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

import com.CN.CarQuest.dto.ReviewRequest;
import com.CN.CarQuest.dto.ReviewResponse;

@Service
public class ReviewServiceCommunicator{
	
	private final RestTemplate restTemplate;
	
	@Autowired
	public ReviewServiceCommunicator(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

    public void addReview(ReviewRequest reviewRequest, String jwtToken){
		String url = "http://localhost:8081/review/add/";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer "+jwtToken);
		HttpEntity<Map<String,Long>> requestEntity = new HttpEntity(reviewRequest, headers);
		restTemplate.exchange(url,HttpMethod.POST, requestEntity, String.class);
    }

    public List<ReviewResponse> getReview(String carName, String jwtToken){
		String url = "http://localhost:8081/review/";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer "+jwtToken);
		HttpEntity<Map<String,Long>> requestEntity = new HttpEntity(headers);
		ResponseEntity<ReviewResponse> reviewResponse = restTemplate.exchange(url+carName,HttpMethod.GET, requestEntity, ReviewResponse.class);

        return (List<ReviewResponse>) reviewResponse.getBody();
    }
}
