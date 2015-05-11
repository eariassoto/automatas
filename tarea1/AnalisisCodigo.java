import java.io.File;
import java.nio.file.Files;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.lang.InterruptedException;
import java.lang.ProcessBuilder;
import java.util.HashSet;
import java.util.Set;

public class AnalisisCodigo{

	public AnalisisCodigo(){
		File[] archivos = filtrarArchivosExtension("ejemplos", ".java");

		// quito analisis anteriores
		eliminarArchivosEnFolder("tablas");

		// analisis de todos los .java
		analizarCodigos(archivos);

		// recuperar las tablas de resultados
		File[] archivosTablas = filtrarArchivosExtension("tablas", ".txt");
		String[] res = analizarResultados(archivosTablas);

		// con esto quito tuplas repetidas
		Set< Pair<String, String> > set = new HashSet< Pair<String, String> >(); 

		// busco coincidencias y las guardo en el set
		buscarResultadosIguales(archivosTablas, res, set);

		// imprimo resultados
		for(Pair<String, String> p : set){
			System.out.println("Los archivos " + p.getLeft() + " y " + p.getRight() + " podrian ser copiados.");
		}
	}
	
	public void analizarCodigos(File[] archivos){
		for(File f: archivos){
			try{
		    	ProcessBuilder pb = new ProcessBuilder("java", "AnalizadorL", "ejemplos/"+f.getName());
				Process pr = pb.start();
				pr.waitFor();  // espere a que termine el proceso de analisis

			}catch(IOException ioe){System.out.println(ioe.getMessage());}
			catch(InterruptedException ioe){System.out.println(ioe.getMessage());}

			reemplazarArchivo(new File("tablas/tabla.txt"), new File("tablas/"+f.getName()+".txt"));

			File tablaTemp = new File("tablas/tabla.txt");
			tablaTemp.delete();
		}
	}

	public String[] analizarResultados(File[] f){
		File[] archivosTablas = f;
		int l = archivosTablas.length;
		String[] resultados = new String[l];
		
		for(int i = 0; i<l; i++){
			try{
				InputStream fis = new FileInputStream(archivosTablas[i]);
			    InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
			    BufferedReader br = new BufferedReader(isr);
			    resultados[i] = br.readLine(); // yo se que esto se ve eew pero como yo hago los archivos lol don't care
			}catch(IOException ioe){

			}
		}
		return resultados;
	}

	public void reemplazarArchivo(File fuente, File dest){
		try{
			Files.copy(fuente.toPath(), dest.toPath());
		}catch(IOException ioe){}
	}

	public void eliminarArchivosEnFolder(String f){
		File file = new File(f);
		for(File i: file.listFiles()) i.delete();
	}

	public File[] filtrarArchivosExtension(String folder, final String e){
		File dir = new File(folder);
		File[] files = dir.listFiles(new FilenameFilter() {
		    public boolean accept(File dir, String name) {
		        return name.toLowerCase().endsWith(e);
		    }
		});
		return files;
	}

	public void buscarResultadosIguales(File[] archivosTablas, String[] res, Set<Pair<String, String>> set){
		int l = res.length;
		for(int j = 0; j<l; j++){
			for(int k = 0; k<l; k++){
				if(j != k){
					if(res[j].equals(res[k])){
						String n1 = archivosTablas[j].getName();
						String n2 = archivosTablas[k].getName();
						set.add(new Pair<String, String>(n1.substring(0, n1.length()-4), n2.substring(0, n2.length()-4	)));
					}
				}
			}
		}
	}

	public static void main(String args[]){
		new AnalisisCodigo();
	}

}