//logic for multiplying or dividing two raw double values
//methods are later used in NodeTerm.java
public class NodeMulop extends Node {

    private String mulop;

    public NodeMulop(int pos, String mulop) {
	this.pos=pos;
	this.mulop=mulop;
    }

    //changed int parameters to doubles for the op() method as well as method return type
    public double op(double o1, double o2) throws EvalException {
	if (mulop.equals("*"))
	    return o1*o2;
	if (mulop.equals("/"))
	    return o1/o2;
	throw new EvalException(pos,"bogus mulop: "+mulop);
    }

}
