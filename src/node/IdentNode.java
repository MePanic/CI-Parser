package node;

import descr.AbstractDescr;
import descr.SimpleTypeDescr;
import descr.SymbolTable;

public class IdentNode extends AbstractNode {

	private static final long serialVersionUID = 1L;
	
	private final String identName;
	
	public IdentNode(String identName) {
		this.identName = identName;
	}
	
	public String name(){
		return this.identName;
	}

    @Override
    public String toString(int indent) {
        return toString(indent, "IdentNode(" + identName + ")\n");
    }

	@Override
	public AbstractDescr compile(SymbolTable sm) {
//		System.out.println(toString(0, "IdentNode(" + identName + ")\n"));
		return new SimpleTypeDescr(identName);
	}

	@Override
	public AbstractDescr compile(SymbolTable sm, AbstractNode type) {
		
		return sm.AbstractDescrFor(identName);
	}

	@Override
	public int getVal() {
		// TODO Auto-generated method stub
		return 0;
	}

//	@Override
//	public String trace(SymbolTable sm) {
//		// TODO Auto-generated method stub
//		return "PUSHI, " + sm.addressOf(identName) + "\n";
//	}
}