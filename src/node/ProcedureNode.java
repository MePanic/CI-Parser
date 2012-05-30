package node;

import descr.*;

public class ProcedureNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

	// heading
	private final IdentNode subject;
	private final FormalParametersNode fparams;
	// body
	private final AbstractNode declarations;
	private final AbstractNode statementSequence;

	public ProcedureNode(IdentNode subject, FormalParametersNode fparams,
			AbstractNode declarations, AbstractNode statementSequence) {
		this.subject = subject;
		this.fparams = fparams;
		this.declarations = declarations;
		this.statementSequence = statementSequence;
	}

	@Override
	public String toString(int indent) {
		StringBuilder sb = new StringBuilder();
		sb.append(toString(indent, "Procedure\n"));
		indent++;
		if (subject != null)
			sb.append(subject.toString(indent));
		if (fparams != null)
			sb.append(fparams.toString(indent));
		if (declarations != null)
			sb.append(declarations.toString(indent));
		if (statementSequence != null)
			sb.append(statementSequence.toString(indent));
		return sb.toString();
	}

	@Override
	public AbstractDescr compile(SymbolTable symbolTable) {
		SymbolTable sm = new SymbolTable(symbolTable);

		if (fparams != null)
			fparams.compile(sm);
		if (declarations != null)
			declarations.compile(sm);
		if (statementSequence != null)
			statementSequence.compile(sm);

		return new ProcDescr(sm);
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