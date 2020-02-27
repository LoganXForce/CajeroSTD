package STD;

public class RPro {
	public static void main(String [] args) {
	Registrar r = new Registrar();
	Propietario u = new Propietario();
	
	u.setIdPropietario(1);
	u.setNombrePropietario("Admin");
	u.setNumTarjeta("990511990511");
	u.setNIP(990511);
	u.setFondoInicial((int) 10000);
	
	r.insertaPT(u);
	System.out.println(u);

}
}
