//constructor for Statements
public class NodeStmt extends Node {

    private NodeAssn assn;

    public NodeStmt(NodeAssn assn) {
	this.assn=assn;
    }

    //changed the return type to double
    public double eval(Environment env) throws EvalException {
	return assn.eval(env);
    }
}
