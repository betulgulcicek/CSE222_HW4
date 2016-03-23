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
public class IntegerVeriable extends Veriables {

    /**
     * veriablein degeri
     */
    private Integer value = new Integer(0);

    /**
     * no parameter Constructer
     */
    public IntegerVeriable() {
        super();
        value = 0;
    }

    /**
     * Constructer
     *
     * @param inType variable type - String value
     * @param inName veriable name - String value
     */
    public IntegerVeriable(String inType, String inName) {
        super(inType, inName);
        value = 0;
    }

    /**
     * Setter
     *
     * @param inValue variable a set edilecek deger
     */
    @Override
    public void setValue(Object inValue) {
        value = (Integer) inValue;
        isInitialized = true;
    }

    /**
     * Getter
     *
     * @return variable valuesu
     */
    @Override
    public Object getValue() {
        return value;
    }

    /**
     * TosString Method
     *
     * @return 
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(value);
        return sb.toString();
    }
}
