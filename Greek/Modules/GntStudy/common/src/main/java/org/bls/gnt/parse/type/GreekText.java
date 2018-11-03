package org.bls.gnt.parse.type;

import org.bls.gnt.parse.WordIndex;

public class GreekText {
	
	private GreekBook book;
	
	private WordIndex index;
	
	private String partSpeech;
	
	private Morph morph;
	
	private String text;
	
	private String word;
	
	private String normalizedWord;
	
	private String lemma;

	public GreekBook getBook() {
		return book;
	}

	public void setBook(GreekBook book) {
		this.book = book;
	}

	public WordIndex getIndex() {
		return index;
	}

	public void setIndex(WordIndex index) {
		this.index = index;
	}

	public String getPartSpeech() {
		return partSpeech;
	}

	public void setPartSpeech(String partSpeech) {
		this.partSpeech = partSpeech;
	}

	public Morph getMorph() {
		return morph;
	}

	public void setMorph(Morph morph) {
		this.morph = morph;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getNormalizedWord() {
		return normalizedWord;
	}

	public void setNormalizedWord(String normalizedWord) {
		this.normalizedWord = normalizedWord;
	}

	public String getLemma() {
		return lemma;
	}

	public void setLemma(String lemma) {
		this.lemma = lemma;
	}
}