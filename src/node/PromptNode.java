package node;

import descr.AbstractDescr;
import descr.SymbolTable;

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

	@Override
	public AbstractDescr compile(SymbolTable sm) {
		// TODO Auto-generated method stub
		return null;
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