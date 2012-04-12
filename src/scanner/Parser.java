package scanner;

import java.util.*;

public class Parser {

	public static void main(String argv[]) {
		List<Token> list = new ArrayList<Token>();
	    if (argv.length == 0) {
	      System.out.println("Usage : java Scanner <inputfile>");
	    }
	    else {
	      for (int i = 0; i < argv.length; i++) {
	        Scanner scanner = null;
	        try {
	          scanner = new Scanner( new java.io.FileReader(argv[i]) );
	          while ( !scanner.zzAtEOF ) list.add(scanner.yylex());
	        }
	        catch (java.io.FileNotFoundException e) {
	          System.out.println("File not found : \""+argv[i]+"\"");
	        }
	        catch (java.io.IOException e) {
	          System.out.println("IO error scanning file \""+argv[i]+"\"");
	          System.out.println(e);
	        }
	        catch (Exception e) {
	          System.out.println("Unexpected exception:");
	          e.printStackTrace();
	        }
	      }
	    }
	    for(int i = 0; i < list.size()-2; i++) System.out.println(list.get(i));
	}
}

