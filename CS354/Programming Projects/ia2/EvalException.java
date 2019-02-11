public class EvalException extends Exception {
	/**
	 * if an evalution is tried and not successful, this eval exception
	 * will show where in the node what could not be evaluated
	 */

	private static final long serialVersionUID = 1L;
	private int pos;
    private String msg;

    public EvalException(int pos, String msg) {
	this.pos=pos;
	this.msg=msg;
    }

    public String toString() {
	return "eval error"
	    +", pos="+pos
	    +", "+msg;
    }

}
