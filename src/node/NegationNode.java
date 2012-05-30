package node;

import descr.AbstractDescr;
import descr.SymbolTable;

public class NegationNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

    private final AbstractNode node;
    
    public NegationNode(AbstractNode node) {
        this.node = node;
    }
    
    @Override
    public String toString(int indent) {
    	StringBuilder sb = new StringBuilder();
    	sb.append(toString(indent, "NegationNode\n"));
    	indent++;
        sb.append(node.toString(indent));
        return sb.toString();
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