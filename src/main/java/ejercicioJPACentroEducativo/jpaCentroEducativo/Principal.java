package ejercicioJPACentroEducativo.jpaCentroEducativo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import ejercicioJPACentroEducativo.jpaCentroEducativo.controllers.ControladorEstudiante;
import ejercicioJPACentroEducativo.jpaCentroEducativo.controllers.ControladorMateria;
import ejercicioJPACentroEducativo.jpaCentroEducativo.controllers.ControladorProfesor;
import ejercicioJPACentroEducativo.jpaCentroEducativo.controllers.ControladorValoracionMateria;
import ejercicioJPACentroEducativo.jpaCentroEducativo.model.Estudiante;
import ejercicioJPACentroEducativo.jpaCentroEducativo.model.Materia;
import ejercicioJPACentroEducativo.jpaCentroEducativo.model.Profesor;
import ejercicioJPACentroEducativo.jpaCentroEducativo.model.ValoracionMateria;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<Materia> jcbMateria;
	private JComboBox<Profesor> jcbProfesor;
	private JComboBox<Integer> jcbNota;
	private JList<Estudiante> jlistSeleccionados;
	private DefaultListModel<Estudiante> listaEstudiantesSeleccionados;

	private int indiceProximalistaEstudiantesSeleccionados = 0;

	private JList<Estudiante> jlistNoSeleccionados;
	private DefaultListModel<Estudiante> listaEstudiantesNoSeleccionados;

	private int indiceProximalistaEstudiantesNoSeleccionados = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 466, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel = new JLabel("Materia:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		jcbMateria = new JComboBox<Materia>();
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.gridwidth = 3;
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 5);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 0;
		panel.add(jcbMateria, gbc_jcbMateria);

		JLabel lblNewLabel_1 = new JLabel("Profesor:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		jcbProfesor = new JComboBox<Profesor>();
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.gridwidth = 3;
		gbc_jcbProfesor.insets = new Insets(0, 0, 5, 5);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 1;
		panel.add(jcbProfesor, gbc_jcbProfesor);

		JLabel lblNewLabel_2 = new JLabel("Nota:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		jcbNota = new JComboBox<Integer>();
		GridBagConstraints gbc_jcbNota = new GridBagConstraints();
		gbc_jcbNota.gridwidth = 3;
		gbc_jcbNota.insets = new Insets(0, 0, 5, 5);
		gbc_jcbNota.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbNota.gridx = 1;
		gbc_jcbNota.gridy = 2;
		panel.add(jcbNota, gbc_jcbNota);

		JButton jbtnActualizarAlumnado = new JButton("Botón actualizar alumnado");
		jbtnActualizarAlumnado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarAlumnos();
			}
		});
		GridBagConstraints gbc_jbtnActualizarAlumnado = new GridBagConstraints();
		gbc_jbtnActualizarAlumnado.gridx = 3;
		gbc_jbtnActualizarAlumnado.gridy = 3;
		panel.add(jbtnActualizarAlumnado, gbc_jbtnActualizarAlumnado);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
//		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//		gbl_panel_1.rowHeights = new int[]{0, 0};
//		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
//		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);

		JButton jbtnGuardarNotasAlumnos = new JButton("Guardar las notas de todos los alumnos seleccionados");
		jbtnGuardarNotasAlumnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarAlumnos();
			}
		});
		GridBagConstraints gbc_jbtnGuardarNotasAlumnos = new GridBagConstraints();
		gbc_jbtnGuardarNotasAlumnos.gridx = 14;
		gbc_jbtnGuardarNotasAlumnos.gridy = 0;
		panel_1.add(jbtnGuardarNotasAlumnos, gbc_jbtnGuardarNotasAlumnos);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 270, 153, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JLabel lblNewLabel_3 = new JLabel("Alumnado no seleccionado:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel_2.add(lblNewLabel_3, gbc_lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Alumnado seleccionado:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 0;
		panel_2.add(lblNewLabel_4, gbc_lblNewLabel_4);

		// La JList debe ir dentro de un ScrollPane, y se construye con el modelo de
		// JList sobre el que despu�s
		// se agregaron o eliminaron provincias.
		jlistNoSeleccionados = new JList<Estudiante>(this.getDefaultListModelNoSeleccionados());
		// Tipos de selección disponibles en JList
		// this.jlistProvincias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// this.jlistProvincias.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		this.jlistNoSeleccionados.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // Valor por defecto

		GridBagConstraints gbc_jlistNoSeleccionados = new GridBagConstraints();
		gbc_jlistNoSeleccionados.insets = new Insets(0, 0, 0, 5);
		gbc_jlistNoSeleccionados.fill = GridBagConstraints.BOTH;
		gbc_jlistNoSeleccionados.gridx = 0;
		gbc_jlistNoSeleccionados.gridy = 1;
		panel_2.add(jlistNoSeleccionados, gbc_jlistNoSeleccionados);

		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 0, 5);
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 1;
		panel_2.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
//		gbl_panel_3.columnWidths = new int[]{0, 0, 78, 0, 0, 0};
//		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
//		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
//		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);

		JButton btnNewButton_1 = new JButton("<<");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarTodosAlumnosDeSeleccionadoANoSeleccionados();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 0;
		panel_3.add(btnNewButton_1, gbc_btnNewButton_1);

		JButton btnNewButton_2 = new JButton("<");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarAlumnoDeSeleccionadoANoSeleccionado();
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 1;
		panel_3.add(btnNewButton_2, gbc_btnNewButton_2);

		JButton btnNewButton_3 = new JButton(">");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarAlumnoDeNoSeleccionadoASeleccionado();
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 2;
		panel_3.add(btnNewButton_3, gbc_btnNewButton_3);

		JButton btnNewButton_4 = new JButton(">>");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarTodosAlumnosDeNoSeleccionadoASeleccionados();
			}
		});
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 0;
		gbc_btnNewButton_4.gridy = 3;
		panel_3.add(btnNewButton_4, gbc_btnNewButton_4);

		// La JList debe ir dentro de un ScrollPane, y se construye con el modelo de
		// JList sobre el que despu�s
		// se agregaron o eliminaron provincias.
		jlistSeleccionados = new JList<Estudiante>(this.getDefaultListModelSeleccionados());
		// Tipos de selección disponibles en JList
		// this.jlistProvincias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// this.jlistProvincias.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		this.jlistSeleccionados.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // Valor por defecto
		GridBagConstraints gbc_jlistSeleccionados = new GridBagConstraints();
		gbc_jlistSeleccionados.fill = GridBagConstraints.BOTH;
		gbc_jlistSeleccionados.gridx = 2;
		gbc_jlistSeleccionados.gridy = 1;
		panel_2.add(jlistSeleccionados, gbc_jlistSeleccionados);

//		Cargar JComboBoxs
		cargarMaterias();
		cargarProfesores();
		cargarNotas();
	}

	@SuppressWarnings("unchecked")
	private void cargarMaterias() {
		List<Materia> listaMateria = (List<Materia>) ControladorMateria.getInstance().findAll();

		for (Materia ma : listaMateria) {
			jcbMateria.addItem(ma);
		}

	}

	@SuppressWarnings("unchecked")
	private void cargarProfesores() {
		List<Profesor> listaProfesores = (List<Profesor>) ControladorProfesor.getInstance().findAll();

		for (Profesor ma : listaProfesores) {
			jcbProfesor.addItem(ma);
		}

	}

	private void cargarNotas() {

		for (int i = 1; i <= 10; i++) {
			jcbNota.addItem(i);
		}

	}

	private void cargarAlumnos() {

		this.indiceProximalistaEstudiantesSeleccionados = 0;
		this.indiceProximalistaEstudiantesNoSeleccionados = 0;
		listaEstudiantesSeleccionados.removeAllElements();
		listaEstudiantesNoSeleccionados.removeAllElements();
		@SuppressWarnings("unchecked")
		List<Estudiante> alumnos = (List<Estudiante>) ControladorEstudiante.getInstance()
				.findAll();
		
		for (Estudiante estudiante : alumnos) {
			listaEstudiantesNoSeleccionados.add(indiceProximalistaEstudiantesNoSeleccionados, estudiante);
			indiceProximalistaEstudiantesNoSeleccionados++;
		}
		
		List<ValoracionMateria> lista = (List<ValoracionMateria>) ControladorValoracionMateria.getInstance()
				.findAllFromProfesorAndMateria(((Profesor) jcbProfesor.getSelectedItem()).getId(),
						((Materia) jcbMateria.getSelectedItem()).getId());
		for (ValoracionMateria e : lista) {
			if (e.getValoracion() == Float.parseFloat(jcbNota.getSelectedItem().toString())) {
				listaEstudiantesSeleccionados.add(indiceProximalistaEstudiantesSeleccionados, e.getIdEstudiante());
				for (Estudiante estudiante : alumnos) {
					if(e.getIdEstudiante().getId() == estudiante.getId()) {
						listaEstudiantesNoSeleccionados.removeElement(estudiante);
					}
				}
				indiceProximalistaEstudiantesSeleccionados++;
				indiceProximalistaEstudiantesNoSeleccionados--;
			}
			
		}

	}
	
	private void guardarAlumnos() {
		for (int i = 0; i<= listaEstudiantesSeleccionados.size() - 1; i++) {
			ValoracionMateria vm = new ValoracionMateria();
			
			vm.setIdEstudiante((Estudiante) listaEstudiantesSeleccionados.elementAt(i));
			vm.setIdMateria(((Materia)jcbMateria.getSelectedItem()).getId());
			vm.setIdProfesor((Profesor)jcbProfesor.getSelectedItem());
			vm.setValoracion(Float.parseFloat(jcbNota.getSelectedItem().toString()));
			if(existenAlumnos((Estudiante) listaEstudiantesSeleccionados.elementAt(i)) != 0 ) {
				vm.setId(existenAlumnos((Estudiante) listaEstudiantesSeleccionados.elementAt(i)));
				ControladorEstudiante.getInstance().actualizacion(vm);
			}
			else {
				vm.setId(0);
				ControladorEstudiante.getInstance().insercion(vm);
			}
		}
	}
	
	private int existenAlumnos(Estudiante estudiante) {
		List<ValoracionMateria> lista = (List<ValoracionMateria>) ControladorValoracionMateria.getInstance()
				.findAllFromProfesorAndMateria(((Profesor) jcbProfesor.getSelectedItem()).getId(),
						((Materia) jcbMateria.getSelectedItem()).getId());
		for (ValoracionMateria e : lista) {
			if(e.getIdEstudiante().getId() == estudiante.getId()) {
				return e.getId();
			}
			
		}
		
		return 0;
	}

	@SuppressWarnings("rawtypes")
	private DefaultListModel getDefaultListModelSeleccionados() {
		this.listaEstudiantesSeleccionados = new DefaultListModel<Estudiante>();
		return this.listaEstudiantesSeleccionados;
	}

	@SuppressWarnings("rawtypes")
	private DefaultListModel getDefaultListModelNoSeleccionados() {
		this.listaEstudiantesNoSeleccionados = new DefaultListModel<Estudiante>();
		return this.listaEstudiantesNoSeleccionados;
	}

	private void pasarAlumnoDeNoSeleccionadoASeleccionado() {

		for (int i = this.jlistNoSeleccionados.getSelectedValues().length - 1; i >= 0; i--) {
			this.listaEstudiantesSeleccionados.add(indiceProximalistaEstudiantesSeleccionados,
					(Estudiante) this.jlistNoSeleccionados.getSelectedValues()[i]);
			indiceProximalistaEstudiantesSeleccionados++;
			this.listaEstudiantesNoSeleccionados.removeElementAt(this.jlistNoSeleccionados.getSelectedIndices()[i]);
			indiceProximalistaEstudiantesNoSeleccionados--;
		}
	}

	private void pasarTodosAlumnosDeNoSeleccionadoASeleccionados() {
		for (int i = listaEstudiantesNoSeleccionados.getSize() - 1; i >= 0; i--) {
			listaEstudiantesSeleccionados.add(indiceProximalistaEstudiantesSeleccionados,
					listaEstudiantesNoSeleccionados.elementAt(i));
			indiceProximalistaEstudiantesSeleccionados++;
		}
		listaEstudiantesNoSeleccionados.removeAllElements();
		indiceProximalistaEstudiantesNoSeleccionados = 0;
		
	}
	
	private void pasarTodosAlumnosDeSeleccionadoANoSeleccionados() {
		for (int i = listaEstudiantesSeleccionados.getSize() - 1; i >= 0; i--) {
			listaEstudiantesNoSeleccionados.add(indiceProximalistaEstudiantesNoSeleccionados,
					listaEstudiantesSeleccionados.elementAt(i));
			indiceProximalistaEstudiantesNoSeleccionados++;
		}
		listaEstudiantesSeleccionados.removeAllElements();
		indiceProximalistaEstudiantesSeleccionados = 0;
		
	}

	private void pasarAlumnoDeSeleccionadoANoSeleccionado() {
		for (int i = this.jlistSeleccionados.getSelectedValues().length - 1; i >= 0; i--) {
			this.listaEstudiantesNoSeleccionados.add(indiceProximalistaEstudiantesNoSeleccionados,
					(Estudiante) this.jlistSeleccionados.getSelectedValues()[i]);
			indiceProximalistaEstudiantesNoSeleccionados++;
			this.listaEstudiantesSeleccionados.removeElementAt(this.jlistSeleccionados.getSelectedIndices()[i]);
			indiceProximalistaEstudiantesSeleccionados--;
		}
	}

}
