package node;

import descr.AbstractDescr;
import descr.SymbolTable;

public class StringNode extends AbstractNode {

	private static final long serialVersionUID = 1L;
	
    private final String strVal;
    
    public StringNode(String strVal) {
        this.strVal = strVal;
    }
    
    @Override
    public String toString(int indent) {
        return toString(indent, "StringNode(" + strVal + ")");
    }

	@Override
	public AbstractDescr compile(SymbolTable sm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractDescr compile(SymbolTable sm, AbstractNode type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getVal() {
		// TODO Auto-generated method stub
		return 0;
	}
}