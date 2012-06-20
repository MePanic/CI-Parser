package descr;

public class ArrayDescr extends AbstractDescr {

	private static final long serialVersionUID = 1L;

	int numberElems;
	AbstractDescr baseType;

	public ArrayDescr() {
		numberElems = 0;
		size = 0;
		baseType = null;
	}

	public ArrayDescr(int fn, int fs, AbstractDescr fb) {
		numberElems = fn;
		size = fs;
		baseType = fb;
	}

	public void setNumberelems(int fn) {
		numberElems = fn;
	}

	public void setBasetype(AbstractDescr fb) {
		baseType = fb;
	}

	public int getNumberelems() {
		return numberElems;
	}

	public AbstractDescr getBasetype() {
		return baseType;
	}
	
	@Override
	public String toString(int indent) {
		StringBuilder sb = new StringBuilder();
		sb.append(toString(indent, "ArrayDescr(numberElems: " + numberElems + ", size: " + size + ")\n"));
		indent++;
		sb.append(baseType.toString(indent));
		return sb.toString();
	}
}