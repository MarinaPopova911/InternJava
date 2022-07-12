public class Main {

    public static void main(String[] args) {
        double a, b, c, d;

        a = Double.parseDouble(args[0]);
        b = Double.parseDouble(args[1]);
        c = Double.parseDouble(args[2]);
        d = Math.pow(b, 2) - 4 * a * c;
        if (d > 0) {
            double x1, x2;
            x1 = (-b + Math.sqrt(d)) / 2 * a;
            x2 = (-b - Math.sqrt(d)) / 2 * a;
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        } else if (d == 0) {
            double x;
            x = -b / 2 * a;
            System.out.println("x = " + x);
        } else {
            System.out.println("The equation has no real roots");
        }
    }
}

