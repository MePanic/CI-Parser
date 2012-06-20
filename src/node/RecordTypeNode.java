package node;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import descr.AbstractDescr;
import descr.RecordDescr;
import descr.TypeDescr;
import descr.VarDescr;

import static compiler.Compiler.*;

public class RecordTypeNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

	private final List<FieldListNode> fieldLists;

	public RecordTypeNode(List<FieldListNode> fieldLists) {
		this.fieldLists = fieldLists;
	}

	@Override
	public AbstractDescr compile(Map<Integer, Map<String, AbstractDescr>> symbolTable) {
		Map<String, AbstractDescr> map = new HashMap<String,AbstractDescr>();
		int size = 0;
		int address = 0;
		for (AbstractNode fieldList : fieldLists) {
			AbstractDescr typeDescr = null;
			AbstractNode type = ((FieldListNode)fieldList).getType();
			if (type instanceof IdentNode) {
				typeDescr = getDescr(level, ((IdentNode) type).getIdent(), symbolTable);
				if (typeDescr == null) {
					typeDescr = new TypeDescr(1, level, ((IdentNode)type).getIdent());
				}
			} else {
				typeDescr = type.compile(symbolTable);
			}
			for (AbstractNode ident : ((IdentListNode)((FieldListNode)fieldList).getIdentList()).getIdents()) {
				map.put(((IdentNode)ident).getIdent(), new VarDescr(level, address, typeDescr, false));
				address += typeDescr.getSize();
				size += typeDescr.getSize();
			}
		}
		return new RecordDescr(size, map);
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
}