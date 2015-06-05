/* tarea 3 */

/* lexical grammar */
%lex
%%

\s+                   /* con esto vale madre los espacios */
[0-9]+("."[0-9]+)?\b  return 'REALN'
[0-9]+\b              return 'INTN'
\'[a-zA-z]\'          return 'CARAC'
\".*\"                return 'HILERA'
"true"|"false"        return 'VBOOL'


"protected"           return 'PROTECTED'
"public"              return 'PUBLIC'
"private"             return 'PRIVATE'
"void"                return 'VOID'
"int"                 return 'INT'
"char"                return 'CHAR'
"float"               return 'FLOAT'
"bool"                return 'BOOL'
"String"              return 'STRING'
"class"               return 'CLASS'
"if"                  return 'IF'       
[a-zA-Z]+             return 'ID'
 

";"                   return 'PC'
"{"                   return "{"
"}"                   return "}"
"("                   return "("
")"                   return ")"
"+="                  return "+="
"-="                  return '-='
"*="                  return '*='
"/="                  return '/='
"++"                  return '++'
"--"                  return '--'
\"                    return "COMILLA"
"=="                  return '=='
"<="                  return '<='
">="                  return '>='
"!="                  return '!='
"&&"                  return '&&'
"||"                  return '||'
"="                   return '='
<<EOF>>               return 'EOF'
.                     return 'INVALID'

/lex

       
%start expressions

%% /* language grammar */

expressions
       : programa EOF
       {console.log($1);return $1;}
       ;
       
programa
       : CLASS ID '{' bloqueCodigo '}'
       {$$ = "La clase se llama: " + $2 + " y adentro tiene: " + $4+ "\n";}
       ;
  
bloqueCodigo 
       : instruccionCodigo  bloqueCodigo 
       {$$ = $1 + $2;}
       ;

bloqueCodigo
       : %empty
       {$$="";}
       ;

instruccionCodigo
       : definicion | metodo
        {$$ = $1 ;}
       ;

metodo
       : modificador  tipodatMetodo ID '(' ')' '{' bloque '}'
       {$$ = "\nEl metodo se llama: " + $3 + " y adentro tiene: " + $7+ "\n";}
       ;
modificador
       : PUBLIC | PRIVATE | PROTECTED
        {$$ = $1 ;}
       ;
bloque
       : instruccion bloque
       {$$ = $1 + $2;}
       ;
       
bloque
       : %empty
       {$$="";}
       ;
       
instruccion
       : asignacion | incdec | declaracion | comp | insif
        {$$ = $1 ;}
       ;

declaracion
       : tipodat ID '=' valor PC
       {$$ = "\n"+"Variable " + $2 + " de tipo " + $1 + " con el valor: " + $4;}
       ;

definicion
       : tipodat ID  PC
       {$$ = "\n"+"Variable " + $2 + " de tipo " + $1;}
       ;       
       
asignacion
       : ID operasig valor PC        
       {$$ = "\n"+"Modificacion de la variable "+$1;}
       ;
       
operasig
       : '+='|'-='| '*='|'/='
       {$$ = $1;}
       ;
       
pos       
       : ID operincdec PC
       {$$ = "\n"+"Modificacion de la variable "+$1;}
       ;

pre       
       : operincdec ID PC
       {$$ = "\n"+"Modificacion de la variable "+$2;}
       ;

incdec       
       : pos | pre
       {$$ = $1;}
       ;

opercomp       
       : '=='|'<='| '>='|'!=' | '&&' | '||'
       {$$ = $1;}
       ;

insif
       : IF '(' ID opercomp X ')' '{' bloque '}'
       {$$ ="\nif que compara " + $3 + " con " + $5 + " y ejecuta "+$8 + "\nfin de if";}
       ;

comp    
       : ID opercomp X PC
       {$$ = "\n"+"Comparacion de " + $1 + " con " + $3;}
       ;     

X
       : ID | valor
       {$$ = $1;}
       ;

operincdec      
       : '++'| '--'
       {$$ = $1;}
       ;
       
tipodat
       : INT | CHAR | BOOL | FLOAT | STRING
       { $$ = $1; }
       ;

tipodatMetodo
       : INT | CHAR | BOOL | FLOAT | STRING | VOID
       { $$ = $1; }
       ;
       
valor
       : INTN | REALN | CARAC | HILERA | VBOOL
       {$$ = $1;}
       ;