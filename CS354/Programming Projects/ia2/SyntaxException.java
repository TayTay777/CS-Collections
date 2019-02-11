
public class SyntaxException extends Exception {

	/**
	 * if a exptected syntax does not match, this toString will run
	 * indicating what was expected, and what was found in whatever position
	 * the parser is currently parsing for a statement.
	 */
	private static final long serialVersionUID = 1L;
	private int pos;
    private Token expected;
    private Token found;

    public SyntaxException(int pos, Token expected, Token found) {
	this.pos=pos;
	this.expected=expected;
	this.found=found;
    }

    public String toString() {
	return "syntax error"
	    +", pos="+pos
	    +", expected="+expected
	    +", found="+found;
    }
}
