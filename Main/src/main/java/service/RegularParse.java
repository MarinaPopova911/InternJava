package service;

import entity.Equation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularParse {
    private static final String REGULAR_EQUATION_PATTERN = "([-]?[1.0-9.0]{1,})x\\^2([+-][1.0-9.0]{1,})x([+-][0-9]{1,})=0";

    public static Equation parseEquation(String stringEquation) {
        Pattern compile = Pattern.compile(REGULAR_EQUATION_PATTERN);
        Matcher matcher = compile.matcher(stringEquation);
        if (matcher.matches()) {
            Double a = Double.valueOf(matcher.group(1));
            Double b = Double.valueOf(matcher.group(2));
            Double c = Double.valueOf(matcher.group(3));
            return new Equation(a, b, c);
        }
        return null;
    }
}
