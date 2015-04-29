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

%init}

%{


private void writeOutputFile() throws IOException { 
	/*String filename = "file.out";
	BufferedWriter out = new BufferedWriter(new FileWriter(filename));
	imprimir la vara*/
}

%}

Decimal     = [0-9]+                
Octal       = "o"[0-7]+             
Hex         = "0x"[0-9|A-F]+        
Identifier  = [a-zA-Z][a-zA-Z0-9_]*
EOF = << EOF >>
%%

{Decimal}       {System.out.println("[" + yyline + "," + yycolumn + "] Decimal: " + yytext());}     
{Octal}         {System.out.println("[" + yyline + "," + yycolumn + "] Octal: " + yytext());}      
{Hex}           {System.out.println("[" + yyline + "," + yycolumn + "] Hexadecimal: " + yytext());} 
{Identifier}    {System.out.println("[" + yyline + "," + yycolumn + "] Identifier: " + yytext());}  
\r|\n|\r\n|\u2028|\u2029|\u000B|\u000C|\u0085 {}
EOF       {this.writeOutputFile(); System.exit(0);}  
.               {}                                         