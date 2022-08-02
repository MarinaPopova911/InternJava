package service;

import entity.Equation;
import exceptions.ParseArgumentEquationException;
import org.apache.commons.cli.*;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParserArgumentEquation {

    private static Logger logger = LoggerFactory.getLogger(ParserArgumentEquation.class);

    public static Equation parse(String[] args) throws ParseArgumentEquationException {
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
            logger.error(pe.getMessage());
            throw new ParseArgumentEquationException();
        }
        if (commandLine.hasOption("a") && commandLine.hasOption("b") && commandLine.hasOption("c")) {
            Double a = Double.parseDouble(commandLine.getOptionValue("a"));
            Double b = Double.parseDouble(commandLine.getOptionValue("b"));
            Double c = Double.parseDouble(commandLine.getOptionValue("c"));
            return new Equation(a, b, c);
        } else {
            throw new ParseArgumentEquationException();
        }
    }
}
