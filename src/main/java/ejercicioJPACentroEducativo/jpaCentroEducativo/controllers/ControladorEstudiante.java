package ejercicioJPACentroEducativo.jpaCentroEducativo.controllers;


import ejercicioJPACentroEducativo.jpaCentroEducativo.model.Estudiante;

public class ControladorEstudiante extends SuperControlador{
	private static ControladorEstudiante instance = null;
	
	public ControladorEstudiante() {
		super("estudiante", Estudiante.class);
	}
	
	public static ControladorEstudiante getInstance() {
		if(instance==null) {
			instance = new ControladorEstudiante();
		}
		return instance;
	}
}
