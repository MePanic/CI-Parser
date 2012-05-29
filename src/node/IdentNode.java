package node;

public class IdentNode extends AbstractNode {

	private static final long serialVersionUID = 1L;
	
	private final String identName;
	
	public IdentNode(String identName) {
		this.identName = identName;
	}

    @Override
    public String toString(int indent) {
        return toString(indent, "IdentNode(" + identName + ")\n");
    }
}