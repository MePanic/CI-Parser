package descr;

public class ArrayDescr extends AbstractDescr {

	private static final long serialVersionUID = 1L;
	int numberelems;
	AbstractDescr basetype;

	public ArrayDescr(int fn, AbstractDescr fb) {
		numberelems = fn;
		basetype = fb;
		size = numberelems * basetype.size();
		System.out.println(numberelems + "-" + basetype.size);
	}

	public String toString(int lev){

		StringBuilder sb = new StringBuilder();
		sb.append(toString(lev,"ArrayDescr: numberelems: "+numberelems+" size: "+size + "\n"));
		lev++;
	
		sb.append(basetype.toString(lev));
	
		return sb.toString();
	}

	// ArrayDescr: numberelems: 10 size: 200
	public int size() {
		return this.size;
	}

}
