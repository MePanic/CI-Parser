package gen;

import scanner.*;

public class CodeGen {

	public static void main(String argv[]) {
		Parser parser = new Parser(argv);
		StringBuilder parsed = parser.pars();
		System.out.println(parsed);
	}
	
	public void trace(String text){
		System.out.println(text);
	}

}
