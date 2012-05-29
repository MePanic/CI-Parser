package descr;

public class ProcDescr extends AbstractDescr {

	private SymbolTable symboltable;

	public ProcDescr(SymbolTable params) {
		this.symboltable = params;
	}

	public SymbolTable getSymbolTable() {
		return this.symboltable;
	}

	public int size() {
		return symboltable.size()/* + framesize ? */;
	}
}
