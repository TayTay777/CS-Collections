import java.util.Map;
import java.util.HashMap;

// This class provides a stubbed-out environment.
// You are expected to implement the methods.
// Accessing an undefined variable should throw an exception.

// Hint!
// Use the Java API to implement your Environment.
// Browse:
//   https://docs.oracle.com/javase/tutorial/tutorialLearningPaths.html
// Read about Collections.
// Focus on the Map interface and HashMap implementation.
// Also:
//   https://www.tutorialspoint.com/java/java_map_interface.htm
//   http://www.javatpoint.com/java-map
// and elsewhere.

public class Environment {

	//Added map class to migrate variable value to 
	//the next 'program' in the console
	private Map<String, Double> variable = new HashMap<>(); 
	
	
    //changed the return type to double
	public double put(String var, double val) 
	{ 
		variable.put(var, val);
		
		//added to print out write commands
		if (var.equals("wr")) 
			System.out.println(val);
		
		
		return val; 
	}



    //changed the return type to double
	public double get(int pos, String var) throws EvalException 
	{ 
		if (variable.containsKey(var)) {
			return variable.get(var);
		} 
		
		else {
			throw new EvalException(pos, "this '" + var + "'" + " "
					+ "variable's value has not been established");
		}
	}





}
