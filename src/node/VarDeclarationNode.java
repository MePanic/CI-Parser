package node;

import java.util.Map;

import descr.AbstractDescr;
import static compiler.Compiler.*;

public class VarDeclarationNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

	private final AbstractNode identList;
	private final AbstractNode type;

	public VarDeclarationNode(AbstractNode identList, AbstractNode type) {
		this.identList = identList;
		this.type = type;
	}
	
	@Override
	public AbstractDescr compile(Map<Integer, Map<String, AbstractDescr>> symbolTable) {
		AbstractDescr descr = null;
		if (type instanceof IdentNode)
			descr = getDescr(level, ((IdentNode) type).getIdent(), symbolTable);
		else
			descr = type.compile(symbolTable);
		identList.compile(symbolTable, descr);
		return null;
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
}