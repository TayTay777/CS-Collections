
//creates a node for factor expressions for catorgory purposes
//ie to better distinguish from say an ID or Negative
public class NodeFactExpr extends NodeFact {

    private NodeExpr expr;

    public NodeFactExpr(NodeExpr expr) {
	this.expr=expr;
    }

    //changed the return type to double
    public double eval(Environment env) throws EvalException {
	return expr.eval(env);
    }

}
