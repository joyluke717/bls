package org.bls.gnt.db.model;

public class GntBook {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gnt_book.id
     *
     * @mbg.generated Mon Jul 23 11:44:47 CDT 2018
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gnt_book.name
     *
     * @mbg.generated Mon Jul 23 11:44:47 CDT 2018
     */
    private String name;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gnt_book.id
     *
     * @return the value of gnt_book.id
     *
     * @mbg.generated Mon Jul 23 11:44:47 CDT 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gnt_book.id
     *
     * @param id the value for gnt_book.id
     *
     * @mbg.generated Mon Jul 23 11:44:47 CDT 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gnt_book.name
     *
     * @return the value of gnt_book.name
     *
     * @mbg.generated Mon Jul 23 11:44:47 CDT 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gnt_book.name
     *
     * @param name the value for gnt_book.name
     *
     * @mbg.generated Mon Jul 23 11:44:47 CDT 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}