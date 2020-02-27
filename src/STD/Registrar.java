package STD;

import java.util.ArrayList;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Registrar {
	private ObjectContainer db=null;
	private void openRegistro() {
		db=Db4oEmbedded.openFile("UsuariosST");
		
	}
	private void closeRegistro() {
		db.close();
	}
	
	public void insertaPT(Propietario u) {
		openRegistro();
		db.store(u);
		closeRegistro();	
	}
	
	public List<Propietario> selectPts(){
		openRegistro();
		ObjectSet listaPT=db.queryByExample(Propietario.class);
		List<Propietario> lp = new ArrayList<>();
		for (Object listaPT1:listaPT) {
			lp.add((Propietario)listaPT1);
		}
		closeRegistro();
		return lp;
	}
	
	public Propietario selectPt(Propietario u) {
		openRegistro();
		ObjectSet result=db.queryByExample(u);
		Propietario propietario=(Propietario) result.next();
		closeRegistro();
		return propietario;
	}
	public void updateRegistro(int id, String nomb, int fondIni, String numTarjeta, int Nip) {
		
		openRegistro();
		Propietario u = new Propietario();
		u.setNumTarjeta(numTarjeta);
		ObjectSet result=db.queryByExample(u);
		Propietario preresult=(Propietario) result.next();
		preresult.setIdPropietario(id);
		preresult.setNombrePropietario(nomb);
		preresult.setNIP(Nip);
		preresult.setFondoInicial(fondIni);
		db.store(preresult);
		closeRegistro();
	}
	public void updateFondos(String numTarjeta, int fondoIni) {
		openRegistro();
		Propietario u = new Propietario();
		u.setNumTarjeta(numTarjeta);
		ObjectSet result = db.queryByExample(u);
		Propietario preresult = (Propietario) result.next();
		preresult.setFondoInicial(fondoIni);
		db.store(preresult);
		closeRegistro();
	}
	
	public void deleteRegistro(int id) {
		openRegistro();
		Propietario u = new Propietario();
		u.setIdPropietario(id);
		ObjectSet result=db.queryByExample(u);
		Propietario preresult=(Propietario) result.next();
		db.delete(preresult);
		closeRegistro();
	}
}
