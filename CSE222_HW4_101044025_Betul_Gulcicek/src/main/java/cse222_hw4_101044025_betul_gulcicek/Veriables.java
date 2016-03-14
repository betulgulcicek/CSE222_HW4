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

    //Constructers
    public Veriables() {
        name = "";
        type = "";
    }

    public Veriables(String inType, String inName) {
        name = inName;
        type = inType;
    }

    public void setType(String inType) {
        type = inType;
    }

    public void setName(String inName) {
        name = inName;
    }

    public void setValue(Object inValue) {
    }

    public boolean getisInitialized() {
        return isInitialized;
    }

    public Object getValue() {
        return 0;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
