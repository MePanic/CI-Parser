package descr;

import java.util.HashMap;
import scanner.Parser;

public class RecordDescr extends AbstractDescr {

	private static final long serialVersionUID = 1L;
	SymbolTable recsymbolTable;

	public RecordDescr(int fs, SymbolTable fr) {
		size = fs;
		recsymbolTable = fr;
	}
	
	public int size(){
		return this.size;
	}
	
	public String toString(){
		return "Record[" + size + "]";
	}
}
