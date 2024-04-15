package ejercicioJPACentroEducativo.jpaCentroEducativo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="valoracionmateria")
public class ValoracionMateria extends Entidad{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name="idProfesor")
	private Profesor idProfesor;
	@ManyToOne
	@JoinColumn(name="idEstudiante")
	private Estudiante idEstudiante;
	private int idMateria;
	private float valoracion;
	
	public ValoracionMateria() {
		super();
	}

	public ValoracionMateria(int id, Profesor idProfesor, Estudiante idEstudiante, int idMateria, float valoracion) {
		super();
		this.id = id;
		this.idProfesor = idProfesor;
		this.idEstudiante = idEstudiante;
		this.idMateria = idMateria;
		this.valoracion = valoracion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Profesor getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(Profesor idProfesor) {
		this.idProfesor = idProfesor;
	}

	public Estudiante getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(Estudiante idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public int getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}

	public float getValoracion() {
		return valoracion;
	}

	public void setValoracion(float valoracion) {
		this.valoracion = valoracion;
	}
	
	
}
