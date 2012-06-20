package descr;

public class IntConstDescr extends AbstractDescr {
	
	private static final long serialVersionUID = 1L;
	
	int integer;

	public IntConstDescr(int level, int integer) {
		super(1, level);
		this.integer = integer;
	}
	
	public int getValue() {
		return integer;
	}
	
	@Override
	public String toString(int indent) {
		return toString(indent, "IntConstDescr(value: " + integer + ", level: " + level + ")\n");
	}
}