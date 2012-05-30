package descr;

public class VarDescr extends AbstractDescr {

	private static final long serialVersionUID = 1L;
	int addr;
	boolean isvarpar;
	AbstractDescr type;
	String name;
	
	public VarDescr(int fa, String name, AbstractDescr ftype){
		isvarpar = false; addr = fa; type = ftype; this.name = name;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString(int lev) {
		// VarDescr: 0 level: 0
		StringBuilder sb = new StringBuilder();
		sb.append(toString(lev,name+"\n"));
		sb.append(toString(lev,"VarDescr: "+addr+" level: "+0 + "\n"));
		lev++;
	
		sb.append(type.toString(lev));
	
		return sb.toString();
	}
}
