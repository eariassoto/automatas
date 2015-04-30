/* The following code was generated by JFlex 1.4.3 on 4/30/15 10:25 AM */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Set;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 4/30/15 10:25 AM from the specification file
 * <tt>frases.flex</tt>
 */
class AnalizadorL {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\12\0\1\2\1\0\1\0\1\4\22\0\1\40\7\0\1\11\1\0"+
    "\1\3\4\0\1\1\12\35\1\0\1\41\1\0\1\41\3\0\22\34"+
    "\1\20\7\34\1\36\1\0\1\37\1\0\1\35\1\0\1\31\1\27"+
    "\1\33\1\32\1\6\1\13\1\30\1\17\1\12\2\34\1\7\1\23"+
    "\1\26\1\14\1\25\1\34\1\15\1\10\1\22\1\24\1\34\1\16"+
    "\1\34\1\21\1\34\1\5\11\0\1\0\u1fa2\0\1\0\1\0\udfd6\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\3\1\1\2\13\3\1\1\1\0\16\3\1\0"+
    "\3\3\1\4\1\5\12\3\1\0\1\6\4\3\1\7"+
    "\1\3\1\0\3\3\1\0\2\3\2\0\1\3\1\0"+
    "\1\10\1\0\1\3\1\0\1\3\1\0\1\3\1\0"+
    "\1\3\1\0\1\3\1\0\1\3\1\0\1\3\1\0"+
    "\1\3\1\0\1\3\1\0\1\11\1\3\1\0\1\3";

  private static int [] zzUnpackAction() {
    int [] result = new int[91];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\42\0\104\0\146\0\42\0\210\0\252\0\314"+
    "\0\356\0\u0110\0\u0132\0\u0154\0\u0176\0\u0198\0\u01ba\0\u01dc"+
    "\0\u01fe\0\u0220\0\u0242\0\u0264\0\u0286\0\u02a8\0\u02ca\0\u02ec"+
    "\0\u030e\0\u0330\0\u0352\0\u0374\0\u0396\0\u03b8\0\u03da\0\u03fc"+
    "\0\u041e\0\u0440\0\u0462\0\u0484\0\42\0\u04a6\0\u04c8\0\u04ea"+
    "\0\u050c\0\u052e\0\u0550\0\u0572\0\u0594\0\u05b6\0\u05d8\0\u05fa"+
    "\0\u061c\0\42\0\u063e\0\u0660\0\u0682\0\u06a4\0\42\0\u06c6"+
    "\0\u06e8\0\u070a\0\u072c\0\u074e\0\u0770\0\u0792\0\u07b4\0\u07d6"+
    "\0\u07f8\0\u081a\0\u083c\0\42\0\u085e\0\u0880\0\u08a2\0\u08c4"+
    "\0\u08e6\0\u0908\0\u092a\0\u094c\0\u096e\0\u0990\0\u09b2\0\u09d4"+
    "\0\u09f6\0\u0a18\0\u0a3a\0\u0a5c\0\u0a7e\0\u0aa0\0\u0ac2\0\42"+
    "\0\u0ae4\0\u0b06\0\u0b28";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[91];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\2\2\1\4\1\5\1\6\1\7\1\10"+
    "\1\2\1\11\1\12\2\13\1\14\1\13\1\15\6\13"+
    "\1\16\2\13\1\17\1\20\1\13\5\2\43\0\1\21"+
    "\1\0\1\22\40\0\1\2\45\0\1\13\1\23\1\13"+
    "\1\0\24\13\12\0\3\13\1\0\2\13\1\24\21\13"+
    "\12\0\3\13\1\0\5\13\1\25\16\13\12\0\3\13"+
    "\1\0\1\13\1\26\12\13\1\27\7\13\12\0\1\13"+
    "\1\30\1\13\1\0\2\13\1\31\21\13\12\0\3\13"+
    "\1\0\24\13\12\0\3\13\1\0\5\13\1\32\16\13"+
    "\12\0\3\13\1\0\7\13\1\33\1\34\13\13\12\0"+
    "\3\13\1\0\2\13\1\35\4\13\1\36\14\13\12\0"+
    "\3\13\1\0\2\13\1\37\21\13\12\0\3\13\1\0"+
    "\5\13\1\40\16\13\4\0\2\21\1\0\37\21\3\22"+
    "\1\41\36\22\6\0\2\13\1\42\1\0\24\13\12\0"+
    "\3\13\1\0\14\13\1\43\7\13\12\0\3\13\1\0"+
    "\2\13\1\44\21\13\12\0\3\13\1\45\24\13\12\0"+
    "\3\13\1\0\10\13\1\46\13\13\12\0\3\13\1\0"+
    "\2\13\1\47\21\13\12\0\3\13\1\0\3\13\1\50"+
    "\20\13\12\0\3\13\1\0\1\51\23\13\12\0\2\13"+
    "\1\52\1\0\24\13\12\0\3\13\1\0\3\13\1\53"+
    "\20\13\12\0\3\13\1\0\2\13\1\54\21\13\12\0"+
    "\3\13\1\0\10\13\1\55\13\13\12\0\3\13\1\0"+
    "\12\13\1\56\11\13\12\0\3\13\1\0\17\13\1\57"+
    "\4\13\4\0\1\22\1\2\1\22\1\41\36\22\6\0"+
    "\1\60\2\13\1\0\24\13\12\0\3\13\1\0\16\13"+
    "\1\46\5\13\12\0\3\13\1\0\3\13\1\27\20\13"+
    "\12\0\3\13\1\0\24\13\1\61\11\0\3\13\1\0"+
    "\17\13\1\27\4\13\12\0\3\13\1\62\24\13\12\0"+
    "\1\13\1\63\1\13\1\0\24\13\12\0\3\13\1\0"+
    "\10\13\1\64\13\13\12\0\3\13\1\0\1\24\23\13"+
    "\12\0\1\13\1\65\1\13\1\0\24\13\12\0\1\46"+
    "\2\13\1\0\24\13\12\0\3\13\1\0\15\13\1\66"+
    "\6\13\12\0\3\13\1\0\3\13\1\46\20\13\12\0"+
    "\3\13\1\67\1\70\23\13\43\0\1\71\10\0\1\50"+
    "\2\13\1\0\24\13\12\0\1\72\2\13\1\0\24\13"+
    "\12\0\1\73\2\13\1\0\24\13\12\0\1\13\1\55"+
    "\1\13\1\0\24\13\12\0\3\13\1\0\1\13\1\74"+
    "\22\13\44\0\1\75\7\0\3\13\1\0\11\13\1\76"+
    "\12\13\12\0\3\13\1\0\17\13\1\77\4\13\12\0"+
    "\3\13\1\67\24\13\12\0\3\100\1\0\23\100\5\0"+
    "\2\101\1\0\3\101\3\102\1\101\24\102\4\101\6\0"+
    "\3\13\1\0\14\13\1\46\7\13\12\0\3\100\1\0"+
    "\24\100\2\0\1\103\1\104\14\0\1\105\33\0\3\13"+
    "\1\0\2\13\1\106\21\13\45\0\1\104\24\0\1\107"+
    "\23\0\3\13\1\0\12\13\1\110\11\13\26\0\1\111"+
    "\25\0\3\13\1\0\10\13\1\112\13\13\4\0\2\113"+
    "\1\0\41\113\1\0\3\113\3\114\1\113\24\114\4\113"+
    "\25\0\1\115\22\0\3\13\1\0\13\13\1\116\10\13"+
    "\21\0\1\117\32\0\3\13\1\0\3\13\1\120\20\13"+
    "\16\0\1\121\35\0\3\13\1\0\1\122\23\13\32\0"+
    "\1\123\21\0\3\13\1\0\14\13\1\124\7\13\26\0"+
    "\1\125\25\0\3\13\1\0\10\13\1\126\13\13\13\0"+
    "\1\127\1\0\1\130\36\0\1\13\1\131\1\13\1\130"+
    "\24\13\32\0\1\132\21\0\3\13\1\0\14\13\1\133"+
    "\7\13\15\0\1\130\36\0\3\13\1\130\24\13\4\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[2890];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\2\1\1\11\14\1\1\0\16\1\1\0"+
    "\3\1\1\11\13\1\1\0\1\11\4\1\1\11\1\1"+
    "\1\0\3\1\1\0\2\1\2\0\1\1\1\0\1\11"+
    "\1\0\1\1\1\0\1\1\1\0\1\1\1\0\1\1"+
    "\1\0\1\1\1\0\1\1\1\0\1\1\1\0\1\1"+
    "\1\0\1\1\1\0\1\11\1\1\1\0\1\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[91];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
Frecuencias f;
static class Frecuencias {
	public enum TipoComponente {
    	IDENTIFICADOR("Identificadores"),
    	LISTA_PARAM("Listas Parámetros"),
    	LLAMADO_METODO("Llamados a métodos"),
    	BLOQUE("Bloques"),
    	TIPO("Tipos"),
    	IF("Condicionales if"),
    	ELSE("Condicionales else"),
    	CICLO("Ciclos"),
    	ARREGLO("Arreglos"),
    	IMPRESION("Impresiones"),
    	INSTRUCCION ("Instrucciones");

    	private final String nombre;       
	    private TipoComponente(String s) {
	        nombre = s;
	    }
	    public boolean equalsName(String n){
	        return (n == null)? false:nombre.equals(n);
	    }
	    public String toString(){
	       return nombre;
	    }
	}
 	
	EnumMap<TipoComponente, Integer> listaFrecuencias;

    Frecuencias() {
        listaFrecuencias = new EnumMap<TipoComponente, Integer>(TipoComponente.class);
        for (TipoComponente tc : TipoComponente.values()) {
            listaFrecuencias.put(tc, 0);
        }
    }

    public void contarComponente(TipoComponente tc){
    	Object valor = listaFrecuencias.get(tc);
		int v = (Integer)valor;
		listaFrecuencias.put(tc, v+1);
	}

	public void guardarTabla() throws IOException {
		String nombreArchivo = "tablas/tabla.txt"; //usar un timestap aqui
		BufferedWriter out = new BufferedWriter(new FileWriter(nombreArchivo));

		Set<TipoComponente> keySet = listaFrecuencias.keySet();
        for (TipoComponente tc : keySet) {
            int v = listaFrecuencias.get(tc);
            System.out.println(tc.toString()+": "+String.valueOf(v));
            out.write(tc.toString()+": "+String.valueOf(v)+"\n");
        }
        out.close();
	}
}



  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  AnalizadorL(java.io.Reader in) {
  f = new Frecuencias();
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  AnalizadorL(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 120) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public int yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 5: 
          { f.contarComponente(Frecuencias.TipoComponente.TIPO);
          }
        case 10: break;
        case 7: 
          { f.contarComponente(Frecuencias.TipoComponente.ELSE);
          }
        case 11: break;
        case 6: 
          { f.contarComponente(Frecuencias.TipoComponente.CICLO);
          }
        case 12: break;
        case 9: 
          { f.contarComponente(Frecuencias.TipoComponente.IMPRESION);
          }
        case 13: break;
        case 4: 
          { f.contarComponente(Frecuencias.TipoComponente.IF);
          }
        case 14: break;
        case 8: 
          { f.contarComponente(Frecuencias.TipoComponente.ARREGLO);
          }
        case 15: break;
        case 1: 
          { 
          }
        case 16: break;
        case 3: 
          { f.contarComponente(Frecuencias.TipoComponente.IDENTIFICADOR);
          }
        case 17: break;
        case 2: 
          { f.contarComponente(Frecuencias.TipoComponente.BLOQUE);
          }
        case 18: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
              {
                f.guardarTabla();System.exit(0);
              }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }

  /**
   * Runs the scanner on input files.
   *
   * This is a standalone scanner, it will print any unmatched
   * text to System.out unchanged.
   *
   * @param argv   the command line, contains the filenames to run
   *               the scanner on.
   */
  public static void main(String argv[]) {
    if (argv.length == 0) {
      System.out.println("Usage : java AnalizadorL <inputfile>");
    }
    else {
      for (int i = 0; i < argv.length; i++) {
        AnalizadorL scanner = null;
        try {
          scanner = new AnalizadorL( new java.io.FileReader(argv[i]) );
          while ( !scanner.zzAtEOF ) scanner.yylex();
        }
        catch (java.io.FileNotFoundException e) {
          System.out.println("File not found : \""+argv[i]+"\"");
        }
        catch (java.io.IOException e) {
          System.out.println("IO error scanning file \""+argv[i]+"\"");
          System.out.println(e);
        }
        catch (Exception e) {
          System.out.println("Unexpected exception:");
          e.printStackTrace();
        }
      }
    }
  }


}
