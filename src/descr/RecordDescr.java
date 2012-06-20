package descr;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class RecordDescr extends AbstractDescr {

	private static final long serialVersionUID = 1L;

	Map<String, AbstractDescr> recsymbolTable;

	public RecordDescr() {
		size = 0;
		recsymbolTable = new HashMap<String, AbstractDescr>();
	}

	public RecordDescr(int fs, Map<String, AbstractDescr> fr) {
		size = fs;
		recsymbolTable = fr;
	}

	public void setRecSymbolTable(Map<String, AbstractDescr> fr) {
		recsymbolTable = fr;
	}

	public Map<String, AbstractDescr> getRecsymbolTable() {
		return recsymbolTable;
	}
	
	@Override
	public String toString(int indent) {
		StringBuilder sb = new StringBuilder();
		sb.append(toString(indent, "RecordDescr(size: " + size + ", level: " + level + ")\n"));
		for (Entry<String, AbstractDescr> entry: recsymbolTable.entrySet()) {
			sb.append(toString(indent, entry.getKey() + ":"));
			sb.append(entry.getValue().toString(indent));
		}
		return sb.toString();
	}
}