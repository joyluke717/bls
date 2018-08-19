package org.bls.gnt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.bls.gnt.db.DBGntBookDAOImpl;
import org.bls.gnt.db.dao.GntBookDAO;
import org.bls.gnt.db.model.GntWord;

public class Utils {

	private String inputFolder;
	
	private GntBookDAO gntDAO;
	
	public static WordIndex parse(String verseString) {
		WordIndex wordIndex = new WordIndex();
		String[] verseItems = verseString.split(":");
		wordIndex.chapter = Integer.parseInt(verseItems[0]);
		int index = verseItems[1].indexOf('.');
		String rest = verseItems[1];
		wordIndex.verse = Integer.parseInt(rest.substring(0, index));
		wordIndex.wordIndex = Integer.parseInt(rest.substring(index + 1, rest.length()));
		return wordIndex;
	}

	public void convert(File inputFile) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF8"));
	
		String line = null;
		while (true) {
			line = reader.readLine();
			if (line == null) {
				break;
			}
			String[] items = line.split(" ");
			String book = items[0];
			String verseString = items[1];

			WordIndex wordIndex = parse(verseString);

			String breakMark = items[2];
			String text = items[3];
			String morph_tag = items[5];
			int strongNumber = Integer.parseInt(items[6]);
			
			String lemma = items[7];
			GntWord word = new GntWord();
			word.setBookName(book);
			word.setChapter(wordIndex.chapter);
			word.setVerse(wordIndex.verse);
			word.setSequence(wordIndex.wordIndex);
			word.setText(text);
			word.setMorphTag(morph_tag);
			word.setLemma(lemma);
			word.setStrong(strongNumber);
			gntDAO.insertGntWord(word);
			System.out.println(book + " " + verseString);
		}
		reader.close();
	}

	public void convert() throws Exception {
		File directory = new File(inputFolder);
		File[] files = directory.listFiles();
		for (File file : files) {
			if (file.isFile()) {
				convert(file);
			}
		}
	}
	
	public void initialize() throws Exception {
		this.gntDAO = this.getDAO();
	}
	
	public GntBookDAO getDAO () throws Exception {
		 // Create SqlSessionFactory       
        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = 
          new SqlSessionFactoryBuilder().build(inputStream);
        
        GntBookDAO dao = new DBGntBookDAOImpl(sqlSessionFactory);
        return dao;        
	}
	
	public Utils(String fodler) {	
		this.inputFolder = fodler;
	}
	
	
	public static void main(String[] args) throws Exception {

		String inputFolder = "D:\\Greek\\Code\\tischendorf-data\\word-per-line\\2.7\\Unicode";
		Utils utils = new Utils(inputFolder);		
		utils.initialize();
		utils.convert();
	}

}
