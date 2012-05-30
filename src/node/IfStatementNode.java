package node;

import descr.AbstractDescr;
import descr.SymbolTable;

public class IfStatementNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

	private final AbstractNode expression;
    private final AbstractNode statementSequence1;
    private final AbstractNode statementSequence2;
    private final AbstractNode elseIfs;
    
    public IfStatementNode(AbstractNode expression, AbstractNode statementSequence1, AbstractNode elseIfs, AbstractNode statementSequence2){
    	this.expression = expression;
    	this.statementSequence1 = statementSequence1;
    	this.elseIfs = elseIfs;
    	this.statementSequence2 = statementSequence2;
    }
    
	@Override
	public String toString(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(toString(indent, "IfStatementNode\n"));
        indent++;
        if (expression != null)
        	sb.append(expression.toString(indent));
        if (statementSequence1 != null)
        	sb.append(statementSequence1.toString(indent));
        if (elseIfs != null)
        	sb.append(elseIfs.toString(indent));
        if (statementSequence2 != null)
        	sb.append(statementSequence2.toString(indent));
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