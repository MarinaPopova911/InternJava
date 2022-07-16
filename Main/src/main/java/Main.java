import entity.Equation;
import entity.EquationDesign;
import entity.Root;
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
       // Equation equation = null;
        if (commandLine.hasOption("a") && commandLine.hasOption("b") && commandLine.hasOption("c")) {
            Double a, b, c;
            a = Double.parseDouble(commandLine.getOptionValue("a"));
            b = Double.parseDouble(commandLine.getOptionValue("b"));
            c = Double.parseDouble(commandLine.getOptionValue("c"));
            EquationDesign equationDesign = new EquationDesign(a,b,c);
            equationDesign.setD(a,b,c);
        }
    }
}