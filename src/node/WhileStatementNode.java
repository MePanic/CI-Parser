package node;

public class WhileStatementNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

	private final AbstractNode expression;
	private final AbstractNode statementSequence;
    
    public WhileStatementNode(AbstractNode expression, AbstractNode statementSequence) {
    	this.expression = expression;
    	this.statementSequence = statementSequence;
    }
    
	@Override
	public String toString(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(toString(indent, "WhileStatement\n"));
        indent++;
        if (expression != null)
        	sb.append(expression.toString(indent));
        if (statementSequence != null)
        	sb.append(statementSequence.toString(indent));
        return sb.toString();
	}
}