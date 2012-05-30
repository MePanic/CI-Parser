package node;

import descr.AbstractDescr;
import descr.SymbolTable;

public class ModuleNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

	private final AbstractNode ident;
	private final AbstractNode declaration;
	private final AbstractNode statementSequence;

	public ModuleNode(AbstractNode ident, AbstractNode declaration,
			AbstractNode statementSequence) {
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
		indent++;
		if (declaration != null)
			sb.append(declaration.toString(indent));
		if (statementSequence != null)
			sb.append(statementSequence.toString(indent));
		return sb.toString();
	}

	@Override
	public AbstractDescr compile(SymbolTable sm) {

		if (ident != null) {
			sm.trace("PUSHS, "+ident.name());
			sm.trace("JMP, "+0);
			ident.compile(sm);
		}
		if (declaration != null){
			declaration.compile(sm);
			sm.trace("LABLE, "+0);
			sm.trace("PUSHI, "+sm.size());
		}	
		if (statementSequence != null)
			statementSequence.compile(sm);
		System.out.println(sm.toString());
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