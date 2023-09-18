	package Test;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.TblAuto;

public class TestAuto {

	public static void main(String[] args) {
		//establecemos la conexion con la unidad de persistencia...
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("JPASabado");
		//gestionar entidades como registrar,actualizar,eliminar,etc....
		EntityManager emanager=conex.createEntityManager();
		//iniciamos la transaccion....
		emanager.getTransaction().begin();
		//realizamos una instancia...
		TblAuto auto=new TblAuto();
		//aplicamos un switch...
		String accion=JOptionPane.showInputDialog("Ingrese la Accion");
		switch(accion){
		case "Registrar":
			//ingresamos valores que van hacer registrados en la BD....
			auto.setModelo("yaris");
			auto.setColor("blanco");
			auto.setMotor("1.4");
			auto.setMarca("toyota");
			auto.setPrecio(13000);
			auto.setNroTarpro("778966");
			//sin JPA INSERT INTO TBL_AUTO VALUES.....
			emanager.persist(auto);
			//emitimos un mensaje por consola...
			System.out.println("Datos Registrados en BD");
			//confirmamos
			emanager.getTransaction().commit();
			//cerramos la transaccion...
			emanager.close();	
			//salimos
			break;
		case "Actualizar":
			auto.setIdauto(6);
			auto.setModelo("etios");
			auto.setColor("rojo");
			auto.setMotor("1.2");
			auto.setMarca("toyota");
			auto.setPrecio(13000);
			auto.setNroTarpro("5552222");
			//realizamo la actualizacion...
			//sin JPA update tbl_auto set modelo=?..........
			emanager.merge(auto);
			//imprimimos un mensaje por consola
			System.out.println("Dato actualizado correctamente");
			//confirmamos
			emanager.getTransaction().commit();
			//cerramos la transaccion
			emanager.close();		
			//salimos
			break;
		case "Eliminar":
			//codigo a eliminar...
			auto.setIdauto(6);
			TblAuto elim=emanager.merge(auto);
			//realizamos la eliminacion...
			//sin JPA delete from tbl_auto...
			emanager.remove(elim);
			//emitimos un mensaje por consola...
			System.out.println("dato eliminado correctamente");
			//confirmamos
			emanager.getTransaction().commit();
			//cerramos
			emanager.close();
			//salimos
			break;
		
		case "Buscar":
			//sin JPA select * from tbl_auto....
			TblAuto busc=emanager.find(TblAuto.class,5);
			//aplicamos una condicion...
			if(busc==null){
				//emitimos un mensaje en consola
				System.out.println("Registron no Encontrado");
			}else{
				//emitimos un mensaje por consola...
				System.out.println("Registro encontrado");
				//imprimimos los valores encontrados en la BD....
				System.out.println("CODIGO "+busc.getIdauto()+" modelo "+busc.getModelo()+
						" color "+busc.getColor()+" marca "+busc.getMarca()+
						" precio "+busc.getPrecio()+" nro de tarjeta"+busc.getNroTarpro());
			}    //fin del else....
			//confirmamos
			emanager.getTransaction().commit();
			emanager.close();
			//salimos
			break;
		
		case "Listar":
			//en sql seria select * from tbl_auto...
			//en JPA es select * from TblAuto....
			List<TblAuto> listado=emanager.createQuery("select a from TblAuto a",TblAuto.class).getResultList();
		//mostramos los datos por consola...
			for(TblAuto lis:listado){
				//imprimimos datos en consola...
				System.out.println("codigo "+lis.getIdauto()+" modelo "+
				lis.getModelo()+" color "+lis.getColor()+" motor "+lis.getMotor()+
				" marca "+lis.getMarca()+" precio "+lis.getPrecio()+" nro de tarjeta "+lis.getNroTarpro());
			}   //fin del bucle for...." 
			//confirmamos
			emanager.getTransaction().commit();
			//cerramos
			emanager.close();
			//salimos
			break;
		case "EliminarII":
			TblAuto elimII=emanager.find(TblAuto.class,5);
			//aplicamos una condicion
			if(elimII==null){
				//emitimos un mensaje en consola...
				System.out.println("el codigo  a ELIMINAR no existe");
			}else{
				//emitimos un mensaje por consola...
				System.out.println("registro encontrado");
				//eliminamos el respectivo registro...
				emanager.remove(elimII);
				System.out.println("Registro Eliminado de la BD!!!!!!!!!");
				//confirmamos
				emanager.getTransaction().commit();
				//cerramos
				emanager.close();
			}  //fin del else....
			//salimos
			break;
			
		}   //fin del switch...

	}   //fin del metodo principal...

}   //fin de la clase testauto
