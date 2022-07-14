import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.log4j.BasicConfigurator;
public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        double a = 0, b = 0, c = 0, d = 0;
        BasicConfigurator.configure();
        Options options = new Options();
        Option optionA = new Option("a", "argument1", true, "");
        Option optionB = new Option("b", "argument2", true, "");
        Option optionC = new Option("c", "argument3", true, "");
        options.addOption(optionA);
        options.addOption(optionB);
        options.addOption(optionC);
        CommandLineParser parser = new DefaultParser();
        CommandLine commandLine = null;
        try {
            commandLine = parser.parse(options, args);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        if (commandLine.hasOption("a") && commandLine.hasOption("b") && commandLine.hasOption("c")) {
            a = Double.parseDouble(commandLine.getOptionValue("a"));
            b = Double.parseDouble(commandLine.getOptionValue("b"));
            c = Double.parseDouble(commandLine.getOptionValue("c"));
        }
        d = Math.pow(b, 2) - 4 * a * c;
        if (d > 0) {
            double x1, x2;
            x1 = (-b + Math.sqrt(d)) / 2 * a;
            x2 = (-b - Math.sqrt(d)) / 2 * a;
            logger.debug("x1 = " + x1);
            logger.debug("x2 = " + x2);
        } else if (d == 0) {
            double x;
            x = -b / 2 * a;
            logger.debug("x=" + x);
        } else {
            logger.debug("The equation has no real roots");
        }
    }
}