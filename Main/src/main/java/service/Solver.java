package service;

import entity.Equation;
import entity.Root;

public class Solver {

    public static Root decide(Equation equation) {
        Root root = null;
        Double d = Math.pow(equation.getB(), 2) - 4 * equation.getA() * equation.getC();
        if (d > 0) {
            Double x1, x2;
            x1 = (-equation.getB() + Math.sqrt(d)) / (2 * equation.getA());
            x2 = (-equation.getB() - Math.sqrt(d)) / (2 * equation.getA());
            root = new Root(x1, x2);
        } else if (d == 0) {
            Double x;
            x = -equation.getB() / 2 * equation.getA();
            root = new Root(x);
        } else {

            root = new Root();
        }

        return root;
    }
}