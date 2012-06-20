package node;

import java.util.Map;

import descr.AbstractDescr;

import static compiler.Compiler.*;

public class ReadNode extends AbstractNode {

	private static final long serialVersionUID = 1L;
    
	private final StringNode stringNode;

    public ReadNode() {
        this(null);
    }

    public ReadNode(StringNode stringNode) {
        this.stringNode = stringNode;
    }
    
	@Override
	public AbstractDescr compile(Map<Integer, Map<String, AbstractDescr>> symbolTable) {
		write("READ, " + stringNode.getString());
		return null;
	}
    
    @Override
    public String toString(int indent) {
        return toString(indent, "Read(" + stringNode.toString(0) +")\n");
    }
}