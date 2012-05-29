package node;

import java.util.List;

public class FormalParametersNode extends AbstractNode {

	private static final long serialVersionUID = 1L;
    
	private final List<FpSectionNode> fpsections;
    
	public FormalParametersNode(List<FpSectionNode> fpsections) {
    	this.fpsections = fpsections;
    }
	
    @Override
    public String toString(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(toString(indent, "FormalParametersNode\n"));
        indent++;
        for (FpSectionNode node : fpsections) {
            sb.append(node.toString(indent));
        }
        return sb.toString();
    }
}