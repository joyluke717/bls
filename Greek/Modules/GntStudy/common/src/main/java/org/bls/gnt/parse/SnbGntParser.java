package org.bls.gnt.parse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bls.gnt.parse.type.GreekBook;
import org.bls.gnt.parse.type.GreekText;
import org.bls.gnt.parse.type.Morph;
import org.bls.gnt.parse.type.MorphCategoryType;

public class SnbGntParser {

	private String inputFolder;
	
	private List<GreekText> greekTextList = new ArrayList<GreekText>();
	
	private List<GreekBook> greekBookList = new ArrayList<GreekBook>();;
	
	public List<GreekText> getGreekTextList() {
		return greekTextList;
	}


	public void setGreekTextList(List<GreekText> greekTextList) {
		this.greekTextList = greekTextList;
	}

	public List<GreekBook> getGreekBookList() {
		return greekBookList;
	}


	public void setGreekBookList(List<GreekBook> greekBookList) {
		this.greekBookList = greekBookList;
	}


	private WordIndex parseWordIndex(String verseString) {
		WordIndex wordIndex = new WordIndex();
		wordIndex.book = Integer.parseInt(verseString.substring(0,2));
		wordIndex.chapter = Integer.parseInt(verseString.substring(2,4));
		wordIndex.verse = Integer.parseInt(verseString.substring(4,6));
		return wordIndex;
	}

	
	private Morph parseMorp(String morphString) {
		Morph morph = new Morph();
		if(morphString.length() != 8) {
			return null;
		}
		morph.person = parseMorpCode(morphString, 0, MorphCategoryType.person.name());
		morph.tense = parseMorpCode(morphString, 1, MorphCategoryType.tense.name()); 
		morph.voice = parseMorpCode(morphString, 2, MorphCategoryType.voice.name());
		morph.mood = parseMorpCode(morphString, 3, MorphCategoryType.mood.name()); 
		morph.wordCase = parseMorpCode(morphString, 4, "case");
		morph.number = parseMorpCode(morphString, 5, MorphCategoryType.number.name());
		morph.gender = parseMorpCode(morphString, 6, MorphCategoryType.gender.name());
		morph.degree = parseMorpCode(morphString, 7, MorphCategoryType.degree.name());
		
		morph.parsingCode = morphString;
		return morph;
	}
	
	private String parseMorpCode(String morpString, int index, String category) {
		String code = morpString.substring(index, index + 1);
		if (code.equals("-")) {
			return null;
		}
		return parseMorpCode(code, category);
	}
	
	private String parseMorpCode(String code, String codeType) {
		
		HashMap<String, HashMap<String, String>> morphCodeMap = SnbGntCodeMap.getMorphCodeMap();
		HashMap<String, String> codeMap = morphCodeMap.get(codeType);
		return codeMap.get(code);
	}
	
	private String parsepartOfSpeech(String str) {		
		HashMap<String, String> partOfSpeechMap = SnbGntCodeMap.getPartOfSpeechMap();
		return partOfSpeechMap.get(str);
	}
	
	private String extractBookName (String fileName) {
		fileName = fileName.substring(3,  fileName.length());
		int index = fileName.indexOf("-");
		if(index < 0) {
			return null;
		}
		return fileName.substring(0, index);
	}
	public void convert(File inputFile) throws Exception {
		System.out.println(inputFile.getName());
		
		String fileName = inputFile.getName();
		String bookShortName = extractBookName(fileName);
		if (bookShortName == null) {
			return;
		}
		
		GreekBook book = new GreekBook();
		book.bookShortName = bookShortName;
		greekBookList.add(book);
		
		int lastVerse = 0;
		int wordSequence = 1;
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF8"));
		String line = null;
		while (true) {
			line = reader.readLine();
			if (line == null) {
				break;
			}
			GreekText greekText = this.parseLine(line);
			greekText.setBook(book);
			int currentVerse = greekText.getIndex().verse;
			if (currentVerse != lastVerse) {
				wordSequence = 1;
				lastVerse = currentVerse;
			}
			else {
				wordSequence ++;
			}
			greekText.getIndex().wordSequence = wordSequence;
			greekTextList.add(greekText);
		}
		reader.close();
	}
	
	private GreekText parseLine(String line) {
		String[] items = line.split(" ");
		String verseString = items[0];
		String partOfSpeechStr = items[1];
		String morphCode = items[2];
		String text = items[3];
		String word = items[4];
		String normalizedWord = items[5];
		String lemma = items[6];
		
		
		GreekText gntWord = new GreekText();
		
		WordIndex wordIndex = this.parseWordIndex(verseString);
		gntWord.setIndex(wordIndex);
		
		// Morph
		Morph morph = this.parseMorp(morphCode);
		gntWord.setMorph(morph);
		
		String partOfSpeech = parsepartOfSpeech(partOfSpeechStr);		
		gntWord.setPartSpeech(partOfSpeech);
		
		gntWord.setText(text);
		gntWord.setLemma(lemma);
		gntWord.setNormalizedWord(normalizedWord);
		gntWord.setWord(word);
		
		return gntWord;
	}

	private void parse() throws Exception  {
		File directory = new File(inputFolder);
		File[] files = directory.listFiles();
		for (File file : files) {
			if (file.isFile()) {
				convert(file);
			}
		}
	}
	
	public void parseFolder(String fodler) throws Exception  {	
		this.inputFolder = fodler;
		this.parse();
	}
	
	public static void main(String[] args) throws Exception {

		String folder = "D:\\Greek\\Data\\sblgnt\\";
		SnbGntParser parser = new SnbGntParser();		
		parser.parseFolder(folder);
		List<GreekText> textList = parser.getGreekTextList();
		System.out.println(textList.size());
	}
}
