//constructor takes in a boolean expression, like > or < 
//as well one or two statements. 
//statements are executed depending on the values of the 
//boolean expressions
public class NodeStmtIf extends NodeStmt {

	NodeBoolExpr boolExpr;
	NodeStmt stmt;
	NodeStmt stmtTwo;


	//for if-then statement
	//if boolean expression is not true, the statement will not be executed
	public NodeStmtIf(NodeBoolExpr boolExpr, NodeStmt stmt) {
		this.boolExpr = boolExpr;
		this.stmt = stmt;
	}

	//for if-then-else statement
	//if boolean expression is not true, the first statement will not be executed
	//but the second statement will
	public NodeStmtIf(NodeBoolExpr boolExpr, NodeStmt stmt, NodeStmt stmtTwo) {
		this.boolExpr = boolExpr;
		this.stmt = stmt;
		this.stmtTwo = stmtTwo;
	}


	//depending on what NodeStmt object gets chosen
	//eval will either return a statement evaluation or
	//return a "0.0" value indicating false.
	public double eval(Environment env) throws EvalException {
		if (stmtTwo == null) {

			if (boolExpr.eval(env) == 1.0) {
				return stmt.eval(env);
			}
			else {
				return boolExpr.eval(env);
			}
		}
		else {

			if (boolExpr.eval(env) == 1.0) {
				return stmt.eval(env);
			}
			else {
				return stmtTwo.eval(env);
			}
		}
	}
}

