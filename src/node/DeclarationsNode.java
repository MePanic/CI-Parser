package node;

import java.util.List;

public class DeclarationsNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

	private final List<? extends AbstractNode> consts;
	private final List<? extends AbstractNode> types;
	private final List<? extends AbstractNode> vars;
	private final List<? extends AbstractNode> procedures;

	public DeclarationsNode(List<? extends AbstractNode> consts, List<? extends AbstractNode> types, List<? extends AbstractNode> vars, List<? extends AbstractNode> procedures) {
		this.consts = consts;
		this.types = types;
		this.vars = vars;
		this.procedures = procedures;
	}
	
	@Override
	public String toString(int indent) {
		StringBuilder sb = new StringBuilder();
		sb.append(toString(indent, "DeclarationsNode\n"));
		indent++;
		for (int i = 0; i < consts.size(); i++) {
			sb.append(consts.get(i).toString(indent));
		}
		for (int i = 0; i < types.size(); i++) {
			sb.append(types.get(i).toString(indent));
		}
		for (int i = 0; i < vars.size(); i++) {
			sb.append(vars.get(i).toString(indent));
		}
		for (int i = 0; i < procedures.size(); i++) {
			sb.append(procedures.get(i).toString(indent));
		}
		return sb.toString();
	}
}