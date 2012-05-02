package node;

import java.io.Serializable;
import scanner.Parser;

//import cip.debug.Debug;
//import cip.gen.Oberon0Lexer;

/**
 * Die abstrakte Darstellung eines Knotens im abstrakten Syntaxbaum.
 * 
 * @author VLL + nilo
 * 
 */
public abstract class AbstractNode implements Serializable {

	private static final long serialVersionUID = 1L;

	int line, column;

	public AbstractNode() {
		line = Parser.getLine();
		column = Parser.getColumn();
//		line = Oberon0Lexer.line;
//		column = Oberon0Lexer.column;
	};

	abstract public void print();

	/**
	 * Diese Variable steuert die Einr�ckung bei der Ausgabe
	 */
	private static String spaces = "";

	/**
	 * Diese Methode ist eine Darstellungshilfe f�r den abstrakten Syntaxbaum.
	 * Die Einr�ckung wird aufgehoben.
	 */
	public void unindent() {
		spaces = spaces.substring(2);
	}

	private void indent() {
		spaces = spaces + "  ";
	}

	/**
	 * Einr�ckungstiefe um zwei Leerzeichen erh�hen und den String ausgeben.
	 * 
	 * @param fieldName
	 */
	public void trace(String s) {
		this.indent();
		//if (Debug.debug > 0) System.out.println(spaces + s);
	}
}

