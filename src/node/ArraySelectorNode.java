package node;

import java.util.Map;

import descr.AbstractDescr;
import descr.ArrayDescr;
import descr.IntConstDescr;
import descr.VarDescr;

import static compiler.Compiler.*;

public class ArraySelectorNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

    private final AbstractNode subject;
    private final AbstractNode selector;

    public ArraySelectorNode(AbstractNode subject, AbstractNode selector) {
        this.subject = subject;
        this.selector = selector;
    }
    
	@Override
	public AbstractDescr compile(Map<Integer, Map<String, AbstractDescr>> symbolTable) {
    	AbstractDescr descr = null;
		ArrayDescr arrayDescr = null;
    	int typeSize = 0;
    	if (subject instanceof IdentNode) {
    		arrayDescr = (ArrayDescr)((VarDescr) getDescr(level, ((IdentNode)subject).getIdent(), symbolTable)).getType();
    		typeSize = arrayDescr.getBasetype().getSize();
    		subject.compile(symbolTable);
    		
    		AbstractDescr selectorDescr = selector.compile(symbolTable);
    		if (selectorDescr instanceof IntConstDescr && selector instanceof IntegerNode)
    			write("PUSHI, " + ((IntConstDescr) selectorDescr).getValue());
    		
    		write("PUSHI, " + typeSize);
    		write("MUL");
    		write("ADD");
    		descr = arrayDescr.getBasetype();
    	} else if (subject instanceof ArraySelectorNode || subject instanceof RecordSelectorNode) {
    		arrayDescr = (ArrayDescr) subject.compile(symbolTable);
    		typeSize = arrayDescr.getBasetype().getSize();
    		
    		AbstractDescr selectorDescr = selector.compile(symbolTable);
    		if (selectorDescr instanceof IntConstDescr && selector instanceof IntegerNode)
    			write("PUSHI, " + ((IntConstDescr) selectorDescr).getValue());
    		
    		write("PUSHI, " + typeSize);
    		write("MUL");
    		write("ADD");
    		descr = arrayDescr.getBasetype();
    	} else {
    		System.out.println("ArraySelectorNodeError: " + subject);
    	}
    	return descr;
	}
	
    @Override
    public String toString(int indent) {
    	StringBuilder sb = new StringBuilder();
    	sb.append(toString(indent, "ArraySelectorNode\n"));
    	indent++;
    	if (subject != null)
    		sb.append(subject.toString(indent));
    	if (selector != null)
    		sb.append(selector.toString(indent));
    	return sb.toString();
    }
}