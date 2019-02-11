
//creates nodefactnum object
public class NodeFactNum extends NodeFact {

    private String num;

    public NodeFactNum(String num) {
	this.num=num;
    }

    //changed the return type to double
    public double eval(Environment env) throws EvalException {
	return Double.parseDouble(num);
    }

}
