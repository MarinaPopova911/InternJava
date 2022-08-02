import entity.Equation;
import entity.Root;
import exceptions.ParseArgumentEquationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.ParserArgumentEquation;
import service.Solver;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws ParseArgumentEquationException {
        Equation equation;
        try {
            equation = ParserArgumentEquation.parse(args);
            Root root = Solver.decide(equation);
            logger.debug(equation.toString());
            logger.debug(root.toString());
        } catch (ParseArgumentEquationException e) {
            logger.error(e.getMessage());
        }
    }
}