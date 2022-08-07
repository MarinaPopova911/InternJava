package entity;


public class Root {
    private final Double x1;
    private final Double x2;

    public Root(Double x1, Double x2) {
        assert x1 != null;
        assert x2 != null;
        this.x1 = x1;
        this.x2 = x2;
    }

    public Root(Double x1) {
        assert x1 != null;
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

    @Override
    public boolean equals(Object obj) {
        Root root = (Root) obj;
        if (this.x1 == null && this.x2 == null && root.x1 == null && root.x2 == null){
            return true;
        }
        if (this.x1 != null && this.x2 == null && root.x1 != null && root.x2 == null) {
            return this.x1.equals(root.x1);
        }
        return (this.x1.equals(root.x1) && this.x2.equals(root.x2))||(this.x1.equals(root.x2) && this.x2.equals(root.x1));
    }
}