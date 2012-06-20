package node;

import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import descr.AbstractDescr;
import descr.IntConstDescr;
import static compiler.Compiler.*;

public class ActualParametersNode extends AbstractNode {

	private static final long serialVersionUID = 1L;
    
	private final List<AbstractNode> expressions;
    
    public ActualParametersNode(List<AbstractNode> expressions) {
        this.expressions = expressions;
    }
    
	@Override
	public AbstractDescr compile(Map<Integer, Map<String, AbstractDescr>> symbolTable) {
		System.out.println("==> stack initialize");
		write("INIT, " + expressions.size());
		ListIterator<AbstractNode> it = expressions.listIterator(expressions.size());
		while (it.hasPrevious()) {
			System.out.println("==> parameter");
			AbstractNode node = it.previous();
			
			AbstractDescr descr = node.compile(symbolTable);
			if (descr instanceof IntConstDescr && node instanceof IntegerNode)
				write("PUSHI, " + ((IntConstDescr) descr).getValue());
			
			write("GETSP");
			write("ASSIGN, 1");
			write("GETSP");
			write("PUSHI, 1");
			write("ADD");
			write("SETSP");
		}
		return null;
	}
    
	@Override
	public String toString(int indent) {
		StringBuilder sb = new StringBuilder();
        sb.append(toString(indent, "ActualParametersNode\n"));
        indent++;
        for (int i = 0; i < expressions.size(); i++) {
        	sb.append(expressions.get(i).toString(indent));
        }
        return sb.toString();
	}
}