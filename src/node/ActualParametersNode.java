package node;

import java.util.List;

import descr.AbstractDescr;
import descr.SymbolTable;

public class ActualParametersNode extends AbstractNode {

	private static final long serialVersionUID = 1L;
    
	private final List<AbstractNode> expressions;
    
    public ActualParametersNode(List<AbstractNode> expressions) {
        this.expressions = expressions;
    }
    
	@Override
	public String toString(int indent) {
		StringBuilder sb = new StringBuilder();
        sb.append(toString(indent, "ActualParametersNode\n"));
        indent++;
        for (int i = 0; i < expressions.size(); i++){
        	sb.append(expressions.get(i).toString(indent));
        }
        return sb.toString();
	}

	@Override
	public AbstractDescr compile(SymbolTable sm) {
		// TODO Auto-generated method stub
		return null;
	}
}