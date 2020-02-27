package STD;

public class Propietario {
	
	private int idPropietario;
	private String nombrePropietario;
	private int NIP;
	private String numTarjeta;
	private int fondoInicial;
	
	public int getIdPropietario() {
		return idPropietario;
	}
	public void setIdPropietario(int idPropietario) {
		this.idPropietario = idPropietario;
	}

	public String getNombrePropietario() {
		return nombrePropietario;
	}

	public void setNombrePropietario(String nombrePropietario) {
		this.nombrePropietario = nombrePropietario;
	}

	public int getNIP() {
		return NIP;
	}

	public void setNIP(int nIP) {
		NIP = nIP;
	}

	public String getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public int getFondoInicial() {
		return fondoInicial;
	}

	public void setFondoInicial(int fondoInicial) {
		this.fondoInicial = fondoInicial;
	}
	
	@Override
	public String toString() {
		return "UsuarioBanco{"+ "idPropietario= " + idPropietario + ", nombrePropietario" + nombrePropietario + ", numTarjeta= " + numTarjeta + ", nip= " + NIP + ", fondoInicial= " + fondoInicial + '}';
	}
	

}
