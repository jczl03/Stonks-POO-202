package vista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import modelo.Conexion;

import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

public class PanelSupplier extends JPanel {
	private JTextField txtNombre = new JTextField();
	private JTextField txtNumeroDeProveedor3 = new JTextField();
	
	private JTabbedPane panelProveedor = new JTabbedPane();
	
	private JPanel panel_anadir = new JPanel();
	private JPanel panel_buscar = new JPanel();
	private JPanel panel_eliminar = new JPanel();
	private JPanel panel_tabla = new JPanel();
	
	private JButton btnAnadir = new JButton("Añadir");
	private JButton btnBuscar = new JButton("Buscar");
	private JButton btnEliminar = new JButton("Eliminar");
	
	private JLabel lblNombre = new JLabel("Nombre:");
	private JLabel lblNombre_1 = new JLabel("Nombre:");
	private JLabel lblNumeroDeProveedor_1 = new JLabel("Numero del proveedor:");
	private JLabel lblNombre_1_1 = new JLabel("Nombre:");
	private JLabel lblNumeroDeProveedor_1_1 = new JLabel("Numero de proveedor:");
	private JLabel lblNumeroDelProveedor2 = new JLabel();
	
	private JComboBox comboNombre2 = new JComboBox();
	private JComboBox comboNombre3 = new JComboBox();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable table = new JTable();
	
	public void cargarMatriz(Object matriz[][]){
        DefaultTableModel model =(DefaultTableModel)table.getModel();
        model.setRowCount(matriz.length);//Num filas
        model.setColumnCount(2);//Num columnas
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
            return this.panelProveedor.getSelectedIndex();
        }
        public void addChangeListener(ChangeListener cl){
            this.panelProveedor.addChangeListener(cl);
        }
	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public JLabel getLblNumeroDelProveedor2() {
		return lblNumeroDelProveedor2;
	}

	public JTextField getTxtNumeroDeProveedor3() {
		return txtNumeroDeProveedor3;
	}
	

	public JButton getBtnAnadir() {
		return btnAnadir;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public JComboBox getComboNombre2() {
		return comboNombre2;
	}
	
	public JComboBox getComboNombre3() {
		return comboNombre3;
	}

	public PanelSupplier() {
		setLayout(null);
		lblNombre.setForeground(Color.WHITE);
		lblNombre_1.setForeground(Color.WHITE);
		lblNumeroDeProveedor_1.setForeground(Color.WHITE);
		lblNumeroDeProveedor_1_1.setForeground(Color.WHITE);
		lblNombre_1_1.setForeground(Color.WHITE);
		lblNumeroDelProveedor2.setForeground(Color.WHITE);
	
        //panel anadir
		panel_anadir.setBackground(Color.DARK_GRAY);
		panelProveedor.setMaximumSize(new Dimension(450, 300));
		panelProveedor.setBounds(0, 5, 450, 296);
		panelProveedor.addTab("Añadir",panel_anadir);
		GroupLayout gl_panel_anadir = new GroupLayout(panel_anadir);
		gl_panel_anadir.setHorizontalGroup(
			gl_panel_anadir.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_anadir.createSequentialGroup()
					.addContainerGap(85, Short.MAX_VALUE)
					.addGroup(gl_panel_anadir.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_anadir.createSequentialGroup()
							.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
							.addGap(78))
						.addGroup(gl_panel_anadir.createSequentialGroup()
							.addComponent(btnAnadir, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addGap(181))))
		);
		gl_panel_anadir.setVerticalGroup(
			gl_panel_anadir.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_anadir.createSequentialGroup()
					.addGap(72)
					.addGroup(gl_panel_anadir.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_anadir.createSequentialGroup()
							.addGap(2)
							.addComponent(lblNombre))
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(67)
					.addComponent(btnAnadir)
					.addContainerGap(86, Short.MAX_VALUE))
		);
		panel_anadir.setLayout(gl_panel_anadir);
		
		//panel buscar
		panel_buscar.setBackground(Color.DARK_GRAY);
		panelProveedor.addTab("Buscar",panel_buscar);
		GroupLayout gl_panel_buscar = new GroupLayout(panel_buscar);
		gl_panel_buscar.setHorizontalGroup(
			gl_panel_buscar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_buscar.createSequentialGroup()
					.addGap(98)
					.addGroup(gl_panel_buscar.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_buscar.createSequentialGroup()
							.addComponent(lblNombre_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboNombre2, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_buscar.createSequentialGroup()
							.addGroup(gl_panel_buscar.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNumeroDeProveedor_1, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNumeroDelProveedor2)))
					.addContainerGap(87, Short.MAX_VALUE))
		);
		gl_panel_buscar.setVerticalGroup(
			gl_panel_buscar.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_buscar.createSequentialGroup()
					.addContainerGap(63, Short.MAX_VALUE)
					.addGroup(gl_panel_buscar.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre_1)
						.addComponent(comboNombre2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addGroup(gl_panel_buscar.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumeroDeProveedor_1)
						.addComponent(lblNumeroDelProveedor2))
					.addGap(33)
					.addComponent(btnBuscar)
					.addGap(72))
		);
		panel_buscar.setLayout(gl_panel_buscar);
		
		//panel eliminar
		panel_eliminar.setBackground(Color.DARK_GRAY);
		panelProveedor.addTab("Eliminar", panel_eliminar);
		GroupLayout gl_panel_eliminar = new GroupLayout(panel_eliminar);
		gl_panel_eliminar.setHorizontalGroup(
			gl_panel_eliminar.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_eliminar.createSequentialGroup()
					.addGap(164)
					.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(168, Short.MAX_VALUE))
				.addGroup(gl_panel_eliminar.createSequentialGroup()
					.addContainerGap(81, Short.MAX_VALUE)
					.addGroup(gl_panel_eliminar.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_eliminar.createSequentialGroup()
							.addComponent(lblNombre_1_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboNombre3, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_eliminar.createSequentialGroup()
							.addComponent(lblNumeroDeProveedor_1_1, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtNumeroDeProveedor3, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)))
					.addGap(78))
		);
		gl_panel_eliminar.setVerticalGroup(
			gl_panel_eliminar.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_eliminar.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_panel_eliminar.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre_1_1)
						.addComponent(comboNombre3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_panel_eliminar.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_eliminar.createSequentialGroup()
							.addGap(2)
							.addComponent(lblNumeroDeProveedor_1_1))
						.addComponent(txtNumeroDeProveedor3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
					.addComponent(btnEliminar)
					.addGap(68))
		);
		panel_eliminar.setLayout(gl_panel_eliminar);
		
		//panel tabla
		panel_tabla.setBackground(Color.DARK_GRAY);
		panelProveedor.addTab("Tabla",panel_tabla);
		panel_tabla.setLayout(null);
		scrollPane.setBounds(10, 11, 425, 246);
		panel_tabla.add(scrollPane);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Unidades Compradas"
			}
		));
		
		scrollPane.setViewportView(table);
		
		add(panelProveedor);
	}
	
	public void fillCombo(JComboBox combo){
		Conexion con = new Conexion();
		PreparedStatement ps ;
		ResultSet res ;
		Connection conex = con.getConexion();
		combo.removeAllItems();
		try {   
            String sql = "SELECT * FROM proveedores";
            ps = conex.prepareStatement(sql);
            res = ps.executeQuery();
            
            while(res.next()) {
            	combo.addItem(res.getString("nombre"));
            }
            res.close();
        } 
        catch (SQLException e) {
            System.err.println(e.toString());
        }
    }
}
