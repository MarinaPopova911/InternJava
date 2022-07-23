import entity.Equation;
import entity.Root;
import entity.Solve;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testEquation {
    @DataProvider(name = "equastion_dataprovider")
    public Object[][] dpEquastion() {
        return new Object[][]{
                {1.0, 12.0, 36.0, -6.0, null},
                {2.0, 5.0, -3.0, 0.5, -3.0},
                {2.0, 1.0, 67.0, null, null},
                {4.0, 11.0, 107.0, null, null},
                {1.0, 4.0, 3.0, -1.0, -3.0}
        };
    }

    @Test(dataProvider = "equastion_dataprovider")
    public void testEquation(Double a, Double b, Double c, Double x1, Double x2) {
        Root root;
        root = Solve.decide(new Equation(a, b, c));
        Assert.assertEquals(root.getX1(), x1);
        Assert.assertEquals(root.getX2(), x2);
    }
}