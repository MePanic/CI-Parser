package node;

import descr.AbstractDescr;
import descr.ArrayDescr;
import descr.SymbolTable;

public class ArrayTypeNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

	private final AbstractNode indexExpression;
	private final AbstractNode type;

	public ArrayTypeNode(AbstractNode indexExpression, AbstractNode type) {
		this.indexExpression = indexExpression;
		this.type = type;
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

	@Override
	public AbstractDescr compile(SymbolTable sm) {
//		System.out.println("hi");
		try {
			return new ArrayDescr(indexExpression.getVal(), type.compile(sm));
		} catch (java.lang.Error e) {
//			return new ArrayDescr(sm.AbstractDescrFor(indexExpression.name()),
//					4, type.compile(sm));
			return new ArrayDescr(10, type.compile(sm));
		}
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