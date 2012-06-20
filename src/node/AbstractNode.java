package node;

import java.io.Serializable;
import java.util.Map;

import compiler.Parser;

import descr.*;

public abstract class AbstractNode implements Serializable {

	private static final long serialVersionUID = 1L;
	
	int line, column;

	public AbstractNode() {
		line = Parser.getLine();
		column = Parser.getColumn();
	}
	
	public AbstractDescr compile(Map<Integer, Map<String, AbstractDescr>> symbolTable) {
		return null;
	}
	
	public AbstractDescr compile(Map<Integer, Map<String, AbstractDescr>> symbolTable, AbstractDescr descr) {
		return null;
	}
	
	public abstract String toString(int indent);
	
	protected String toString(int indent, String string) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; ++i) {
            sb.append("  ");
        }
        sb.append(string);
        return sb.toString();
	}
}