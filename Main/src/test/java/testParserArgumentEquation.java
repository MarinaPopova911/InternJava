import entity.Equation;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.ParserArgumentEquation;

public class testParserArgumentEquation {
    @DataProvider(name = "parserArgumentEquation_dataprovider")
    public Object[][] dbParserArgumentEquation () {
        String[] str = {"-a=1" ,"-b=12", "-c=36"};
        String[] str1 = {"-a=1" ,"-b=12"};
        return new Object[][]{
               {str, new Equation(1.0,12.0,36.0)},
                {str1, null}
        };
    }

    @Test(dataProvider = "parserArgumentEquation_dataprovider")
    public void testParserArgumentEquation(String[] args, Equation equation) {
        Assert.assertEquals(ParserArgumentEquation.parse(args), equation);

    }
}
