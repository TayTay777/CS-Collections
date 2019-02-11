/*
 * @author Taylor Paul Roberts
 * 
 * Interface and coceptual skeleton authors: BSU CS Department, including @author elenasherman
 * 
 */


package fa.nfa;
import fa.dfa.DFA;
import fa.dfa.DFAState;
import java.util.LinkedHashSet;
import java.util.Set;
import fa.FAInterface;
import fa.State;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeSet;
import java.util.LinkedList; 
import java.util.LinkedHashMap;


public class NFA implements fa.FAInterface, fa.nfa.NFAInterface {


	private NFAState start; //The one and only start state!
	private Set<NFAState> states; //all the states
	private Set<Character> sigma; //set of Sigma. (move characters)


	//Constructor
	public NFA() {
		states = new LinkedHashSet<NFAState>();
		sigma = new LinkedHashSet<Character>();
	}


	//adds and sets an NFAState's condition to final 
	public void addFinalState(String name){
		NFAState s = new NFAState(name, true);
		states.add(s);
	}


	//returns an already established state from a string
	private NFAState getState(String name){
		NFAState ret = null;
		for(NFAState s : states){
			if(s.getName().equals(name)){
				ret = s;
				break;
			}
		}
		return ret;
	}


	//creates and adds an NFAState from a string
	public void addState(String name) {
		NFAState s = new NFAState(name);
		states.add(s);
	}


	//adds transitions to nfa
	public void addTransition(String fromState, char onSymb, String toState){
		(getState(fromState)).addTransition(onSymb, getState(toState));
		if(!sigma.contains(onSymb)){
			sigma.add(onSymb);
		}
	}


	//adds start state to nfa
	public void addStartState(String name){
		NFAState s = getState(name);
		if(s == null){
			s = new NFAState(name);
			states.add(s);
		}
		start = s;
	}



	//creates a dfa object with nfa components

	public DFA getDFA() {

		boolean EmptyState = false;
		DFA dfa = new DFA();
		Queue<Set<NFAState>> dfaQueue = new LinkedList<>();

		//collection of stacks used for storing transitions to be added to DFA
		Stack<String> dfaFrom = new Stack<String>();
		Stack<Character> dfaChar = new Stack<Character>();
		Stack<String> dfaTo = new Stack<String>();
		TreeSet myTreeSet;

		//helps by keeping track of what has already been in the queue needed for duplicate states.
		Set<Set<NFAState>> addedToDFA = new LinkedHashSet<Set<NFAState>>();


		//Start dfaQueue off with eClosure of NFA start state
		dfaQueue.add(eClosure(start));


		/*
		 * While loop traverses all DFA from states, thens adds the toStates
		 * from NFA together into combinedSet
		 * 
		 * 
		 * Does not go over a DFA state that has already been through the while 
		 * loop thanks to beenInQueue
		 * 
		 * 
		 */



		while (dfaQueue.peek() != null) {
			for (char move : sigma) {
				if (move != 'e') {
					Set<NFAState> combinedSet = new LinkedHashSet<NFAState>();
					for (NFAState state : dfaQueue.peek()) {
						if (getToState(state, move) != null) {
							for (NFAState stateCom : getToState(state, move)) {
								//CombinedSet: adds columns of toStates together from NFA 
								//to create a proper toState for an DFA
								combinedSet.add(stateCom);
							}
						}
					}

					//adds from character to from stack
					dfaFrom.push(dfaQueue.peek().toString());

					//adds Start State
					if(dfaQueue.peek().equals(eClosure(start))) {
						dfa.addStartState(dfaQueue.peek().toString());
						addedToDFA.add(dfaQueue.peek());
					}

					/*
					 * for loop finds out what states are final, 
					 * then adds them with the addFinalState setter. 
					 * If not final, after for loop, following if loop adds the rest
					 * 
					 */

					for (NFAState state : dfaQueue.peek()) {
						if(!addedToDFA.contains(dfaQueue.peek())) {
							if (state.isFinal()) {
								dfa.addFinalState(dfaQueue.peek().toString());
								addedToDFA.add(dfaQueue.peek());
								break;
							}
						}
					}

					if(!addedToDFA.contains(dfaQueue.peek())) {
						dfa.addState(dfaQueue.peek().toString());
						addedToDFA.add(dfaQueue.peek());
					}




					//adds traversing character to the character stack 
					dfaChar.push(move);



					/* Very important for changing the order of strings
					 * within a set of states because when added to DFA they are added
					 * as strings, making a set of states with different ordering
					 * of states a completely different state when changing from
					 * a set of states to one state within the DFA class. Utilizing the 
					 * java.util.TreeSet, I stored all the elements within a treeSet object,
					 * which ordered everything in numerical order, then I add the elements 
					 * back to combinedSet, in that numerical order 
					 */
					
					myTreeSet = new TreeSet();
					for(NFAState state : combinedSet) {
						myTreeSet.add(state.toString());
					}
					//transition characters added for transition here
					dfaTo.push(myTreeSet.toString());
					combinedSet.clear();
					for(Object state : myTreeSet) {
						combinedSet.add(getState(state.toString()));
					}


					//handy if statement to avoid the same states being
					//run through the while loop again
					if (!addedToDFA.contains(combinedSet)) {
						dfaQueue.add(combinedSet);
					}					
				}
			}
			dfaQueue.remove();
		}


		
		/*
		 * Below, all the way to the return statement, is where the transitions are 
		 * added to the DFA. 
		 * 
		 * The addTransition is used later because the method 
		 * only takes in string values that are match with already established states
		 * which are not fully established until the while loop for the dfaQueue is finished.
		 * 
		 * If any toStates for the already added states of the DFA equal null, then the empty 
		 * state "[]" is added, and then all the states that have a toState of null are changed
		 * by adding the empty state "[]" in place of the null.
		 * 
		 */


		//adds Transitions to dfa object from regular traversals
		while (dfaFrom.isEmpty() != true) {
			dfa.addTransition(dfaFrom.pop(), dfaChar.pop(), dfaTo.pop());
		}


		//Checks for empty transitions, then if they exist, changes EmptyState boolean to true
		for (char c : sigma) {
			if (c != 'e') {                                 
				for (DFAState state : dfa.getStates()) {  
					if (dfa.getToState(state, c) == null) {   
						EmptyState = true;                    
					}                             
				}											
			}                                  
		}     
		

		//traversals for empty states        
		if(EmptyState == true) {            
			dfa.addState("[]");
			for (char charTwo : sigma) {
				if (charTwo != 'e') {
					for (DFAState state : dfa.getStates()) {
						if (dfa.getToState(state, charTwo) == null) {
							dfa.addTransition(state.toString(), charTwo, "[]");
						}
					}
				}
			}
		}
		return dfa;
	}
	

	/*                 ****Personal Note for getToState()****   
	 * a free move is a free move. The toState is only a toState, 
	 * after the onSymb is consumed. Saying that, a free move is, 
	 * a free move, meaning all e transitions can be traversed, 
	 * regardless of the onSymb being consumed. 
	 * Ex: from "1" onSymb 'a'; 1e1 -> 1e4 -> 4a3 -> 3e2; toStates = [3, 2]
	 */


	/*
	 * returns toStates of an NFAState under traversal of a specific onSymb, 
	 * this includes episilon inclusions after consumption of onSymb
	 */
	public Set<NFAState> getToState(NFAState from, char onSymb){

		//variables used for endless loop prevention
		Boolean loopOneStart = false;
		Boolean loopTwoStart = false;
		NFAState QepsilonStart;

		Queue<NFAState> qEpsilon = new LinkedList<>();
		Queue<NFAState> qConsumed = new LinkedList<>();
		Set<NFAState> toStates = new LinkedHashSet<NFAState>();

		qEpsilon.add(from);

		while ((qEpsilon.peek() != null)) {

			
			//loop breaking logic
			if (loopOneStart == true) {
				if (qEpsilon.peek().equals(from)) {
					break;
				}
			}
			loopOneStart = true;

			
			for (NFAState state : states) {
				//System.out.println("epsilon");
				if (state.toString().equals(qEpsilon.peek().toString())) {
					if (state.getTo('e') != null) {
						for (NFAState toStatesEpsilon : state.getTo('e')) {
							qEpsilon.add(toStatesEpsilon);
						}
					}
					if (state.getTo(onSymb) != null) {
						for (NFAState toStatesOnSym : state.getTo(onSymb)) {
							getState(from.toString()).addTransition(onSymb, toStatesOnSym);
							qConsumed.add(toStatesOnSym);
						}
					}
				}
			}
			qEpsilon.remove();
		}

		QepsilonStart = qConsumed.peek();
		while ((qConsumed.peek() != null)) {

			
			//loop breaking logic
			if (loopTwoStart == true) {
				if (qConsumed.peek().equals(QepsilonStart)) {
					break;
				}
			}
			loopTwoStart = true;

			
			for (NFAState state : states) {
				if (state.toString().equals(qConsumed.peek().toString())) {
					if (state.getTo('e') != null) {
						for (NFAState stateACPE : state.getTo('e')) {
							getState(from.toString()).addTransition(onSymb, stateACPE);
							qConsumed.add(stateACPE);
						}
					}
				}
			}
			qConsumed.remove();
		}

		toStates = getState(from.toString()).getTo(onSymb);
		return toStates;
	}



	/*
	 * returns a set of states that are reached via the method of closure, 
	 * this includes the state itself, and all epsilon connections
	 */
	public Set<NFAState> eClosure(NFAState s){
		//BFS algorithm
		
		//variables used for endless loop prevention
		Boolean avoidLoop = false;
		NFAState start = s;
		
		Queue<NFAState> q = new LinkedList<>();
		Set<NFAState> eClosures = new LinkedHashSet<NFAState>();

		q.add(s);

		while (q.peek() != null) {
			
			
			//loop breaking logic
			if (avoidLoop == true) {
				if (q.peek().equals(start)) {
					break;
				}
			}
			avoidLoop = true;
			
			
			for (NFAState state : states) {
				if (state.toString().equals(q.element().getName())) {
					if (getToState(state, 'e') != null) {
						for (NFAState toState : getToState(state, 'e')) {
							q.add(toState);
						}
					}
				}
			}
			eClosures.add(q.remove());
		}
		return eClosures;
	}

	public Set<NFAState> getStates(){
		return states;
	}




	//returns all final states
	public Set<NFAState> getFinalStates(){
		Set<NFAState> finalStates = new LinkedHashSet<NFAState>(); //set of final states
		for (NFAState state : states) {
			if (state.isFinal() == true) {
				finalStates.add(state);
			}
		}
		return finalStates;
	}


	//returns start state
	public NFAState getStartState() {
		return start;
	}


	//returns collection of sigma
	public Set<Character> getABC(){
		return sigma;
	}

}
