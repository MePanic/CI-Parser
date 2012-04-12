package scanner;

%%

%public
%class Scanner
%line
%column
%type Token



%{
public static final int	MUL = 256;
public static final int	PLUS = 257;
public static final int	MINUS = 258;
public static final int	DIV = 259;
public static final int	ASSIGN = 260;
public static final int	EQ = 261;
public static final int	NEQ = 262;
public static final int LO = 263;
public static final int DO = 295;
public static final int LOEQ = 264;
public static final int HI = 265;
public static final int HIEQ = 267;
public static final int DOT = 268;
public static final int COMMA = 269;
public static final int COLON = 270;
public static final int LPAR = 271;
public static final int RPAR = 272;
public static final int LBRAC = 273;
public static final int RBRAC = 274;
public static final int SEMICOLON = 275;
public static final int OF = 276;
public static final int THEN = 277;
public static final int PRINT = 278;
public static final int READ = 279;
public static final int END = 280;
public static final int ELSE = 281;
public static final int ELSIF = 282;
public static final int IF = 283;
public static final int WHILE = 284;
public static final int REPEAT = 285;
public static final int UNTIL = 286;
public static final int ARRAY = 287;
public static final int RECORD = 288;
public static final int CONST = 289;
public static final int TYPE = 290;
public static final int VAR = 291;
public static final int PROCEDURE = 292;
public static final int BEGIN = 293;
public static final int MODULE = 294;
public static final int ID = 295;
public static final int DIGIT = 296;
public static final int ERROR = 297;
%}
	
digit  =	[0-9]
letter =	[a-zA-Z]
id     =	{letter}({letter}|{digit}|"_"})*
BLANK  =	[ \t\n\r]

%% 
"*"					{ return new Token(MUL, yytext(), yyline, yycolumn); }
"+"					{ return new Token(PLUS, yytext(), yyline, yycolumn); }
"-"					{ return new Token(MINUS, yytext(), yyline, yycolumn); }
"/"					{ return new Token(DIV, yytext(), yyline, yycolumn); }
":="					{ return new Token(ASSIGN, yytext(), yyline, yycolumn); }
"="					{ return new Token(EQ, yytext(), yyline, yycolumn); }
"#"					{ return new Token(NEQ, yytext(), yyline, yycolumn); }
"<"					{ return new Token(LO, yytext(), yyline, yycolumn); }
"<="					{ return new Token(LOEQ, yytext(), yyline, yycolumn); }
">"					{ return new Token(HI, yytext(), yyline, yycolumn); }
">="					{ return new Token(HIEQ, yytext(), yyline, yycolumn); }
"."					{ return new Token(DOT, yytext(), yyline, yycolumn); }
","					{ return new Token(COMMA, yytext(), yyline, yycolumn); }
":"					{ return new Token(COLON, yytext(), yyline, yycolumn); }
"("					{ return new Token(LPAR, yytext(), yyline, yycolumn); }
")"					{ return new Token(RPAR, yytext(), yyline, yycolumn); }
"["					{ return new Token(LBRAC, yytext(), yyline, yycolumn); }
"]"					{ return new Token(RBRAC, yytext(), yyline, yycolumn); }
";"					{ return new Token(SEMICOLON, yytext(), yyline, yycolumn); }
[oO][fF]				{ return new Token(OF, yytext(), yyline, yycolumn); }
[tT][hH][eE][nN]			{ return new Token(THEN, yytext(), yyline, yycolumn); }
[dD][oO]				{ return new Token(DO, yytext(), yyline, yycolumn); }
[pP][rR][iI][nN][tT]			{ return new Token(PRINT, yytext(), yyline, yycolumn); }
[rR][eE][aA][dD]			{ return new Token(READ, yytext(), yyline, yycolumn); }
[eE][nN][dD]				{ return new Token(END, yytext(), yyline, yycolumn); }
[eE][lL][sS][eE]			{ return new Token(ELSE, yytext(), yyline, yycolumn); }
[eE][lL][sS][iI][fF]			{ return new Token(ELSIF, yytext(), yyline, yycolumn); }
[iI][fF]				{ return new Token(IF, yytext(), yyline, yycolumn); }
[wW][hH][iI][lL][eE]			{ return new Token(WHILE, yytext(), yyline, yycolumn); }
[rR][eE][pP][eE][eA][tT]		{ return new Token(REPEAT, yytext(), yyline, yycolumn); }
[uU][nN][tT][iI][lL]			{ return new Token(UNTIL, yytext(), yyline, yycolumn); }
[aA][rR][rR][aA][yY]			{ return new Token(ARRAY, yytext(), yyline, yycolumn); }
[rR][eE][cC][oO][rR][dD]		{ return new Token(RECORD, yytext(), yyline, yycolumn); }
[cC][oO][nN][sS][tT]			{ return new Token(CONST, yytext(), yyline, yycolumn); }
[tT][yY][pP][eE]			{ return new Token(TYPE, yytext(), yyline, yycolumn); }	
[vV][aA][rR]				{ return new Token(VAR, yytext(), yyline, yycolumn); }
[pP][rR][oO][cC][eE][dD][uU][rR][eE]	{ return new Token(PROCEDURE, yytext(), yyline, yycolumn); }
[bB][eE][gG][iI][nN]			{ return new Token(BEGIN, yytext(), yyline, yycolumn); }
[mM][oO][dD][uU][lL][eE]		{ return new Token(MODULE, yytext(), yyline, yycolumn); }
{digit}+ 				{ return new Token(DIGIT, yytext(), yyline, yycolumn); }
{id}					{ return new Token(ID, yytext(), yyline, yycolumn); }
{BLANK} 				{}
. 					{ return new Token(ERROR, yytext(), yyline, yycolumn);}
