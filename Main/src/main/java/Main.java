import entity.Root;
import entity.Solve;
import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.log4j.BasicConfigurator;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
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
        Root root;
        if (commandLine.hasOption("a") && commandLine.hasOption("b") && commandLine.hasOption("c")) {
            Double a, b, c;
            a = Double.parseDouble(commandLine.getOptionValue("a"));
            b = Double.parseDouble(commandLine.getOptionValue("b"));
            c = Double.parseDouble(commandLine.getOptionValue("c"));
            Solve solve = new Solve(a, b, c);
            root = solve.decide();
            String result = root.outputInLog();
            logger.debug(result);
        }
    }
}