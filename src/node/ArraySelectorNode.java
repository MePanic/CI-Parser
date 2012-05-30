package node;

import descr.AbstractDescr;
import descr.SymbolTable;

public class ArraySelectorNode extends AbstractNode {

	private static final long serialVersionUID = 1L;

    private final AbstractNode subject;
    private final AbstractNode selector;

    public ArraySelectorNode(AbstractNode subject, AbstractNode selector) {
        this.subject = subject;
        this.selector = selector;
    }
    
    @Override
    public String toString(int indent) {
    	StringBuilder sb = new StringBuilder();
    	sb.append(toString(indent, "ArraySelectorNode\n"));
    	indent++;
    	sb.append(subject.toString(indent));
    	sb.append(selector.toString(indent));
    	return sb.toString();
    }

	@Override
	public AbstractDescr compile(SymbolTable sm) {
		
		System.out.println(subject);
		System.out.println(selector.getVal() + "--");
		return null;
	}

	@Override
	public AbstractDescr compile(SymbolTable sm, AbstractNode type) {
		System.out.println(subject);
		System.out.println(selector.getVal() + "--");
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

//	@Override
//	public String trace(SymbolTable sm) {
//		StringBuilder res = new StringBuilder();
//		res.append(subject.trace(sm));
//
//		int size = selector.compile(sm).size();
//		System.out.println(size);
//		if(size >1){
//			res.append("PUSHI, " + size+"\n");
//		}
//		
////		return  "" + selector.trace(null)+subject.trace(null) ;
//		return res.toString();
//	}
}