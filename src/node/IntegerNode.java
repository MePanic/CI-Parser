package node;

import java.util.Map;

import descr.AbstractDescr;
import descr.IntConstDescr;
import static compiler.Compiler.*;

public class IntegerNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

    private final int integer;

    public IntegerNode(int integer) {
        this.integer = integer;
    }
    
    public int getInteger() {
    	return integer;
    }
    
	@Override
	public AbstractDescr compile(Map<Integer, Map<String, AbstractDescr>> symbolTable) {
		return new IntConstDescr(level, integer);
	}
    
    @Override
    public String toString(int indent) {
        return toString(indent, "IntNode(" + integer + ")\n");
    }
}