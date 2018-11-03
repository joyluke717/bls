package org.bls.gnt.parse.lexicon;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.bls.gnt.db.DBGntLexiconDAOImpl;
import org.bls.gnt.db.dao.GntLexiconDAO;
import org.bls.gnt.db.model.GntLexiconBean;

public class MounceImporter {
	private GntLexiconDAO gntDAO;

	public GntLexiconBean convert(LexiconEntry entry) {
		GntLexiconBean lexiconBean = new GntLexiconBean();
		lexiconBean.setWord(entry.word);
		lexiconBean.setFullWord(entry.fullWord);
		lexiconBean.setMeaning(entry.briefMeaning);
		lexiconBean.setFullMeaning(entry.fullMeaning);
		lexiconBean.setFrequency(entry.frequency);
		lexiconBean.setStrongNumber(entry.Strong);
		return lexiconBean;
	}

	public void initialize() throws Exception {
		this.gntDAO = this.getDAO();
	}
	
	public GntLexiconDAO getDAO () throws Exception {
		 // Create SqlSessionFactory       
        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = 
          new SqlSessionFactoryBuilder().build(inputStream);
        
        GntLexiconDAO dao = new DBGntLexiconDAOImpl(sqlSessionFactory);
        return dao;        
	}
	
	
	public void convert(String fodler) throws Exception {	
		MounceDictionaryParser parser = new MounceDictionaryParser();
		parser.parseFile(fodler);
		List<LexiconEntry> greekTextList = parser.getLexiconEntryList();
		for (LexiconEntry entry : greekTextList) {
			GntLexiconBean lexicion = this.convert(entry);
			gntDAO.insertGntLexicon(lexicion);
		}
	}
	
	
	public static void main(String[] args) throws Exception {

		String inputFolder = "D:\\Greek\\Data\\dictionary\\dictionary.json";
		MounceImporter utils = new MounceImporter();		
		utils.initialize();
		utils.convert(inputFolder);
	}

}
