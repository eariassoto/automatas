
%%

%byaccj

%{
  private Parser yyparser;

  public Yylex(java.io.Reader r, Parser yyparser) {
    this(r);
    this.yyparser = yyparser;
  }
%}


// POSIBLES PARAMETROS 
NUM = [0-9]+

NL  = \n | \r | \r\n

VERBOS = "CALCULAR" |"OBTENER"| "DAR" 

FIGURAS = "TRIANGULO"|"RECTANGULO"

PETICION = "AREA" | "PERIMETRO"| "POTENCIA"

PARAMETROS = "BASE" |"ALTURA" | "LARGO" | "ANCHO" | "BASE" | "EXPONENTE"

PREPOSICIONES = ("CON" | "Y"|"DE" |"LA"| "DEL" |"NUMERO")+

%%    

/* newline */
{NL}   { 
    return Parser.NL;
}

{VERBOS} { yyparser.yylval = new ParserVal(yytext()); return Parser.VERBOS; }

{FIGURAS} { yyparser.yylval = new ParserVal(yytext()); return Parser.FIGURAS; }

{PETICION} { yyparser.yylval = new ParserVal(yytext()); return Parser.PETICION; }

{PARAMETROS} { yyparser.yylval = new ParserVal(yytext()); return Parser.PARAMETROS; }
/*Int*/
{NUM}  { yyparser.yylval = new ParserVal(Integer.parseInt(yytext())); return Parser.NUM; }

{PREPOSICIONES} { yyparser.yylval = new ParserVal(yytext()); return Parser.PREPOSICIONES; }


/* whitespace */
[ \t]+ { }

\b     { System.err.println("Sorry, backspace doesn't work"); }

//ESTO REPRESENTA CUALQUIER COSA EL .
/* error fallback */  
[^]    { System.err.println("Error: unexpected character '"+yytext()+"'"); return -1; }
