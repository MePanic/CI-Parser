package node;

import java.util.Map;

import descr.AbstractDescr;
import descr.IntConstDescr;

import static compiler.Compiler.*;

public class NegationNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

    private final AbstractNode node;
    
    public NegationNode(AbstractNode node) {
        this.node = node;
    }
    
	@Override
	public AbstractDescr compile(Map<Integer, Map<String, AbstractDescr>> symbolTable) {
		write("PUSHI, 0");
		
		AbstractDescr descr = node.compile(symbolTable);
    	if (descr instanceof IntConstDescr && node instanceof IntegerNode)
			write("PUSHI, " + ((IntConstDescr) descr).getValue());
    	
    	write("SUB");
    	return descr;
	}
	
    @Override
    public String toString(int indent) {
    	StringBuilder sb = new StringBuilder();
    	sb.append(toString(indent, "NegationNode\n"));
    	indent++;
        sb.append(node.toString(indent));
        return sb.toString();
    }
}