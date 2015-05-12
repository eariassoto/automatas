public class Base{

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