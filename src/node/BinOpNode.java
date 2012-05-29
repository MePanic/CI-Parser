package node;

public class BinOpNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

    public enum BinOp {
        MUL_OP, DIV_OP, PLUS_OP, MINUS_OP,
        EQ_OP, NEQ_OP, LO_OP, LOEQ_OP, HI_OP, HIEQ_OP
    }

    private final BinOp op;
    private final AbstractNode left, right;

    public BinOpNode(BinOp op, AbstractNode left, AbstractNode right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }
    
    @Override
    public String toString(int indent) {
        StringBuilder sb = new StringBuilder();
    	sb.append(toString(indent, "BinOpNode(" + op + ")\n"));
    	indent++;
    	sb.append(left.toString(indent));
        sb.append(right.toString(++indent));
        return sb.toString();
    }
}