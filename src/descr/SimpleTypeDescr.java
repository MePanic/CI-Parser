package descr;

public class SimpleTypeDescr extends AbstractDescr {
	
	private static final long serialVersionUID = 1L;
	String type;
	int size = 1;
	
	public SimpleTypeDescr(String type){
		this.type = type;
		size = 1;
		if(type.equals("integer")) {this.size = 1;}
	}

	public int size(){
		return this.size;
	}
	
	@Override
	public String toString(int lev){
		
		return toString(lev, "SimpleTypeDescr: " + type + " size: "+size+" level: 0\n");
	}
}
