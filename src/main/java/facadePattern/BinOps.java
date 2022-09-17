package facadePattern;

import adapterPattern.IntsCalculator;

public class BinOps {
    protected IntsCalculator calculator;

    public BinOps(){
        this.calculator = new IntsCalculator();
    }
    public String sum(String a, String b) {
        return Integer.toBinaryString(calculator.sum(Integer.parseInt(a, 2), Integer.parseInt(b, 2)));
    }

    public String mult(String a, String b) {
        return Integer.toBinaryString(calculator.mult(Integer.parseInt(a, 2), Integer.parseInt(b, 2)));
    }
}
