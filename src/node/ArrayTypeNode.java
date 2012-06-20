package node;

import java.util.Map;

import descr.AbstractDescr;
import descr.ArrayDescr;
import descr.IntConstDescr;
import descr.TypeDescr;

import static compiler.Compiler.*;

public class ArrayTypeNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

	private final AbstractNode indexExpression;
	private final AbstractNode type;

	public ArrayTypeNode(AbstractNode indexExpression, AbstractNode type) {
		this.indexExpression = indexExpression;
		this.type = type;
	}
	
	@Override
	public AbstractDescr compile(Map<Integer, Map<String, AbstractDescr>> symbolTable) {
		AbstractDescr indexDescr = indexExpression.compile(symbolTable);
		AbstractDescr typeDescr = null;
		if (type instanceof IdentNode) {
			typeDescr = getDescr(level, ((IdentNode) type).getIdent(), symbolTable);
			if (typeDescr == null) {
				typeDescr = new TypeDescr(1, level, ((IdentNode) type).getIdent());
			}
		} else {
			typeDescr = type.compile(symbolTable);
		}
		int numberOfElems = ((IntConstDescr) indexDescr).getValue();
		int size = numberOfElems * typeDescr.getSize();
		return new ArrayDescr(numberOfElems, size, typeDescr);
	}

	@Override
	public String toString(int indent) {
		StringBuilder sb = new StringBuilder();
		sb.append(toString(indent, "ArrayTypeNode\n"));
		indent++;
		if (indexExpression != null)
			sb.append(indexExpression.toString(indent));
		if (type != null)
			sb.append(type.toString(indent));
		return sb.toString();
	}
}