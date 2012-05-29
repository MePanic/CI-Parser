package node;

public class ConstDeclarationNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

    private final AbstractNode ident;
    private final AbstractNode expression;
    
    public ConstDeclarationNode(AbstractNode ident, AbstractNode expression){
    	this.ident = ident;
    	this.expression = expression;
    }
    
	@Override
	public String toString(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(toString(indent, "ConstDeclarationNode\n"));
        indent++;
        if (ident != null)
        	sb.append(ident.toString(indent));
        if (expression != null)
        	sb.append(expression.toString(indent));
        return sb.toString();
	}
}