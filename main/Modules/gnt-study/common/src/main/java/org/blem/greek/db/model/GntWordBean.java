package org.blem.greek.db.model;

public class GntWordBean {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gnt_word.id
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gnt_word.book_name
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    private String bookName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gnt_word.chapter
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    private Integer chapter;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gnt_word.verse
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    private Integer verse;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gnt_word.sequence
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    private Integer sequence;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gnt_word.text
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    private String text;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gnt_word.normalized_text
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    private String normalizedText;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gnt_word.type
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    private String type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gnt_word.morph_tag
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    private String morphTag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gnt_word.number
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    private String number;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gnt_word.gender
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    private String gender;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gnt_word.word_case
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    private String wordCase;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gnt_word.tense
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    private String tense;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gnt_word.voice
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    private String voice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gnt_word.mood
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    private String mood;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gnt_word.strong
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    private Integer strong;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gnt_word.lemma
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    private String lemma;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gnt_word.id
     *
     * @return the value of gnt_word.id
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gnt_word.id
     *
     * @param id the value for gnt_word.id
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gnt_word.book_name
     *
     * @return the value of gnt_word.book_name
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gnt_word.book_name
     *
     * @param bookName the value for gnt_word.book_name
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gnt_word.chapter
     *
     * @return the value of gnt_word.chapter
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    public Integer getChapter() {
        return chapter;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gnt_word.chapter
     *
     * @param chapter the value for gnt_word.chapter
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    public void setChapter(Integer chapter) {
        this.chapter = chapter;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gnt_word.verse
     *
     * @return the value of gnt_word.verse
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    public Integer getVerse() {
        return verse;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gnt_word.verse
     *
     * @param verse the value for gnt_word.verse
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    public void setVerse(Integer verse) {
        this.verse = verse;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gnt_word.sequence
     *
     * @return the value of gnt_word.sequence
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gnt_word.sequence
     *
     * @param sequence the value for gnt_word.sequence
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gnt_word.text
     *
     * @return the value of gnt_word.text
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    public String getText() {
        return text;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gnt_word.text
     *
     * @param text the value for gnt_word.text
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gnt_word.normalized_text
     *
     * @return the value of gnt_word.normalized_text
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    public String getNormalizedText() {
        return normalizedText;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gnt_word.normalized_text
     *
     * @param normalizedText the value for gnt_word.normalized_text
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    public void setNormalizedText(String normalizedText) {
        this.normalizedText = normalizedText == null ? null : normalizedText.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gnt_word.type
     *
     * @return the value of gnt_word.type
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gnt_word.type
     *
     * @param type the value for gnt_word.type
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gnt_word.morph_tag
     *
     * @return the value of gnt_word.morph_tag
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    public String getMorphTag() {
        return morphTag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gnt_word.morph_tag
     *
     * @param morphTag the value for gnt_word.morph_tag
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    public void setMorphTag(String morphTag) {
        this.morphTag = morphTag == null ? null : morphTag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gnt_word.number
     *
     * @return the value of gnt_word.number
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    public String getNumber() {
        return number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gnt_word.number
     *
     * @param number the value for gnt_word.number
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gnt_word.gender
     *
     * @return the value of gnt_word.gender
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    public String getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gnt_word.gender
     *
     * @param gender the value for gnt_word.gender
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gnt_word.word_case
     *
     * @return the value of gnt_word.word_case
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    public String getWordCase() {
        return wordCase;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gnt_word.word_case
     *
     * @param wordCase the value for gnt_word.word_case
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    public void setWordCase(String wordCase) {
        this.wordCase = wordCase == null ? null : wordCase.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gnt_word.tense
     *
     * @return the value of gnt_word.tense
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    public String getTense() {
        return tense;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gnt_word.tense
     *
     * @param tense the value for gnt_word.tense
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    public void setTense(String tense) {
        this.tense = tense == null ? null : tense.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gnt_word.voice
     *
     * @return the value of gnt_word.voice
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    public String getVoice() {
        return voice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gnt_word.voice
     *
     * @param voice the value for gnt_word.voice
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    public void setVoice(String voice) {
        this.voice = voice == null ? null : voice.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gnt_word.mood
     *
     * @return the value of gnt_word.mood
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    public String getMood() {
        return mood;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gnt_word.mood
     *
     * @param mood the value for gnt_word.mood
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    public void setMood(String mood) {
        this.mood = mood == null ? null : mood.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gnt_word.strong
     *
     * @return the value of gnt_word.strong
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    public Integer getStrong() {
        return strong;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gnt_word.strong
     *
     * @param strong the value for gnt_word.strong
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    public void setStrong(Integer strong) {
        this.strong = strong;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gnt_word.lemma
     *
     * @return the value of gnt_word.lemma
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    public String getLemma() {
        return lemma;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gnt_word.lemma
     *
     * @param lemma the value for gnt_word.lemma
     *
     * @mbg.generated Sat Jun 09 00:54:46 CDT 2018
     */
    public void setLemma(String lemma) {
        this.lemma = lemma == null ? null : lemma.trim();
    }
}