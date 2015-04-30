import java.io.File;
import java.nio.file.Files;
import java.io.FilenameFilter;
import java.io.IOException;
import java.security.Permission;

// este codigo lo tome de http://www.avanderw.co.za/preventing-calls-to-system-exit-in-java/
// lo uso para cortar los llamados a exit() en el Analizador léxico
// no me atribuyo autoría del mismo
class SystemExitControl {
    public static class ExitTrappedException extends SecurityException {
    }
    public static void forbidSystemExitCall() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }
    public static void enableSystemExitCall() {
        System.setSecurityManager(null);
    }
}
// fin codigo ajeno

public class AnalisisCodigo{
	
	public static void reemplazarArchivo(File fuente, File dest){
		try{
			Files.copy(fuente.toPath(), dest.toPath());
		}catch(IOException ioe){}
	}

	public static void ejecutarAnalisisSeguro(String[] args){
		SystemExitControl.forbidSystemExitCall();
		try {
			AnalizadorL.main(args);
		} catch (SystemExitControl.ExitTrappedException e) {}
		SystemExitControl.enableSystemExitCall();
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

		eliminarArchivosEnFolder("tablas");

		// analisis de todos los .java
		for(File f: archivos){
			String[] arg = {"ejemplos/"+f.getName()};
			ejecutarAnalisisSeguro(arg);
			reemplazarArchivo(new File("tablas/tabla.txt"), new File("tablas/"+f.getName()+".txt"));
		}

		File tablaTemp = new File("tablas/tabla.txt");
		tablaTemp.delete();
	}

}