package node;

import java.util.Map;

import descr.AbstractDescr;

public class PromptNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

	private AbstractNode stringNode;
	
	public PromptNode(AbstractNode stringNode) {
		this.stringNode = stringNode;
	}

	@Override
	public AbstractDescr compile(Map<Integer, Map<String, AbstractDescr>> symbolTable) {
		return null;
	}
	
	@Override
	public String toString(int indent) {
		return toString(indent, "Prompt(" + stringNode.toString(0) + ")\n");
	}
}