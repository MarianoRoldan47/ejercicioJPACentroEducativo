package ejercicioJPACentroEducativo.jpaCentroEducativo.controllers;

import ejercicioJPACentroEducativo.jpaCentroEducativo.model.Profesor;

public class ControladorProfesor extends SuperControlador{

private static ControladorProfesor instance = null;
	
	public ControladorProfesor() {
		super("profesor", Profesor.class);
	}
	
	public static ControladorProfesor getInstance() {
		if(instance==null) {
			instance = new ControladorProfesor();
		}
		return instance;
	}
}
