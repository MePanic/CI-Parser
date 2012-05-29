package node;

import java.util.List;

public class RecordTypeNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

    private final List<FieldListNode> fieldLists;
    
    public RecordTypeNode(List<FieldListNode> fieldLists) {
    	this.fieldLists = fieldLists;
    }
    
    @Override
    public String toString(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(toString(indent, "RecordTypeNode\n"));
        indent++;
        for (AbstractNode node : fieldLists) {
            sb.append(node.toString(indent));
        }
        return sb.toString();
    }
}