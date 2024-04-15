package ejercicioJPACentroEducativo.jpaCentroEducativo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "materia")
public class Materia extends Entidad{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombre;
	private String acronimo;
	
	public Materia() {
		super();
	}

	public Materia(int id, String nombre, String acronimo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.acronimo = acronimo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAcronimo() {
		return acronimo;
	}

	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}

	@Override
	public String toString() {
		return nombre;
	}
	
	
	
}
