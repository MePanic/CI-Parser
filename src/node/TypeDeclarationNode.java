package node;

import java.util.Map;

import descr.AbstractDescr;
import descr.TypeDescr;

import static compiler.Compiler.*;

public class TypeDeclarationNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

    private final AbstractNode ident;
    private final AbstractNode type;
    
    public TypeDeclarationNode(AbstractNode ident, AbstractNode type) {
    	this.ident = ident;
    	this.type = type;
    }
    
	@Override
	public AbstractDescr compile(Map<Integer, Map<String, AbstractDescr>> symbolTable) {
		AbstractDescr typeDescr = null;
		if (type instanceof IdentNode){
			if (symbolTable.get(level).containsKey(((IdentNode)type).getIdent())) {
				typeDescr = symbolTable.get(level).get(((IdentNode)type).getIdent());
			} else {
				typeDescr = new TypeDescr(1, level, ((IdentNode)ident).getIdent());
			}
		} else {
			typeDescr = type.compile(symbolTable);
		}
		symbolTable.get(level).put(((IdentNode)ident).getIdent(), typeDescr);
		return typeDescr;
	}
	
	@Override
	public String toString(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(toString(indent, "TypeDeclarationNode\n"));
        indent++;
        if (ident != null)
        	sb.append(ident.toString(indent));
        if (type != null)
        	sb.append(type.toString(indent));
        return sb.toString();
	}
}