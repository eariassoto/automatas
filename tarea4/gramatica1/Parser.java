//### This file created by BYACC 1.8(/Java extension  1.15)
//### Java capabilities added 7 Jan 97, Bob Jamison
//### Updated : 27 Nov 97  -- Bob Jamison, Joe Nieten
//###           01 Jan 98  -- Bob Jamison -- fixed generic semantic constructor
//###           01 Jun 99  -- Bob Jamison -- added Runnable support
//###           06 Aug 00  -- Bob Jamison -- made state variables class-global
//###           03 Jan 01  -- Bob Jamison -- improved flags, tracing
//###           16 May 01  -- Bob Jamison -- added custom stack sizing
//###           04 Mar 02  -- Yuval Oren  -- improved java performance, added options
//###           14 Mar 02  -- Tomas Hurka -- -d support, static initializer workaround
//### Please send bug reports to tom@hukatronic.cz
//### static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";






//#line 50 "alto_intermedio.y"
  import java.io.*;
//#line 19 "Parser.java"




public class Parser
{

boolean yydebug;        //do I want debug output?
int yynerrs;            //number of errors so far
int yyerrflag;          //was there an error?
int yychar;             //the current working character

//########## MESSAGES ##########
//###############################################################
// method: debug
//###############################################################
void debug(String msg)
{
  if (yydebug)
    System.out.println(msg);
}

//########## STATE STACK ##########
final static int YYSTACKSIZE = 500;  //maximum stack size
int statestk[] = new int[YYSTACKSIZE]; //state stack
int stateptr;
int stateptrmax;                     //highest index of stackptr
int statemax;                        //state when highest index reached
//###############################################################
// methods: state stack push,pop,drop,peek
//###############################################################
final void state_push(int state)
{
  try {
		stateptr++;
		statestk[stateptr]=state;
	 }
	 catch (ArrayIndexOutOfBoundsException e) {
     int oldsize = statestk.length;
     int newsize = oldsize * 2;
     int[] newstack = new int[newsize];
     System.arraycopy(statestk,0,newstack,0,oldsize);
     statestk = newstack;
     statestk[stateptr]=state;
  }
}
final int state_pop()
{
  return statestk[stateptr--];
}
final void state_drop(int cnt)
{
  stateptr -= cnt; 
}
final int state_peek(int relative)
{
  return statestk[stateptr-relative];
}
//###############################################################
// method: init_stacks : allocate and prepare stacks
//###############################################################
final boolean init_stacks()
{
  stateptr = -1;
  val_init();
  return true;
}
//###############################################################
// method: dump_stacks : show n levels of the stacks
//###############################################################
void dump_stacks(int count)
{
int i;
  System.out.println("=index==state====value=     s:"+stateptr+"  v:"+valptr);
  for (i=0;i<count;i++)
    System.out.println(" "+i+"    "+statestk[i]+"      "+valstk[i]);
  System.out.println("======================");
}


//########## SEMANTIC VALUES ##########
//public class ParserVal is defined in ParserVal.java


String   yytext;//user variable to return contextual strings
ParserVal yyval; //used to return semantic vals from action routines
ParserVal yylval;//the 'lval' (result) I got from yylex()
ParserVal valstk[];
int valptr;
//###############################################################
// methods: value stack push,pop,drop,peek.
//###############################################################
void val_init()
{
  valstk=new ParserVal[YYSTACKSIZE];
  yyval=new ParserVal();
  yylval=new ParserVal();
  valptr=-1;
}
void val_push(ParserVal val)
{
  if (valptr>=YYSTACKSIZE)
    return;
  valstk[++valptr]=val;
}
ParserVal val_pop()
{
  if (valptr<0)
    return new ParserVal();
  return valstk[valptr--];
}
void val_drop(int cnt)
{
int ptr;
  ptr=valptr-cnt;
  if (ptr<0)
    return;
  valptr = ptr;
}
ParserVal val_peek(int relative)
{
int ptr;
  ptr=valptr-relative;
  if (ptr<0)
    return new ParserVal();
  return valstk[ptr];
}
final ParserVal dup_yyval(ParserVal val)
{
  ParserVal dup = new ParserVal();
  dup.ival = val.ival;
  dup.dval = val.dval;
  dup.sval = val.sval;
  dup.obj = val.obj;
  return dup;
}
//#### end semantic value section ####
public final static short NL=257;
public final static short NUM=258;
public final static short VERBOS=259;
public final static short FIGURAS=260;
public final static short PETICION=261;
public final static short PARAMETROS=262;
public final static short PREPOSICIONES=263;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    0,    4,    4,    4,    4,    1,    1,    2,    2,
    3,    3,    3,
};
final static short yylen[] = {                            2,
    0,    2,    1,    2,    2,    2,    7,    9,    5,    6,
    6,    9,    8,
};
final static short yydefred[] = {                         1,
    0,    3,    0,    0,    0,    0,    2,    0,    4,    5,
    6,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   11,    0,    0,    7,
    0,    0,    0,    0,   13,    0,    8,   12,
};
final static short yydgoto[] = {                          1,
    4,    5,    6,    7,
};
final static short yysindex[] = {                         0,
 -253,    0, -256, -248, -245, -244,    0, -260,    0,    0,
    0, -255, -257, -252, -243, -246, -242, -241, -249, -240,
 -239, -237, -238, -236, -235, -234,    0, -232, -231,    0,
 -230, -227, -229, -224,    0, -223,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0, -248,
    0,    0,    0,    0,    0, -245,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
    0,    0,    0,    0,
};
final static int YYTABLESIZE=35;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         12,
   17,   13,   14,    2,    8,    3,   15,   16,    9,   18,
   19,   10,   11,   24,   20,   21,   23,    0,   26,   22,
   27,   25,   30,    0,   28,   29,   33,    0,   31,   32,
   35,   34,   36,   37,   38,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                        260,
  258,  262,  263,  257,  261,  259,  262,  263,  257,  262,
  263,  257,  257,  263,  258,  262,  258,   -1,  258,  262,
  258,  262,  258,   -1,  263,  262,  258,   -1,  263,  262,
  258,  262,  262,  258,  258,
};
}
final static short YYFINAL=1;
final static short YYMAXTOKEN=263;
final static String yyname[] = {
"end-of-file",null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,"NL","NUM","VERBOS","FIGURAS","PETICION","PARAMETROS",
"PREPOSICIONES",
};
final static String yyrule[] = {
"$accept : input",
"input :",
"input : input line",
"line : NL",
"line : area NL",
"line : perimetro NL",
"line : potencia NL",
"area : VERBOS PETICION FIGURAS PARAMETROS NUM PARAMETROS NUM",
"area : VERBOS PETICION FIGURAS PREPOSICIONES PARAMETROS NUM PREPOSICIONES PARAMETROS NUM",
"perimetro : VERBOS PETICION FIGURAS PARAMETROS NUM",
"perimetro : VERBOS PETICION FIGURAS PREPOSICIONES PARAMETROS NUM",
"potencia : VERBOS PETICION PARAMETROS NUM PARAMETROS NUM",
"potencia : VERBOS PETICION PREPOSICIONES PREPOSICIONES PREPOSICIONES PARAMETROS NUM PARAMETROS NUM",
"potencia : VERBOS PETICION PREPOSICIONES PARAMETROS NUM PREPOSICIONES PARAMETROS NUM",
};

//#line 138 "alto_intermedio.y"
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
//#line 397 "Parser.java"
//###############################################################
// method: yylexdebug : check lexer state
//###############################################################
void yylexdebug(int state,int ch)
{
String s=null;
  if (ch < 0) ch=0;
  if (ch <= YYMAXTOKEN) //check index bounds
     s = yyname[ch];    //now get it
  if (s==null)
    s = "illegal-symbol";
  debug("state "+state+", reading "+ch+" ("+s+")");
}





//The following are now global, to aid in error reporting
int yyn;       //next next thing to do
int yym;       //
int yystate;   //current parsing state from state table
String yys;    //current token string


//###############################################################
// method: yyparse : parse input and execute indicated items
//###############################################################
int yyparse()
{
boolean doaction;
  init_stacks();
  yynerrs = 0;
  yyerrflag = 0;
  yychar = -1;          //impossible char forces a read
  yystate=0;            //initial state
  state_push(yystate);  //save it
  val_push(yylval);     //save empty value
  while (true) //until parsing is done, either correctly, or w/error
    {
    doaction=true;
    if (yydebug) debug("loop"); 
    //#### NEXT ACTION (from reduction table)
    for (yyn=yydefred[yystate];yyn==0;yyn=yydefred[yystate])
      {
      if (yydebug) debug("yyn:"+yyn+"  state:"+yystate+"  yychar:"+yychar);
      if (yychar < 0)      //we want a char?
        {
        yychar = yylex();  //get next token
        if (yydebug) debug(" next yychar:"+yychar);
        //#### ERROR CHECK ####
        if (yychar < 0)    //it it didn't work/error
          {
          yychar = 0;      //change it to default string (no -1!)
          if (yydebug)
            yylexdebug(yystate,yychar);
          }
        }//yychar<0
      yyn = yysindex[yystate];  //get amount to shift by (shift index)
      if ((yyn != 0) && (yyn += yychar) >= 0 &&
          yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
        {
        if (yydebug)
          debug("state "+yystate+", shifting to state "+yytable[yyn]);
        //#### NEXT STATE ####
        yystate = yytable[yyn];//we are in a new state
        state_push(yystate);   //save it
        val_push(yylval);      //push our lval as the input for next rule
        yychar = -1;           //since we have 'eaten' a token, say we need another
        if (yyerrflag > 0)     //have we recovered an error?
           --yyerrflag;        //give ourselves credit
        doaction=false;        //but don't process yet
        break;   //quit the yyn=0 loop
        }

    yyn = yyrindex[yystate];  //reduce
    if ((yyn !=0 ) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
      {   //we reduced!
      if (yydebug) debug("reduce");
      yyn = yytable[yyn];
      doaction=true; //get ready to execute
      break;         //drop down to actions
      }
    else //ERROR RECOVERY
      {
      if (yyerrflag==0)
        {
        yyerror("syntax error");
        yynerrs++;
        }
      if (yyerrflag < 3) //low error count?
        {
        yyerrflag = 3;
        while (true)   //do until break
          {
          if (stateptr<0)   //check for under & overflow here
            {
            yyerror("stack underflow. aborting...");  //note lower case 's'
            return 1;
            }
          yyn = yysindex[state_peek(0)];
          if ((yyn != 0) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
            if (yydebug)
              debug("state "+state_peek(0)+", error recovery shifting to state "+yytable[yyn]+" ");
            yystate = yytable[yyn];
            state_push(yystate);
            val_push(yylval);
            doaction=false;
            break;
            }
          else
            {
            if (yydebug)
              debug("error recovery discarding state "+state_peek(0)+" ");
            if (stateptr<0)   //check for under & overflow here
              {
              yyerror("Stack underflow. aborting...");  //capital 'S'
              return 1;
              }
            state_pop();
            val_pop();
            }
          }
        }
      else            //discard this token
        {
        if (yychar == 0)
          return 1; //yyabort
        if (yydebug)
          {
          yys = null;
          if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
          if (yys == null) yys = "illegal-symbol";
          debug("state "+yystate+", error recovery discards token "+yychar+" ("+yys+")");
          }
        yychar = -1;  //read another
        }
      }//end error recovery
    }//yyn=0 loop
    if (!doaction)   //any reason not to proceed?
      continue;      //skip action
    yym = yylen[yyn];          //get count of terminals on rhs
    if (yydebug)
      debug("state "+yystate+", reducing "+yym+" by rule "+yyn+" ("+yyrule[yyn]+")");
    if (yym>0)                 //if count of rhs not 'nil'
      yyval = val_peek(yym-1); //get current semantic value
    yyval = dup_yyval(yyval); //duplicate yyval if ParserVal is used as semantic value
    switch(yyn)
      {
//########## USER-SUPPLIED ACTIONS ##########
case 3:
//#line 77 "alto_intermedio.y"
{ if (interactive) System.out.print("Expression: "); }
break;
case 4:
//#line 79 "alto_intermedio.y"
{ System.out.println("El resultado es:\n" + val_peek(1).sval);
       guardarArchivo(val_peek(1).sval); 
                   if (interactive) System.out.print("Expression: "); }
break;
case 5:
//#line 83 "alto_intermedio.y"
{ System.out.println("El resultado es:\n" + val_peek(1).sval); 
       guardarArchivo(val_peek(1).sval); 
                   if (interactive) System.out.print("Expression: "); }
break;
case 6:
//#line 87 "alto_intermedio.y"
{ System.out.println("El resultado es:\n" + val_peek(1).sval); 
       guardarArchivo(val_peek(1).sval); 
                   if (interactive) System.out.print("Expression: "); }
break;
case 7:
//#line 94 "alto_intermedio.y"
{
           yyval.sval = calcularArea(val_peek(5).sval, val_peek(4).sval, val_peek(3).sval, val_peek(2).ival, val_peek(1).sval, val_peek(0).ival); 
        }
break;
case 8:
//#line 98 "alto_intermedio.y"
{
            yyval.sval = calcularArea(val_peek(7).sval, val_peek(6).sval, val_peek(4).sval, val_peek(3).ival, val_peek(1).sval, val_peek(0).ival); 
        }
break;
case 9:
//#line 107 "alto_intermedio.y"
{
             yyval.sval = calcularPerimetro(val_peek(3).sval, val_peek(2).sval, val_peek(1).sval, val_peek(0).ival); 
          }
break;
case 10:
//#line 111 "alto_intermedio.y"
{
             yyval.sval = calcularPerimetro(val_peek(4).sval, val_peek(3).sval, val_peek(1).sval, val_peek(0).ival); 
          }
break;
case 11:
//#line 122 "alto_intermedio.y"
{
              yyval.sval = calcularPotencia(val_peek(4).sval, val_peek(3).sval, val_peek(2).ival, val_peek(1).sval, val_peek(0).ival); 
          }
break;
case 12:
//#line 126 "alto_intermedio.y"
{
              yyval.sval = calcularPotencia(val_peek(7).sval, val_peek(3).sval, val_peek(2).ival, val_peek(1).sval, val_peek(0).ival); 
          }
break;
case 13:
//#line 130 "alto_intermedio.y"
{
              yyval.sval = calcularPotencia(val_peek(6).sval, val_peek(4).sval, val_peek(3).ival, val_peek(1).sval, val_peek(0).ival); 
          }
break;
//#line 610 "Parser.java"
//########## END OF USER-SUPPLIED ACTIONS ##########
    }//switch
    //#### Now let's reduce... ####
    if (yydebug) debug("reduce");
    state_drop(yym);             //we just reduced yylen states
    yystate = state_peek(0);     //get new state
    val_drop(yym);               //corresponding value drop
    yym = yylhs[yyn];            //select next TERMINAL(on lhs)
    if (yystate == 0 && yym == 0)//done? 'rest' state and at first TERMINAL
      {
      if (yydebug) debug("After reduction, shifting from state 0 to state "+YYFINAL+"");
      yystate = YYFINAL;         //explicitly say we're done
      state_push(YYFINAL);       //and save it
      val_push(yyval);           //also save the semantic value of parsing
      if (yychar < 0)            //we want another character?
        {
        yychar = yylex();        //get next character
        if (yychar<0) yychar=0;  //clean, if necessary
        if (yydebug)
          yylexdebug(yystate,yychar);
        }
      if (yychar == 0)          //Good exit (if lex returns 0 ;-)
         break;                 //quit the loop--all DONE
      }//if yystate
    else                        //else not done yet
      {                         //get next state and push, for next yydefred[]
      yyn = yygindex[yym];      //find out where to go
      if ((yyn != 0) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn]; //get new state
      else
        yystate = yydgoto[yym]; //else go to new defred
      if (yydebug) debug("after reduction, shifting from state "+state_peek(0)+" to state "+yystate+"");
      state_push(yystate);     //going again, so push state & val...
      val_push(yyval);         //for next action
      }
    }//main loop
  return 0;//yyaccept!!
}
//## end of method parse() ######################################



//## run() --- for Thread #######################################
/**
 * A default run method, used for operating this parser
 * object in the background.  It is intended for extending Thread
 * or implementing Runnable.  Turn off with -Jnorun .
 */
public void run()
{
  yyparse();
}
//## end of method run() ########################################



//## Constructors ###############################################
/**
 * Default constructor.  Turn off with -Jnoconstruct .

 */
public Parser()
{
  //nothing to do
}


/**
 * Create a parser, setting the debug to true or false.
 * @param debugMe true for debugging, false for no debug.
 */
public Parser(boolean debugMe)
{
  yydebug=debugMe;
}
//###############################################################



}
//################### END OF CLASS ##############################
