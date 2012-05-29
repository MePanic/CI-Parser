package node;

public class FpSectionNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

    private final AbstractNode identList;
    private final AbstractNode type;
    
    public FpSectionNode(AbstractNode identList, AbstractNode type) {
        this.identList = identList;
        this.type = type;
    }
    
    @Override
    public String toString(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(toString(indent, "FPSectionNode\n"));
		indent++;
        if (identList != null)
			sb.append(identList.toString(indent));
		if (type != null)
        	sb.append(type.toString(indent));
		return sb.toString();
    }
}