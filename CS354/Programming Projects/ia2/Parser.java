// This class is a recursive-descent parser,
// modeled after the programming language's grammar.
// It constructs and has-a Scanner for the program
// being parsed.



public class Parser {

	private Scanner scanner;
	private int statements;
	
	
	/*added variable "IFDO" from it1
	this method makes sure a ";" is not matched if a statement 
	is within a if-then(-else), while-do, and a begin-end.
	 */
	private boolean IFDO;

	
	private void match(String s) throws SyntaxException {
		scanner.match(new Token(s));
	}

	private Token curr() throws SyntaxException {
		return scanner.curr();
	}

	private int pos() {
		return scanner.pos();
	}

	//this method checks for multiplication and division operators
	private NodeMulop parseMulop() throws SyntaxException {
		if (curr().equals(new Token("*"))) {
			match("*");
			return new NodeMulop(pos(),"*");
		}
		if (curr().equals(new Token("/"))) {
			match("/");
			return new NodeMulop(pos(),"/");
		}
		return null;
	}

	//this method checks for addition and subtraction operators
	private NodeAddop parseAddop() throws SyntaxException {
		if (curr().equals(new Token("+"))) {
			match("+");
			return new NodeAddop(pos(),"+");
		}
		if (curr().equals(new Token("-"))) {
			match("-");
			return new NodeAddop(pos(),"-");
		}
		return null;
	}

	//checks to see what type of relation operator the boolean expression has
	private NodeRelop parseRelop() throws SyntaxException {
		if (curr().equals(new Token("<"))) {
			match("<");
			return new NodeRelop(pos(),"<");
		}
		if (curr().equals(new Token("<="))) {
			match("<=");
			return new NodeRelop(pos(),"<=");
		}
		if (curr().equals(new Token(">"))) {
			match(">");
			return new NodeRelop(pos(),">");
		}
		if (curr().equals(new Token(">="))) {
			match(">=");
			return new NodeRelop(pos(),">=");
		}
		if (curr().equals(new Token("<>"))) {
			match("<>");
			return new NodeRelop(pos(),"<>");
		}
		if (curr().equals(new Token("=="))) {
			match("==");
			return new NodeRelop(pos(),"==");
		}
		return null;
	}

	//parses a boolean expression
	private NodeBoolExpr parseBoolExpr() throws SyntaxException {
		NodeExpr boolExprOne = parseExpr();
		NodeRelop relop = parseRelop();
		NodeExpr boolExprTwo = parseExpr();
		NodeBoolExpr nbe = new NodeBoolExpr(boolExprOne, relop, boolExprTwo);
		return nbe; 
	}

	//parses if-then(-do) statements
	private NodeStmtIf parseIf() throws SyntaxException {
		scanner.next();
		NodeBoolExpr nbe = parseBoolExpr();
		scanner.next();
		NodeStmt nstate = parseStmt();
		NodeStmt nstateTwo;
		NodeStmtIf nsi;
		if (curr().tok().equals("else")) {
			scanner.next();
			nstateTwo = parseStmt();
			nsi = new NodeStmtIf(nbe, nstate, nstateTwo);
		}
		else {
			nsi = new NodeStmtIf(nbe, nstate);
		}
		match(";");
		return nsi;
	}

	//parses while-do statements
	private NodeStmtWhile parseWhile() throws SyntaxException {
		scanner.next();
		NodeBoolExpr nbe = parseBoolExpr();
		scanner.next();
		NodeStmt nstate = parseStmt();
		NodeStmtWhile nsw = new NodeStmtWhile(nbe, nstate);
		match(";");
		return nsw;
	}

	//parses factor characters
	private NodeFact parseFact() throws SyntaxException {

		if (curr().equals(new Token("-"))) {
			match("-");
			NodeFact fact =parseFact();
			return new NodeFactNegative(fact);
		}
		if (curr().equals(new Token("("))) {
			match("(");
			NodeExpr expr=parseExpr();
			match(")");
			return new NodeFactExpr(expr);
		}
		if (curr().equals(new Token("id"))) {
			Token id=curr();
			match("id");
			return new NodeFactId(pos(),id.lex());
		}
		Token num=curr();
		match("num");
		return new NodeFactNum(num.lex());
	}


	//parses a term
	private NodeTerm parseTerm() throws SyntaxException {
		NodeFact fact=parseFact();
		NodeMulop mulop=parseMulop();
		if (mulop==null)
			return new NodeTerm(fact,null,null);
		NodeTerm term=parseTerm();
		term.append(new NodeTerm(fact,mulop,null));
		return term;
	}

	//parses expressions
	private NodeExpr parseExpr() throws SyntaxException {
		NodeTerm term=parseTerm();
		NodeAddop addop=parseAddop();
		if (addop==null)
			return new NodeExpr(term,null,null);
		NodeExpr expr=parseExpr();
		expr.append(new NodeExpr(term,addop,null));
		return expr;
	}

	//second part in parsing assignment
	private NodeAssn parseAssn() throws SyntaxException {
		Token id=curr();
		match("id");
		match("=");
		NodeExpr expr = parseExpr();
		NodeAssn assn = new NodeAssn(id.lex(),expr);
		return assn;
	}

	//second part in parsing a statement
	private NodeStmtAssn parseStmtAssn() throws SyntaxException {
		NodeAssn assn=parseAssn();
		NodeStmtAssn stmt=new NodeStmtAssn(assn);
		return stmt;
	}

	//parses a statement
	private NodeStmt parseStmt() throws SyntaxException {
		//branch for parsing write statements
		if (curr().lex().equals("wr")) {
			scanner.next();
			NodeExpr ne = parseExpr();
			NodeAssn assn = new NodeAssn("wr",ne);
			NodeStmtAssn nsa = new NodeStmtAssn(assn);
			NodeStmt ns = nsa;
			return ns;
		}
		//branch for parsing read statements
		if (curr().lex().equals("rd")) {
			scanner.next();
			NodeStmtRd nsrd = new NodeStmtRd(curr().lex());
			NodeStmt stmt = nsrd;
			scanner.next();
			match(";");
			return stmt;
		}
		//branch for parsing if-then(-else) statements
		else if (curr().tok().equals("if")) {
			IFDO = true;
			NodeStmtIf nodeStIf = parseIf();
			NodeStmt stmt = nodeStIf;
			IFDO = false;
			return stmt;
		}
		//branch for parsing while-do statements
		else if (curr().tok().equals("while")) {
			IFDO = true;
			NodeStmtWhile nodeStWhile = parseWhile();
			NodeStmt stmt = nodeStWhile;
			IFDO = false;
			return stmt;
		}
		//branch for parsing begin-end statements
		else if (curr().tok().equals("begin")) {
			IFDO = true;
			scanner.next();
			NodeStmt stmt = parseStmt();
			scanner.next();
			match(";");
			IFDO = false;
			return stmt;
		}
		//parses assignments to variables
		NodeStmtAssn assn = parseStmtAssn();
		if (IFDO != true)
			match(";");
		NodeStmt stmt = assn;
		return stmt;
	}

	//parses everything into one Node
	public Node parse(String program) throws SyntaxException {
		scanner=new Scanner(program);
		scanner.next();
		return parseStmt();
	}

	//parses the program for multiple statements witin one arg
	//returns an array of statements
	//concatinates the last statement with a ";"
	public String[] parseProgram(String program) {
		scanner = new Scanner(program);
		while(scanner.next())
			statements = scanner.statements();
		String[] statementArray = new String[statements];
		int pos = 0;
		int arrayIndex = 0;
		for (int z = pos; z < program.length(); z++) {
			String s = program.charAt(z) + "";
			if (s.equals(";")) {
				String c = program.substring(pos, (z + 1));
				statementArray[arrayIndex] = c;
				z++;
				pos = z;
				arrayIndex++;
			}
			if (z == (program.length() - 1)) {
				String c = program.substring(pos, (z + 1));
				c = c + ";";
				statementArray[arrayIndex] = c;
			}
		}
		return statementArray;
	}
}































