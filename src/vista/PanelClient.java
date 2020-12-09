package vista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;

import modelo.Conexion;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

public class PanelClient extends JPanel{
	private JTextField txtNombre = new JTextField();
	private JTextField txtAt = new JTextField();
	private JTextField txtDireccion = new JTextField();
	private JTextField txtDireccion3 = new JTextField();
	private JTextField txtAt3 = new JTextField();
	private JLabel txtDireccion4 = new JLabel();
	private JLabel txtAt4 = new JLabel();
	private JLabel txtNumeroDeCliente4 = new JLabel();
	
	private JButton btnAnadir = new JButton("Añadir");
	private JButton btnModificar = new JButton("Modificar");
	private JButton btnEliminar = new JButton("Eliminar");
	private JButton btnBuscar = new JButton("Buscar");
	
	private JComboBox comboNombre = new JComboBox();
	private JComboBox comboNombre2 = new JComboBox();
	private JComboBox comboNombre3 = new JComboBox();
	
	private JLabel lblNombre = new JLabel("Nombre:");
	private JLabel lblId = new JLabel("Id del Cliente:");
	private JLabel lblAt = new JLabel("@:");
	private JLabel lblDireccion = new JLabel("Direccion:");
	private JLabel lblNombre2 = new JLabel("Nombre:");
	private JLabel lblId2 = new JLabel("Id del Cliente:");
	private JLabel lblAt_2 = new JLabel("@:");
	private JLabel lblDireccion_2 = new JLabel("Direccion:");
	private JLabel lblNombre3 = new JLabel("Nombre:");
	private JLabel lblAt3 = new JLabel("@:");
	private JLabel lblDireccion3 = new JLabel("Direccion:");
	private JLabel lblNombre4 = new JLabel("Nombre:");
	private JLabel lblId4 = new JLabel("Id del Cliente:");
	private JLabel lblAt4 = new JLabel("@:");
	private JLabel lblDireccion4 = new JLabel("Direccion:");
	
	private JLabel lblAt2 = new JLabel();
	private JLabel lblNumeroDeCliente2 = new JLabel();
	private JLabel lblDireccion2 = new JLabel();
	
	private JPanel panel_anadir = new JPanel();
	private JPanel panel_buscar = new JPanel();
	private JPanel panel_modificar = new JPanel();
	private JPanel panel_eliminar = new JPanel();
	private JPanel panel_tabla = new JPanel();
	
	private JTabbedPane panelCliente = new JTabbedPane();
	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public JTextField getTxtAt() {
		return txtAt;
	}

	public JTextField getTxtDireccion() {
		return txtDireccion;
	}

	public JLabel getLblDireccion2() {
		return lblDireccion2;
	}

	public JLabel getLblAt2() {
		return lblAt2;
	}

	public JLabel getLblNumeroDeCliente2() {
		return lblNumeroDeCliente2; 
	}

	public JTextField getTxtDireccion3() {
		return txtDireccion3;
	}

	public JTextField getTxtAt3() {
		return txtAt3;
	}

	public JLabel getTxtDireccion4() {
		return txtDireccion4;
	}

	public JLabel getTxtAt4() {
		return txtAt4;
	}

	public JLabel getTxtNumeroDeCliente4() {
		return txtNumeroDeCliente4;
	}

	public JButton getBtnAnadir() {
		return btnAnadir;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JComboBox getComboNombre() {
		return comboNombre;
	}

	public JComboBox getComboNombre2() {
		return comboNombre2;
	}

	public JComboBox getComboNombre3() {
		return comboNombre3;
	}
        public void cargarMatriz(Object matriz[][]){
        DefaultTableModel model =(DefaultTableModel)table.getModel();
        model.setRowCount(matriz.length);//Num filas
        model.setColumnCount(3);//Num columnas
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[i].length;j++){
                table.setValueAt(matriz[i][j], i, j);
            }
        }
        }
        public void LimpiarFilas() {//Se pasa el modelo a limpiar, ej: (DefaultTableModel)tablaClientes.getModel()
            DefaultTableModel model=(DefaultTableModel)this.table.getModel();
            for(int i=model.getRowCount()-1;i>=0;i--) {
                model.removeRow(i);
            }
        }
        public int getSelectedIndex(){
            return this.panelCliente.getSelectedIndex();
        }
        public void addChangeListener(ChangeListener cl){
            this.panelCliente.addChangeListener(cl);
        }

	public PanelClient() {
		setMaximumSize(new Dimension(450, 300));
		setPreferredSize(new Dimension(450, 300));
		lblNombre.setBounds(70, 61, 83, 14);
		lblNombre.setForeground(Color.WHITE);
		lblAt.setBounds(70, 99, 83, 14);
		lblAt.setForeground(Color.WHITE);
		lblDireccion.setBounds(70, 137, 83, 14);
		lblDireccion.setForeground(Color.WHITE);
		lblId.setForeground(Color.WHITE);
		setLayout(null);
		lblNombre2.setForeground(Color.WHITE);
		lblAt_2.setForeground(Color.WHITE);
		lblDireccion_2.setForeground(Color.WHITE);
		lblId2.setForeground(Color.WHITE);
		lblNombre3.setForeground(Color.WHITE);
		lblAt3.setForeground(Color.WHITE);
		lblDireccion3.setForeground(Color.WHITE);
		lblNombre4.setForeground(Color.WHITE);
		lblAt4.setForeground(Color.WHITE);
		lblDireccion4.setForeground(Color.WHITE);
		lblId4.setForeground(Color.WHITE);
		lblAt2.setForeground(Color.WHITE);
		lblNumeroDeCliente2.setForeground(Color.WHITE);
		lblDireccion2.setForeground(Color.WHITE);
		panelCliente.setBounds(0, 0, 449, 300);
		
		//panel anadir
		panelCliente.add("Añadir",panel_anadir);
		panel_anadir.setBackground(Color.DARK_GRAY);
		panel_anadir.setLayout(null);
		panel_anadir.add(lblAt);
		txtAt.setBounds(163, 99, 211, 20);
		panel_anadir.add(txtAt);
		panel_anadir.add(lblDireccion);
		txtDireccion.setBounds(163, 137, 211, 20);
		panel_anadir.add(txtDireccion);
		panel_anadir.add(lblNombre);
		txtNombre.setBounds(163, 61, 211, 20);
		panel_anadir.add(txtNombre);
		btnAnadir.setBounds(173, 190, 88, 23);
		panel_anadir.add(btnAnadir);
		
		//panel buscar
		panelCliente.add("Buscar",panel_buscar);
		panel_buscar.setBackground(Color.DARK_GRAY);
		//ubicacion y tamano
		GroupLayout gl_panel_buscar = new GroupLayout(panel_buscar);
		gl_panel_buscar.setHorizontalGroup(
			gl_panel_buscar.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_buscar.createSequentialGroup()
					.addGap(79)
					.addGroup(gl_panel_buscar.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_buscar.createSequentialGroup()
							.addComponent(lblNombre2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboNombre, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_buscar.createSequentialGroup()
							.addComponent(lblAt_2)
							.addPreferredGap(ComponentPlacement.RELATED, 268, Short.MAX_VALUE)
							.addComponent(lblAt2))
						.addGroup(gl_panel_buscar.createSequentialGroup()
							.addComponent(lblId2)
							.addPreferredGap(ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
							.addComponent(lblNumeroDeCliente2))
						.addGroup(gl_panel_buscar.createSequentialGroup()
							.addComponent(lblDireccion_2)
							.addPreferredGap(ComponentPlacement.RELATED, 235, Short.MAX_VALUE)
							.addComponent(lblDireccion2)))
					.addGap(76))
				.addGroup(Alignment.LEADING, gl_panel_buscar.createSequentialGroup()
					.addGap(187)
					.addComponent(btnBuscar)
					.addContainerGap(193, Short.MAX_VALUE))
		);
		gl_panel_buscar.setVerticalGroup(
			gl_panel_buscar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_buscar.createSequentialGroup()
					.addGap(43)
					.addGroup(gl_panel_buscar.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre2)
						.addComponent(comboNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_buscar.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAt_2)
						.addComponent(lblAt2))
					.addGap(18)
					.addGroup(gl_panel_buscar.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId2)
						.addComponent(lblNumeroDeCliente2))
					.addGap(18)
					.addGroup(gl_panel_buscar.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDireccion_2)
						.addComponent(lblDireccion2))
					.addGap(29)
					.addComponent(btnBuscar)
					.addContainerGap(59, Short.MAX_VALUE))
		);
		panel_buscar.setLayout(gl_panel_buscar);
		
		//panel modificar
		panelCliente.add("Modificar",panel_modificar);
		panel_modificar.setBackground(Color.DARK_GRAY);
		//ubicacion y tamano
		GroupLayout gl_panel_modificar = new GroupLayout(panel_modificar);
		gl_panel_modificar.setHorizontalGroup(
			gl_panel_modificar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_modificar.createSequentialGroup()
					.addGap(88)
					.addGroup(gl_panel_modificar.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_modificar.createSequentialGroup()
							.addComponent(lblDireccion3)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtDireccion3, 202, 202, 202))
						.addGroup(gl_panel_modificar.createSequentialGroup()
							.addGroup(gl_panel_modificar.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNombre3)
								.addComponent(lblAt3))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_modificar.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtAt3)
								.addComponent(comboNombre2, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(103, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_modificar.createSequentialGroup()
					.addContainerGap(187, Short.MAX_VALUE)
					.addComponent(btnModificar)
					.addGap(183))
		);
		gl_panel_modificar.setVerticalGroup(
			gl_panel_modificar.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_modificar.createSequentialGroup()
					.addContainerGap(68, Short.MAX_VALUE)
					.addGroup(gl_panel_modificar.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre3)
						.addComponent(comboNombre2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_modificar.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAt3)
						.addComponent(txtAt3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_modificar.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDireccion3)
						.addComponent(txtDireccion3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addComponent(btnModificar)
					.addGap(47))
		);
		panel_modificar.setLayout(gl_panel_modificar);
		
		//panel eliminar
		panelCliente.add("Eliminar",panel_eliminar);
		panel_eliminar.setBackground(Color.DARK_GRAY);
		//ubicacion y tamano
		GroupLayout gl_panel_eliminar = new GroupLayout(panel_eliminar);
		gl_panel_eliminar.setHorizontalGroup(
			gl_panel_eliminar.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_eliminar.createSequentialGroup()
					.addGap(93)
					.addGroup(gl_panel_eliminar.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_eliminar.createSequentialGroup()
							.addComponent(lblNombre4)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboNombre3, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel_eliminar.createSequentialGroup()
							.addGroup(gl_panel_eliminar.createParallelGroup(Alignment.LEADING)
								.addComponent(lblId4)
								.addComponent(lblAt4)
								.addComponent(lblDireccion4))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_eliminar.createParallelGroup(Alignment.LEADING)
								.addComponent(txtDireccion4, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
								.addComponent(txtNumeroDeCliente4, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
								.addComponent(txtAt4, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
							.addGap(85))))
				.addGroup(gl_panel_eliminar.createSequentialGroup()
					.addContainerGap(188, Short.MAX_VALUE)
					.addComponent(btnEliminar)
					.addGap(180))
		);
		gl_panel_eliminar.setVerticalGroup(
			gl_panel_eliminar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_eliminar.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panel_eliminar.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre4)
						.addComponent(comboNombre3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_eliminar.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAt4)
						.addComponent(txtAt4))
					.addGap(18)
					.addGroup(gl_panel_eliminar.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId4)
						.addComponent(txtNumeroDeCliente4))
					.addGap(18)
					.addGroup(gl_panel_eliminar.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDireccion4)
						.addComponent(txtDireccion4))
					.addGap(29)
					.addComponent(btnEliminar)
					.addContainerGap(47, Short.MAX_VALUE))
		);
		txtNumeroDeCliente4.setForeground(Color.WHITE);
		txtNumeroDeCliente4.setHorizontalAlignment(SwingConstants.TRAILING);
		txtAt4.setForeground(Color.WHITE);
		txtDireccion4.setHorizontalAlignment(SwingConstants.TRAILING);
		txtDireccion4.setForeground(Color.WHITE);
		txtAt4.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_eliminar.setLayout(gl_panel_eliminar);
		
		//panel tabla
		panelCliente.add("Tabla",panel_tabla);
		panel_tabla.setBackground(Color.DARK_GRAY);
		panel_tabla.setLayout(null);
		scrollPane.setBounds(10, 11, 424, 250);
		
		panel_tabla.add(scrollPane);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "@", "Direcci\u00F3n"
			}
		));
		
		scrollPane.setViewportView(table);
		
		add(panelCliente);	
	}
	
	Conexion con = new Conexion();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable table = new JTable();
	public void validateTable(){
            this.panel_tabla.revalidate();
        }
	
	public void fillCombo(JComboBox combo){
		PreparedStatement ps ;
		ResultSet res ;
		Connection conex = con.getConexion();
		combo.removeAllItems(); //vacia la combobox por si tiene algo
		try {   
            String sql = "SELECT * FROM clientes";
            ps = conex.prepareStatement(sql);
            res = ps.executeQuery();
            
            while(res.next()) {
            	combo.addItem(res.getString("nombre")); //la vuelva a llenar con cada registro en la columna nombre
            }
            res.close();
        } 
        catch (SQLException e) {
            System.err.println(e.toString());
        }
    }

}
