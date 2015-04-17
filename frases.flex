
%%

%public
%class AnalizadorL
%standalone

%unicode

%{
	String resultado = "";
  	int cantComa = 0, cantNum = 0,  cantReg = 0, cantPos = 0, cantEsp = 0, cantLoad = 0, cantAdd = 0, cantCmp = 0;
%}

%%

"," { resultado+= "COMA"; cantComa++; }
"(1[0-5]|\d)" { resultado+= "NUM"; canNum++; }
"(R1[0-5]|R\d)" { resultado+= "REG"; cantReg++; }
"(\[1[0-5]\]|\[\d\])" { resultado+= "POS"; cantPos++; }
"\s" { resultado+= "ESPACIO"; cantEsp++; }
"LOAD" { resultado+= "LOAD"; cantLoad++; }
"ADD" { resultado+= "ADD"; cantAdd++; }
"CMP" { resultado+= "CMṔ"; cantCmp++; }
int|char {System.out.println("TIPO") ;}
[a-zA-Z]+ {System.out.println("ID") ;}
";" {System.out.println("PC") ;}
"."				{ System.out.println("El sujeto de su frase es: "+sujeto ); }
. { System.out.println("encontré una vara rara q no se q es.. oh oh");}
