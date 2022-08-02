import entity.Equation;
import exceptions.ParseArgumentEquationException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.ParserArgumentEquation;

public class testParserArgumentEquation {
    @DataProvider(name = "parserArgumentEquation_data provider")
    public Object[][] dbParserArgumentEquation() {
        return new Object[][]{{new String[]{"-a=1", "-b=12", "-c=36"}, new Equation(1.0, 12.0, 36.0)}};
    }

    @DataProvider(name = "parserArgumentEquation_data provider_error")
    public Object[][] dbParserArgumentEquation_error() {
        return new Object[][]{{new String[]{"-a=1", "-b=12"}, new ParseArgumentEquationException()}};
    }

    @Test(dataProvider = "parserArgumentEquation_data provider")
    public void testParserArgumentEquation(String[] args, Equation equation) {
        Assert.assertEquals(ParserArgumentEquation.parse(args), equation);
    }

    @Test(dataProvider = "parserArgumentEquation_data provider_error")
    public void testParserArgumentEquation_error(String[] args, ParseArgumentEquationException error) {
        Assert.assertEquals(ParserArgumentEquation.parse(args), error);
    }
}
