import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

%%


%class MyLexerExample   
%unicode                
%line                   
%column                 
%standalone            
%type String           


%init{ 
this.tokensList = new ArrayList();
%init}

%{

private ArrayList tokensList;


%}

Decimal     = [0-9]+              
Octal       = "o"[0-7]+            
Hex         = "0x"[0-9|A-F]+        
Identifier  = [a-zA-Z][a-zA-Z0-9_]* 


%%

{Decimal}       {this.tokensList.add("[" + yyline + "," + yycolumn + "] Decimal: " + yytext());}     
{Octal}         {this.tokensList.add("[" + yyline + "," + yycolumn + "] Octal: " + yytext());}       
{Hex}           {this.tokensList.add("[" + yyline + "," + yycolumn + "] Hexadecimal: " + yytext());} 
{Identifier}    {this.tokensList.add("[" + yyline + "," + yycolumn + "] Identifier: " + yytext());}  
.               {}                                       