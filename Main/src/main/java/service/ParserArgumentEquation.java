package service;

import entity.Equation;
import exceptions.ParseArgumentEquationException;
import org.apache.commons.cli.*;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserArgumentEquation {

    private static Logger logger = LoggerFactory.getLogger(ParserArgumentEquation.class);

    public static Equation parse(String[] args) throws ParseArgumentEquationException {
        BasicConfigurator.configure();
        Equation equation = null;
        Options options = new Options();
        Option optionType = new Option("type", "argument1", true, "");
        Option optionA = new Option("a", "argument2", true, "");
        Option optionB = new Option("b", "argument3", true, "");
        Option optionC = new Option("c", "argument4", true, "");
        options.addOption(optionType);
        options.addOption(optionA);
        options.addOption(optionB);
        options.addOption(optionC);
        CommandLineParser parser = new DefaultParser();
        CommandLine commandLine = null;
        try {
            commandLine = parser.parse(options, args);
        } catch (ParseException pe) {
            logger.error(pe.getMessage());
        }
        if (commandLine.hasOption("type") && commandLine.getOptionValue("type").equals("coeff")) {
            if (commandLine.hasOption("a") && commandLine.hasOption("b") && commandLine.hasOption("c")) {
                Double a = Double.parseDouble(commandLine.getOptionValue("a"));
                Double b = Double.parseDouble(commandLine.getOptionValue("b"));
                Double c = Double.parseDouble(commandLine.getOptionValue("c"));
                equation = new Equation(a, b, c);
            } else {
                throw new ParseArgumentEquationException();
            }
        }
        if (commandLine.hasOption("type") && commandLine.getOptionValue("type").equals("equation")) {
            if (commandLine.hasOption("x^2") && commandLine.hasOption("x") && commandLine.hasOption("c")) {
                Double a = Double.parseDouble(commandLine.getOptionValue("x^2"));
                Double b = Double.parseDouble(commandLine.getOptionValue("x"));
                Double c = Double.parseDouble(commandLine.getOptionValue("c"));
                equation = new Equation(a, b, c);
            } else {
                throw new ParseArgumentEquationException();
            }
        }
        return equation;
    }
}

