package Carlos;

public class Transicion {
	private String desde;
	private String hasta;
	private String transicion;
	public Transicion(String desde,String hasta, String transicion){
		this.desde=desde;
		this.hasta=hasta;
		this.transicion=transicion;
	}
	@Override
	public String toString() {
		return desde + "->" + hasta + "(" + transicion + ")";
	}

}
