import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double a, b, c, d;
        System.out.println("Enter a, b, c");
        Scanner in = new Scanner(System.in);
        a = in.nextDouble();
        b = in.nextDouble();
        c = in.nextDouble();

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

