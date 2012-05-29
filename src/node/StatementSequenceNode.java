package node;

import java.util.List;

public class StatementSequenceNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

	private final List<AbstractNode> statements;
	
	public StatementSequenceNode(List<AbstractNode> statements){
		this.statements = statements;
	}
	
	@Override
	public String toString(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(toString(indent, "StatementSequence\n"));
        indent++;
        for (int i = 0; i < statements.size(); i++){
        	if (statements.get(i) != null)
        		sb.append(statements.get(i).toString(indent));
        }
        return sb.toString();
	}
}