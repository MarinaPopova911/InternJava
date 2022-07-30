package entity;


public class Root {
    private final Double x1;
    private final Double x2;

    public Root(Double x1, Double x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    public Root(Double x1) {
        this.x1 = x1;
        this.x2 = null;
    }

    public Root() {
        this.x1 = null;
        this.x2 = null;
    }

    public Double getX1() {
        return x1;
    }

    public Double getX2() {
        return x2;
    }

    @Override
    public String toString() {
        if (x1 != null && x2 != null) {
            return "x1 = " + x1 + " x2 = " + x2;
        } else if (x1 != null) {
            return "x = " + x1;
        } else {
            return "The equation has no real roots";
        }
    }
}