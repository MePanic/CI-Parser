package node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import descr.*;

import static compiler.Compiler.*;

public class ProcedureNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

	// heading
	private final IdentNode subject;
	private final FormalParametersNode fparams;
	
	// body
	private final AbstractNode declarations;
	private final AbstractNode statementSequence;

	public ProcedureNode(IdentNode subject, FormalParametersNode fparams, AbstractNode declarations, AbstractNode statementSequence) {
		this.subject = subject;
		this.fparams = fparams;
		this.declarations = declarations;
		this.statementSequence = statementSequence;
	}

	@Override
	public AbstractDescr compile(Map<Integer, Map<String, AbstractDescr>> symbolTable) {
		level++;
		int savedAddress = address;
		address = -3;
		
		// Parameter
		List<AbstractDescr> params = new LinkedList<AbstractDescr>();
		if (symbolTable.get(level) == null)
			symbolTable.put(level, new HashMap<String, AbstractDescr>());
		if (fparams != null) {
			for (FpSectionNode node : fparams.getFpSections()){
				AbstractDescr descr = node.compile(symbolTable);
				params.addAll(((ProcDescr) descr).getParams());
			}
		}
		int paramsLength = Math.abs(address) - 3;
		
		int localStart = address;
		declarations.compile(symbolTable);
		int localEnd = address;
		int local = Math.abs(localStart) - Math.abs(localEnd);
		
		int frameSize = address;
		int start = newLabel();
		int end = newLabel();
		System.out.println("==> start " + subject.getIdent());
		write("LABEL, " + start);
		System.out.println("==> 3 linkage + " + local + " local");
		write("INIT, " + (3 + local));
		System.out.println("==> entry code");
		write("PUSHREG, RK");
		write("PUSHREG, FP");
		write("PUSHI, " + level);
		write("PUSHREG, SL");
		System.out.println("==> FP := SP");
		write("GETSP");
		write("SETFP");
		System.out.println("==> SL1 := FP");
		write("GETFP");
		write("PUSHI, " + level);
		write("SETSL");
		System.out.println("==> SP := SP + " + local);
		write("GETSP");
		write("PUSHI, " + local);
		write("ADD");
		write("SETSP");
		System.out.println("==> statements begin");
		statementSequence.compile(symbolTable);
		System.out.println("==> exit code");
		write("LABEL, " + end);
		System.out.println("==> SP := FP");
		write("GETFP");
		write("SETSP");
		System.out.println("==> restore SL1");
		write("PUSHI, " + level);
		write("POPREG, SL");
		System.out.println("==> restore FP");
		write("POPREG, FP");
		System.out.println("==> restore RK");
		write("POPREG, RK");
		
		address = savedAddress;
		level--;
		
		ProcDescr descr = new ProcDescr(subject.getIdent(), frameSize, paramsLength, start, params);
		symbolTable.get(level).put(descr.getName(), descr);
		
		System.out.println("==> SP := SP - " + descr.getLengthparblock());
		write("GETSP");
		write("PUSHI, " + descr.getLengthparblock());
		write("SUB");
		write("SETSP");
		
		int reduce = 3 + local + descr.getLengthparblock();
		System.out.println("==> reduce " + reduce);
		write("REDUCE, " + reduce);
		write("RET");
		
		return descr;
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
}