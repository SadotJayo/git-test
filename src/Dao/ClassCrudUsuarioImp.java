package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Interfaces.Iusuarioable;
import model.TblUsuario;

public class ClassCrudUsuarioImp implements Iusuarioable{

	@Override
	public void RegistrarUsuario(TblUsuario tblusu) {
		// TODO Auto-generated method stub
		
	}   //fin del metodo registrar...

	@Override
	public void ActualizarUsuario(TblUsuario tblusu) {
		// TODO Auto-generated method stub
		
	}   //fin del metodo actualizar...

	@Override
	public void EliminarUsuario(TblUsuario tblusu) {
		// TODO Auto-generated method stub
		
	}   //fin del metodo eliminar usuario...

	@Override
	public List<TblUsuario> ListadoUsuario() {
		// TODO Auto-generated method stub
		return null;
	}   //fin del metodo listado usuario...

	@Override
	public TblUsuario BuscarUsuario(TblUsuario tblusu) {
		//establecer conexion con la unidad de persistencia....
		
		
		return null;
	}    //fin del metodo buscar usuario...

	@Override
	public String ValidarUsuario(TblUsuario tblusu) {
		//establecemos la conexion con la unidad de persistencia...
				EntityManagerFactory conex=Persistence.createEntityManagerFactory("JPASabado");
				//gestionar entidades como registrar,actualizar,eliminar,etc....
				EntityManager emanager=conex.createEntityManager();
				//iniciamos la transaccion....
				emanager.getTransaction().begin();
				
				//aplicamos el JPQL relacionado con entidades...
				Query consulta=emanager.createQuery("select u from TblUsuario u"
						+ " where u.usuario=:x and password=:y",TblUsuario.class);
				//pasamos los pararametros...
				consulta.setParameter("x",tblusu.getUsuario());
				consulta.setParameter("y",tblusu.getPassword());
				String mensaje="";
				TblUsuario u;
				try{
					u=(TblUsuario) consulta.getSingleResult();
					mensaje="existe";
				}catch(Exception ex){
					u=null;
					mensaje="noexiste";
					
				}
		
		return mensaje;
	}    //fin del metodo validar...

}
