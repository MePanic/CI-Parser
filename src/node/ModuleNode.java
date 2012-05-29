package node;

public class ModuleNode extends AbstractNode {

	private static final long serialVersionUID = 1L;
	
	private final AbstractNode ident;
	private final AbstractNode declaration;
	private final AbstractNode statementSequence;

	public ModuleNode(AbstractNode ident, AbstractNode declaration, AbstractNode statementSequence) {
		this.ident = ident;
		this.declaration = declaration;
		this.statementSequence = statementSequence;
	}
	
	@Override
	public String toString(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(toString(indent, "ModuleNode\n"));
		indent++;
        if (ident != null)
			sb.append(ident.toString(indent));
        indent ++;
		if (declaration != null)
			sb.append(declaration.toString(indent));
		if (statementSequence != null)
			sb.append(statementSequence.toString(indent));
    	return sb.toString();
	}
}