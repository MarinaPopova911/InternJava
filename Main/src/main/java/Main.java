import entity.Equation;
import entity.Root;
import exeptions.ParseArgumentEquastionExeption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.ParserArgumentEquation;
import service.Solver;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws ParseArgumentEquastionExeption {
        Equation equation; //= ParserArgumentEquation.parse(args);
       // equation = null;
        //equation = ParserArgumentEquation.parse(args);

        try {
            equation = ParserArgumentEquation.parse(args);
            if (equation == null) {
                throw new ParseArgumentEquastionExeption();
            }
            else {
                Root root = Solver.decide(equation);
                 logger.debug(equation.toString());
                logger.debug(root.toString());
            }
        } catch (ParseArgumentEquastionExeption e) {
            logger.debug(e.printExeption());
        }

      //  Root root = Solver.decide(equation);
       // logger.debug(equation.toString());
        //logger.debug(root.toString());
    }
}