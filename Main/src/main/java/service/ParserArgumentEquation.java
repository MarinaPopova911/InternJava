package service;

import entity.Equation;
import exeptions.ParseArgumentEquastionExeption;
import org.apache.commons.cli.*;
import org.apache.log4j.BasicConfigurator;

public class ParserArgumentEquation {

    public static Equation parse(String[] args) throws ParseArgumentEquastionExeption{
        Equation equation = null;
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
                Double a = Double.parseDouble(commandLine.getOptionValue("a"));
                Double b = Double.parseDouble(commandLine.getOptionValue("b"));
                Double c = Double.parseDouble(commandLine.getOptionValue("c"));
                equation = new Equation(a, b, c);
            }
            else {
                try {
                    throw  new ParseArgumentEquastionExeption();
                } catch (ParseArgumentEquastionExeption e) {
                 System.out.println(e.printExeption());
                }
            }
        return equation;
    }
}
