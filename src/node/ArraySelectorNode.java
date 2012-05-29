package node;

public class ArraySelectorNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

    private final AbstractNode subject;
    private final AbstractNode selector;

    public ArraySelectorNode(AbstractNode subject, AbstractNode selector) {
        this.subject = subject;
        this.selector = selector;
    }
    
    @Override
    public String toString(int indent) {
    	StringBuilder sb = new StringBuilder();
    	sb.append(toString(indent, "ArraySelectorNode\n"));
    	indent++;
    	sb.append(subject.toString(indent));
    	sb.append(selector.toString(indent));
    	return sb.toString();
    }
}