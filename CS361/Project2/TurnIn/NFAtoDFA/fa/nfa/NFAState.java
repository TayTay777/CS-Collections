package fa.nfa;

import fa.State;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.HashSet;


public class NFAState extends State {

	private Set<NFAState> toStateSet;  //holds possible toStates
	private HashMap<Character, Set<NFAState>> delta;//delta
	private boolean isFinal;//remembers final or not final 

	//constructor
	public NFAState(String name){
		initDefault(name);
		isFinal = false;
	}

	//constructor for final states
	public NFAState(String name, boolean isFinal){
		initDefault(name);
		this.isFinal = isFinal;
	}

	//initializes delta and class variable name
	private void initDefault(String name ){
		this.name = name;
		delta = new HashMap<Character, Set<NFAState>>();
	}

	//returns true/false if a state is final
	public boolean isFinal(){
		return isFinal;
	}

	//adds transition to next state traveling over onSymb
	public void addTransition(char onSymb, NFAState toState){
		if(delta.get(onSymb) == null) {
			toStateSet = new HashSet<NFAState>();
			toStateSet.add(toState);
			delta.put(onSymb, toStateSet);
		}
		else
			delta.get(onSymb).add(toState);
	}

	//returns to states for a symb
	public Set<NFAState> getTo(char symb){
		return delta.get(symb);
	}
}
