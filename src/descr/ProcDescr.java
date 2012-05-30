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

	@Override
	public String toString(int lev) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set(AbstractDescr descr) {
		// TODO Auto-generated method stub
		
	}
}
