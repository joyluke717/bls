package org.bls.greek.web.model;

public class GreekVocabulary {
	private String word;
	
	private String fullWord;
	
	private String briefMeaning;
	
	private String fullMeaning;
	
	private Integer frequency;
	
	private Integer Strong;

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getFullWord() {
		return fullWord;
	}

	public void setFullWord(String fullWord) {
		this.fullWord = fullWord;
	}

	public String getBriefMeaning() {
		return briefMeaning;
	}

	public void setBriefMeaning(String briefMeaning) {
		this.briefMeaning = briefMeaning;
	}

	public String getFullMeaning() {
		return fullMeaning;
	}

	public void setFullMeaning(String fullMeaning) {
		this.fullMeaning = fullMeaning;
	}

	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	public Integer getStrong() {
		return Strong;
	}

	public void setStrong(Integer strong) {
		Strong = strong;
	}
}