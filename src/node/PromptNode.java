package node;

public class PromptNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

	private AbstractNode stringNode;
	
	public PromptNode(AbstractNode stringNode) {
		this.stringNode = stringNode;
	}

	@Override
	public String toString(int indent) {
		return toString(indent, "Prompt(" + stringNode.toString(0) + ")\n");
	}
}