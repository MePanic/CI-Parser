package descr;

import java.util.*;

public class SymbolTable {

	private Map<String, Integer> addressMap = new HashMap<String, Integer>();
	private Map<String, AbstractDescr> AbstractDescrMap = new HashMap<String, AbstractDescr>();
	private int currentAddress = 0;
	private SymbolTable parentTable;

	public SymbolTable() {
		this.parentTable = null;
	}

	public SymbolTable(SymbolTable table) {
		this.parentTable = table;
	}

	public static SymbolTable createSymbolTable() {
		return new SymbolTable();
	}

	public void declare(String ident, AbstractDescr descr) {
		AbstractDescrMap.put(ident, descr);
		addressMap.put(ident, currentAddress);
		currentAddress += descr.size();
	}

	// public void undeclare(String ident){
	// AbstractDescrMap.remove(ident);
	// addressMap.remove(ident);
	//
	// }

	public AbstractDescr AbstractDescrFor(String ident) {
		AbstractDescr d = AbstractDescrMap.get(ident);
		if (d == null && parentTable != null) {
			return parentTable.AbstractDescrFor(ident);
		}
		return d;
	}

	public int addressOf(String ident) {

		if (addressMap.containsKey(ident)) {
			return addressMap.get(ident);
		}
		if (parentTable != null) {
			return parentTable.addressOf(ident);
		}
		return -1;

	}

	public int size() {
		return currentAddress;
	}
	
	@Override
	public String toString(){
		
		for(String s : AbstractDescrMap.keySet()){
			System.out.println("Entry " + s + " - " + AbstractDescrMap.get(s) + " - " + addressMap.get(s));
		}
		
		return "";
	}

}
