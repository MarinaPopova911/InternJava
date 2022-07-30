package entity;

public class Equation {
    private final Double a;
    private final Double b;
    private final Double c;

    public Equation(Double a, Double b, Double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    @Override
    public String toString() {
        String equation = a + "x^2+" + b + "x+" + c +"=0";
        return equation;
    }
}
