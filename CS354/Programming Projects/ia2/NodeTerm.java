//class multiplies or divides given fact and term evaluations
public class NodeTerm extends Node {

    private NodeFact fact;
    private NodeMulop mulop;
    private NodeTerm term;

    public NodeTerm(NodeFact fact, NodeMulop mulop, NodeTerm term) {
	this.fact=fact;
	this.mulop=mulop;
	this.term=term;
    }

    //used for recursively parsing to the right,
    //append switches the first NodeTerm's mulop and term (from parseExpr()) 
    //with the last expr's mulop and term that's within NodeTerm object
    public void append(NodeTerm term) {
	if (this.term==null) {
	    this.mulop=term.mulop;
	    this.term=term;
	    term.mulop=null;
	} else
	    this.term.append(term);
    }

    //evaluates term and fact, then multiplies or devides them
    //if possible
    public double eval(Environment env) throws EvalException {
	return term==null
	    ? fact.eval(env)
	    : mulop.op(term.eval(env),fact.eval(env));
    }
}
