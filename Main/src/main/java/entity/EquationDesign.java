package entity;

public class EquationDesign {
    private double a, b, c, d;

    public EquationDesign(Double a, Double b, Double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void setD(Double a, Double b, Double c) {
        Equation equation = new Equation(a, b, c);
        Root root;
        d = Math.pow(b, 2) - 4 * a * c;
        if (d > 0) {
            Double x1, x2;
            x1 = (-equation.getB() + Math.sqrt(d)) / 2 * equation.getA();
            x2 = (-equation.getB() - Math.sqrt(d)) / 2 * equation.getA();
            root = new Root(x1, x2);
        } else if (d == 0) {
            Double x;
            x = -equation.getB() / 2 * equation.getA();
            root = new Root(x);
        } else {
            root = new Root();
        }
        root.outputInLog();
    }


}
