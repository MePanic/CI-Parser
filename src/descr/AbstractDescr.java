package descr;

import java.io.Serializable;

public abstract class AbstractDescr implements Serializable {

	private static final long serialVersionUID = 1L;

	protected int size;
	protected int level;

	public AbstractDescr(int size, int level) {
		this.size = size;
		this.level = level;
	}

	public AbstractDescr() {
		this.size = 0;
	}
	
	public int getLevel() {
		return level;
	}

	//public void setLevel(int level) {
	//	this.level = level;
	//}

	public int getSize() {
		return size;
	}	
	
	//public void setSize(int fs) {
	//	size = fs;
	//}
	
	public abstract String toString(int indent);
	
	protected String toString(int indent, String string) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; ++i) {
            sb.append("  ");
        }
        sb.append(string);
        return sb.toString();
	}
}