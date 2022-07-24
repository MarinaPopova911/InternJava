package entity;

public class Solve {

    public static Root decide(Equation equation) {
        Root root = null;
        try {
            Double d = Math.pow(equation.getB(), 2) - 4 * equation.getA() * equation.getC();
            if(equation.getA() == 0) throw new ArithmeticException("Division by 0");
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
                throw new ArithmeticException("The equation has no real root");
                root = new Root();
            }
        } catch (ArithmeticException exception) {
            System.out.println(exception);
        }
            return root;
    }
}
