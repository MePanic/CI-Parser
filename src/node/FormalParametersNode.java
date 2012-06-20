package node;

import java.util.List;
import java.util.Map;

import descr.AbstractDescr;

public class FormalParametersNode extends AbstractNode {

	private static final long serialVersionUID = 1L;
    
	private final List<FpSectionNode> fpsections;
    
	public FormalParametersNode(List<FpSectionNode> fpsections) {
    	this.fpsections = fpsections;
    }
	
	public List<FpSectionNode> getFpSections() {
		return fpsections;
	}
	
	@Override
	public AbstractDescr compile(Map<Integer, Map<String, AbstractDescr>> symbolTable) {
		return null;
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