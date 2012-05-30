package node;

import java.io.Serializable;
import scanner.Parser;
import descr.*;

public abstract class AbstractNode implements Serializable {

	private static final long serialVersionUID = 1L;
	
	int line, column;

	public AbstractNode() {
		line = Parser.getLine();
		column = Parser.getColumn();
	}
	
//	public abstract String name();

	public abstract String toString(int indent);
	
	public abstract AbstractDescr compile(SymbolTable sm);
	public abstract AbstractDescr compile(SymbolTable sm, AbstractNode type);
	
	public abstract String name();
	public abstract int getVal();
	
	protected String toString(int indent, String string) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; ++i) {
            sb.append("  ");
        }
        sb.append(string);
        return sb.toString();
	}
	
//	public abstract String trace(SymbolTable sm);
}

