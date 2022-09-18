package exceptions;

public class ParseArgumentEquationException extends RuntimeException {
    public ParseArgumentEquationException() {
        super("Invalid arg parse");
    }
}
