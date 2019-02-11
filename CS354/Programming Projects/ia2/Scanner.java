// This class is a scanner for the program
// and programming language being interpreted.

import java.util.*;

public class Scanner {

	private String program;	// source program being interpreted
	private int pos;		// index of next char in program
	private Token token;	// last/current scanned token
	private int statements; // number of statements with one arg[]

	// sets of various characters and lexemes
	private Set<String> whitespace = new HashSet<String>();
	private Set<String> digits = new HashSet<String>();
	private Set<String> letters = new HashSet<String>();
	private Set<String> legits = new HashSet<String>();
	private Set<String> keywords = new HashSet<String>();
	private Set<String> operators = new HashSet<String>();
	private Set<String> comment = new HashSet<String>();
	private Set<String> words = new HashSet<String>();


	// initializers for previous sets

	private void fill(Set<String> s, char lo, char hi) {
		for (char c=lo; c<=hi; c++)
			s.add(c+"");
	}    

	private void initWhitespace(Set<String> s) {
		s.add(" ");
		s.add("\n");
		s.add("\t");
	}

	private void initDigits(Set<String> s) {
		fill(s,'0','9');
		//added the '.' character for double values
		s.add(".");
	}

	private void initLetters(Set<String> s) {
		fill(s,'A','Z');
		fill(s,'a','z');
	}

	private void initLegits(Set<String> s) {
		s.addAll(letters);
		s.addAll(digits);
	}

	//add relation operators
	//nextOp already has code for characters
	//longer than one length
	private void initOperators(Set<String> s) {
		s.add("=");
		s.add("+");
		s.add("-");
		s.add("*");
		s.add("/");
		s.add("(");
		s.add(")");
		s.add(";");
		s.add("<");
		s.add("<=");
		s.add(">");
		s.add(">=");
		s.add("<>");
		s.add("==");
	}

	//adds comment char to comment set
	private void initCommentChar(Set<String> s) {
		s.add("#");
	}

	//initializes all the word lexemes
	private void initWordChar(Set<String> s) {
		s.add("rd");
		s.add("wr");
		s.add("if");
		s.add("then");
		s.add("else");
		s.add("while");
		s.add("do");
		s.add("begin");
		s.add("end");
	}

	private void initKeywords(Set<String> s) {
	}

	// constructor:
	//   - squirrel-away source program
	//   - initialize sets
	public Scanner(String program) {
		this.program=program;
		pos=0;
		token=null;
		initWhitespace(whitespace);
		initDigits(digits);
		initLetters(letters);
		initLegits(legits);
		initKeywords(keywords);
		initOperators(operators);
		initCommentChar(comment);
		initWordChar(words);
	}

	// handy string-processing methods

	public boolean done() {
		return pos >= program.length();
	}

	private void many(Set<String> s) {
		while (!done() && s.contains(program.charAt(pos) + ""))
			pos++;
	}

	private void past(char c) {
		while (!done() && c!=program.charAt(pos))
			pos++;
		if (!done() && c==program.charAt(pos))
			pos++;
	}

	// scan various kinds of lexeme

	private void nextNumber() {
		int old=pos;
		many(digits);
		token=new Token("num",program.substring(old,pos));
	}

	private void nextKwId() {
		int old=pos;
		many(letters);
		many(legits);
		String lexeme=program.substring(old,pos);
		token=new Token((keywords.contains(lexeme) ? lexeme : "id"),lexeme);
	}


	//creates tokens for operator characters
	private void nextOp() {
		int old=pos;
		pos=old+2;
		if (!done()) 
		{
			String lexeme=program.substring(old,pos);
			if (operators.contains(lexeme)) 
			{
				token=new Token(lexeme); // two-char operator
				return;
			}
		}
		//pos resets back one position 
		//if a two character lexeme is not found
		pos=old+1;
		String lexeme=program.substring(old,pos);
		token=new Token(lexeme); // one-char operator
	}


	//method for counting ";" for indicating number of statements
	//only used in parseStatements within parser class
	public int statements() {
		return statements + 1;
	}

	//method used for scanning words
	private boolean nextWord() {
		for (int i = pos; i < program.length(); i++) {

			String c = program.substring(pos, i);
			//added in order to print the out after the write 
			//command without from the an evironment object
			if (words.contains(c)) {
				if (c.equals("wr")) {
					token = new Token("id", c);
					pos = i;
					return true;
				}
				else {
					token = new Token(c);
					pos = i;
					return true;
				}
			}
		}
		return false;
	}
	
	// This method determines the kind of the next token (e.g., "id"),
	// and calls a method to scan that token's lexeme (e.g., "foo").
	public boolean next() 
	{
		if (done())
			return false;
		many(whitespace);
		String c = program.charAt(pos) + "";
		//nextWord() created for scanning words only
		//put first to avoid creating "id's" out of words
		if (nextWord());
		else if (digits.contains(c))
			nextNumber();
		else if (letters.contains(c))
			nextKwId();
		else if (operators.contains(c)) {
			if (c.equals(";")) 
				statements++;
			nextOp();
		}
		//added for comments
		else if (comment.contains(c))
			commentScan();
		else {
			System.err.println("illegal character at position "+pos);
			pos++;
			//return next() used for moving on to the next program
			return next();
		}
		return true;
	}

	// This method scans the next lexeme,
	// if the current token is the expected token.
	public void match(Token t) throws SyntaxException {
		if (!t.equals(curr()))
			throw new SyntaxException(pos,t,curr());
		next();
	}

	//checks for null token 
	//Ex: ""
	public Token curr() throws SyntaxException {
		if (token==null)
			throw new SyntaxException(pos,new Token("ANY"),new Token("EMPTY"));
		return token;
	}

	//returns current position
	public int pos() { return pos; }

	//method for skipping content between 
	//the comment parameters, 
	//Ex. #comment#
	public void commentScan() {
		pos++;
		past('#');
		next();
	}

	// for unit testing
	public static void main(String[] args) {
		try {
			Scanner scanner=new Scanner(args[0]);
			while (scanner.next())
				System.out.println(scanner.curr());
		} catch (SyntaxException e) {
			System.err.println(e);
		}
	}

}
