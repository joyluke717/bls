package org.bls.gnt.db.model;

public class GntLexiconBean {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gnt_lexicon.id
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gnt_lexicon.word
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
    private String word;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gnt_lexicon.full_word
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
    private String fullWord;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gnt_lexicon.meaning
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
    private String meaning;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gnt_lexicon.full_meaning
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
    private String fullMeaning;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gnt_lexicon.word_type
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
    private String wordType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gnt_lexicon.strong_number
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
    private Integer strongNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gnt_lexicon.frequency
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
    private Integer frequency;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gnt_lexicon.id
     *
     * @return the value of gnt_lexicon.id
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gnt_lexicon.id
     *
     * @param id the value for gnt_lexicon.id
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gnt_lexicon.word
     *
     * @return the value of gnt_lexicon.word
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
    public String getWord() {
        return word;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gnt_lexicon.word
     *
     * @param word the value for gnt_lexicon.word
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
    public void setWord(String word) {
        this.word = word == null ? null : word.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gnt_lexicon.full_word
     *
     * @return the value of gnt_lexicon.full_word
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
    public String getFullWord() {
        return fullWord;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gnt_lexicon.full_word
     *
     * @param fullWord the value for gnt_lexicon.full_word
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
    public void setFullWord(String fullWord) {
        this.fullWord = fullWord == null ? null : fullWord.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gnt_lexicon.meaning
     *
     * @return the value of gnt_lexicon.meaning
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
    public String getMeaning() {
        return meaning;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gnt_lexicon.meaning
     *
     * @param meaning the value for gnt_lexicon.meaning
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
    public void setMeaning(String meaning) {
        this.meaning = meaning == null ? null : meaning.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gnt_lexicon.full_meaning
     *
     * @return the value of gnt_lexicon.full_meaning
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
    public String getFullMeaning() {
        return fullMeaning;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gnt_lexicon.full_meaning
     *
     * @param fullMeaning the value for gnt_lexicon.full_meaning
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
    public void setFullMeaning(String fullMeaning) {
        this.fullMeaning = fullMeaning == null ? null : fullMeaning.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gnt_lexicon.word_type
     *
     * @return the value of gnt_lexicon.word_type
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
    public String getWordType() {
        return wordType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gnt_lexicon.word_type
     *
     * @param wordType the value for gnt_lexicon.word_type
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
    public void setWordType(String wordType) {
        this.wordType = wordType == null ? null : wordType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gnt_lexicon.strong_number
     *
     * @return the value of gnt_lexicon.strong_number
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
    public Integer getStrongNumber() {
        return strongNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gnt_lexicon.strong_number
     *
     * @param strongNumber the value for gnt_lexicon.strong_number
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
    public void setStrongNumber(Integer strongNumber) {
        this.strongNumber = strongNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gnt_lexicon.frequency
     *
     * @return the value of gnt_lexicon.frequency
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
    public Integer getFrequency() {
        return frequency;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gnt_lexicon.frequency
     *
     * @param frequency the value for gnt_lexicon.frequency
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }
}