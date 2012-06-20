package compiler;

class Token {
	
	private ID id;
	private int line, column;
	private String text;
	
	public Token(ID id, String text, int line, int column) {
		this.id = id;
		this.text = text;
		this.line = line;
		this.column = column;
	}
	
	@Override
	public String toString() {
		return "Token(" + text + ", ID: " + id + "," + line + "," + column + ")";
	}

	public ID id() { return id; }
	public String text() { return text; }
	public int line() { return line; }
	public int column() { return column; }
}