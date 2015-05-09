import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Set;
%%

%class AnalizadorL  
%unicode                
%line                   
%column                 
%standalone             


%init{ 
f = new Frecuencias();
%init}

%{
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
        String primeraLinea = "", detalles ="";
        for (TipoComponente tc : keySet) {
            int v = listaFrecuencias.get(tc);
            primeraLinea += String.valueOf(v) + " ";
            detalles += tc.toString()+": "+String.valueOf(v)+"\n";
        }
        out.write(primeraLinea.trim()+"\n"+detalles);
        out.close();
	}
}

%}

Comentario =  (\/\/.*)|(\/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+\/)
Bloque = \{
Else = (else[ ]*\{)|(else[ ]*if\()  
If = if[ ]*\( 
Ciclos = (for[ ]*\()|(while[ ]*\()
Impresion = (System.out.println\()|(System.out.print\()
Tipo = byte|short|int|long|float|double|boolean|char|String
Identificador  = [a-zA-Z][a-zA-Z0-9_]*
Caracter = (\'[a-zA-Z]\') | (\'[0-9]\')
Hilera = \".*\"
Numero = [-+]?[0-9]*\.?[0-9]+
AlgoParaParametro = {Caracter}|{Hilera}|{Numero}|{Identificador}|(true)|(false)
AlgunParametro = {Tipo}[ ]+{Identificador}

LlamadaMetodo =  \.?{Identificador}\(({AlgoParaParametro}(\,)?|(\,?[ ])?)*\)
DefParametro  =     {Identificador}\(({AlgunParametro}(\,)?|(\,?[ ])?)*\)

Arreglo = {Tipo}\[\][ ]+{Identificador}[ ]*(;|=)  

Declaracion = ({Identificador}[ ]*?=[ ]*new[ ]+{Identificador})|({Identificador}[ ]*=[ ]*{AlgoParaParametro})
Comparacion = {AlgoParaParametro}|{Identificador}[ ]*(\<|\>|\=\=|\<\=|\>\=|\!\=)[ ]*{AlgoParaParametro}|{Identificador}
Instruccion = {Declaracion}|{Comparacion}
%%

// recuerde yyline yycolumn yytext()
{Comentario} {} 

{Tipo} {f.contarComponente(Frecuencias.TipoComponente.TIPO);} 
{Arreglo} {f.contarComponente(Frecuencias.TipoComponente.ARREGLO);} 
{Identificador} {f.contarComponente(Frecuencias.TipoComponente.IDENTIFICADOR);}

{If} {f.contarComponente(Frecuencias.TipoComponente.IF);}
{Else} {f.contarComponente(Frecuencias.TipoComponente.ELSE);}

{Ciclos} {f.contarComponente(Frecuencias.TipoComponente.CICLO);}
{Impresion} {f.contarComponente(Frecuencias.TipoComponente.IMPRESION);}

{DefParametro} {f.contarComponente(Frecuencias.TipoComponente.LISTA_PARAM);}
{LlamadaMetodo} {f.contarComponente(Frecuencias.TipoComponente.LLAMADO_METODO);}

{Bloque} {f.contarComponente(Frecuencias.TipoComponente.BLOQUE);} 
{Instruccion} {f.contarComponente(Frecuencias.TipoComponente.INSTRUCCION);} 
//llamados a metodos
// genericos
\r|\n|\r\n|\u2028|\u2029|\u000B|\u000C|\u0085 {}
<<EOF>>       {f.guardarTabla();System.exit(0);} 
.         {}                                         