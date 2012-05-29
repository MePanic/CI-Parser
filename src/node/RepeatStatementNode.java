package node;

public class RepeatStatementNode extends AbstractNode {

	private static final long serialVersionUID = 1L;
	
    private final AbstractNode statementSequence;
 	private final AbstractNode expression;   
    
    public RepeatStatementNode(AbstractNode statementSequence, AbstractNode expression) {
    	this.statementSequence = statementSequence;
    	this.expression = expression;
    }
    
	@Override
	public String toString(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(toString(indent, "RepeatStatement\n"));
        indent++;
        if (statementSequence != null)
        	sb.append(statementSequence.toString(indent));
        if (expression != null)
        	sb.append(expression.toString(indent));
        return sb.toString();
	}
}