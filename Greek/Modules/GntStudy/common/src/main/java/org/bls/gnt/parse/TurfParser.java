package org.bls.gnt.parse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.bls.gnt.db.DBGntTextDAOImpl;
import org.bls.gnt.db.dao.GntTextDAO;
import org.bls.gnt.db.model.GntTextBean;

public class TurfParser {

	private String inputFolder;
	
	private GntTextDAO gntDAO;
	
	public static WordIndex parse(String verseString) {
		WordIndex wordIndex = new WordIndex();
		String[] verseItems = verseString.split(":");
		wordIndex.chapter = Integer.parseInt(verseItems[0]);
		int index = verseItems[1].indexOf('.');
		String rest = verseItems[1];
		wordIndex.verse = Integer.parseInt(rest.substring(0, index));
		wordIndex.wordSequence = Integer.parseInt(rest.substring(index + 1, rest.length()));
		return wordIndex;
	}

	public void convert(File inputFile, Set<Character> charSet) throws Exception {
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
			GntTextBean word = new GntTextBean();
			word.setBookShortName(book);
			word.setChapterNumber(wordIndex.chapter);
			word.setVerseNumber(wordIndex.verse);
			word.setSequenceNumber(wordIndex.wordSequence);
			word.setText(text);
			word.setMorphTag(morph_tag);
			word.setLemma(lemma);
			word.setStrong(strongNumber);
			//gntDAO.insertGntWord(word);
			//System.out.println();
			for (char ch : text.toCharArray()) {
				//char lastChar = text.charAt(text.length()-1);
				if (ch == ',' || ch == ',' || ch == ',' || ch == ',' || ch == ',') {
					
				}
				charSet.add(ch);
			}
			if (text.contains("[") || text.contains("]") || text.contains("·") || text.contains("ʹ") || text.contains("’")) {
				System.out.println(text);
			}
			
			//charSet.add(lastChar);
			
		}
		reader.close();
	}

	public void convert() throws Exception {
		Set<Character> charSet = new HashSet<Character>();
		
		File directory = new File(inputFolder);
		File[] files = directory.listFiles();
		for (File file : files) {
			if (file.isFile()) {
				convert(file, charSet);
			}
		}
		
		Object [] charArray = charSet.toArray();
		Arrays.sort(charArray);
		
		for (Object c : charArray) {
			System.out.print((Character) c + " ");
		}
		System.out.println();
		System.out.println(charArray.length);

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
	
	public TurfParser(String fodler) {	
		this.inputFolder = fodler;
	}
	
	
	public static void main(String[] args) throws Exception {

		String inputFolder = "D:\\Greek\\Data\\tischendorf-data\\word-per-line\\2.7\\Unicode\\";
		TurfParser utils = new TurfParser(inputFolder);		
		utils.initialize();
		utils.convert();
	}

}
