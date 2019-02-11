//constructor that retrieves already established id's name
public class NodeFactId extends NodeFact {

    private String id;

    public NodeFactId(int pos, String id) {
	this.pos=pos;
	this.id=id;
    }

    //changed the return type to double
    public double eval(Environment env) throws EvalException {
	return env.get(pos,id);
    }

}
