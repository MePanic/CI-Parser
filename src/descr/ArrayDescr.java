package descr;

public class ArrayDescr extends TypeDescr {

	private static final long serialVersionUID = 1L;
	int numberelems;
	AbstractDescr basetype;

	public ArrayDescr(int fn, int fs, AbstractDescr fb) {
		numberelems = fn;
		size = fs;
		basetype = fb;
	}
	
	public String toString(){
		
		return "Array["+numberelems+"]:"+basetype.toString();
	}

}
