package scanner;

import static scanner.ID.*;

import java.util.ArrayList;
import java.util.List;

import descr.SymbolTable;

import node.*;
import node.BinOpNode.BinOp;

import scanner.Scanner;
import scanner.Token;

public class Parser {

	StringBuilder pars;
	
	// Main

	@SuppressWarnings("hiding")
	public static void main(String argv[]) {
		if (argv.length == 0) {
			System.out.println("Usage : java Scanner <inputfile>");
		} else {
			for (int i = 0; i < argv.length; i++) {
				try {
					scanner = new Scanner(new java.io.FileReader(argv[i]));
					insymbol();
					program();
				} catch (java.io.FileNotFoundException e) {
					System.out.println("File not found : \"" + argv[i] + "\"");
				} catch (java.io.IOException e) {
					System.out.println("IO error scanning file \"" + argv[i]
							+ "\"");
					System.out.println(e);
				} catch (Exception e) {
					System.out.println("Unexpected exception:");
					e.printStackTrace();
				}
			}
		}
	}
	
	public Parser(String argv[]){
		if (argv.length == 0) {
			System.out.println("Usage : java Scanner <inputfile>");
		} else {
			for (int i = 0; i < argv.length; i++) {
				try {
					scanner = new Scanner(new java.io.FileReader(argv[i]));
					insymbol();
					pars = program();
				} catch (java.io.FileNotFoundException e) {
					System.out.println("File not found : \"" + argv[i] + "\"");
				} catch (java.io.IOException e) {
					System.out.println("IO error scanning file \"" + argv[i]
							+ "\"");
					System.out.println(e);
				} catch (Exception e) {
					System.out.println("Unexpected exception:");
					e.printStackTrace();
				}
			}
		}
	}
	
	public StringBuilder pars(){
		return pars;
	}

	static Token nextSym = null;
	static String inFile;
	static Scanner scanner = null;
	static String spaces = "";

	// Getter

	public static int getLine() {
		return nextSym.line();
	}

	public static int getColumn() {
		return nextSym.column();
	}

	// Hilfsroutinen

	public static void indent() {
		spaces = spaces + "  ";
	}

	public static void unindent() {
		spaces = spaces.substring(2);
	}

	public static void printNextSymbol() {
//		System.out.println(spaces + " -- " + nextSym.id() + " "); /**/
	}

	public static void printThisSymbol(Token t) {
//		System.out.println(spaces + " -- " + t.id() + " "); /**/
	}

	public static void printFunction(String name) {
//		System.out.println(spaces + name);/* +": " + nextsymbol);/* */
	}

	public static String place() {
		return ("l: " + (nextSym.line() + 1) + ", c:" + (nextSym.column() + 1));
	}

	public static void error(String str) {
		System.out.println("==> Error: " + str + " " + place());
		System.exit(0);
	}

	public static void insymbol() {
		try {
			while ((nextSym = scanner.yylex()) != null
					&& nextSym.id().getValue() == BLANK.getValue()) {
			}
			// System.out.println(spaces + "insymbol: " + nextSym);
		} catch (java.io.FileNotFoundException e) {
			System.out.println("File not found : \"" + inFile + "\"");
		} catch (java.io.IOException e) {
			System.out.println("IO error scanning file \"" + inFile + "\"");
			System.out.println(e);
		} catch (Exception e) {
			System.out.println("Unexpected exception:");
			e.printStackTrace();
		}
	}

	// Abfragehilfe

	private static boolean isString() {
		return (nextSym.id() == QUOT);
	}

	private static boolean isInteger() {
		return (nextSym.id() == DIGIT);
	}

	private static boolean isIdent() {
		return (nextSym.id() == ID);
	}

	private static boolean isLpar() {
		return (nextSym.id() == LPAR);
	}

	private static boolean isRpar() {
		return (nextSym.id() == RPAR);
	}

	private static boolean isLbrac() {
		return (nextSym.id() == LBRAC);
	}

	private static boolean isRbrac() {
		return (nextSym.id() == RBRAC);
	}

	private static boolean isPlus() {
		return (nextSym.id() == PLUS);
	}

	private static boolean isMinus() {
		return (nextSym.id() == MINUS);
	}

	private static boolean isMul() {
		return (nextSym.id() == MUL);
	}

	private static boolean isDiv() {
		return (nextSym.id() == DIV);
	}

	private static boolean isEq() {
		return (nextSym.id() == EQ);
	}

	private static boolean isNeq() {
		return (nextSym.id() == NEQ);
	}

	private static boolean isLo() {
		return (nextSym.id() == LO);
	}

	private static boolean isHi() {
		return (nextSym.id() == HI);
	}

	private static boolean isLoEq() {
		return (nextSym.id() == LOEQ);
	}

	private static boolean isHiEq() {
		return (nextSym.id() == HIEQ);
	}

	private static boolean isDot() {
		return (nextSym.id() == DOT);
	}

	private static boolean isComma() {
		return (nextSym.id() == COMMA);
	}

	private static boolean isAssign() {
		return (nextSym.id() == ASSIGN);
	}

	private static boolean isSemicolon() {
		return (nextSym.id() == SEMICOLON);
	}

	private static boolean isColon() {
		return (nextSym.id() == COLON);
	}

	private static boolean isError() {
		return (nextSym.id() == ERROR);
	}

	private static boolean isRead() {
		return (nextSym.id() == READ);
	}

	private static boolean isIf() {
		return (nextSym.id() == IF);
	}

	private static boolean isThen() {
		return (nextSym.id() == THEN);
	}

	private static boolean isElse() {
		return (nextSym.id() == ELSE);
	}

	private static boolean isElseIf() {
		return (nextSym.id() == ELSIF);
	}

	private static boolean isWhile() {
		return (nextSym.id() == WHILE);
	}

	private static boolean isDo() {
		return (nextSym.id() == DO);
	}

	private static boolean isEnd() {
		return (nextSym.id() == END);
	}

	private static boolean isRepeat() {
		return (nextSym.id() == REPEAT);
	}

	private static boolean isUntil() {
		return (nextSym.id() == UNTIL);
	}

	private static boolean isPrint() {
		return (nextSym.id() == PRINT);
	}

	private static boolean isModule() {
		return (nextSym.id() == MODULE);
	}

	private static boolean isBegin() {
		return (nextSym.id() == BEGIN);
	}

	private static boolean isConst() {
		return (nextSym.id() == CONST);
	}

	private static boolean isType() {
		return (nextSym.id() == TYPE);
	}

	private static boolean isVar() {
		return (nextSym.id() == VAR);
	}

	private static boolean isProcedure() {
		return (nextSym.id() == PROCEDURE);
	}

	private static boolean isArray() {
		return (nextSym.id() == ARRAY);
	}

	private static boolean isOf() {
		return (nextSym.id() == OF);
	}

	private static boolean isRecord() {
		return (nextSym.id() == RECORD);
	}

	private static boolean isFactor() {
		return (isIdent() || isInteger() || isString() || isRead() || isLpar());
	}

	private static boolean isExpression() {
		return (isMinus() || isFactor());
	}

	private static boolean isStatement() {
		return (isIdent() || isIf() || isPrint() || isWhile() || isRepeat());
	}

	// private static boolean isDeclaration() { return (isConst() || isType() ||
	// isVar() || isProcedure()); }

	// Parserroutinen

	static StringBuilder program() {
		StringBuilder res = new StringBuilder();
		printFunction("Program");
		indent();
		while (nextSym != null) {
			if (isModule()) {
				AbstractNode mod = module();
				mod.compile(new SymbolTable());
				res.append(mod.toString(0));
//				System.out.println(module().toString(0));
			} else
				error("unknown Code");
		}
		unindent();
//		System.out.println(res);
		return res;
	}

	// Module = �MODULE� ident �;� Declarations
	// �BEGIN� StatementSequence
	// �END� ident �
	static AbstractNode module() {
		printFunction("Module");
		indent();
		AbstractNode module = null;
		IdentNode ident = null;
		AbstractNode declarations = null;
		AbstractNode statementSequence = null;
		if (isModule()) {
			printNextSymbol();
			insymbol();
			if (isIdent()) {
				ident = constIdent();
				if (isSemicolon()) {
					printNextSymbol();
					insymbol();
					declarations = declarations();
					if (isBegin()) {
						printNextSymbol();
						insymbol();
						statementSequence = statementSequence();
						if (isEnd()) {
							printNextSymbol();
							insymbol();
							if (isIdent()) {
								printNextSymbol();
								insymbol();
								if (isDot()) {
									module = new ModuleNode(ident,
											declarations, statementSequence);
									printNextSymbol();
									insymbol();
								} else
									error("'.' expected");
							} else
								error("Ident expected");
						} else
							error("'end' expected");
					} else
						error("'begin' expected");
				} else
					error("';' expected");
			} else
				error("Ident expected");
		} else
			error("'module' expected");
		unindent();
		return module;
	}

	// Declarations = [�CONST� ident �=� Expression �;� {ident �=� Expression
	// �;�}]
	// [�TYPE� ident �=� Type �;� {ident �=� Type �;�}]
	// [�VAR� IdentList �:� Type �;� {IdentList �:� Type �;�}]
	// {ProcedureDeclaration �;�}
	static AbstractNode declarations() {
		printFunction("Declarations");
		indent();
		List<ConstDeclarationNode> consts = new ArrayList<ConstDeclarationNode>();
		List<TypeDeclarationNode> types = new ArrayList<TypeDeclarationNode>();
		List<VarDeclarationNode> vars = new ArrayList<VarDeclarationNode>();
		List<AbstractNode> procedures = new ArrayList<AbstractNode>();
		AbstractNode arg1;
		AbstractNode arg2;

		// Const
		if (isConst()) {
			printNextSymbol();
			insymbol();
			if (isIdent()) {
				while (isIdent()) {
					arg1 = constIdent();
					if (isEq()) {
						printNextSymbol();
						insymbol();
						if (isExpression()) {
							arg2 = expression();
							if (isSemicolon()) {
								printNextSymbol();
								insymbol();
								consts.add(new ConstDeclarationNode(arg1, arg2));
							} else
								error("';' expected");
						} else
							error("Expression expected");
					} else
						error("'=' expected");
				}
			} else
				error("Ident expected");
		}

		// Type
		if (isType()) {
			printNextSymbol();
			insymbol();
			if (isIdent()) {
				while (isIdent()) {
					arg1 = constIdent();
					if (isEq()) {
						printNextSymbol();
						insymbol();
						if (isIdent() || isArray() || isRecord()) {
							arg2 = type();
							if (isSemicolon()) {
								printNextSymbol();
								insymbol();
								types.add(new TypeDeclarationNode(arg1, arg2));
							} else
								error("';' expected");
						} else
							error("Expression expected");
					} else
						error("'=' expected");
				}
			} else
				error("Ident expected");
		}

		// Var
		if (isVar()) {
			printNextSymbol();
			insymbol();
			if (isIdent()) {
				while (isIdent()) {
					arg1 = identList();
					if (isColon()) {
						printNextSymbol();
						insymbol();
						if (isIdent() || isArray() || isRecord()) {
							arg2 = type();
							if (isSemicolon()) {
								printNextSymbol();
								insymbol();
								vars.add(new VarDeclarationNode(arg1, arg2));
							} else
								error("';' expected");
						} else
							error("Type expected");
					} else
						error("':' expected");
				}
			} else
				error("IdentList expected");
		}

		// Procedure
		while (isProcedure()) {
			procedures.add(procedure());
			if (isSemicolon()) {
				printNextSymbol();
				insymbol();
			} else
				error("';' expected");
		}

		unindent();
		return new DeclarationsNode(consts, types, vars, procedures);
	}

	// Expression = SimpleExpression
	// [(�=� | �#� | �<� | �<=� | �>� | �>=�) SimpleExpression].
	static AbstractNode expression() {
		printFunction("Expression");
		indent();
		AbstractNode expression = simpleExpression();
		if (isEq()) {
			printNextSymbol();
			insymbol();
			expression = new BinOpNode(BinOp.EQ_OP, expression,
					simpleExpression());
		} else if (isNeq()) {
			printNextSymbol();
			insymbol();
			expression = new BinOpNode(BinOp.NEQ_OP, expression,
					simpleExpression());
		} else if (isLo()) {
			printNextSymbol();
			insymbol();
			expression = new BinOpNode(BinOp.LO_OP, expression,
					simpleExpression());
		} else if (isHi()) {
			printNextSymbol();
			insymbol();
			expression = new BinOpNode(BinOp.HI_OP, expression,
					simpleExpression());
		} else if (isLoEq()) {
			printNextSymbol();
			insymbol();
			expression = new BinOpNode(BinOp.LOEQ_OP, expression,
					simpleExpression());
		} else if (isHiEq()) {
			printNextSymbol();
			insymbol();
			expression = new BinOpNode(BinOp.HIEQ_OP, expression,
					simpleExpression());
		}
		unindent();
		return expression;
	}

	static AbstractNode print() {
		printFunction("Print");
		indent();
		AbstractNode print = null;
		if (isPrint()) {
			printNextSymbol();
			insymbol();
		} else
			error("'print' expected");
		if (isExpression()) {
			print = new PrintNode(expression());
		}
		unindent();
		return print;
	}

	// SimpleExpression = [�-�] Term
	// {(�+� | �-�) Term}.
	static AbstractNode simpleExpression() {
		printFunction("SimpleExpression");
		AbstractNode simpleExpression = null;
		indent();
		if (isMinus()) {
			printNextSymbol();
			insymbol();
			simpleExpression = new NegationNode(term());
		} else {
			simpleExpression = term();
		}
		while (isPlus() || isMinus()) {
			if (isPlus()) {
				printNextSymbol();
				insymbol();
				simpleExpression = new BinOpNode(BinOp.PLUS_OP,
						simpleExpression, term());
			} else if (isMinus()) {
				printNextSymbol();
				insymbol();
				simpleExpression = new BinOpNode(BinOp.MINUS_OP,
						simpleExpression, term());
			} else
				error("(�+� | �-�) expected");
		}
		unindent();
		return simpleExpression;
	}

	// Term = Factor
	// {(�*� | �/�) Factor}.
	static AbstractNode term() {
		printFunction("Term");
		indent();
		AbstractNode term = factor();
		while (isMul() || isDiv()) {
			if (isMul()) {
				printNextSymbol();
				insymbol();
				term = new BinOpNode(BinOp.MUL_OP, term, factor());
			} else if (isDiv()) {
				printNextSymbol();
				insymbol();
				term = new BinOpNode(BinOp.DIV_OP, term, factor());
			} else
				error("(�*� | �/�) expected");
		}
		unindent();
		return term;
	}

	// Factor = Ident Selector | Integer | String | Read | �(� Expression �)�.
	static AbstractNode factor() {
		printFunction("Factor");
		indent();
		AbstractNode factor = null;
		if (isIdent()) {
			IdentNode ident = constIdent();
			if (isDot() || isLbrac()) {
				factor = selector(ident);
			} else {
				factor = ident;
			}
		} else if (isInteger()) {
			factor = integerNode();
		} else if (isString()) {
			factor = stringNode();
		} else if (isRead()) {
			factor = read();
		} else if (isLpar()) {
			printNextSymbol();
			insymbol();
			factor = expression();
			if (isRpar()) {
				printNextSymbol();
				insymbol();
			} else
				error("')' expected");
		} else
			error("Ident Selector, Integer, String, READ or '(' expected");
		unindent();
		return factor;
	}

	// Selector = {�.� ident | �[� Expression �]�}.
	// static AbstractNode selector(IdentNode subject) {
	// printFunction("Selector");
	// indent();
	// AbstractNode selector = null;
	// if (isDot() || isLbrac()) {
	// while (isDot() || isLbrac()) {
	// if (isDot()) {
	// printNextSymbol();
	// insymbol();
	// selector = new RecordSelectorNode(subject, constIdent());
	// } else if (isLbrac()) {
	// printNextSymbol();
	// insymbol();
	// selector = new ArraySelectorNode(subject, indexExpression());
	// if (isRbrac()) {
	// printNextSymbol();
	// insymbol();
	// } else error("']' expected");
	// }
	// }
	// } else error ("('.' | �[�) expected");
	// unindent();
	// return selector;
	// }

	static AbstractNode selector(AbstractNode subject) {
		printFunction("Selector");
		indent();

		AbstractNode selector = null;
		if (isDot() || isLbrac()) {
			while (isDot() || isLbrac()) {
				if (isDot()) {
					printNextSymbol();
					insymbol();
					if(isDot()){
					selector = new RecordSelectorNode(selector(subject),
							constIdent());
					} else {
						new RecordSelectorNode(subject, constIdent());
					}
				} else if (isLbrac()) {
					printNextSymbol();
					insymbol();
					AbstractNode indExp = indexExpression();

					if (isRbrac()) {
						printNextSymbol();
						insymbol();
						if (isLbrac()) {
							selector = new ArraySelectorNode(selector(subject),
									indExp);
						} else {
							selector = new ArraySelectorNode(subject, indExp);
						}
					} else
						error("']' expected");
				}
			}
		} else
			error("('.' | �[�) expected");
		unindent();
		return selector;
	}

	// Read = READ [Prompt].
	static AbstractNode read() {
		printFunction("Read");
		indent();
		AbstractNode read = null;
		if (isRead()) {
			printNextSymbol();
			insymbol();
		} else
			error("'read' expected");
		if (isString()) {
			read = prompt();
		}
		unindent();
		return read;
	}

	// Prompt = String.
	static AbstractNode prompt() {
		printFunction("Prompt");
		indent();
		AbstractNode prompt = null;
		if (isString()) {
			prompt = new PromptNode(stringNode());
		}
		unindent();
		return prompt;
	}

	// Type = ident | ArrayType | RecordType.
	static AbstractNode type() {
		printFunction("Type");
		indent();
		AbstractNode type = null;
		if (isIdent()) {
			type = constIdent();
		} else if (isArray()) {
			type = arrayType();
		} else if (isRecord()) {
			type = recordType();
		} else
			error("Ident, ArrayType or RecordType expected");
		unindent();
		return type;
	}

	// ArrayType = �ARRAY� �[� IndexExpression �]� �OF� Type.
	static AbstractNode arrayType() {
		printFunction("ArrayType");
		indent();
		AbstractNode arrayType = null;
		AbstractNode indexExpression = null;
		if (isArray()) {
			printNextSymbol();
			insymbol();
			if (isLbrac()) {
				printNextSymbol();
				insymbol();
				if (isInteger() || isIdent()) {
					indexExpression = indexExpression();
					if (isRbrac()) {
						printNextSymbol();
						insymbol();
						if (isOf()) {
							printNextSymbol();
							insymbol();
							if (isIdent() || isArray() || isRecord()) {
								arrayType = new ArrayTypeNode(indexExpression,
										type());
							} else
								error("Type expected");
						} else
							error("'of' expected");
					} else
						error("']' expected");
				} else
					error("IndexExpression expected");
			} else
				error("'[' expected");
		} else
			error("'array' expected");
		unindent();
		return arrayType;
	}

	// RecordType = �RECORD� FieldList
	// {�;� FieldList} �END�.
	static AbstractNode recordType() {
		printFunction("RecordType");
		indent();
		List<FieldListNode> fieldLists = new ArrayList<FieldListNode>();
		if (isRecord()) {
			printNextSymbol();
			insymbol();
			fieldLists.add(fieldList());
			while (isSemicolon()) {
				printNextSymbol();
				insymbol();
				fieldLists.add(fieldList());
			}
			if (isEnd()) {
				printNextSymbol();
				insymbol();
			} else
				error("'end' expected");
		} else
			error("'record' expected");
		unindent();
		return new RecordTypeNode(fieldLists);
	}

	// FieldList = [IdentList �:� Type].
	static FieldListNode fieldList() {
		printFunction("FieldList");
		indent();
		FieldListNode fieldList = null;
		AbstractNode identList = null;
		if (isIdent()) {
			identList = identList();
			if (isColon()) {
				printNextSymbol();
				insymbol();
				if (isIdent() || isArray() || isRecord()) {
					fieldList = new FieldListNode(identList, type());
				} else
					error("Type expected");
			} else
				error("':' expected");
		}
		unindent();
		return fieldList;
	}

	// IdentList = ident {�,� ident}.
	static AbstractNode identList() {
		printFunction("IdentList");
		indent();
		List<IdentNode> idents = new ArrayList<IdentNode>();
		if (isIdent()) {
			idents.add(constIdent());
		} else
			error("Ident expected");
		while (isComma()) {
			printNextSymbol();
			insymbol();
			if (isIdent()) {
				idents.add(constIdent());
			} else
				error("Ident expected");
		}
		unindent();
		return new IdentListNode(idents);
	}

	// Procedure = �PROCEDURE� ident �(� [FormalParameters] �)� �;� Declarations
	// �BEGIN� StatementSequence �END� ident.
	static ProcedureNode procedure() {
		printFunction("Procedure");
		indent();
		ProcedureNode procedure = null;
		IdentNode ident = null;
		FormalParametersNode formalParameters = null;
		AbstractNode declarations = null;
		AbstractNode statementSequence = null;
		if (isProcedure()) {
			printNextSymbol();
			insymbol();
			ident = constIdent();
			if (isLpar()) {
				printNextSymbol();
				insymbol();
				if (isVar() || isIdent()) {
					formalParameters = formalParameters();
				}
				if (isRpar()) {
					printNextSymbol();
					insymbol();
					if (isSemicolon()) {
						printNextSymbol();
						insymbol();
						declarations = declarations();
						if (isBegin()) {
							printNextSymbol();
							insymbol();
							statementSequence = statementSequence();
							if (isEnd()) {
								printNextSymbol();
								insymbol();
								if (isIdent()) {
									printNextSymbol();
									insymbol();
									procedure = new ProcedureNode(ident,
											formalParameters, declarations,
											statementSequence);
								} else
									error("Ident expected");
							} else
								error("'end' expected");
						} else
							error("'begin' expected");
					} else
						error("';' expected");
				} else
					error("')' expected");
			} else
				error("'(' expected");
		} else
			error("'procedure' expected");
		unindent();
		return procedure;
	}

	// FormalParameters = FPSection {�;� FPSection}.
	static FormalParametersNode formalParameters() {
		printFunction("FormalParameters");
		indent();
		List<FpSectionNode> fpsections = new ArrayList<FpSectionNode>();
		if (isVar() || isIdent()) {
			fpsections.add(fpSection());
		} else
			error("FPSection expected");
		while (isSemicolon()) {
			printNextSymbol();
			insymbol();
			if (isVar() || isIdent()) {
				fpsections.add(fpSection());
			} else
				error("FPSection expected");
		}
		unindent();
		return new FormalParametersNode(fpsections);
	}

	// FPSection = [�VAR�] IdentList �:� Type.
	static FpSectionNode fpSection() {
		printFunction("FPSection");
		indent();
		FpSectionNode fpSection = null;
		AbstractNode identList = null;
		if (isVar()) {
			printNextSymbol();
			insymbol();
		}
		if (isIdent()) {
			identList = identList();
			if (isColon()) {
				printNextSymbol();
				insymbol();
				if (isIdent() || isArray() || isRecord()) {
					fpSection = new FpSectionNode(identList, type());
				} else
					error("Type expected");
			} else
				error("':' expected");
		} else
			error("IdentList expected");
		unindent();
		return fpSection;
	}

	// Assignment = ident Selector �:=� Expression.
	static AbstractNode assignment(Token save) {
		printFunction("Assignment");
		indent();
		AbstractNode assignment = null;
		AbstractNode subject = null;
		if (save.id() == ID) {
			printThisSymbol(save);
			IdentNode ident = new IdentNode(save.text());
			if (isDot() || isLbrac()) {
				subject = selector(ident);
			} else {
				subject = ident;
			}
			if (isAssign()) {
				printNextSymbol();
				insymbol();
				if (isExpression()) {
					assignment = new AssignmentNode(subject, expression());
				} else
					error("Expression expected");
			} else
				error("':=' expected");
		} else
			error("Ident expected");
		unindent();
		return assignment;
	}

	// ProcedureCall = ident �(� [ActualParameters] �)�.
	static AbstractNode procedureCall(Token save) {
		printFunction("ProcedureCall");
		indent();
		AbstractNode procedureCall = null;
		IdentNode ident = null;
		AbstractNode actualParameters = null;
		if (save.id() == ID) {
			printThisSymbol(save);
			ident = new IdentNode(save.text());
			if (isLpar()) {
				printNextSymbol();
				insymbol();
				if (isExpression()) {
					actualParameters();
				}
				if (isRpar()) {
					printNextSymbol();
					insymbol();
					procedureCall = new ProcedureCallNode(ident,
							actualParameters);
				} else
					error("')' expected");
			} else
				error("'(' expected");
		} else
			error("Ident expected");
		unindent();
		return procedureCall;
	}

	// ActualParameters = Expression {�,� Expression}.
	static AbstractNode actualParameters() {
		printFunction("ActualParameters");
		indent();
		List<AbstractNode> expressions = new ArrayList<AbstractNode>();
		if (isExpression()) {
			expressions.add(expression());
		} else
			error("Expression expected");
		while (isComma()) {
			printNextSymbol();
			insymbol();
			if (isExpression()) {
				expressions.add(expression());
			} else
				error("Expression expected");
		}
		unindent();
		return new ActualParametersNode(expressions);
	}

	// Statement = [Assignment | ProcedureCall | IfStatement | �PRINT�
	// Expression | WhileStatement | RepeatStatement].
	static AbstractNode statement() {
		printFunction("Statement");
		indent();
		AbstractNode statement = null;
		if (nextSym.text().toLowerCase().equals("repeat")) {
			statement = repeatStatement();
		} else if (isIdent()) {
			Token save = nextSym;
//			System.out.println(nextSym.text());
			insymbol();
			if (isDot() || isLbrac() || isAssign()) {
				statement = assignment(save);
			} else if ((isLpar())) {
				statement = procedureCall(save);
			} else
				error("Selector, ':=' or '(' expected");
		} else if (isIf()) {
			statement = ifStatement();
		} else if (isPrint()) {
			// printNextSymbol();
			// insymbol();
			// if (isExpression()) {
			// System.out.println("hi");
			statement = print();
			// } else error("Expression expected");
		} else if (isWhile()) {
			statement = whileStatement();
		}  
		unindent();
		return statement;
	}

	// StatementSequence = Statement {�;� Statement}.
	static AbstractNode statementSequence() {
		printFunction("StatementSequence");
		indent();
		ArrayList<AbstractNode> statements = new ArrayList<AbstractNode>();
		if (isStatement()) {
			statements.add(statement());
		}
		while (isSemicolon()) {
			printNextSymbol();
			insymbol();
			if (isStatement()) {
				statements.add(statement());
			}
		}
		unindent();
		return new StatementSequenceNode(statements);
	}

	// IfStatement = �IF� Expression �THEN� StatementSequence
	// {�ELSIF� Expression �THEN� StatementSequence}
	// [�ELSE� StatementSequence] �END�.
	static IfStatementNode ifStatement() {
		printFunction("IfStatement");
		indent();
		IfStatementNode ifStatement = null;
		AbstractNode expression = null;
		AbstractNode statementSequence1 = null;
		AbstractNode statementSequence2 = null;
		AbstractNode elseIfs = null;
		if (isIf()) {
			printNextSymbol();
			insymbol();
			if (isExpression()) {
				expression = expression();
				if (isThen()) {
					printNextSymbol();
					insymbol();
					if (isStatement()) {
						statementSequence1 = statementSequence();
						if (isElseIf()) {
							elseIfs = ifStatement_();
						}
						if (isElse()) {
							printNextSymbol();
							insymbol();
							if (isStatement()) {
								statementSequence2 = statementSequence();
							} else
								error("Statement expected");
						}
						if (isEnd()) {
							printNextSymbol();
							insymbol();
							ifStatement = new IfStatementNode(expression,
									statementSequence1, elseIfs,
									statementSequence2);
						} else
							error("'end' expected");
					} else
						error("Statement expected");
				} else
					error("'then' expected");
			} else
				error("Expression expected");
		} else
			error("'if' expected");
		unindent();
		return ifStatement;
	}

	static IfStatementNode ifStatement_() {
		IfStatementNode ifStatementNode = null;
		AbstractNode expression = null;
		AbstractNode statementSequence = null;
		if (isElseIf()) {
			printNextSymbol();
			insymbol();
			if (isExpression()) {
				expression = expression();
				if (isThen()) {
					insymbol();
					if (isStatement()) {
						statementSequence = statementSequence();
//						System.out.println(nextSym.text());
						ifStatementNode = new IfStatementNode(expression,
								statementSequence, isElseIf() ? ifStatement_()
										: null, null);
					} else
						error("Statement expected");
				} else
					error("'then' expected");
			} else
				error("Expression expected");
		} else
			error("'elseif' expected");
		return ifStatementNode;
	}

	// WhileStatement = �WHILE� Expression �DO� StatementSequence �END�.
	static AbstractNode whileStatement() {
		printFunction("WhileStatement");
		indent();
		AbstractNode whileStatement = null;
		AbstractNode expression = null;
		AbstractNode statementSequence = null;
		if (isWhile()) {
			printNextSymbol();
			insymbol();
			if (isExpression()) {
				expression = expression();
				if (isDo()) {
					printNextSymbol();
					insymbol();
					if (isStatement()) {
						statementSequence = statementSequence();
					}
					if (isEnd()) {
						printNextSymbol();
						insymbol();
						whileStatement = new WhileStatementNode(expression,
								statementSequence);
					} else
						error("'end' expected");
				} else
					error("'do' expected");
			} else
				error("Expression expected");
		} else
			error("'while' expected");
		unindent();
		return whileStatement;
	}

	// RepeatStatement = �REPEAT� StatementSequence �UNTIL� Expression.
	static AbstractNode repeatStatement() {
		printFunction("RepeatStatement");
		indent();
		AbstractNode repeatStatement = null;
		AbstractNode statementSequence = null;
		if (nextSym.text().toLowerCase().equals("repeat")) {
			printNextSymbol();
			insymbol();
			if (isStatement()) {
				statementSequence = statementSequence();
				if (isUntil()) {
					printNextSymbol();
					insymbol();
					if (isExpression()) {
						repeatStatement = new RepeatStatementNode(
								statementSequence, expression());
					} else
						error("Expression expected");
				} else
					error("'until' expected");
			} else
				error("Statement expected");
		} else
			error("'repeat' expected");
		unindent();
		return repeatStatement;
	}

	static IdentNode constIdent() {
		printFunction("ConstIdent");
		IdentNode ident = null;
		indent();
		if (isIdent()) {
			printNextSymbol();
			ident = new IdentNode(nextSym.text());
			insymbol();
		} else
			error("Ident expected");
		unindent();
		return ident;
	}

	static IntegerNode integerNode() {
		printFunction("Integer");
		indent();
		IntegerNode integerNode = null;
		if (isInteger()) {
			printNextSymbol();
			integerNode = new IntegerNode(Integer.valueOf(nextSym.text()));
			insymbol();
		} else
			error("Integer expected");
		return integerNode;
	}

	static StringNode stringNode() {
		printFunction("String");
		indent();
		StringNode stringNode = null;
		if (isString()) {
			printNextSymbol();
			insymbol();
			StringBuilder sb = new StringBuilder();
			if (isIdent() || isInteger() || isError()) {
				while (isIdent() || isInteger() || isError()) {
					printNextSymbol();
					sb.append(nextSym.text());
					insymbol();
				}
				if (isString()) {
					printNextSymbol();
					stringNode = new StringNode(sb.toString());
					insymbol();
				} else
					error("' ' ' expected");
			} else
				error("Ident expected");
		} else
			error("String expected");
		return stringNode;
	}

	static AbstractNode indexExpression() {
		printFunction("IndexExpression");
		indent();
		AbstractNode indexExpression = null;
		if (isInteger()) {
			indexExpression = integerNode();
		} else if (isIdent()) {
			indexExpression = constIdent();
		} else
			error("Integer or Ident expected");
		unindent();
		return indexExpression;
	}
}