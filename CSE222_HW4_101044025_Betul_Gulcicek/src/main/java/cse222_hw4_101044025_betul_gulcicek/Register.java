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
public class Register {

    /**
     * Veriable
     */
    private Veriables veriable;

    /**
     * register location
     */
    private String location;
    /**
     * register status
     */
    private boolean registerEmpty;

    /**
     * no parameter constructor
     */
    public Register() {
        veriable = new Veriables();
        location = new String();
        registerEmpty = true;
    }

    /**
     * constructor
     *
     * @param veriable Veriable
     * @param location register location
     * @param registerEmpty register status
     */
    public Register(Veriables veriable, String location, boolean registerEmpty) {
        this.veriable = veriable;
        this.location = location;
        this.registerEmpty = registerEmpty;

    }

    /**
     * getter method for variable
     *
     * @return the veriable
     */
    public Veriables getVeriable() {
        return veriable;
    }

    /**
     * setter method for variable
     *
     * @param veriable the veriable to set
     */
    public void setVeriable(Veriables veriable) {
        this.veriable = veriable;
    }

    /**
     * getter method for location
     *
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * setter method for location
     *
     * @param location the location to set
     */
    public void setLocation(String location) {
/*        if(Integer.parseInt(location) < 0 || Integer.parseInt(location) > 11)
        {
            throw new IndexOutOfBoundsException("Location Out!");
        }*/
        this.location = location;
    }

    /**
     * getter method for registerStatus
     *
     * @return the registerStatus
     */
    public boolean getRegisterEmpty(String location) {

        return registerEmpty;
    }

    /**
     * setter method for registerStatus
     *
     * @param registerStatus the registerStatus to set
     */
    public void setRegisterEmpty(boolean registerStatus) {
        this.registerEmpty = registerStatus;
    }

}
