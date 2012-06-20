package node;

import java.util.Map;

import descr.AbstractDescr;
import descr.IntConstDescr;

import static compiler.Compiler.*;

public class PrintNode extends AbstractNode{

	private static final long serialVersionUID = 1L;
	
 	private final AbstractNode expression;
	
	public PrintNode(AbstractNode expression){
		this.expression = expression;
	}
	
	@Override
	public AbstractDescr compile(Map<Integer, Map<String, AbstractDescr>> symbolTable) {
        AbstractDescr descr = expression.compile(symbolTable);
        
        if (descr instanceof IntConstDescr && expression instanceof IntegerNode)
        	write("PUSHI, " + ((IntConstDescr) descr).getValue());
        
        write("PRINT");
        return null;
	}
	
	@Override
	public String toString(int indent) {
		StringBuilder sb = new StringBuilder();
		sb.append(toString(indent, "Print\n"));
		indent++;
        if (expression != null)
        	sb.append(expression.toString(indent));
		return sb.toString();
	}
}