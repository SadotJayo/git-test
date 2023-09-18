package Test;

import java.util.Date;
import java.util.List;

import Dao.ClassCrudEmpleadoImp;
import model.TblEmpleado;

public class TestEmpleado {

	public static void main(String[] args) {
		//instanciar la entidad........
		TblEmpleado tblemp=new TblEmpleado();
		ClassCrudEmpleadoImp crud=new ClassCrudEmpleadoImp();
	//**************************registrar ***********
		//agregamos datos nuevos para el empleado....
		/*tblemp.setNombre("alberto juan");
		tblemp.setApellido("sanche perez");
		tblemp.setSexo("m");
		tblemp.setEmail("alberto@hotmail.com");
		//convertimos  a fecha sql..
		Date fecha=new Date();
		Date fechasql=new Date(fecha.getTime());
		tblemp.setFechanac(fechasql);
		tblemp.setTel("3814789");
		tblemp.setDni("10347895");
		//invocamos el metodo registrar...
		crud.RegistrarEmpleado(tblemp);
		*/
		//********************actualizar ************************
	/*	tblemp.setIdempleado(1);
		tblemp.setNombre("carmen rosa");
		tblemp.setApellido("perez perez");
		tblemp.setSexo("f");
		tblemp.setEmail("carmen@gmail.com");
		Date fecha=new Date();
		Date fechasql=new Date(fecha.getTime());
		tblemp.setFechanac(fechasql);
		tblemp.setTel("3814752");
		tblemp.setDni("45678963");
		//invocamos el metodo actualizar..
		crud.ActualizarEmpleado(tblemp);*/
		
		//************************eliminar  ***************
		/*tblemp.setIdempleado(3);
		
		//invocamos el metodo eliminar..
		crud.EliminarEmpleado(tblemp);*/
		
		
		//****************listado de empleados **************
	/*	
		List<TblEmpleado> listar=crud.ListadoEmpleado();
		
		//aplicamos un bucle...
		
		for(TblEmpleado lis:listar){
			
			//imprimimos por pantalla
			System.out.println("codigo "+lis.getIdempleado()+" nombre "+lis.getNombre()
			+" apellido "+lis.getApellido()+" sexo "+lis.getSexo()+
			" email "+lis.getEmail()+" fechana "+lis.getFechanac()+
			" telef "+lis.getTel()+" dni "+lis.getDni());
		}*/
		//**********************buscar empleado por codigo...
		tblemp.setIdempleado(1);
		//invocamos al metodo buscar por codigo
		TblEmpleado empbusc=crud.BuscarEmpleadoCodigo(tblemp);
		
		//imprimimos el empleado buscado....
		System.out.println("codigo "+empbusc.getIdempleado()+" nombre "+
		empbusc.getNombre()+" apellido "+empbusc.getSexo()+" email "+empbusc.getEmail()+
		" fechana "+empbusc.getFechanac()+" telefon "+empbusc.getTel()+" dni "+empbusc.getDni());
        
	}  //fin del main....

}   //fin de la clase....
