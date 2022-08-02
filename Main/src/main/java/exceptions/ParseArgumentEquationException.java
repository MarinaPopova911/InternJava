package exceptions;

public class ParseArgumentEquationException extends RuntimeException {
    public ParseArgumentEquationException() {
        super("Invalid arg parse");
    }

    @Override
    public boolean equals(Object obj) {
        ParseArgumentEquationException e = (ParseArgumentEquationException) obj;
        ParseArgumentEquationException exception = this;
        return exception.equals(obj);
    }
}
