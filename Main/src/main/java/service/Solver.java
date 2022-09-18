package service;

import entity.Equation;
import entity.Root;

public class Solver {

    public static Root decide(Equation equation) {
        Double d = Math.pow(equation.getB(), 2) - 4 * equation.getA() * equation.getC();
        if (d > 0) {
            Double x1 = (-equation.getB() + Math.sqrt(d)) / (2 * equation.getA());
            Double x2 = (-equation.getB() - Math.sqrt(d)) / (2 * equation.getA());
            return new Root(x1, x2);
        } else if (d == 0) {
            Double x = -equation.getB() / 2 * equation.getA();
            return new Root(x);
        } else {
            return new Root();
        }
    }
}