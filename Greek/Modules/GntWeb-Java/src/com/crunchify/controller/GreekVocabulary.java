package com.crunchify.controller;

import java.util.List;

import org.bls.gnt.ConfigHelper;
import org.bls.gnt.db.DBGntBookDAOImpl;
import org.bls.gnt.db.dao.GntBookDAO;
import org.bls.gnt.db.model.GntWord;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreekVocabulary {
	
	private GntBookDAO bookDao = null;
	
	public GreekVocabulary() {
		bookDao = new DBGntBookDAOImpl(ConfigHelper.getGntServiceContext().getSqlSessionFactory());
	}

	@RequestMapping("/vocabulary/all")
	public ModelAndView helloWorld()  {
		List<GntWord> words = null;
		try {
			words = bookDao.getAllWords();
		}
		catch (Exception e) {
			
		}
		return new ModelAndView("welcome", "message", words);
	}
}