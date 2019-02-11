//class is the constructor for assignments, storing 
//the id and value into an environment object
//for example, if Y = 33, then Y = 33 will be stored 
//in the environment for later use if Y is called upon
//like X = Y + 3
public class NodeAssn extends Node {

    private String id;
    private NodeExpr expr;

    public NodeAssn(String id, NodeExpr expr) {
	this.id=id;
	this.expr=expr;
    }

    //puts the id and its value into the environment
    //which is then stored in a map object if needed later
    public double eval(Environment env) throws EvalException {
	return env.put(id,expr.eval(env));
    }

}
