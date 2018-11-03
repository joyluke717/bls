package org.bls.gnt.parse.lexicon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class MounceDictionaryParser {

	private String fileName = null;
	
	private List<LexiconEntry> lexiconEntryList = new ArrayList<LexiconEntry>();
	
	public MounceDictionaryParser()
	{	
	}
	
	public List<LexiconEntry> getLexiconEntryList() {
		return lexiconEntryList;
	}

	private LexiconEntry convert(MoounceEntry entry, String word) {
		LexiconEntry lexicon = new LexiconEntry();
		lexicon.word = word;
		lexicon.frequency = entry.getFrequencyCount();
		lexicon.briefMeaning = entry.getDefinition();
		lexicon.Strong = entry.getStrongs().get(0);
		return lexicon;
	}
	
	public void parseFile(String file) throws Exception {
		this.fileName = file;
		this.parseImpl();
	}
		
	
	public void parseImpl() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(this.fileName));
        JsonParser parser = new JsonParser();
        Gson gson = new Gson();
		JsonElement rootElement = parser.parse(bufferedReader);
		JsonObject rootObj = (JsonObject) rootElement;
		Set<Map.Entry<String,JsonElement>> childObjectMap = rootObj.entrySet();
		for (Map.Entry<String,JsonElement> entry : childObjectMap) {
			String word = entry.getKey();
			JsonElement element = entry.getValue();
			MoounceEntry mEntry = gson.fromJson(element, MoounceEntry.class);
			LexiconEntry lEntry = convert(mEntry, word);
			lexiconEntryList.add(lEntry);
		}
	}
	
	public static void main(String[] args) throws Exception {
		String file = "D:\\Greek\\Data\\Dodson-Greek-Lexicon\\dodson.json";
		DocsonParser parser = new DocsonParser();
		parser.parseFile(file);
	}
}
