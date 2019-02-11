//constructor take in an expression
//used for writing to the console
public class NodeStmtWr extends NodeStmt{

	private NodeExpr expr;

	//evaluates an expression, then writes that value out of 
	//the environment
	public NodeStmtWr(NodeExpr expr) throws EvalException {
		this.expr = expr;
	}
	
	//evaluates expression
    public double eval(Environment env) throws EvalException {
    	return expr.eval(env);
    }
}
