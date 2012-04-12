package scanner;

class Token {
	private int id, line, column;
	private String text;
	
	public Token(int id, String text, int line, int column) {
		this.id = id;
		this.text = text;
		this.line = line;
		this.column = column;
		

	}
	
	@Override
	public String toString() {
		String out = "Token(" + text + ",ID:" + id + "," + line + "," + column + ")";
		return out;	
	}

	public int id() { return id; }
	public String text() { return text; }
	public int line() { return line; }
	public int column() { return column; }
}
