package org.bls.gnt.parse;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.bls.gnt.db.DBGntTextDAOImpl;
import org.bls.gnt.db.dao.GntTextDAO;
import org.bls.gnt.db.model.GntTextBean;
import org.bls.gnt.parse.type.GreekText;

public class SnbGntImporter {
	private GntTextDAO gntDAO;

	public GntTextBean convert(GreekText greekText) {
		GntTextBean wordBean = new GntTextBean();
		wordBean.setBookShortName(greekText.getBook().bookShortName);
		wordBean.setChapterNumber(greekText.getIndex().chapter);
		wordBean.setVerseNumber(greekText.getIndex().verse);
		wordBean.setSequenceNumber(greekText.getIndex().wordSequence);
		
		wordBean.setPartOfSpeech(greekText.getPartSpeech());
		wordBean.setMorphTag(greekText.getMorph().parsingCode);

		wordBean.setLemma(greekText.getLemma());
		wordBean.setText(greekText.getText());
		wordBean.setNormalizedText(greekText.getNormalizedWord());
		wordBean.setWord(greekText.getWord());
		
		wordBean.setPerson(greekText.getMorph().person); 
		wordBean.setTense(greekText.getMorph().tense); 
		wordBean.setVoice(greekText.getMorph().voice); 
		wordBean.setMood(greekText.getMorph().mood); 
		wordBean.setWordCase(greekText.getMorph().wordCase);
		wordBean.setNumber(greekText.getMorph().number);
		wordBean.setGender(greekText.getMorph().gender);
		wordBean.setDegree(greekText.getMorph().degree);
		return wordBean;
	}

	public void initialize() throws Exception {
		this.gntDAO = this.getDAO();
	}
	
	public GntTextDAO getDAO () throws Exception {
		 // Create SqlSessionFactory       
        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = 
          new SqlSessionFactoryBuilder().build(inputStream);
        
        GntTextDAO dao = new DBGntTextDAOImpl(sqlSessionFactory);
        return dao;        
	}
	
	
	public void convert(String fodler) throws Exception {	
		SnbGntParser parser = new SnbGntParser();
		parser.parseFolder(fodler);
		List<GreekText> greekTextList = parser.getGreekTextList();
		for (GreekText greekText : greekTextList) {
			GntTextBean wordBean = this.convert(greekText);
			gntDAO.insertGntText(wordBean);
		}
	}
	
	
	public static void main(String[] args) throws Exception {

		String inputFolder = "D:\\Greek\\Data\\sblgnt\\";
		SnbGntImporter utils = new SnbGntImporter();		
		utils.initialize();
		utils.convert(inputFolder);
	}

}
