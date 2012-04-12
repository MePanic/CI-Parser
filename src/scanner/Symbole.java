package scanner;
import java.util.ArrayList;
import java.util.List;

public class Symbole {
	private List symbolList = new ArrayList();

	public static final int ID = Yylex.ID;
	public static final int INT_TYP = Yylex.ICONST;

	// Schl�sselworte
	public static final int PROG_SYM = 101;
	public static final int BEGIN_SYM = 102;
	
//	--------------------- SymTab --------------------
	Symbole() {
		symbolList = new ArrayList();
		insert(PROG_SYM, "program");
		insert(BEGIN_SYM, "begin");
	}

//	--------------------- insert --------------------
  	public int insert(int aToken, String aLexem) {
		Symbol t = new Symbol(aToken, aLexem);
	 	return insert(t);
  	}

//	--------------------- insert --------------------
	public int insert(Symbol aSym) {
		// f�gt aSym ein, wenn e noch nicht vorhanden ist
		// liefert die symId
		int index = indexOf(aSym.lexem);
		if (index==-1) {
			symbolList.add(aSym);
			index = symbolList.size()-1;
		} 
		return index;
	}

//	--------------------- getToken --------------------
	public int getToken(String aLexem) {
		Symbol sym;
		int token=-1;
		String lexem = aLexem.toLowerCase();
		for (int i=0; i<symbolList.size(); i++) {
			sym = (Symbol)symbolList.get(i);
			if (sym.lexem.equals(lexem)) {
				token = sym.token;
			}
		}
		return token;
	}
 
//	--------------------- indexOf --------------------
	private int indexOf(String aLexem) {
		Symbol sym;
		int index = -1;
		for (int i=0; i<symbolList.size(); i++) {
			sym = (Symbol)symbolList.get(i);
			if (sym.lexem.equals(aLexem.toLowerCase())) {
				index = i;
			}
		}
		return index;
	}

//	--------------------- printSymbolList --------------------
	public void printSymbolList() {
		System.out.println("\n\nSymbolListe:");
		System.out.println(symbolList);
	}

}

//-----------------------------------------
//---------------- Symbol ------------------
//-----------------------------------------
 
 class Symbol {
	int token;
	String lexem;

//	--------------------- Token --------------------
	Symbol (int aktToken, String aLexem) {
	  token = aktToken;
	  lexem = aLexem.toLowerCase();
	}

//--------------------- toString --------------------
  public String toString() {
	  return "<" + token + ", " + lexem + ">\n";
  }
}
