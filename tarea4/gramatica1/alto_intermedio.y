/* 
PROGRAMA QUE CALCULA:
  TIPO 1) AREA DE RECTANGULO
  TIPO 2) PERIMETRO DE RECTANGULO
  TIPO 3) AREA DE TRIANGULO
  TIPO 4) POTENCIA DE UN NUMERO 

Ejemplo de consultas:

TIPO 1:
"CALCULAR AREA RECTANGULO LARGO 3 ANCHO 4"
"CALCULAR AREA RECTANGULO ANCHO 3 LARGO 4"
"OBTENER AREA RECTANGULO LARGO 3 ANCHO 4"
"OBTENER AREA RECTANGULO ANCHO 3 LARGO 4"

"CALCULAR AREA RECTANGULO CON LARGO 3 CON ANCHO 4"
"CALCULAR AREA RECTANGULO CON LARGO 3 Y ANCHO 4"
"CALCULAR AREA RECTANGULO DE LARGO 3 Y ANCHO 4"

TIPO 2:
"CALCULAR PERIMETRO RECTANGULO LARGO 3"

"CALCULAR PERIMETRO RECTANGULO CON LARGO 3"
"CALCULAR PERIMETRO RECTANGULO DE LARGO 3"

TIPO 3:
"CALCULAR AREA TRIANGULO BASE 3 ALTURA 4"
"CALCULAR AREA TRIANGULO ALTURA 3 BASE 4"
"OBTENER AREA TRIANGULO BASE 3 ALTURA 4"
"OBTENER AREA TRIANGULO ALTURA 3 BASE 4"

"CALCULAR AREA TRIANGULO CON BASE 3 CON ALTURA 4"
"CALCULAR AREA TRIANGULO CON BASE 3 Y ALTURA 4"
"CALCULAR AREA TRIANGULO DE ALTURA 3 DE BASE 4"
"CALCULAR AREA TRIANGULO DE ALTURA 3 Y BASE 4"


TIPO 4:
"CALCULAR POTENCIA DEL NUMERO CON BASE 3 EXPONENTE 2"
"CALCULAR POTENCIA DEL NUMERO CON EXPONENTE 3 BASE 2"

"CALCULAR POTENCIA BASE 3 Y EXPONENTE 2"
"CALCULAR POTENCIA EXPONENTE 3 Y BASE 2"

"CALCULAR POTENCIA DE BASE 2 Y EXPONENTE 4"  
"CALCULAR POTENCIA DE EXPONENTE 2 Y BASE 4"  
*/

%{
  import java.io.*;
%}

// token: componentes lexicos
%token NL          /* newline  */
%token <ival> NUM  
%token <sval> VERBOS
%token <sval> FIGURAS  
%token <sval> PETICION  
%token <sval> PARAMETROS
%token <sval> PREPOSICIONES

//type: para simbolos no terminales
%type <sval> area
%type <sval> perimetro
%type <sval> potencia

    
// Aqui empieza la gramatica 
%%

input:   /* empty string */
       | input line
       //| input line2
       //| input line3
       ;
       
line:    NL      { if (interactive) System.out.print("Expression: "); }

       | area NL  { System.out.println("El resultado es:\n" + $1);
       guardarArchivo($1); 
                   if (interactive) System.out.print("Expression: "); }

       | perimetro NL  { System.out.println("El resultado es:\n" + $1); 
       guardarArchivo($1); 
                   if (interactive) System.out.print("Expression: "); }

       | potencia NL  { System.out.println("El resultado es:\n" + $1); 
       guardarArchivo($1); 
                   if (interactive) System.out.print("Expression: "); }
       ;

//calcularArea( area, (triang/rect), (base/altura/largo/acncho), num, (base/altura/largo/acncho) ,num,); 
area:  VERBOS PETICION FIGURAS PARAMETROS NUM PARAMETROS NUM
        {
           $$ = calcularArea($2, $3, $4, $5, $6, $7); 
        }
      | VERBOS PETICION FIGURAS PREPOSICIONES PARAMETROS NUM PREPOSICIONES PARAMETROS NUM
        {
            $$ = calcularArea($2, $3, $5, $6, $8, $9); 
        }

;


//calcularPerimetro((perim), (rect), (largo),num ) 
perimetro: VERBOS PETICION FIGURAS PARAMETROS NUM
          {
             $$ = calcularPerimetro($2, $3, $4, $5); 
          }
          | VERBOS PETICION FIGURAS PREPOSICIONES PARAMETROS NUM
          {
             $$ = calcularPerimetro($2, $3, $5, $6); 
          }
;

//CASO A: "CALCULAR POTENCIA BASE 3 EXPONENTE 2"  

//CASO B:"CALCULAR POTENCIA DEL NUMERO CON EXPONENTE 3 BASE 2"

//CASO C:"CALCULAR POTENCIA DE BASE 2 Y EXPONENTE 4"  
potencia: VERBOS PETICION PARAMETROS NUM PARAMETROS NUM //CASO A
          {
              $$ = calcularPotencia($2, $3, $4, $5, $6); 
          }
          | VERBOS PETICION PREPOSICIONES PREPOSICIONES PREPOSICIONES PARAMETROS NUM PARAMETROS NUM //CASO B
          {
              $$ = calcularPotencia($2, $6, $7, $8, $9); 
          }
          |VERBOS PETICION PREPOSICIONES PARAMETROS NUM PREPOSICIONES PARAMETROS NUM //CASO C
          {
              $$ = calcularPotencia($2, $4, $5, $7, $8); 
          }
;


// Este es el codigo asociado (Acciones semanticas)
%%
  private Yylex lexer;

  private int yylex () {
    int yyl_return = -1;
    try {
      yylval = new ParserVal(0);
      yyl_return = lexer.yylex();
    }
    catch (IOException e) {
      System.err.println("IO error :"+e);
    }
    return yyl_return;
  }

  public void yyerror (String error) {
    System.err.println ("Error: " + error);
  }

  public Parser(Reader r) {
    lexer = new Yylex(r, this);
  }
    

//calcularArea((area/perim), (triang/cuadrad), (base/altura/),num, (base/altura),num,); 
public String calcularArea(String calculo, String figura, String dato1, int p1, String dato2, int p2)
{
    String hilera = "";
    if(calculo.toLowerCase().equals("area")) {
        if(figura.toLowerCase().equals("triangulo")) {
            
            if( dato1.toLowerCase().equals("altura")) {
                hilera = traducirAreaTriangulo(p1, p2);
            }
            else{
                hilera = traducirAreaTriangulo(p2, p1);
            }
        }
        else{
            if(figura.toLowerCase().equals("rectangulo")){

              if( dato1.toLowerCase().equals("largo")) {
                hilera = traducirMultiplicacion(p1, p2);
              }
              else{
                hilera = traducirMultiplicacion(p2, p1);
              }
            }
       } 
    }
    else {
        System.out.println(" ERROR ");
    }
    return hilera;
}


//calcularPerimetro((area/perim), (cuadrad), (largo),num ); 
public String calcularPerimetro(String calculo, String figura, String dato1, int p1)
{
    String hilera = "";
    if(calculo.toLowerCase().equals("perimetro")) {
        if(figura.toLowerCase().equals("rectangulo")) {
            
            if( dato1.toLowerCase().equals("largo")) {
                hilera = traducirPerimetroRectangulo(p1);
            }
        }
    }
    else {
        System.out.println(" ERROR ");
    }
    return hilera;
}

//"CALCULAR LA POTENCIA DEL NUMERO CON BASE 3 EXPONENTE 2"
public String calcularPotencia(String calculo,String dato1, int p1, String dato2, int p2)
{
    String hilera = "";
    if(calculo.toLowerCase().equals("potencia")) {
        if( dato1.toLowerCase().equals("base")) {
            hilera = traducirMultiplicacion(p1, p2);
        }
        else{
             hilera = traducirMultiplicacion(p2, p1);
        }
    }
    else {
        System.out.println(" ERROR ");
    }
    return hilera;
}


//VA A RECIBIR PRIMERO LARGO Y DESPUES ANCHO
public String traducirPerimetroRectangulo(int largo){
  // A = Largo*4
  String respuesta = "";

  /*SE GUARDA UN CERO PORQUE SE OCUPA UN REGISTRO CON CERO PORQUE SE OCUPAN TRES REGISTROS PARA EL OPERADOR ADD
  (CUADRO DE INST SCHOOLOGY) ENTONCES PARA SUMAR POR EJEMPLO: X+Y (ESTANDO X EN R1 , Y EN R2) SERIA: ADD R1 R2 0  */
  respuesta += "STOREI R0, 0 \n";
  respuesta += "STOREI R1," + " [" +largo +"]\n";
  respuesta += "STOREI R2, 0 \n"; //CONTADOR PARA EL "LOOP"
  respuesta += "STOREI R3, 4 \n"; // GUARDA EL 4

  //ETIQUETA (PUNTERO A MEMORIA ES ESTE NUMERO DE LINEA 210)
  respuesta += "STOREI R4, 1 \n";
  respuesta += "ADD R2, R3, R0 \n";
  respuesta += "ADD R1, R1, R0 \n"; // SUMA LARGO + LARGO
  respuesta += "CMP R2, R3 \n"; // COMPARA CONTADOR DE LOOP CON 4
  respuesta += "JMP 240 \n";//5 x 16 bits
  return respuesta;
}

//VA A RECIBIR PRIMERO LARGO Y DESPUES ANCHO
public String traducirMultiplicacion(int numero1, int  numero2){
  // A = Largo*Ancho
  String respuesta = "";
  respuesta += "STOREI R0," + " [" +numero1 +"]\n";
  respuesta += "STOREI R1," + " [" +numero2 +"]\n";

  // GUARDA EL CONTADOR PARA EL "LOOP" HASTA QUE R2 SEA IGAUL A ANCHO
  respuesta += "STOREI R2, 0 \n";
  /*SE GUARDA UN CERO PORQUE SE OCUPA UN REGISTRO CON CERO PORQUE SE OCUPAN TRES REGISTROS PARA EL OPERADOR ADD
   (CUADRO DE INST SCHOOLOGY) ENTONCES PARA SUMAR POR EJEMPLO: X+Y (ESTANDO X EN R1 , Y EN R2) SERIA: ADD R1 R2 0  */
  respuesta += "STOREI R3, 0 \n";

  // SE SUMAN EL LARGO CON EL MISMA  "ANCHO VECES"  (** ESTA POS DE MEM SERIA LA "ETIQUETA" A LA CUAL BRINCA EL JMP PARA QUE SE HAGA UN LOOP)
  respuesta += "ADD R0, R0, R3 \n";
  //SUMA UNO AL CONTADOR(R2)
  respuesta += "STOREI R4, 1 \n";
  respuesta += "ADD R2, R4, R3 \n";
  // COMPARA EL CONTADOR(R2) CON ANCHO ( PARA QUE SE HAGA ANCHO VECES)
  respuesta += "CMP R2, R1 \n";

  //se ASUME que el numero de linea es pos de memoria a la cual brinca
  respuesta += "JMP 262 \n";//5 x 16 bits
  return respuesta;
}

// VA A RECIBIR PRIMERO ALTURA Y DESPUES LA BASE
public String traducirAreaTriangulo(int altura, int  base){
  // AreaDeTriangulo = ( (base*altura)/2 )
  String respuesta = "";
  // GUARDA EN REGISTRO LA BASE Y ALTURA
	respuesta += "STOREI R0," + " [" +base +"]\n";
	respuesta += "STOREI R1," + " [" +altura +"]\n";

  // GUARDA EL CONTADOR PARA EL "LOOP" HASTA QUE R2 SEA IGAUL A ALTURA
	respuesta += "STOREI R2, 0 \n";
  // SE SUMA UN CERO PORQUE SE OCUPA TRES REGISTROS PARA EL OPERADOR ADD
  // ENTONCES PARA SUMAR POR EJEMPLO: X+Y SERIA: ADD X Y 0   
	respuesta += "STOREI R3, 0 \n";

  // SE SUMAN LA BASE CON ELLA MISMA  "ALTURA VECES"
	respuesta += "ADD R0, R0, R3 \n";

  //(** ESTA POS DE MEM SERIA LA "ETIQUETA" A LA CUAL BRINCA EL JMP PARA QUE SE HAGA UN LOOP)
  //GUARDA UN 1 EN R4 Y SUMA UNO AL CONTADOR
  respuesta += "STOREI R4, 1 \n";
	respuesta += "ADD R2, R4, R3 \n";

  // COMPARA A VER SI EL CONTADOR MANEJADO EN R2 YA ES IGUAL A ALTUTA
	respuesta += "CMP R2, R1 \n";
  //se ASUME que el numero de linea es pos de memoria a la cual brinca
  respuesta += "JMP 292 \n";//5 x 16 bits
	// DIVIDE ENTRE 2 cuando sale del "loop"
	respuesta += "SHIFT R0, 2 \n";
  return respuesta;
}

public void guardarArchivo(Object o)  {
  try{
    String nombreArchivo = "intermedio.code";
    String res = String.valueOf(o);
    BufferedWriter out = new BufferedWriter(new FileWriter(nombreArchivo));
    out.write(res);
    out.close();
  }catch(IOException ioe){

  } 
}

  static boolean interactive;

  public static void main(String args[]) throws IOException {
        System.out.println("Traductor de Alto Nivel a Nivel Intermedio");

        Parser yyparser;
        if ( args.length > 0 ) {
          // parse a file
          yyparser = new Parser(new FileReader(args[0]));
        }
        else {
          // interactive mode
          System.out.println("[Quit with CTRL-D]");
          System.out.print("Expression: ");
          interactive = true;
            yyparser = new Parser(new InputStreamReader(System.in));
        }

        yyparser.yyparse();

        if (interactive) {
          System.out.println();
          System.out.println("Finished");
        }
  }
