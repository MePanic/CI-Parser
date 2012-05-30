package node;

import java.util.List;

import descr.AbstractDescr;
import descr.SymbolTable;

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