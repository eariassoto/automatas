import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

%%

%class AnalizadorL  
%unicode                
%line                   
%column                 
%standalone             


%init{ 
this.tokensList = new ArrayList();
%init}

%{

private ArrayList tokensList; 

private void writeOutputFile() throws IOException { 
	String filename = "file.out";
	BufferedWriter out = new BufferedWriter(new FileWriter(filename));
	for (String s:this.tokensList) {
		System.out.println(s);
		out.write(s + "\n");
	}
	out.close();
}

%}

Decimal     = [0-9]+                
Octal       = "o"[0-7]+             
Hex         = "0x"[0-9|A-F]+        
Identifier  = [a-zA-Z][a-zA-Z0-9_]*
EOF = << EOF >>
%%

{Decimal}       {this.tokensList.add("[" + yyline + "," + yycolumn + "] Decimal: " + yytext());}     
{Octal}         {this.tokensList.add("[" + yyline + "," + yycolumn + "] Octal: " + yytext());}      
{Hex}           {this.tokensList.add("[" + yyline + "," + yycolumn + "] Hexadecimal: " + yytext());} 
{Identifier}    {this.tokensList.add("[" + yyline + "," + yycolumn + "] Identifier: " + yytext());}  
\r|\n|\r\n|\u2028|\u2029|\u000B|\u000C|\u0085 {}
EOF       {this.writeOutputFile(); System.exit(0);}  
.               {}                                         