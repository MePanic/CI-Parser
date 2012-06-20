package node;

import java.util.Map;

import descr.AbstractDescr;
import descr.VarDescr;

import static compiler.Compiler.*;

public class IdentNode extends AbstractNode {

	private static final long serialVersionUID = 1L;
	
	private final String ident;
	
	public IdentNode(String ident) {
		this.ident = ident;
	}
	
	public String getIdent() {
		return ident;
	}
	
	@Override
	public AbstractDescr compile(Map<Integer, Map<String, AbstractDescr>> symbolTable) {
		AbstractDescr descr = getDescr(level, ident, symbolTable);
		if (descr instanceof VarDescr) {
			if (descr.getLevel() == 0)
				write("PUSHI, " + ((VarDescr) descr).getAddress());
			else {
				write("PUSHI, " + ((VarDescr) descr).getAddress());
				write("GETFP");
				write("ADD");
			}
		}
		return descr;
	}

    @Override
    public String toString(int indent) {
        return toString(indent, "IdentNode(" + ident + ")\n");
    }
}