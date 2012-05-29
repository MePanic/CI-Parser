package node;

import descr.AbstractDescr;
import descr.SimpleTypeDescr;
import descr.SymbolTable;

public class IntegerNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

    private final int intVal;

    public IntegerNode(int val) {
        intVal = val;
    }
    
    public int getVal(){
    	return this.intVal;
    }
    
    @Override
    public String toString(int indent) {
        return toString(indent, "IntNode(" + intVal + ")\n");
    }

	@Override
	public AbstractDescr compile(SymbolTable sm) {
		return new SimpleTypeDescr("integer");
	}
}