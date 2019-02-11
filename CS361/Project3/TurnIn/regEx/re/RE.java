package re;
import java.util.Vector;
import fa.dfa.DFA;
import fa.nfa.NFA;

/**
 * Takes in a regular expression from a .txt file, then constructs a NFA
 * object based off of the regular expression. 
 * 
 * 
 * @author Taylor Paul Roberts
 *
 */
public class RE implements re.REInterface{
	//class variable
	private String regEx;
	
	
	/**
	 * Constructor. 
	 * 
     * The regular expression can contain characters '(', ')', 'a', 'b', 'e', '|' , and '*'.
     * 'a', 'b', 'e', are transition characters, '(' and ')' are used to contain expressions,
     * '|' represents the U union symbol, and '*' represents a loop.
	 * 
	 * 
	 * @param regEx - the regular expression from test file
	 */
	public RE(String regEx) {
		this.regEx = regEx;
	}


	
	/**
	 * @return NFA - NFA object contructed from regular expression
	 */
	public NFA getNFA() {
		
		
		Vector<String> mainStorage = new Vector<String>();
		int stateValCounter = 0;
		boolean subStringStarted = false;
		boolean matchFound = false;




		for (char chari : regEx.toCharArray()) {
			mainStorage.add(""+chari);
		}

		//wraps regEx in parenthesis for recursive functionality 
		//to cover the entire regEx after sub parens are dealt with
		mainStorage.add(0, "(");
		mainStorage.add(")");



		/*
		 *This is the beginning of the "brains" behind the operation. 
		 *Basically this while loop with keep going until all the expressions 
		 *within parenthesis are evaluated, starting with the inner most expression
		 *first, then the next level of presidence, and then the next... and so forth.
		 *Fairly simple logic. Don't be intimidated. The majority of the complexity of
		 *this program lyes here where an inner most expression is evaluated. 
		 *For example the logic behind evaluating (a|bbb|a) and then adding states 
		 *can be fairly complex if making a program that evaluates iterably, but really
		 *thats it. I found out once something at the innermost level is evaluated, it
		 *can then be condensed and then treated like a transition character. for example 
		 *if I wanted to evaluate (aa(a|b)), I would first evaluate (a|b), the inner most 
		 *expression, then I would evaluate (aa(a|b)). Now if I evaluated (a|b), then treated 
		 *it like a transition character then the same algorithem could be used to evaluate 
		 *(aa(a|b)) as (a|b). Pretty simple.
		 */
		
		//since all expressions wrapped in parenthesis will eventually have
		//an 'F' character in front of them, This is a simple way to check if 
		// every expression has been evaluted since the outter most parenthesis 
		//is going to be the last expression evaluated.
		while (mainStorage.get(0).charAt(0) != 'F') {	

			int endIndex = 0;
			int beginIndex = 0;

			for (int i = 0; i < mainStorage.size(); i++) {

				//These two "if" statements might be confusing as to how 
				//they work, but basically, the '(' character will get
				//overwritten to the one desired before the matching ')' 
				//character is found. 
				if (mainStorage.elementAt(i).equals("(")) {
					beginIndex = i;
				}
				if (mainStorage.elementAt(i).equals(")")){
					endIndex = i;

					String tempStr = "";
					String tempInd = "";
					int indexX = 0;
					Vector<String> tempVec = new Vector<String>();

					//traverses the expression
					for (int ii = beginIndex; ii <= endIndex; ii++) {
						tempStr = tempStr + mainStorage.get(ii);
						tempVec.add(mainStorage.get(ii));
						
						//very important. 
						//Used to store the index of multiple union
						//characters within one expression
						if (mainStorage.get(ii).equals("|")) {
							tempInd = tempInd + "+" + indexX;
						}
						indexX++;
					}
					
					//'E' used as end filler to help with 
					//searching through index string
					tempInd = tempInd + "E";

					
					//leftMove is the left side of the union
					//rightMove is the right side of the union
					String leftMove="";
					String rightMove="";
					boolean leftFin = false;
					boolean rightFin = false;

					int plus = 0;
					
					//as mentioned before, there could be several unions 
					//within an expression. This traverses them. 
					for (char chari : tempInd.toCharArray()) {
						if (chari == '+') {
							
							//here plus records how many unions are within 
							//the expression by counting the '+' characters 
							//that are within tempInd
							plus++;
						}
					}

					int plusPos = 1;

					while (plusPos != (plus + 1)){
						int forPlusPos = 0;

						//creates strings for what will be unioned on the left side
						//and what will be unioned on the right side of the union sign
						for (int iii = 0; iii < tempVec.size(); iii++) {
							if (tempVec.get(iii).equals("|")) {
								
								//incremented
								forPlusPos++;
							}
							
							//here it checks what union sign should be 
							//evaluated. Creates leftMove
							//and rightMove
							if (forPlusPos == plusPos) {
								if (tempVec.get(iii - 1).equals("*"))
									leftMove = tempVec.get(iii - 2);
								else leftMove = tempVec.get(iii - 1);
								rightMove = tempVec.get(iii + 1);
								break;
							}
						}

						
						int plusIndexCount = 0;
						String index = "";
						
						//creates an index variable called "index"
						//for the current union index
						for (int iii = 0; iii < tempInd.length();iii++) {
							if (tempInd.charAt(iii) == '+') {
								plusIndexCount++;
							}

							if (plusIndexCount == plusPos) {
								iii++;
								while((tempInd.charAt(iii) != '+')) {
									index = index + tempInd.charAt(iii);
									iii++;
									if (tempInd.charAt(iii) == 'E') {
										break;
									}
								}
								break;
							}
						}

						
						/*
						 *Some key concepts to unionize two transitions. If you put the same state on the left side of
						 *both transitions, then another state on the right side of both transitions, you'll create a union.
						 *Adding 'e' transitions is very helpful in making connections because they do not mess up traversals.
						 *For example a|b, after the while loops, (1)a(2) (1)b(2). (state)transition(state)
						 *Why add 'e's around the transition? Thinking ahead, they ensure there will be no conflicts say
						 *if I had (a|bb|a) or (a|bbb|a). You'll see later that all the stateless spots where there should be
						 *a state will be added later. 
						 */
						
						//adds states and 'e' transitions to the left transition of the 
						//union sign
						int left = Integer.parseInt(index);
						while (leftFin == false) {
							if (tempVec.elementAt(left).contains(leftMove)) {
								tempVec.setElementAt( "<" + "e" + stateValCounter + "e" + tempVec.elementAt(left) + "e" +(stateValCounter + 1) + "e", left);
								leftFin = true;
								break;
							}
							left = left - 1;
						}

						//adds states and 'e' transitions to the right transition of the 
						//union sign
						int right = Integer.parseInt(index);
						while (rightFin == false) {
							if (tempVec.elementAt(right).contains(rightMove)) {
								tempVec.setElementAt(">" + "e" + stateValCounter + "e" + tempVec.elementAt(right) + "e" + (stateValCounter + 1) + "e", right);
								rightFin = true;
								break;
							}
							right = right + 1;
						}

						rightFin = false;
						leftFin = false;
						plusPos++;
						stateValCounter = stateValCounter + 2;
						rightMove = "";
						leftMove = "";
					}

					String compress = "";

					//goes over all the characters for the expression
					//and adds them together into one string
					for (String string : tempVec) {
						compress = compress + string;
					}
					
					//'F' symbol is put in front and behind the
					//string to signify it is finished
					//***This string is treated like a state. 
					compress = "F" + compress + "F";
					
					//compressed expression is added to main storage
					mainStorage.add(beginIndex, compress);

					//strings that were condensed into "compress" 
					//are removed here because they are now together
					//into one string.
					for (int iii = 0; iii < tempVec.size(); iii++) {
						mainStorage.remove(beginIndex + 1);
					}
					break;
				}
			}
		}



		/*
		 *After everythings is propertly evaluated, states added where they need to be,
		 *then condensed, they are then pulled back apart and then more states are added 
		 *where they need to be. 
		 *
		 */

		String mainString = mainStorage.get(0);
		mainStorage.remove(0);

		for (int ii = 0; ii < mainString.length(); ii++) {
			if  ( (mainString.charAt(ii) == 'F')
					|| (mainString.charAt(ii) == '>')
					|| (mainString.charAt(ii) == '<')
					) {

			}
			else mainStorage.add(mainString.charAt(ii)+"");
		}

		//adds states
		//'B' and 'E' are for adding states to the beginning and end
		mainStorage.add(0, "B");
		mainStorage.add("E");

		
		//for loop for adding additional states in between transition characters
		//that do not have a state to move to. Excludes adding a state after a
		//transition character that has a '|' union operator right after it.
		//incrementing the stateValCounter variable every time a new state is 
		//added ensures that no states will incorrectly connect
		for (int ii = 0; ii < mainStorage.size(); ii++) {

			if  ( (mainStorage.get(ii).equals("a"))
					|| (mainStorage.get(ii).equals("b"))
					|| (mainStorage.get(ii).equals("e")) 
					|| (mainStorage.get(ii).equals("B"))) {

				if (mainStorage.get(ii +1).equals("*") ){
					ii++;
				}

				while (mainStorage.get(ii +1).equals("(") ){
					ii++;
				}



				//this logic makes sure that the state is added before the ")" 
				//rather than after. Helps with "*" logic later
				if (mainStorage.get(ii +1).equals(")") ){
					int start = ii;
					while ( (mainStorage.get(ii +2).equals("*")) 
							|| (mainStorage.get(ii +2).equals(")"))
							|| (mainStorage.get(ii +2).equals("("))
							){
						ii++;
					}
					if  ( (mainStorage.get(ii + 2).equals("a"))
							|| (mainStorage.get(ii + 2).equals("b"))
							|| (mainStorage.get(ii + 2).equals("e")) 
							|| (mainStorage.get(ii + 2).equals("E"))) {
						mainStorage.add(start+1, stateValCounter+"");
						stateValCounter++;
					}
				}

				//for adding states normally
				else if  ( (mainStorage.get(ii + 1).equals("a"))
						|| (mainStorage.get(ii + 1).equals("b"))
						|| (mainStorage.get(ii + 1).equals("e")) ) {

					mainStorage.add(ii+1, stateValCounter+"");
					stateValCounter++;
				}

			}

		}
		stateValCounter++;


		//this is the loop logic. 
		//Basically finds out if the loop is for a parenthesis encased operation
		//or a single trasition character by scanning to the left until it runs into
		//one or the other, then makes sure that the same state is on either side of it
		for (int ii = (mainStorage.size() - 1); ii >= 0; ii--) {
			if (mainStorage.get(ii).equals("*")) {
				while ( !((mainStorage.get(ii).equals("a"))
						|| (mainStorage.get(ii).equals("b"))
						|| (mainStorage.get(ii).equals(")"))

						)) {
					ii--;
				}

				//for single transition character loops
				if ( (mainStorage.get(ii).equals("a"))
						|| (mainStorage.get(ii).equals("b"))
						){
					mainStorage.add(ii, ""+stateValCounter);
					mainStorage.add(ii, "e");
					mainStorage.add(ii+3, "e");
					mainStorage.add(ii+3, ""+stateValCounter);
					stateValCounter++;
				}

				//for looped expressions
				if (mainStorage.get(ii).equals(")")){
					int parCount = 1;
					boolean stored = false;
					String starState = "";
					while (parCount != 0) {
						ii--;
						if (stored == false) {
							if (!( (mainStorage.get(ii).equals("e")) 
									|| (mainStorage.get(ii).equals("b"))
									|| (mainStorage.get(ii).equals("a"))
									|| (mainStorage.get(ii).equals(")"))
									|| (mainStorage.get(ii).equals("("))
									|| (mainStorage.get(ii).equals("*"))
									|| (mainStorage.get(ii).equals("|"))
									|| (mainStorage.get(ii).equals("B"))
									|| (mainStorage.get(ii).equals("E"))
									))
							{
								starState = mainStorage.get(ii);
								stored = true;
							}
						}
						if (mainStorage.get(ii).equals("(")) {
							parCount--;
						}
						if (mainStorage.get(ii).equals(")")) {
							parCount++;
						}
						//System.out.println(parCount+" this is the parCount");
					}
					//for multiple "(" next to each other
					while(mainStorage.get(ii + 1).equals("(")) {
						ii++;
					}
					mainStorage.remove(ii + 1);
					mainStorage.add(ii+1, starState);
				}
			}
		}


		//removes un-needed info for DFA input
		for (int ii = 0; ii < mainStorage.size(); ii++) {
			if ((  (mainStorage.get(ii).equals(")"))
					|| (mainStorage.get(ii).equals("("))
					|| (mainStorage.get(ii).equals("*"))
					|| (mainStorage.get(ii).equals("|"))
					|| (mainStorage.get(ii).equals("B"))
					|| (mainStorage.get(ii).equals("E"))
					)) {
				mainStorage.remove(ii);
				ii--;
			}
		}


		Vector<String> stateSet = new Vector<String>();

		//adds states to a set, to avoid duplication
		//ii starts at 1 and ends -1 from end so as to 
		//not add the start and final states to stateSet
		for (int ii = 1; ii < mainStorage.size()-1; ii++) {
			if (!( (mainStorage.get(ii).equals("e"))
					|| (mainStorage.get(ii).equals("a"))
					|| (mainStorage.get(ii).equals("b"))
					)) {
				stateSet.add(mainStorage.get(ii));
			}
		}


		String startState = mainStorage.get(0);
		String finalState = mainStorage.get(mainStorage.size()-1);



		//puts transitions into a vector
		//every three strings in the vector is a transition
		Vector<String> trans = new Vector<String>();
		for (int ii = 0; ii < mainStorage.size(); ii++) {

			if (!((ii + 2) >= mainStorage.size()) || !((ii + 1) >= mainStorage.size())) {
				if (!((mainStorage.get(ii).equals("e"))
						|| (mainStorage.get(ii).equals("a"))
						|| (mainStorage.get(ii).equals("b"))
						)){
					if (!((mainStorage.get(ii+2).equals("e"))
							|| (mainStorage.get(ii+2).equals("a"))
							|| (mainStorage.get(ii+2).equals("b"))
							)) {
						trans.add(trans.size(),mainStorage.get(ii));
						trans.add(trans.size(),mainStorage.get(ii+1));
						trans.add(trans.size(),mainStorage.get(ii+2));
					}	
				}
			}
		}


		
		NFA nfa = new NFA();
		
		//adds state and final state to NFA object
		nfa.addFinalState(finalState);
		nfa.addStartState(startState);
		
		//adds states to NFA object
		for (int ii = 0; ii < stateSet.size(); ii++) {
			nfa.addState(stateSet.get(ii));
		}
		
		//adds transitions to NFA object
		for (int ii = 0; ii <= trans.size()-3; ii = ii + 3) {
			nfa.addTransition(trans.get(ii), trans.get(ii+1).charAt(0), trans.get(ii+2));
		}
		
		return nfa;
	}
}
