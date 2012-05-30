package descr;

public class SimpleTypeDescr extends AbstractDescr {
	
	private static final long serialVersionUID = 1L;
	String type;
	int size = 1;
	int val;
	
	public SimpleTypeDescr(String type){
		this.type = type;
		size = 1;
		this.val = 0;
		if(type.equals("integer")) {this.size = 1;}
	}
	
	public SimpleTypeDescr(String type, int val){
		this.type = type;
		size = 1;
		this.val = val;
		if(type.equals("integer")) {this.size = 1;}
	}

	public int size(){
		return this.size;
	}
	
	@Override
	public String toString(int lev){
		
		return toString(lev, "SimpleTypeDescr: " + type + " size: "+size+" level: 0\n");
	}

	@Override
	public void set(AbstractDescr descr) {
		
		
	}
}
