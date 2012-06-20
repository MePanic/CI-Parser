package descr;

public class TypeDescr extends AbstractDescr {

	private static final long serialVersionUID = 1L;
	
	String type;
	
	public TypeDescr() {
		super();
		this.type = "";
	}

	public TypeDescr(int size, int level, String type) {
		super(size, level);
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString(int indent) {
		return toString(indent, "TypeDescr(type: " + type + ", size: " + size + ", level: " + level + ")\n");
	}
}