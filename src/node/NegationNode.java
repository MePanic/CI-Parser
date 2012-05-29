package node;

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
}