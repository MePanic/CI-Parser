package node;

public class ArrayTypeNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

    private final AbstractNode indexExpression;
    private final AbstractNode type;
    
    public ArrayTypeNode(AbstractNode indexExpression, AbstractNode type) {
        this.indexExpression = indexExpression;
        this.type = type;
    }
    
    @Override
    public String toString(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(toString(indent, "ArrayTypeNode\n"));
		indent++;
        if (indexExpression != null)
        	sb.append(indexExpression.toString(indent));
		if (type != null)
	    	sb.append(type.toString(indent));
    	return sb.toString();
    }
}