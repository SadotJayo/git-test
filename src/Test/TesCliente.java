package Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.TblCliente;

public class TesCliente {

	public static void main(String[] args) {
		//establecemos la conexion con la unidad de persistencia...
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("JPASabado");
		//gestionar entidades como registrar,actualizar,eliminar,etc....
		EntityManager emanager=conex.createEntityManager();
		//iniciamos la transaccion....
		emanager.getTransaction().begin();
		//realizamos una instancia...
        TblCliente cliente=new TblCliente();
        String accion=JOptionPane.showInputDialog("Ingrese Accion");
        switch(accion){
        
        
        }//fin del switch....

	}    //fin del metodo principal.....

}   //fin de la clase...
