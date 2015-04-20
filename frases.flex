
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

"," { resultado+= "COMA"; cantComa++; System.out.println("COMA");}
"(1[0-5]|\d)" { resultado+= "NUM"; cantNum++; System.out.println("NUM");}
"(R1[0-5]|R\d)" { resultado+= "REG"; cantReg++; System.out.println("REG");}
"(\[1[0-5]\]|\[\d\])" { resultado+= "POS"; cantPos++; System.out.println("POS");}
"\s" { resultado+= "ESPACIO"; cantEsp++; System.out.println("ESPACIO");}
"LOAD" { resultado+= "LOAD"; cantLoad++; System.out.println("LOAD");}
"ADD" { resultado+= "ADD"; cantAdd++; System.out.println("ADD");}
"CMP" { resultado+= "CMP"; cantCmp++; System.out.println("CMP");}
