package node;

import java.util.List;

public class IdentListNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

    private final List<IdentNode> idents;
    
    public IdentListNode(List<IdentNode> idents) {
    	this.idents = idents;
    }
    
    @Override
    public String toString(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(toString(indent, "IdentListNode\n"));
        indent++;
        for (AbstractNode node : idents) {
            sb.append(node.toString(indent));
        }
        return sb.toString();
    }
}