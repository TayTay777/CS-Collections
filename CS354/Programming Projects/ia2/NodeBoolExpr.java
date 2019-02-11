//constructor that compares two expression values and 
//then calls upon the relop.op method to return of value 
//of 1.0 or 0.0, 1 being true, 0 being false
public class NodeBoolExpr {

	
    private NodeExpr exprOne;
    private NodeRelop relop;
    private NodeExpr exprTwo;
	
	public NodeBoolExpr(NodeExpr exprOne, NodeRelop relop, NodeExpr exprTwo) {
		this.exprOne = exprOne;
		this.relop = relop;
		this.exprTwo = exprTwo;	
	}
	
    public double eval(Environment env) throws EvalException {
	return exprTwo==null
	    ? exprOne.eval(env)
	    : relop.op(exprOne.eval(env),exprTwo.eval(env));
    }
}
