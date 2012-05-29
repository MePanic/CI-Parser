package node;

public class TypeDeclarationNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

    private final AbstractNode ident;
    private final AbstractNode type;
    
    public TypeDeclarationNode(AbstractNode ident, AbstractNode type) {
    	this.ident = ident;
    	this.type = type;
    }
    
	@Override
	public String toString(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(toString(indent, "TypeDeclarationNode\n"));
        indent++;
        if (ident != null)
        	sb.append(ident.toString(indent));
        if (type != null)
        	sb.append(type.toString(indent));
        return sb.toString();
	}
}