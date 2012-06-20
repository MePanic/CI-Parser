package node;

import java.util.Map;

import descr.AbstractDescr;
import descr.IntConstDescr;
import static compiler.Compiler.*;

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
	public AbstractDescr compile(Map<Integer, Map<String, AbstractDescr>> symbolTable) {
		AbstractDescr leftDescr = null, rightDescr = null;
		
		leftDescr = left.compile(symbolTable);
		if (leftDescr instanceof IntConstDescr && left instanceof IntegerNode)
			write("PUSHI, " + ((IntConstDescr) leftDescr).getValue());
		if (left instanceof IdentNode)
			write("CONT, 1");
		
		rightDescr = right.compile(symbolTable);
		if (rightDescr instanceof IntConstDescr && right instanceof IntegerNode)
			write("PUSHI, " + ((IntConstDescr) rightDescr).getValue());
		if (right instanceof IdentNode)
			write("CONT, 1");
		
		if (op.equals(BinOp.MUL_OP))
			write("MUL");
		else if (op.equals(BinOp.DIV_OP))
			write("DIV");
		else if (op.equals(BinOp.MINUS_OP))
			write("SUB");
		else if (op.equals(BinOp.PLUS_OP))
			write("ADD");
		else if (op.equals(BinOp.EQ_OP))
			write("EQ");
		else if (op.equals(BinOp.HI_OP))
			write("GT");
		else if (op.equals(BinOp.HIEQ_OP))
			write("GE");
		else if (op.equals(BinOp.LO_OP))
			write("LT");
		else if (op.equals(BinOp.LOEQ_OP))
			write("LE");
		else if (op.equals(BinOp.NEQ_OP))
			write("NEQ");
		
		return leftDescr;
	}
	
    @Override
    public String toString(int indent) {
        StringBuilder sb = new StringBuilder();
    	sb.append(toString(indent, "BinOpNode(" + op + ")\n"));
    	indent++;
    	sb.append(left.toString(indent));
        sb.append(right.toString(indent));
        return sb.toString();
    }
}