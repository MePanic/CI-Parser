package node;

import descr.AbstractDescr;
import descr.SymbolTable;

public class AssignmentNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

    private final AbstractNode subject;
    private final AbstractNode expression;

    public AssignmentNode(AbstractNode subject, AbstractNode expression) {
        this.subject = subject;
        this.expression = expression;
    }
    
	@Override
	public String toString(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(toString(indent, "AssignmentNode\n"));
		indent++;
        if (subject != null)
			sb.append(subject.toString(indent));
		if (expression != null)
			sb.append(expression.toString(indent));
        return sb.toString();
	}

	@Override
	public AbstractDescr compile(SymbolTable sm) {
        if (subject != null && expression != null){
//        	System.out.println("hi");
        	
        }

		return null;
	}
}