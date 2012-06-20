package node;

import java.util.List;
import java.util.Map;

import descr.AbstractDescr;
import descr.VarDescr;

import static compiler.Compiler.*;

public class IdentListNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

    private final List<IdentNode> idents;
    
    public IdentListNode(List<IdentNode> idents) {
    	this.idents = idents;
    }
    
    public List<IdentNode> getIdents() {
		return idents;
	}
    
	@Override
	public AbstractDescr compile(Map<Integer, Map<String, AbstractDescr>> symbolTable, AbstractDescr descr) {
		for (IdentNode ident : idents)
    		declareDescr(level, ident.getIdent(), new VarDescr(level, address, descr, false), symbolTable);
    	return null;
	}
    
    @Override
    public String toString(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(toString(indent, "IdentListNode\n"));
        indent++;
        for (AbstractNode node : idents) {
            sb.append(node.toString(indent));
        }
        return sb.toString();
    }
}