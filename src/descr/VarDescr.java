package descr;

public class VarDescr extends AbstractDescr {
	
	private static final long serialVersionUID = 1L;
	
	AbstractDescr type;
	int address;
	boolean isVar;
	
	public VarDescr(int level, int address, AbstractDescr type, boolean isVar) {
		super(type.getSize(), level);
		this.type = type;
		this.address = address;
		this.isVar = isVar;
	}

	public boolean isVar() {
		return isVar;
	}
	
	public int getAddress() {
		return address;
	}

	public void setAddress(int address) {
		this.address = address;
	}

	public AbstractDescr getType() {
		return type;
	}

	public void setType(AbstractDescr type) {
		this.type = type;
	}

	@Override
	public String toString(int indent) {
		return toString(indent, "VarDescr(address: " + address + ", size: " + size + ", level: " + level + ", isVar: " + isVar + ")\n");
	}
}