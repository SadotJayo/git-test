package Interfaces;

import java.util.List;

import model.TblUsuario;

public interface Iusuarioable {
	//declaramos los respectivos metodos...
	public void RegistrarUsuario(TblUsuario tblusu);
	public void ActualizarUsuario(TblUsuario tblusu);
	public void EliminarUsuario(TblUsuario tblusu);
	public List<TblUsuario> ListadoUsuario();
	public TblUsuario BuscarUsuario(TblUsuario tblusu);
	public String ValidarUsuario(TblUsuario tblusu);
	
	
	

}   //fin de la interface....
