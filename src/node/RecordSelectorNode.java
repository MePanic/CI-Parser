package node;

import java.util.Map;

import descr.AbstractDescr;
import descr.RecordDescr;
import descr.VarDescr;
import static compiler.Compiler.*;

public class RecordSelectorNode extends AbstractNode {

	private static final long serialVersionUID = 1L;
	
    private final AbstractNode subject;
    private final AbstractNode selector;

    public RecordSelectorNode(AbstractNode subject, AbstractNode selector) {
        this.subject = subject;
        this.selector = selector;
    }
    
	@Override
	public AbstractDescr compile(Map<Integer, Map<String, AbstractDescr>> symbolTable) {
		AbstractDescr descr = null;
		RecordDescr recordDescr = null;
		if (subject instanceof IdentNode) {
			
			// subject Descriptor
			VarDescr subjectVarDescr = (VarDescr) getDescr(level, ((IdentNode) subject).getIdent(), symbolTable);
			write("PUSHI, " + subjectVarDescr.getAddress());
			Map<String, AbstractDescr> map = ((RecordDescr) ((VarDescr) symbolTable.get(level).get(((IdentNode) subject).getIdent())).getType()).getRecsymbolTable();
			
			// selector Descriptor
			VarDescr selectorVarDescr = ((VarDescr) map.get(((IdentNode) selector).getIdent()));
			write("PUSHI, " + selectorVarDescr.getAddress());
			write("ADD");
			descr = selectorVarDescr.getType();
			
		} else if (subject instanceof RecordSelectorNode || subject instanceof ArraySelectorNode) {
			
			// subject Descriptor
			recordDescr = (RecordDescr) subject.compile(symbolTable);
			Map<String, AbstractDescr> map = recordDescr.getRecsymbolTable();
			
			// selector Descriptor
			VarDescr selectorVarDescr = ((VarDescr) map.get(((IdentNode) selector).getIdent()));
			write("PUSHI, " + selectorVarDescr.getAddress());
			write("ADD");
			descr = selectorVarDescr.getType();
			
		} else {
			System.out.println("RecordSelectorNodeError: " + subject);
		}
		return descr;
	}
	
    @Override
    public String toString(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(toString(indent, "RecordSelectorNode\n"));
        indent++;
        sb.append(subject.toString(indent));
        sb.append(selector.toString(indent));
        return sb.toString();
    }
}