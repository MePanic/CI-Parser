package descr;

import java.util.*;

public class SymbolTable {

	private Map<String, Integer> addressMap = new HashMap<String, Integer>();
	private Map<String, AbstractDescr> abstractDescrMap = new HashMap<String, AbstractDescr>();
	private Map<String, Integer> constantMap = new HashMap<String, Integer>();
	private Map<Integer, Integer> stack = new HashMap<Integer, Integer>();
	private StringBuilder stackString = new StringBuilder();
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
		abstractDescrMap.put(ident, descr);
		addressMap.put(ident, currentAddress);
		currentAddress += descr.size();
	}
	
	public void trace(String string){
		stackString.append(string + "\n");
	}
	
	public void declareVar(String ident, AbstractDescr descr) {
		abstractDescrMap.put(ident, new VarDescr(currentAddress,ident, descr));
		addressMap.put(ident, currentAddress);
		currentAddress += descr.size();
	}
	
	public void declareConst(String ident, AbstractDescr descr) {
		abstractDescrMap.put(ident, descr);
		addressMap.put(ident, currentAddress);
		currentAddress += descr.size();
	}

	public AbstractDescr AbstractDescrFor(String ident) {
		AbstractDescr d = abstractDescrMap.get(ident);
		if (d == null && parentTable != null) {
			return parentTable.AbstractDescrFor(ident);
		}
		return d;
	}

	public Map<String, AbstractDescr> getAllAbstractDescrs(){
		return abstractDescrMap;
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
		
		for(String s : abstractDescrMap.keySet()){
			System.out.println(abstractDescrMap.get(s).toString(1));
			
		}
		System.out.println(stackString);
		return "";
	}

}
