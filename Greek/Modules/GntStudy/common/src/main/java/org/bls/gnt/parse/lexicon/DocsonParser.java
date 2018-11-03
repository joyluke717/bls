package org.bls.gnt.parse.lexicon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class DocsonParser {

	private String fileName = null;
	
	private List<LexiconEntry> lexiconEntryList = new ArrayList<LexiconEntry>();
	
	public DocsonParser()
	{	
	}
	
	public List<LexiconEntry> getLexiconEntryList() {
		return lexiconEntryList;
	}

	private LexiconEntry convert(DocsonEntry entry) {
		LexiconEntry lexicon = new LexiconEntry();
		lexicon.fullWord = entry.getOrth();
		for (DocsonDefinition definition : entry.getDef()) {
			if (definition.getRole().equals("brief")) {
				lexicon.briefMeaning = definition.getText();
			}
			else if (definition.getRole().equals("full")) {
				lexicon.fullMeaning = definition.getText();
			}
		}
		String text = entry.getN();
		int index = text.indexOf('|');
		String word = text.substring(0,  index).trim();
		lexicon.word = word;
		return lexicon;
	}
	
	public void parseFile(String file) throws Exception {
		this.fileName = file;
		this.parseImpl();
	}
		
	
	public void parseImpl() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(this.fileName));
        Gson gson = new Gson();
		Docson docson = gson.fromJson(bufferedReader, Docson.class);
		System.out.println(docson.getEntry().size());
		for (DocsonEntry entry : docson.getEntry()) {
			lexiconEntryList.add(this.convert(entry));
		}
	}
	
	public static void main(String[] args) throws Exception {
		String file = "D:\\Greek\\Data\\Dodson-Greek-Lexicon\\dodson.json";
		DocsonParser parser = new DocsonParser();
		parser.parseFile(file);
	}
}
