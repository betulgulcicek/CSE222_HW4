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
public class IntegerVeriable extends Veriables{

    private Integer value = new Integer(0);
    
    //Constructers
    public IntegerVeriable(){
        super();
        value = 0;
    }
    public IntegerVeriable(String inType, String inName) {
        super(inType, inName);
        value = 0;
    }
    //Setter
    public void setValue(Object inValue) {
        value = (Integer)inValue;
        isInitialized = true;
    }
    //Getter
    public Object getValue() {
        return value;
    }
    //TosString Method
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(value);
        return sb.toString();
    }
}
