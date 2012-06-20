package compiler;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import node.AbstractNode;
import descr.*;

public class Compiler {

	public static int address = 0;
	public static int level = 0;

	public static FileWriter writer;
	public static int label = 0;
	public static Map<Integer, Map<String, AbstractDescr>> symbolTable = new HashMap<Integer, Map<String, AbstractDescr>>();
	AbstractNode tree;

	public Compiler(AbstractNode tree) {
		this.tree = tree;
	    File file = new File("/Users/Raimund/Documents/workspace/CI-Parser/oberon.txt");
	    try {
			writer = new FileWriter(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void compile() {
		tree.compile(symbolTable);
	}

	public static int newLabel() {
		return label++;
	}

	public static void write(String operation) {
		try {
			System.out.println("write " + operation);
			writer.write(operation + System.getProperty("line.separator"));
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static AbstractDescr getDescr(int level, String ident, Map<Integer, Map<String, AbstractDescr>> symbolTable) {
		while (level >= 0) {
			Map<String, AbstractDescr> map = symbolTable.get(level);
			if (map != null) {
				AbstractDescr descr = map.get(ident);
				if (descr != null)
					return descr;
			}
			level--;
		}
		return null;
	}
	
	public static void declareDescr(int level, String ident, AbstractDescr descr, Map<Integer, Map<String, AbstractDescr>> symbolTable) {
		Map<String, AbstractDescr> map = symbolTable.get(level);
		if (map != null) {
			if (!map.containsKey(ident)) {
				map.put(ident, descr);
				address += descr.getSize();
			} else
				System.out.println("variable already exist");
		} else
			System.out.println("level doesn't exist");
	}
	
	public static void printDescrs() {
		for (Entry<Integer, Map<String, AbstractDescr>> levelEntry : symbolTable.entrySet()){
			System.out.println("level: " + levelEntry.getKey() + "\n");
			for (Entry<String, AbstractDescr> entry : levelEntry.getValue().entrySet()) {
				System.out.println("ident '" + entry.getKey() + "':");
				System.out.println(entry.getValue().toString(0) + "==========");
			}
		}
	}
}