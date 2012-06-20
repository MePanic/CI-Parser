package node;

import java.util.HashMap;
import java.util.Map;

import descr.AbstractDescr;
import descr.TypeDescr;
import static compiler.Compiler.*;

public class ModuleNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

	private final AbstractNode ident;
	private final AbstractNode declarations;
	private final AbstractNode statementSequence;

	public ModuleNode(AbstractNode ident, AbstractNode declarations, AbstractNode statementSequence) {
		this.ident = ident;
		this.declarations = declarations;
		this.statementSequence = statementSequence;
	}
	
	@Override
	public AbstractDescr compile(Map<Integer, Map<String, AbstractDescr>> symbolTable) {
		symbolTable.put(level, new HashMap<String, AbstractDescr>());
		symbolTable.get(level).put("integer", new TypeDescr(1, level, "integer"));
		symbolTable.get(level).put("boolean", new TypeDescr(1, level, "boolean"));
		symbolTable.get(level).put("string", new TypeDescr(1, level, "string"));
		write("PUSHS, " + ((IdentNode)ident).getIdent());
		int startLabel = newLabel();
		write("JMP, " + startLabel);
		declarations.compile(symbolTable);
		System.out.println("==> start main");
		write("LABEL, " + startLabel);
		System.out.println("==> SP := " + address);
		write("PUSHI, " + (address));
		write("SETSP");
		statementSequence.compile(symbolTable);
		write("STOP");
		return null;
	}

	@Override
	public String toString(int indent) {
		StringBuilder sb = new StringBuilder();
		sb.append(toString(indent, "ModuleNode\n"));
		indent++;
		if (ident != null)
			sb.append(ident.toString(indent));
		indent++;
		if (declarations != null)
			sb.append(declarations.toString(indent));
		if (statementSequence != null)
			sb.append(statementSequence.toString(indent));
		return sb.toString();
	}
}