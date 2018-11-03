package org.bls.greek.web.service;

import java.util.ArrayList;
import java.util.List;

import org.bls.greek.web.model.GreekVocabulary;
import org.springframework.stereotype.Service;

import io.swagger.client.ApiClient;
import io.swagger.client.api.LexiconApi;
import io.swagger.client.model.GntLexiconBean;

@Service
public class LexiconService {
 
	private final LexiconApi api;
    
    public LexiconService() {
    	ApiClient apiClient = new ApiClient();
    	apiClient.setBasePath("http://localhost:8090");
    	this.api = new LexiconApi();
    	api.setApiClient(apiClient);
    } 	    
   
    public List<GreekVocabulary> retrieveVocabularys(String user) throws Exception {
    	List<GntLexiconBean> lexionBeanList = this.api.getAllLexicion();
        return convert(lexionBeanList);
    }
    
    private List<GreekVocabulary> convert(List<GntLexiconBean> inputList) {
    	List<GreekVocabulary> vocList = new ArrayList<GreekVocabulary>();
    	for (GntLexiconBean bean : inputList) {
    		GreekVocabulary voc = new GreekVocabulary();
    		voc.setBriefMeaning(bean.getFullMeaning());
    		voc.setWord(bean.getWord());
    		voc.setFrequency(bean.getFrequency());
    		vocList.add(voc);
    	}
    	return vocList;
    }
}