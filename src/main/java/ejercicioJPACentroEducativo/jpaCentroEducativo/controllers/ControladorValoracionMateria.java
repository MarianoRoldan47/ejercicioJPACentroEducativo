package ejercicioJPACentroEducativo.jpaCentroEducativo.controllers;

import java.util.List;

import ejercicioJPACentroEducativo.jpaCentroEducativo.model.ValoracionMateria;

public class ControladorValoracionMateria extends SuperControlador{
private static ControladorValoracionMateria instance = null;
	
	public ControladorValoracionMateria() {
		super("valoracionmateria", ValoracionMateria.class);
	}
	
	public static ControladorValoracionMateria getInstance() {
		if(instance==null) {
			instance = new ControladorValoracionMateria();
		}
		return instance;
	}
	
	@SuppressWarnings("unchecked")
	public List<ValoracionMateria> findAllFromProfesorAndMateria(int idProfesor, int idMateria) {
		return (List<ValoracionMateria>) getEntityManager().createNativeQuery("SELECT * FROM valoracionmateria  where idProfesor=" + idProfesor +" and idMateria=" + idMateria + "", ValoracionMateria.class).getResultList();
	}
	
	
}
