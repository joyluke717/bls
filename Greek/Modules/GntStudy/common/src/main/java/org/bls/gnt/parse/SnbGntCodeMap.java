package org.bls.gnt.parse;

import java.util.HashMap;

public class SnbGntCodeMap {

	private static HashMap<String, String> partOfSpeechMap = new HashMap<String, String>();
	
	private static HashMap<String, HashMap<String, String>> morphMap = new HashMap<String, HashMap<String, String>>();
	
	private static String partOfSpeechMapStr = "A- adjective  \r\n" + 
			"C- conjunction  \r\n" + 
			"D- adverb  \r\n" + 
			"I- interjection  \r\n" + 
			"N- noun  \r\n" + 
			"P- preposition  \r\n" + 
			"RA definiteArticle  \r\n" + 
			"RD demonstrativePronoun  \r\n" + 
			"RI interrogativePronoun  \r\n" + 
			"RP personalPronoun  \r\n" + 
			"RR relativePronoun  \r\n" + 
			"V- verb  \r\n" + 
			"X- particle";
	
	private static String morphCodeMapStr = " * person (1=1st, 2=2nd, 3=3rd)\r\n" + 
			" * tense (P=present, I=imperfect, F=future, A=aorist, X=perfect, Y=pluperfect)\r\n" + 
			" * voice (A=active, M=middle, P=passive)\r\n" + 
			" * mood (I=indicative, D=imperative, S=subjunctive, O=optative, N=infinitive, P=participle)\r\n" + 
			" * case (N=nominative, G=genitive, D=dative, A=accusative)\r\n" + 
			" * number (S=singular, P=plural)\r\n" + 
			" * gender (M=masculine, F=feminine, N=neuter)\r\n" + 
			" * degree (C=comparative, S=superlative)";
	
	
	private static void parsePartOfSpeechMap() {
		String [] lines = partOfSpeechMapStr.split("\\r\\n");
		for (String line : lines) {
			line = line.trim();
			String [] items = line.split(" ");
			partOfSpeechMap.put(items[0],  items[1]);
		}
	}

	private static void parseMorpMap() {
		String [] lines = morphCodeMapStr.split("\\r\\n");
		for (String line : lines) {
			line = line.trim();
			// remove "* "
			line= line.substring(2,  line.length());
			
			int index = line.indexOf(" ");
			String category = line.substring(0, index);
			String codeListStr = line.substring(index + 1, line.length());
			
			HashMap<String, String> codeMap = new HashMap<String, String>();
			morphMap.put(category, codeMap); 
			
			codeListStr = codeListStr.substring(1,  codeListStr.length()-1);
			String [] codePairList = codeListStr.split(",");
			for (String codePair : codePairList) {
				codePair = codePair.trim();
				String [] codeItemList = codePair.split("=");
				codeMap.put(codeItemList[0], codeItemList[1]);
			}
		}
	}

	static {
		parsePartOfSpeechMap();
		parseMorpMap();
	}

	public static HashMap<String, String> getPartOfSpeechMap() {
		return partOfSpeechMap;
	}

	public static HashMap<String, HashMap<String, String>> getMorphCodeMap() {
		return morphMap;
	}	
	
	public static void main(String []args) {
		SnbGntCodeMap.getMorphCodeMap();
	}
}
