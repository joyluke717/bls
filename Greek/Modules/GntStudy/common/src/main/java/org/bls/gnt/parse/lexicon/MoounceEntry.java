package org.bls.gnt.parse.lexicon;

import java.util.List;

public class MoounceEntry {

	private Integer gk;
	
	private List<Integer> strongs;

	private String lemma;
	
	private String transliteration;
	
	private Integer frequencyCount;
	
	private String definition;

	public Integer getGk() {
		return gk;
	}

	public void setGk(Integer gk) {
		this.gk = gk;
	}

	public List<Integer> getStrongs() {
		return strongs;
	}

	public void setStrongs(List<Integer> strongs) {
		this.strongs = strongs;
	}

	public String getLemma() {
		return lemma;
	}

	public void setLemma(String lemma) {
		this.lemma = lemma;
	}

	public String getTransliteration() {
		return transliteration;
	}

	public void setTransliteration(String transliteration) {
		this.transliteration = transliteration;
	}

	public Integer getFrequencyCount() {
		return frequencyCount;
	}

	public void setFrequencyCount(Integer frequencyCount) {
		this.frequencyCount = frequencyCount;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}
}
