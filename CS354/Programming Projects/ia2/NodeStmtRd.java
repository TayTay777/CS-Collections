import java.util.Scanner;

//reads in a value to the specified id name during execution
//then puts the id and value into the environment
public class NodeStmtRd extends NodeStmt{

	private Scanner scanner;
	private String id;
	private double value; 
	
	
	public NodeStmtRd(String id) {
		this.id = id;
		scanner = new Scanner(System.in);
		value = scanner.nextDouble();
	}
	
    public double eval(Environment env) throws EvalException {
	return env.put(id,value);
    }
}
