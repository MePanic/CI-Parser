package node;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import descr.AbstractDescr;
import descr.ProcDescr;
import descr.VarDescr;
import static compiler.Compiler.*;

public class FpSectionNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

    private final AbstractNode identList;
    private final AbstractNode type;
    private final boolean isVar;
    
    public FpSectionNode(AbstractNode identList, AbstractNode type, boolean isVar) {
        this.identList = identList;
        this.type = type;
        this.isVar = isVar;
    }
    
	@Override
	public AbstractDescr compile(Map<Integer, Map<String, AbstractDescr>> symbolTable) {
		List<AbstractDescr> list = new LinkedList<AbstractDescr>();
		AbstractDescr typeDescr = type.compile(symbolTable);
		for (IdentNode ident : ((IdentListNode) identList).getIdents()) {
			address -= typeDescr.getSize();
			AbstractDescr varDescr = new VarDescr(level, address, typeDescr, isVar);
			list.add(varDescr);
			symbolTable.get(level).put(ident.getIdent(), varDescr);
		}
		return new ProcDescr("", 0, 0, 0, list); // nur für die Übergabe der Liste
	}
	
    @Override
    public String toString(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(toString(indent, "FPSectionNode (var: " + isVar + ")\n"));
		indent++;
        if (identList != null)
			sb.append(identList.toString(indent));
		if (type != null)
        	sb.append(type.toString(indent));
		return sb.toString();
    }
}