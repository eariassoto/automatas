import java.util.Vector;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Partido{
	
	private static final int VISITA = 0;
	private static final int CASA   = 1;
	private Equipo equipoVisita, equipoCasa, equipoActual;
	private Vector<Base> base;

	public Partido(BufferedReader entrada){
		equipoVisita = new Equipo("equipo visitante");
		equipoCasa   = new Equipo("equipo local");
		equipoActual = equipoVisita;
		
		base = new Vector<Base>();
		for(int i = 0; i < 4; i++)
			base.addElement(new Base());

		try{
			String accion = entrada.readLine();
			while (accion != null) {
				analizarJugada(accion);
				accion = entrada.readLine();
			}

		}catch(IOException ioe){}
	}

  	private void ponchado(){
  		equipoActual.sumarOuts(1);
  		System.out.print("Bateador del " + equipoActual.getNombre() + " ponchado.\n");
  	}

	private void bolaDetenida(char n, char m){
		equipoActual.sumarOuts(1);
		System.out.print("Bola detenida por " + n + ", out producido por " + m + ".\n");
	}

	private void jugadaDoble(){
		equipoActual.sumarOuts(2);
  		System.out.print("Jugada doble.\n");
	}

	private void outAtrapada(char n){
		equipoActual.sumarOuts(1);
		System.out.print("Out por atrapada de " + n + ".\n");
	}

	private void outPrimera(){
		equipoActual.sumarOuts(1);
		System.out.print("Out pero el jugador avanza a primera.\n");
	}

	private void primeraPorError(char n){
		System.out.print("Bateador llega a primera por error de " + n + ".\n");
	}

	private void jugadorGolpeado(){
		System.out.print("Bateador golpeado por bola, avanza a primera.\n");
	}

	private void basePorBola(){
		System.out.print("Base por bolas, el bateador avanza a primera.\n");
	}

	private void primeraBase(){
		System.out.print("Bateador avanza a primera base.\n");
	}

	private void segundaBase(){
		System.out.print("Bateador avanza a segunda base.\n");
	}

	private void terceraBase(){
		System.out.print("Bateador avanza a tercera base.\n");
	}

	private void cuartaBase(){
		System.out.print("Cuadrangular.\n");
	}

	private void sacrificio(){
		equipoActual.sumarOuts(1);
		System.out.print("Sacrificio, los corredores avanzan una base.\n");
		
	}

	private void analizarJugada(String j){
		Pattern p;
		Matcher m;

		// mother of nesting
		p = Pattern.compile("K");
		m = p.matcher(j);
		if(m.find()){
			ponchado();
		}else{
			p = Pattern.compile("[1-9][1-9]");
			m = p.matcher(j);
			if(m.find()){
				bolaDetenida(j.charAt(0), j.charAt(1));
			}else{
				p = Pattern.compile("DP");
				m = p.matcher(j);
				if(m.find()){
					jugadaDoble();
				}else{
					p = Pattern.compile("L[1-9]");
					m = p.matcher(j);
					if(m.find()){
						outAtrapada(j.charAt(1));
					}else{
						p = Pattern.compile("FC");
						m = p.matcher(j);
						if(m.find()){
							outPrimera();
						}else{
							p = Pattern.compile("E[1-9]");
							m = p.matcher(j);
							if(m.find()){
								primeraPorError(j.charAt(1));
							}else{
								p = Pattern.compile("HP");
								m = p.matcher(j);
								if(m.find()){
									jugadorGolpeado();
								}else{
									p = Pattern.compile("(BB)|(W)");
									m = p.matcher(j);
									if(m.find()){
										basePorBola();
									}else{
										p = Pattern.compile("1B");
										m = p.matcher(j);
										if(m.find()){
											primeraBase();
										}else{
											p = Pattern.compile("2B");
											m = p.matcher(j);
											if(m.find()){
												segundaBase();
											}else{
												p = Pattern.compile("3B");
												m = p.matcher(j);
												if(m.find()){
													terceraBase();
												}else{
													p = Pattern.compile("(4B)|(HR)");
													m = p.matcher(j);
													if(m.find()){
														cuartaBase();
													}else{
														p = Pattern.compile("SAC");
														m = p.matcher(j);
														if(m.find()){
															sacrificio();
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
  	}


	public static void main(String[] args){
		try{
			BufferedReader entrada = new BufferedReader(new FileReader(args[0]));
			Partido p = new Partido(entrada);
		}catch(FileNotFoundException fnfe){}
	}

}

class Equipo{

	private Vector<Integer> entradas;
	private int outs;
	private String nombre;

	public Equipo(String n){
		nombre = n;
		outs = 0;
	}
	
	void sumarOuts(int o){
		outs += o;
	}

	boolean hayTresOuts(){
		return outs > 2;
	}

	String getNombre(){
		return nombre;
	}

}

class Base{

	private boolean jugadorEnBase;
	public Base(){

	}
	
	public boolean hayJugador(){
		return jugadorEnBase;
	}
	public void ponerJugador(boolean b){
		jugadorEnBase = b;
	}

}
