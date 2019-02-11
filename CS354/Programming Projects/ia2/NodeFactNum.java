//constructor that takes in a variables value, 
//then returns it. 
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
