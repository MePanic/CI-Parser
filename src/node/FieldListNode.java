package node;

public class FieldListNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

	private final AbstractNode identList;
	private final AbstractNode type;

	public FieldListNode(AbstractNode identList, AbstractNode type) {
		this.identList = identList;
		this.type = type;
	}

	@Override
	public String toString(int indent) {
		StringBuilder sb = new StringBuilder();
		sb.append(toString(indent, "FieldListNode\n"));
		indent++;
		if (identList != null)
//			System.out.println("IDList " + (identList.line+1) + " - " + (identList.column+1));
			sb.append(identList.toString(indent));
		if (type != null)
//			System.out.println("type " + (type.line+1) + " - " + (type.column+1));
			sb.append(type.toString(indent+1));
		return sb.toString();
	}
}