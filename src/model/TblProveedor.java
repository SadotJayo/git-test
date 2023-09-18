package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_proveedor database table.
 * 
 */
@Entity
@Table(name="tbl_proveedor")
@NamedQuery(name="TblProveedor.findAll", query="SELECT t FROM TblProveedor t")
public class TblProveedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idproveedor;

	private String descri;

	private String email;

	private String nombcomer;

	private String razonsoc;

	private String ruc;

	private String telef;

	public TblProveedor() {
	}

	public int getIdproveedor() {
		return this.idproveedor;
	}

	public void setIdproveedor(int idproveedor) {
		this.idproveedor = idproveedor;
	}

	public String getDescri() {
		return this.descri;
	}

	public void setDescri(String descri) {
		this.descri = descri;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombcomer() {
		return this.nombcomer;
	}

	public void setNombcomer(String nombcomer) {
		this.nombcomer = nombcomer;
	}

	public String getRazonsoc() {
		return this.razonsoc;
	}

	public void setRazonsoc(String razonsoc) {
		this.razonsoc = razonsoc;
	}

	public String getRuc() {
		return this.ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getTelef() {
		return this.telef;
	}

	public void setTelef(String telef) {
		this.telef = telef;
	}

}