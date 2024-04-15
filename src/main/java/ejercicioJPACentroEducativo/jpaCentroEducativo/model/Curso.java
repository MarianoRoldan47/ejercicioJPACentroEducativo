package ejercicioJPACentroEducativo.jpaCentroEducativo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "curso")
public class Curso  extends Entidad{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String descripcion;
	
	public Curso() {
		super();
	}

	public Curso(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
