/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse222_hw4_101044025_betul_gulcicek;

/**
 *
 * @author BETUL
 */
public class Veriables {

    private String name;
    private String type;
    protected boolean isInitialized = false;

    /**
     * no parameter Constructer
     */
    public Veriables() {
        name = "";
        type = "";
    }

    /**
     * Constructers
     *
     * @param inType variable type - String value
     * @param inName variable name - String value
     */
    public Veriables(String inType, String inName) {
        name = inName;
        type = inType;
    }

    /**
     * setter method for veriable type
     *
     * @param inType veriable type
     */
    public void setType(String inType) {
        type = inType;
    }

    /**
     * setter method for veriable name
     *
     * @param inName veriable name
     */
    public void setName(String inName) {
        name = inName;
    }

    /**
     * setter method for veriable value
     *
     * @param inValue veriable value
     */
    public void setValue(Object inValue) {
    }

    /**
     * getter method for veriable initialized
     *
     * @return veriable initialized
     */
    public boolean getisInitialized() {
        return isInitialized;
    }

    /**
     * getter method for veriable value
     *
     * @return veriable value
     */
    public Object getValue() {
        return 0;
    }

    /**
     * getter method for veriable type
     *
     * @return veriable type
     */
    public String getType() {
        return type;
    }

    /**
     * getter method for veriable name
     *
     * @return veriable name
     */
    public String getName() {
        return name;
    }
}
