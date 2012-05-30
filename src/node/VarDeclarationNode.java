package node;

import descr.AbstractDescr;
import descr.SymbolTable;

public class VarDeclarationNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

	private final AbstractNode identList;
	private final AbstractNode type;

	public VarDeclarationNode(AbstractNode identList, AbstractNode type) {
		this.identList = identList;
		this.type = type;
	}

	@Override
	public String toString(int indent) {
		StringBuilder sb = new StringBuilder();
		sb.append(toString(indent, "VarDeclarationNode\n"));
		indent++;
		if (identList != null)
			sb.append(identList.toString(indent));
		if (type != null)
			sb.append(type.toString(indent));
		return sb.toString();
	}

	@Override
	public AbstractDescr compile(SymbolTable sm) {

		identList.compile(sm, type);
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