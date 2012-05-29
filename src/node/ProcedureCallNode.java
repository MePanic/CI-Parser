package node;

public class ProcedureCallNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

	private final IdentNode ident;
    private final AbstractNode actualParameters;
	
	public ProcedureCallNode(IdentNode ident, AbstractNode actualParameters){
		this.ident = ident;
		this.actualParameters = actualParameters;
	}
	
	@Override
	public String toString(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(toString(indent, "ProcedureCallNode\n"));
        indent++;
        if (ident != null)
        	sb.append(ident.toString(indent));
        if (actualParameters != null)
        	sb.append(actualParameters.toString(indent));
        return sb.toString();
	}
}