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
	
	public String toString(int lev){
		//RecordDescr: size: 27 level: 0
		StringBuilder sb = new StringBuilder();
		sb.append(toString(lev,"RecordDescr: size: "+size+" level: "+0 + "\n"));
		lev++;
	
		for(String a : recsymbolTable.getAllAbstractDescrs().keySet()){
			sb.append(recsymbolTable.AbstractDescrFor(a).toString(lev));
		}
		
	
		return sb.toString();
	}
}
