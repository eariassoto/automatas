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
    	TIPOS("Tipos"),
    	IF("Condicionales if"),
    	ELSE("Condicionales else"),
    	CICLOS("Ciclos"),
    	ARREGLOS("Arreglos"),
    	IMPRESION("Impresiones"),
    	INSTRUCCIONES ("Instrucciones");

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
    }

    public void contarComponente(TipoComponente tc){
    	Object valor = listaFrecuencias.get(tc);
    	if(valor == null){
    		listaFrecuencias.put(tc, 1);
    	}else{
    		int v = (Integer)valor;
			listaFrecuencias.put(tc, v+1);
    	}
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

Tipos
Condicionales if
Condicionales else
Ciclos
Arreglos
Impresiones
Instrucciones
*/

Decimal     = [0-9]+ 
Bloque = \{               
//Octal       = "o"[0-7]+             
//Hex         = "0x"[0-9|A-F]+        
//Identifier  = [a-zA-Z][a-zA-Z0-9_]*

%%

// recuerde yyline yycolumn yytext()

{Bloque} {f.contarComponente(Frecuencias.TipoComponente.BLOQUE);} 

// genericos
\r|\n|\r\n|\u2028|\u2029|\u000B|\u000C|\u0085 {}
<<EOF>>       {f.guardarTabla(); System.exit(0);}  
.         {}                                         