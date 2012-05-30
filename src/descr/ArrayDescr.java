package descr;

import java.util.*;

public class ArrayDescr extends AbstractDescr {

	private static final long serialVersionUID = 1L;
	int numberelems;
	AbstractDescr basetype;
	List<AbstractDescr> content = new ArrayList<AbstractDescr>();

	public ArrayDescr(int fn, AbstractDescr fb) {
		numberelems = fn;
		basetype = fb;
		size = numberelems * basetype.size();
	}
	
	public AbstractDescr get(int i){
		return content.get(i);
	}
	
	public void set(AbstractDescr descr){
		
	}
	
	public void set(int i, AbstractDescr descr){
		content.set(i,descr);
	}

	public String toString(int lev){

		StringBuilder sb = new StringBuilder();
		sb.append(toString(lev,"ArrayDescr: numberelems: "+numberelems+" size: "+size + "\n"));
		lev++;
	
		sb.append(basetype.toString(lev));
	
		return sb.toString();
	}

	public int size() {
		return this.size;
	}

}
