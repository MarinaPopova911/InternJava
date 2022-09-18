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
    public Double getA() {
        return a;
    }

    public Double getB() {
        return b;
    }

    public Double getC() {
        return c;
    }

    @Override
    public String toString() {
        return a + "x^2+" + b + "x+" + c +"=0";
    }

    @Override
    public boolean equals(Object obj) {
        Equation o = (Equation) obj;
        return this.a.equals(o.a) && this.b.equals(o.b) && this.c.equals(o.c);
    }
}
