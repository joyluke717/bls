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
public class CrunchifyHelloWorld {
	
	private GntBookDAO bookDao = null;
	
	public CrunchifyHelloWorld() {
		bookDao = new DBGntBookDAOImpl(ConfigHelper.getGntServiceContext().getSqlSessionFactory());
	}

	@RequestMapping("/welcome")
	public ModelAndView helloWorld()  {

		String message = "<br><div style='text-align:center;'>"
				+ "<h3>******* Hello World, Spring MVC Turorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		List<GntWord> words = null;
		try {
			words = bookDao.getAllWords();
		}
		catch (Exception e) {
			
		}
		return new ModelAndView("welcome", "message", words);
	}
}