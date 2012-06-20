package node;

import java.util.Map;

import descr.AbstractDescr;
import descr.IntConstDescr;
import static compiler.Compiler.*;

public class ContentNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

	private AbstractNode subject;

    public ContentNode(AbstractNode subject) {
        this.subject = subject;
    }
    
 	public AbstractNode getSubject(){
		return subject;
	}
 	
 	@Override
 	public AbstractDescr compile(Map<Integer, Map<String, AbstractDescr>> symbolTable) {
    	AbstractDescr descr = subject.compile(symbolTable);
        
    	if (descr instanceof IntConstDescr && subject instanceof IntegerNode)
    		write("PUSHI, " + ((IntConstDescr) descr).getValue());
    	else {
    		System.out.println(descr.toString(0));
    		write("CONT, " + descr.getSize());
    	}
    	
    	return descr;
 	}

	@Override
	public String toString(int indent) {
		StringBuilder sb = new StringBuilder();
		sb.append(toString(indent, "ContentNode\n"));
		indent++;
		if (subject != null)
			sb.append(subject.toString(indent));
		return sb.toString();
	}
}