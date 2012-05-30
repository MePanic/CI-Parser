package node;

import java.util.List;

import descr.AbstractDescr;
import descr.SymbolTable;

public class StatementSequenceNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

	private final List<AbstractNode> statements;
	
	public StatementSequenceNode(List<AbstractNode> statements){
		this.statements = statements;
	}
	
	@Override
	public String toString(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(toString(indent, "StatementSequence\n"));
        indent++;
        for (int i = 0; i < statements.size(); i++){
        	if (statements.get(i) != null)
        		sb.append(statements.get(i).toString(indent));
        }
        return sb.toString();
	}

	@Override
	public AbstractDescr compile(SymbolTable sm) {
        for (int i = 0; i < statements.size(); i++){
        	if (statements.get(i) != null)
        		statements.get(i).compile(sm);
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