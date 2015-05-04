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

public class AnalisisCodigo{
	
	public static void reemplazarArchivo(File fuente, File dest){
		try{
			Files.copy(fuente.toPath(), dest.toPath());
		}catch(IOException ioe){}
	}

	public static void eliminarArchivosEnFolder(String f){
		File file = new File(f);
		for(File i: file.listFiles()) i.delete();
	}

	public static File[] filtrarArchivosExtension(String folder, String ext){
		File dir = new File(folder);
		File[] files = dir.listFiles(new FilenameFilter() {
		    public boolean accept(File dir, String name) {
		        return name.toLowerCase().endsWith(ext);
		    }
		});
		return files;
	}

	public static void main(String args[]){

		File[] archivos = filtrarArchivosExtension("ejemplos", ".java");

		// quito análisis anteriores
		eliminarArchivosEnFolder("tablas");

		// analisis de todos los .java
		for(File f: archivos){
			try{
				String[] arg = {"java AnalizadorL ejemplos/"+f.getName()};
		    	ProcessBuilder pb = new ProcessBuilder("java", "AnalizadorL", "ejemplos/"+f.getName());
				Process pr = pb.start();
				pr.waitFor();  // espere a que termine el análisis

			}catch(IOException ioe){System.out.println(ioe.getMessage());}
			catch(InterruptedException ioe){System.out.println(ioe.getMessage());}

			reemplazarArchivo(new File("tablas/tabla.txt"), new File("tablas/"+f.getName()+".txt"));
		}

		File tablaTemp = new File("tablas/tabla.txt");
		tablaTemp.delete();

		File[] archivosTablas = filtrarArchivosExtension("tablas", ".txt");
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

		for(int j = 0; j<l; j++){
			for(int k = 0; k<l; k++){
				if(j != k){
					if(resultados[j].equals(resultados[k])){
						System.out.println("El archivo " + archivosTablas[j].getName() + " y el archivo " + archivosTablas[k].getName() + "podrian ser copias.");
					}
				}
			}
		}


	}

}