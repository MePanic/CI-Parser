package node;

import java.util.Map;

import descr.AbstractDescr;

import static compiler.Compiler.*;

public class StringNode extends AbstractNode {

	private static final long serialVersionUID = 1L;
	
    private final String string;
    
    public StringNode(String string) {
        this.string = string;
    }
    
    public String getString() {
    	return string;
    }
    
	@Override
	public AbstractDescr compile(Map<Integer, Map<String, AbstractDescr>> symbolTable) {
		write("PUSHS, " + string);
		return null;
	}
	
    @Override
    public String toString(int indent) {
        return toString(indent, "StringNode(" + string + ")");
    }
}