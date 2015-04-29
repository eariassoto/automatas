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
		String nombreArchivo = "tabla.txt"; //usar un timestap aqui
		BufferedWriter out = new BufferedWriter(new FileWriter(nombreArchivo));

		Set<TipoComponente> keySet = listaFrecuencias.keySet();
        for (TipoComponente tc : keySet) {
            int v = listaFrecuencias.get(tc);
            System.out.println(tc.toString()+": "+String.valueOf(v));
        }
	}
}

%}
/*
Identificadores
Listas Parámetros
Llamados a métodos
Arreglos
Instrucciones
*/
Comentario =  (\/\/.*)|(\/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+\/)
Bloque = \{
Else = (else\()|else|else if|(else if \()  
If = (if\()|if  
Ciclos = (for\()|(while\()
Impresion = (System.out.println\()|(System.out.print\()
Tipo = byte|short|int|long|float|double|boolean|char|String
%%

// recuerde yyline yycolumn yytext()
{Comentario} {} 
{Tipo} {f.contarComponente(Frecuencias.TipoComponente.TIPO);} 
{Bloque} {f.contarComponente(Frecuencias.TipoComponente.BLOQUE);} 
{Else} {f.contarComponente(Frecuencias.TipoComponente.ELSE);}
{If} {f.contarComponente(Frecuencias.TipoComponente.IF);}
{Ciclos} {f.contarComponente(Frecuencias.TipoComponente.CICLO);}
{Impresion} {f.contarComponente(Frecuencias.TipoComponente.IMPRESION);}
//llamados a metodos
// genericos
\r|\n|\r\n|\u2028|\u2029|\u000B|\u000C|\u0085 {}
<<EOF>>       {f.guardarTabla();System.exit(0);} 
.         {}                                         