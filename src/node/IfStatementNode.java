package node;

import java.util.Map;

import descr.AbstractDescr;

import static compiler.Compiler.*;

public class IfStatementNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

	private final AbstractNode expression;
    private final AbstractNode thenNode;
    private final AbstractNode elseNode;
    
    public IfStatementNode(AbstractNode expression, AbstractNode thenNode, AbstractNode elseNode) {
    	this.expression = expression;
    	this.thenNode = thenNode;
    	this.elseNode = elseNode;
    }
    
	@Override
	public AbstractDescr compile(Map<Integer, Map<String, AbstractDescr>> symbolTable) {
		int elseLabel = newLabel();
		int endLabel = newLabel();
		expression.compile(symbolTable);
		write("BF, " + elseLabel);
		if (thenNode != null)
			thenNode.compile(symbolTable);
		write("JMP, " + endLabel);
		write("LABEL, " + elseLabel);
		if (elseNode != null)
			elseNode.compile(symbolTable);
		write("LABEL, " + endLabel);
		return null;
	}
	
	@Override
	public String toString(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(toString(indent, "IfStatementNode\n"));
        indent++;
        if (expression != null)
        	sb.append(expression.toString(indent));
        if (thenNode != null)
        	sb.append(thenNode.toString(indent));
        if (elseNode != null)
        	sb.append(elseNode.toString(indent));
        return sb.toString();
	}
}