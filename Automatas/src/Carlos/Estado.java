package Carlos;

public class Estado {
	private String estado;
	private boolean inicial;
	private boolean end;

	public Estado(String estado,boolean inicial,boolean end){
		this.estado=estado;
		this.inicial=inicial;
		this.end=end;
	}

	
	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public boolean isInicial() {
		return inicial;
	}


	public void setInicial(boolean inicial) {
		this.inicial = inicial;
	}


	public boolean isEnd() {
		return end;
	}


	public void setEnd(boolean end) {
		this.end = end;
	}
    

	public String toString() {
		return "n "+estado+" "+inicial+" "+end;

	}

}
