import entity.Equation;
import entity.Root;
import service.Solver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SolverTest {
    @DataProvider(name = "equation_data provider")
    public Object[][] dpEquation() {
        return new Object[][]{
                {new Equation(1.0, 12.0, 36.0), new Root(-6.0)},
                {new Equation(2.0, 5.0, -3.0), new Root(0.5, -3.0)},
                {new Equation(2.0, 1.0, 67.0), new Root()},
                {new Equation(4.0, 11.0, 107.0), new Root()},
                {new Equation(1.0, 4.0, 3.0), new Root(-3.0, -1.0)},
                {new Equation(1.0, 4.0, 3.0), new Root(-1.0, -3.0)}
        };
    }

    @Test(dataProvider = "equation_data provider")
    public void testEquation(Equation equation, Root x) {
        Root root = Solver.decide(equation);
        Assert.assertEquals(root, x);
    }
}