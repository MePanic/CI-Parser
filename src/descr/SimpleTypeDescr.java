package descr;

public class SimpleTypeDescr extends AbstractDescr {
	
	private static final long serialVersionUID = 1L;
	String type;
	int size = 0;
	
	public SimpleTypeDescr(String type){
		this.type = type;
		if(type.equals("integer")) {this.size = 1;}
	}

	public int size(){
		return this.size;
	}
	
	@Override
	public String toString(){
		return type;
	}
}
