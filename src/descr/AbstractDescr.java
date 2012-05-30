package descr;

import java.io.Serializable;

public abstract class AbstractDescr implements Serializable {
	private static final long serialVersionUID = 1L;
	protected int size;
	protected int level;

	public AbstractDescr() {
		this.size = 0;
		// this.level = CodeGen.level;
	}
	
	public abstract int size();

	public int getLevel() {
		return level;
	}
	
	public abstract String toString(int lev);
	
	public String toString(int lev, String string){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lev; ++i) {
            sb.append("  ");
        }
        sb.append(string);
        return sb.toString();
	}
}
