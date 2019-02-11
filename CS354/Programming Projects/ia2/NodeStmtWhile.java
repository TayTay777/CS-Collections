//constructor takes in a boolean expression and statement
public class NodeStmtWhile extends NodeStmt{

	NodeBoolExpr boolExpr;
	NodeStmt stmt;

	//while boolExpr == 1.0, stmt will be evaluated
	NodeStmtWhile(NodeBoolExpr boolExpr, NodeStmt stmt){
		this.boolExpr = boolExpr;
		this.stmt = stmt;
	}

	//while the the boolean value is true, the statement's evaluation
	//will keep returning, otherwise a 0.0 value will return for false
	public double eval(Environment env) throws EvalException {
		while (boolExpr.eval(env) == 1.0) {
			return stmt.eval(env);
		}
		return boolExpr.eval(env);
	}
}
