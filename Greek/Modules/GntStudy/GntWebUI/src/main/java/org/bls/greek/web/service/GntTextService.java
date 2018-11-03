package org.bls.greek.web.service;

import org.springframework.stereotype.Service;
import io.swagger.client.ApiClient;
import io.swagger.client.api.LexiconApi;
import io.swagger.client.api.TextsApi;
import io.swagger.client.model.Chapter;

@Service
public class GntTextService {
 
	private final LexiconApi api;
	
	private final TextsApi textsApi;
    
    public GntTextService() {
    	ApiClient apiClient = new ApiClient();
    	apiClient.setBasePath("http://localhost:8090");
    	this.api = new LexiconApi();
    	api.setApiClient(apiClient);
    	this.textsApi = new TextsApi();
    	this.textsApi.setApiClient(apiClient);
    } 	    
   
    public Chapter retrieveChapter(String book, int chapterNumber) throws Exception {
    	return textsApi.getChapter(book, chapterNumber);
    }
}