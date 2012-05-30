package node;

import descr.AbstractDescr;
import descr.SymbolTable;

public class RecordSelectorNode extends AbstractNode {

	private static final long serialVersionUID = 1L;
	
    private final AbstractNode subject;
    private final AbstractNode selector;

    public RecordSelectorNode(AbstractNode subject, AbstractNode selector) {
        this.subject = subject;
        this.selector = selector;
    }
    
    @Override
    public String toString(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(toString(indent, "RecordSelectorNode\n"));
        indent++;
        sb.append(subject.toString(indent));
        sb.append(selector.toString(indent));
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