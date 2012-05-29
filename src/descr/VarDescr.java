package descr;

public class VarDescr extends AbstractDescr {

	private static final long serialVersionUID = 1L;
	int addr;
	boolean isvarpar;
	AbstractDescr type;
	
	public VarDescr(int fa, AbstractDescr ftype){
		isvarpar = false; addr = fa; type = ftype;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
}
