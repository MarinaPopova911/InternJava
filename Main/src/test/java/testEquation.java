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
                {1.0, 12.0, 36.0, "x = -6.0"},
                {2.0, 5.0, -3.0, "x1 = 2.0 x2 = -12.0"},
                {2.0, 1.0, 67.0, "The equation has no real roots"},
                {4.0, 11.0, 107.0, "The equation has no real roots"},
                {1.0, 4.0, 3.0, "x1 = -1.0 x2 = -3.0"}
        };
    }

    @Test(dataProvider = "equastion_dataprovider")

    public void testEquation(Double a, Double b, Double c, String str) {
        Root root;
        root = Solve.decide(new Equation(a, b, c));
        Assert.assertEquals(root.outputInLog(), str);
    }
}
