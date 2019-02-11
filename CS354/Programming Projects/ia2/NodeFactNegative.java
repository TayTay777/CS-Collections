//Node class to support a -* factor
//check grammar.txt file for comparison to '-' operator

public class NodeFactNegative extends NodeFact {

	private NodeFact fact;


	public NodeFactNegative(NodeFact fact) {
		this.fact = fact;
	}


	public double eval(Environment env) throws EvalException {
		return -(double) fact.eval(env);
	}
}
