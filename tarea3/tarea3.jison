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

class
   : CLASS 
   { $$ = new Nodo("class", true, $1); }
   ;

id
   : ID 
   { $$ = new Nodo("id", true, $1); }
   ;

pc
   : PC
   { $$ = new Nodo("pc", true, $1); }
   ;

valor
   : INTN 
   { $$ = new Nodo("valor", true, $1); }
   | REALN 
   { $$ = new Nodo("valor", true, $1); }
   | CARAC 
   { $$ = new Nodo("valor", true, $1); }
   | HILERA 
   { $$ = new Nodo("valor", true, $1); }
   | VBOOL
   { $$ = new Nodo("valor", true, $1); }
   ;

tipodat
   : INT 
   { $$ = new Nodo("tipodat", true, $1); }
   | CHAR 
   { $$ = new Nodo("tipodat", true, $1); }
   | BOOL 
   { $$ = new Nodo("tipodat", true, $1); }
   | FLOAT 
   { $$ = new Nodo("tipodat", true, $1); }
   | STRING
   { $$ = new Nodo("tipodat", true, $1); }
   ;

tipodatMetodo
   : INT 
   { $$ = new Nodo("tipodatMetodo", true, $1); }
   | CHAR 
   { $$ = new Nodo("tipodatMetodo", true, $1); }
   | BOOL 
   { $$ = new Nodo("tipodatMetodo", true, $1); }
   | FLOAT 
   { $$ = new Nodo("tipodatMetodo", true, $1); }
   | STRING 
   { $$ = new Nodo("tipodatMetodo", true, $1); }
   | VOID
   { $$ = new Nodo("tipodatMetodo", true, $1); }
   ;

operincdec      
       : '++'
       { $$ = new Nodo("operincdec", true, $1); }
       | '--'
       { $$ = new Nodo("operincdec", true, $1); }
       ;

X
       : id 
       { $$ = $1; }
       | valor
       { $$ = $1; }
       ;

opercomp       
   : '=='
   { $$ = new Nodo("opercomp", true, $1); }
   |'<='
   { $$ = new Nodo("opercomp", true, $1); }
   | '>='
   { $$ = new Nodo("opercomp", true, $1); }
   |'!=' 
   { $$ = new Nodo("opercomp", true, $1); }
   | '&&' 
   { $$ = new Nodo("opercomp", true, $1); }
   | '||'
   { $$ = new Nodo("opercomp", true, $1); }
   ;

operasig
   : '+='
   { $$ = new Nodo("operasig", true, $1); }
   |'-='
   { $$ = new Nodo("operasig", true, $1); }
   | '*='
   { $$ = new Nodo("operasig", true, $1); }
   |'/='
   { $$ = new Nodo("operasig", true, $1); }
   ;

modificador
   : PUBLIC 
   { $$ = new Nodo("modificador", true, $1); }
   | PRIVATE 
   { $$ = new Nodo("modificador", true, $1); }
   | PROTECTED
   { $$ = new Nodo("modificador", true, $1); }
   ;

if
   : IF 
   { $$ = new Nodo("if", true, $1); }
   ;

comp    
   : id opercomp X pc
   { $$ = new Nodo("comp", false); 
     $$.agregarHijo($1);
     $$.agregarHijo($2);
     $$.agregarHijo($3);
     $$.agregarHijo($4);
   }
   ;

insif
   : if '(' id opercomp X ')' '{' bloque '}'
   { $$ = new Nodo("insif", false); 
     $$.agregarHijo($1);
     $$.agregarHijo($3);
     $$.agregarHijo($4);
     $$.agregarHijo($5);
     $$.agregarHijo($8);
   }
   ;

pos       
   : id operincdec pc
   { $$ = new Nodo("pos", false);
   $$.agregarHijo($1);
   $$.agregarHijo($2);
   $$.agregarHijo($3);
   }
   ;

pre       
   : operincdec id pc
   { $$ = new Nodo("pre", false);
   $$.agregarHijo($1);
   $$.agregarHijo($2);
   $$.agregarHijo($3);
   }
   ;

incdec       
   : pos 
   { $$ = $1; }
   | pre
   { $$ = $1; }
   ;

asignacion
   : id operasig valor pc        
   { $$ = new Nodo("asignacion", false);
   $$.agregarHijo($1);
   $$.agregarHijo($2);
   $$.agregarHijo($3);
   $$.agregarHijo($4);
   }
   ;

definicion
   : tipodat id pc
   {$$ = new Nodo("definicion", false);
   $$.agregarHijo($1);
   $$.agregarHijo($2);
   $$.agregarHijo($3);
   }
   ; 

declaracion
   : tipodat id '=' valor pc
   { $$ = new Nodo("declaracion", false);
   $$.agregarHijo($1);
   $$.agregarHijo($2);
   $$.agregarHijo($4);
   $$.agregarHijo($5);
   }
   ;

instruccion
   : asignacion | incdec | declaracion | comp | insif
    { $$ = $1; }
   ;

bloque
   : instruccion bloque
   { 
       $$ = new Nodo("bloque", false);
       $$.agregarHijo($1);
       if($2.nombreGramatica == "bloque"){
              for(i = 0; i < $2.nHijos; i++) {
                     $$.agregarHijo($2.hijos[i]);
              }
       }
   }
   | %empty
   {$$ = new Nodo("finbloque", false); }
   ;


metodo
   : modificador tipodatMetodo id '(' ')' '{' bloque '}'
   { $$ = new Nodo("metodo", false);
   $$.agregarHijo($1);
   $$.agregarHijo($2);
   $$.agregarHijo($3);
   $$.agregarHijo($7);
   }
   ;

instruccionCodigo
   : definicion | metodo
    {$$ = $1;}
   ;

bloqueCodigo 
   : instruccionCodigo  bloqueCodigo 
   { $$ = new Nodo("bloqueCodigo", false); 
   $$.agregarHijo($1);
   if($2.nombreGramatica == "bloqueCodigo"){
              for(i = 0; i < $2.nHijos; i++) {
                     $$.agregarHijo($2.hijos[i]);
              }
       }
   }
   | %empty
   { $$ = new Nodo("finbloquecodigo", false); }
   ;
   
programa
   : class id '{' bloqueCodigo '}'
   { $$ = new Nodo("programa", false);
   $$.agregarHijo($1);
   $$.agregarHijo($2);
   $$.agregarHijo($4);
   }
   ;
       
expressions
   : programa EOF
   {
       $1.imprimir("");
       return $1;
   }
   ;
       