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

	
	public String toString() {
		return "Estado [estado=" + estado + ", inicial=" + inicial + ", end=" + end + "]";
	}

}
