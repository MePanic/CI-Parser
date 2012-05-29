package node;

import java.util.List;

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
}