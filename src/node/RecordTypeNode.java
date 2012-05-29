package node;

import java.util.List;

import descr.AbstractDescr;
import descr.RecordDescr;
import descr.SymbolTable;

public class RecordTypeNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

	private final List<FieldListNode> fieldLists;

	public RecordTypeNode(List<FieldListNode> fieldLists) {
		this.fieldLists = fieldLists;
	}

	@Override
	public String toString(int indent) {
		StringBuilder sb = new StringBuilder();
		sb.append(toString(indent, "RecordTypeNode\n"));
		indent++;
		for (AbstractNode node : fieldLists) {
			if (node != null) { /* System.out.println("hier"); */
				sb.append(node.toString(indent));
			}
		}
		return sb.toString();
	}

	@Override
	public AbstractDescr compile(SymbolTable sm) {
		SymbolTable res = new SymbolTable(sm);
		for (AbstractNode node : fieldLists) {
			if (node != null) { 
				System.out.println(node.line);
//				res.declare(node.name(), descr)
				node.compile(res);
			}
		}
		return new RecordDescr(res.size(), res);
	}
}