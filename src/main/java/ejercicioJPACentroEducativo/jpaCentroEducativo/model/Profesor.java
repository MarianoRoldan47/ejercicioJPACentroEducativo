package ejercicioJPACentroEducativo.jpaCentroEducativo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "profesor")
public class Profesor extends Entidad{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int id;
	private String nombre; 
	private String apellido1;
	private String apellido2;
	private String dni;
	private String direccion;
	private String email;
	private String telefono;
	
	@OneToMany(mappedBy="idProfesor")
	private List<ValoracionMateria> notas;
	
	public Profesor() {
		super();
	}

	public Profesor(int id, String nombre, String apellido1, String apellido2, String dni, String direccion,
			String email, String telefono, int sexo, byte[] imagen, String colorPreferido) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
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

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
	@Override
	public String toString() {
		return nombre + " " + apellido1 + " " + apellido2;
	}

	
	
	
	
}
