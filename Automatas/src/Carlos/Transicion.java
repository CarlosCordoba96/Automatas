package Carlos;

public class Transicion {
	private Estado desde;
	private Estado hasta;
	private String transicion;
	public Transicion(Estado desde,Estado hasta, String transicion){
		this.desde=desde;
		this.hasta=hasta;
		this.transicion=transicion;
		
	}

	public void setDesde(Estado desde) {
		this.desde = desde;
	}

	public void setHasta(Estado hasta) {
		this.hasta = hasta;
	}
	@Override
	public String toString() {

		return "t "+desde.getEstado()+ "->" + hasta.getEstado() + "(" + transicion + ")";

	}

	public String hashName(){
		return desde.getEstado()+hasta.getEstado()+transicion;
	}

	
	public Estado getDesde() {
		return desde;
	}
	
	public Estado getHasta() {
		return hasta;
	}


}
