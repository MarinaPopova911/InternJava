import entity.Equation;
import exceptions.ParseArgumentEquationException;
import org.apache.commons.cli.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.ParserArgumentEquation;

public class ParserArgumentEquationTest {
    @DataProvider(name = "parserArgumentEquationDataProvider")
    public Object[][] dbParserArgumentEquation() {
        return new Object[][]{
                {new String[]{"-type=coeff", "-a=1", "-b=12", "-c=36"}, new Equation(1.0, 12.0, 36.0)},
                {new String[]{"-type=coeff", "-a=7", "-b=-1", "-c=-5"}, new Equation(7.0, -1.0, -5.0)},
                {new String[]{"-type=coeff","-a=4", "-b=-1", "-c=-5"}, new Equation(4.0, -1.0, -5.0)},
                {new String[]{"-type=equation","-e=-6.2x^2+9.3x-10=0"}, new Equation(-6.2, 9.3, -10.0)},
                {new String[]{"-type=equation","-e=2.0x^2-3.0x+5=0"}, new Equation(2.0, -3.0, 5.0)}
        };
    }

    @DataProvider(name = "parserArgumentEquationDataProviderError")
    public Object[][] dbParserArgumentEquationError() {
        return new Object[][]{
                {new String[]{"-a=1", "-b=12"}},
                {new String[]{"-a=рнрs", "-c=12"}},
                {new String[]{"-a=3"}},
                {new String[]{"-type=equation", "-a=4", "-b=-1", "-c=-5"}},
                {new String[]{"-type=earg", "-a=4", "-b=-1", "-c=-5"}},
                {new String[]{"-type=coeff", "-e=2.0x^2-3.0x+5=0"}},
                {new String[]{"-type=equation", "-a=4", "-b=-1"}},

        };
    }

    @Test(dataProvider = "parserArgumentEquationDataProvider")
    public void testParserArgumentEquation(String[] args, Equation equation) throws ParseException {
        Assert.assertEquals(ParserArgumentEquation.parse(args), equation);
    }

    @Test(dataProvider = "parserArgumentEquationDataProviderError")
    public void testParserArgumentEquationError(String[] args) {
        try {
            ParserArgumentEquation.parse(args);
        } catch (ParseArgumentEquationException e) {
            return;
        } catch (Throwable throwable) {
            Assert.fail("Incorrect throwable: expected ParseArgumentEquationException / actual " + throwable.getClass());
        }
        Assert.fail("Error args not have throwable");
    }
}