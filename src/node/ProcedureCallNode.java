package node;

import java.util.Map;

import descr.AbstractDescr;
import descr.ProcDescr;
import static compiler.Compiler.*;

public class ProcedureCallNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

	private final IdentNode ident;
    private final AbstractNode actualParameters;
	
	public ProcedureCallNode(IdentNode ident, AbstractNode actualParameters){
		this.ident = ident;
		this.actualParameters = actualParameters;
	}
	
	@Override
	public AbstractDescr compile(Map<Integer, Map<String, AbstractDescr>> symbolTable) {
		ProcDescr descr = (ProcDescr) getDescr(level, ident.getIdent(), symbolTable);
		if (actualParameters != null)
			actualParameters.compile(symbolTable);
		write("CALL, " + descr.getStart());
		return null;
	}
	
	@Override
	public String toString(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(toString(indent, "ProcedureCallNode\n"));
        indent++;
        if (ident != null)
        	sb.append(ident.toString(indent));
        if (actualParameters != null)
        	sb.append(actualParameters.toString(indent));
        return sb.toString();
	}
}