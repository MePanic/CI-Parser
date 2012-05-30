package node;

import descr.AbstractDescr;
import descr.SymbolTable;

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