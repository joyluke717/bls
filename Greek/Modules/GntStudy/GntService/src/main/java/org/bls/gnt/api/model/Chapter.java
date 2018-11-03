package org.bls.gnt.api.model;

import java.util.List;

public class Chapter {
	
	private String bookName;
	
	private int totalVerse;
	
	private int chapterNumber;
	
	private List<Verse> verseList;

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getTotalVerse() {
		return totalVerse;
	}

	public void setTotalVerse(int totalVerse) {
		this.totalVerse = totalVerse;
	}

	public int getChapterNumber() {
		return chapterNumber;
	}

	public void setChapterNumber(int chapterNumber) {
		this.chapterNumber = chapterNumber;
	}

	public List<Verse> getVerseList() {
		return verseList;
	}

	public void setVerseList(List<Verse> verseList) {
		this.verseList = verseList;
	}
}