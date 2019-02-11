//constructor take in an assignment Node and 
//then evaluates with .eval method
public class NodeStmtAssn extends NodeStmt {

    private NodeAssn assn;
    

    public NodeStmtAssn(NodeAssn assn) {
	this.assn=assn;
    }
    
    
    //changed the return type to double
    public double eval(Environment env) throws EvalException {
	return assn.eval(env);
    }

}
