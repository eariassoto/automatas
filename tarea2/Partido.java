import java.util.Vector;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Partido{

	public static void main(String[] args){
		try{
			// lee el archivo de entrada
			BufferedReader entrada = new BufferedReader(new FileReader(args[0]));

			// nueva instancia
			Partido p = new Partido(entrada);
		}catch(FileNotFoundException fnfe){
			
		}
	}

	// punteros a instancias de los equipos y uno extra que
	// va a apuntar al equipo que esta bateando
	private Equipo equipoVisita, equipoCasa, equipoActual;

	// vector que se va a poblar con 4 instancias de Base
	private Vector<Base> base;

	public Partido(BufferedReader entrada){

		// creo que lo equipos
		equipoVisita = new Equipo("equipo visitante");
		equipoCasa   = new Equipo("equipo local");
		
		// vista batea primero
		equipoActual = equipoVisita;
		
		// poblo bases
		base = new Vector<Base>();
		for(int i = 0; i < 4; i++)
			base.addElement(new Base());

		// imprimo el mensaje de primera entrada
		System.out.print(getMensajeEntrada());

		try{
			// mientras haya lineas, analicela
			String accion = entrada.readLine();
			while (accion != null) {
				analizarJugada(accion);
				accion = entrada.readLine();
			}

		}catch(IOException ioe){

		}
	}

	private String getMensajeEntrada(){
		return "Entrada #" + equipoActual.getEntrada() + ". Batea el " + equipoActual.getNombre() + ".\n";
	}

	private void sumarEntrada(){
		equipoVisita.nuevaEntrada();
		equipoCasa.nuevaEntrada();
	}

	private void nuevaEntrada(){
		equipoVisita.nuevaEntrada();
		equipoCasa.nuevaEntrada();
		if(equipoActual == equipoCasa)
			equipoActual = equipoVisita;
		else
			equipoActual = equipoCasa;
		System.out.print(getMensajeEntrada());
	}

	/* jugadas
	0 ponchado
	1 bola detenida
	2 outaptrapada
	3 outprimera
	4 sacrificio
	5 jugada doble
	*/
	private void jugadaOut(int opcion, char n, char m){
		
		// imprimo mensajes
		switch(opcion){
			case 0:
			System.out.print("Bateador del " + equipoActual.getNombre() + " ponchado.\n");
			break;
			case 1:
			System.out.print("Bola detenida por " + n + ", out producido por " + m + ".\n");
			break;
			case 2:
			System.out.print("Out por atrapada de " + n + ".\n");
			break;
			case 3:
			System.out.print("Out pero el jugador avanza a primera.\n");
			break;
			case 4:
			System.out.print("Sacrificio, los corredores avanzan una base.\n");
			break;
			case 5:
			System.out.print("Jugada doble.\n");
			break;
		}
		if(opcion < 5)
			equipoActual.sumarOuts(1);
		else
			equipoActual.sumarOuts(2); // codigo jugada doble

		if(equipoActual.hayTresOuts() && equipoActual == equipoVis){
  			nuevaEntrada();
  		}
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

	/* jugadas
	0 ponchado
	1 bola detenida
	2 outaptrapada
	3 outprimera
	4 sacrificio
	5 jugada doble
	*/
	private void analizarJugada(String j){
		Pattern p;
		Matcher m;

		// mother of nesting
		p = Pattern.compile("K");
		m = p.matcher(j);
		if(m.find()){
			jugadaOut(0, '0', '0');
		}else{
			p = Pattern.compile("[1-9][1-9]");
			m = p.matcher(j);
			if(m.find()){
				jugadaOut(1, j.charAt(0), j.charAt(1));
			}else{
				p = Pattern.compile("DP");
				m = p.matcher(j);
				if(m.find()){
					jugadaOut(5, '0', '0');
				}else{
					p = Pattern.compile("L[1-9]");
					m = p.matcher(j);
					if(m.find()){
						jugadaOut(2, j.charAt(1), '0');
					}else{
						p = Pattern.compile("FC");
						m = p.matcher(j);
						if(m.find()){
							jugadaOut(3, '0', '0');
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
															jugadaOut(4, '0', '0');
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

}
