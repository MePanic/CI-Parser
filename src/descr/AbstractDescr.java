package descr;

import java.io.Serializable;

public abstract class AbstractDescr implements Serializable {
	private static final long serialVersionUID = 1L;
	protected int size;
	protected int level;

	public AbstractDescr() {
		// this.size = 0; this.level = CodeGen.level;
	}

	public int getLevel() {
		return level;
	}
}
