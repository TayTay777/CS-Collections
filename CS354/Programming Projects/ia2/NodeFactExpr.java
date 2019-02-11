//constructor for expressions
//evaluates expressions
public class NodeFactExpr extends NodeFact {

    private NodeExpr expr;

    public NodeFactExpr(NodeExpr expr) {
	this.expr=expr;
    }

    //evaluates expressions
    public double eval(Environment env) throws EvalException {
	return expr.eval(env);
    }

}
