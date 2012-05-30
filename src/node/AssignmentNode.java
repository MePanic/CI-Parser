package node;

import descr.AbstractDescr;
import descr.SymbolTable;

public class AssignmentNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

	private final AbstractNode subject;
	private final AbstractNode expression;
	private final AbstractNode idNote;

	public AssignmentNode(AbstractNode subject, AbstractNode expression, AbstractNode idNote) {
		this.subject = subject;
		this.expression = expression;
		this.idNote = idNote;
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
		if (subject != null && expression != null) {
//			System.out.println("------" + idNote.name());
//			System.out.println(subject);
//			System.out.println(expression + "-");
//			subject.compile(sm, idNote).set(expression.compile(sm));
//			sm.trace(expression.trace(sm));
			
			
		}

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