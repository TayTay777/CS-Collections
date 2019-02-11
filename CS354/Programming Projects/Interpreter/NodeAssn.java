
//class initializes id and expression, then gives to the environment
public class NodeAssn extends Node {

    private String id;
    private NodeExpr expr;

    public NodeAssn(String id, NodeExpr expr) {
	this.id=id;
	this.expr=expr;
    }

    //changed the return type to double
    public double eval(Environment env) throws EvalException {
	return env.put(id,expr.eval(env));
    }

}
