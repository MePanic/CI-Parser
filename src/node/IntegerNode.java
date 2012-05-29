package node;

public class IntegerNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

    private final int intVal;

    public IntegerNode(int val) {
        intVal = val;
    }
    
    @Override
    public String toString(int indent) {
        return toString(indent, "IntNode(" + intVal + ")\n");
    }
}