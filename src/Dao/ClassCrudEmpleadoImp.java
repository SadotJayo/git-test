package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.Iempleadoable;
import model.TblEmpleado;

public class ClassCrudEmpleadoImp implements Iempleadoable {

	@Override
	public void RegistrarEmpleado(TblEmpleado tblemp) {
		        //establecemos la conexion con la unidad de persistencia...
				EntityManagerFactory conex=Persistence.createEntityManagerFactory("JPASabado");
				//gestionar entidades como registrar,actualizar,eliminar,etc....
				 EntityManager emanager=conex.createEntityManager();
				//iniciamos la transaccion....
				 emanager.getTransaction().begin();
				 //insertamos en la base de datos
				 emanager.persist(tblemp);
				 //emitimo un mensaje por consola
				 System.out.println("Dato registrado en BD");
				 //comfirmamos´
				 emanager.getTransaction().commit();
				 //cerramos 
				 emanager.close();
		
	}   //fin del metodo registrar.....

	@Override
	public void ActualizarEmpleado(TblEmpleado tblemp) {
		        //establecemos la conexion con la unidad de persistencia...
				EntityManagerFactory conex=Persistence.createEntityManagerFactory("JPASabado");
				//gestionar entidades como registrar,actualizar,eliminar,etc....
				EntityManager emanager=conex.createEntityManager();
				//iniciamos la transaccion....
				emanager.getTransaction().begin();
				//actualizamos los registros...
				emanager.merge(tblemp);
				//emitimos un mensaje por consola
				System.out.println("Dato actulizado en la bd");
				//confirmamos
				emanager.getTransaction().commit();
				//cerramos
				emanager.close();
				
		
	}    //fin del metodo actualizar....

	@Override
	public void EliminarEmpleado(TblEmpleado tblemp) {
		//establecemos la conexion con la unidad de persistencia...
				EntityManagerFactory conex=Persistence.createEntityManagerFactory("JPASabado");
				//gestionar entidades como registrar,actualizar,eliminar,etc....
				EntityManager emanager=conex.createEntityManager();
				//iniciamos la transaccion....
				emanager.getTransaction().begin();	
				//recuperamos el codigo a eliminar..
				TblEmpleado elim=emanager.merge(tblemp);
				emanager.remove(elim);
				System.out.println("dato eliminado de la bd");
				//comfirmamos 
				emanager.getTransaction().commit();
				//cerramos
				emanager.close();
		
	}   //fin del metodo eliminar...

	@Override
	public List<TblEmpleado> ListadoEmpleado() {
		         //establecemos la conexion con la unidad de persistencia...
				EntityManagerFactory conex=Persistence.createEntityManagerFactory("JPASabado");
				//gestionar entidades como registrar,actualizar,eliminar,etc....
				EntityManager emanager=conex.createEntityManager();
				//iniciamos la transaccion....
				emanager.getTransaction().begin();
				
				List<TblEmpleado> listado=emanager.createQuery("select e from TblEmpleado e",TblEmpleado.class).getResultList();
		
				//comfirmamos
				emanager.getTransaction().commit();
				
				//cerramos
				emanager.close();
				
				return listado;
	}    //fin del metodo listar...

	@Override
	public TblEmpleado BuscarEmpleadoCodigo(TblEmpleado tblemp) {
		       //establecemos la conexion con la unidad de persistencia...
				EntityManagerFactory conex=Persistence.createEntityManagerFactory("JPASabado");
				//gestionar entidades como registrar,actualizar,eliminar,etc....
				EntityManager emanager=conex.createEntityManager();
				//iniciamos la transaccion....
				emanager.getTransaction().begin();			
				TblEmpleado buscar=emanager.find(TblEmpleado.class,tblemp.getIdempleado());		
				//confirmamos
				emanager.getTransaction().commit();
				//cerramos
				emanager.close();
			    return buscar;
	}    //fin del metodo buscar....

}   //fin de la clase...
