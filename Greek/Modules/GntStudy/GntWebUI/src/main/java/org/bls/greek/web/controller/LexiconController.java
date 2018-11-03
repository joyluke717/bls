package org.bls.greek.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.bls.greek.web.model.GreekVocabulary;
import org.bls.greek.web.service.LexiconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LexiconController {

	@Autowired
	LexiconService service;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}

	@RequestMapping(value = "/list-vocabulary", method = RequestMethod.GET)
	public String showVocabularys(ModelMap model) throws Exception {
		String name = getLoggedInUserName(model);
		List<GreekVocabulary> vocList = service.retrieveVocabularys(name); 
		model.put("vocabularyList", vocList);
		return "list-vocabulary";
	}

	private String getLoggedInUserName(ModelMap model) {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		
		return principal.toString();
	}
}
