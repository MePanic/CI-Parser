package node;

import java.util.Map;

import descr.AbstractDescr;

public class FieldListNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

	private final AbstractNode identList;
	private final AbstractNode type;

	public FieldListNode(AbstractNode identList, AbstractNode type) {
		this.identList = identList;
		this.type = type;
	}
	
	public AbstractNode getIdentList() {
		return identList;
	}

	public AbstractNode getType() {
		return type;
	}
	
	@Override
	public AbstractDescr compile(Map<Integer, Map<String, AbstractDescr>> symbolTable) {
    	AbstractDescr descr = null;
		if (type instanceof IdentNode){
			String s = ((IdentNode)type).getIdent();
			if (s.equals("integer")) {
				//descr = new SimpleTypeDescr(Type.INTEGER);
			} else if (s.equals("boolean")){
				//descr = new SimpleTypeDescr(Type.BOOLEAN);
			} else if (s.equals("string")){
				//descr = new SimpleTypeDescr(Type.STRING);
			} else {
				//descr = symbolTable.descriptorFor(s);
			}
		} else {
			descr = type.compile(symbolTable);
		}
    	identList.compile(symbolTable, descr);
    	return null;
	}

	@Override
	public String toString(int indent) {
		StringBuilder sb = new StringBuilder();
		sb.append(toString(indent, "FieldListNode\n"));
		indent++;
		if (identList != null)
			sb.append(identList.toString(indent));
		if (type != null)
			sb.append(type.toString(indent+1));
		return sb.toString();
	}
}