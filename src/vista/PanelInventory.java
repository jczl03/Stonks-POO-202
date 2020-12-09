package vista;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import modelo.Conexion;

import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

public class PanelInventory extends JPanel {
	private JTextField txtNombre = new JTextField();
	private JTextField txtCantidad = new JTextField();
	private JTextField txtPrecioDeVenta = new JTextField();
	private JTextField txtPrecioDeVenta3 = new JTextField();
	
	private JTabbedPane panelInventory = new JTabbedPane();
	
	private JPanel panel_anadir = new JPanel();
	private JPanel panel_buscar = new JPanel();
	private JPanel panel_modificar = new JPanel();
	
	private JButton btnAnadir = new JButton("Añadir");
	private JButton btnBuscar = new JButton("Buscar");
	private JButton btnEliminar = new JButton("Modificar");
	
	private JLabel lblNombre = new JLabel("Nombre:");
	private JLabel lblCantidad = new JLabel("Cantidad:");
	private JLabel lblPrecioDeVenta = new JLabel("Precio de venta:");
	private JLabel lblNumeroDelProducto = new JLabel("Número del producto:");
	private JLabel lblCantidad_1 = new JLabel("Cantidad:");
	private JLabel lblDireccion_1 = new JLabel("Precio de venta:");
	private JLabel lblNombre2 = new JLabel("Nombre:");
	private JLabel lblNombre_1_1 = new JLabel("Nombre:");
	private JLabel lblDireccion_2_2 = new JLabel("Precio de venta:");
	private JLabel lblNumeroDelProducto2 = new JLabel("");
	private JLabel lblCantidad2 = new JLabel("");
	private JLabel lblPrecioDeVenta2 = new JLabel("");

	private JComboBox comboNombre2 = new JComboBox();
	private JComboBox comboNombre3 = new JComboBox();
	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public JTextField getTxtCantidad() {
		return txtCantidad;
	}

	public JTextField getTxtPrecioDeVenta() {
		return txtPrecioDeVenta;
	}

	public JLabel getLblPrecioDeVenta2() {
		return lblPrecioDeVenta2;
	}

	public JLabel getLblCantidad2() {
		return lblCantidad2;
	}

	public JLabel getLblNumeroDelProducto2() {
		return lblNumeroDelProducto2;
	}

	public JTextField getTxtPrecioDeVenta3() {
		return txtPrecioDeVenta3;
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
            return this.panelInventory.getSelectedIndex();
        }
        public void addChangeListener(ChangeListener cl){
            this.panelInventory.addChangeListener(cl);
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

	public PanelInventory() {
		setMaximumSize(new Dimension(450, 300));
		setSize(new Dimension(450, 300));
		setLayout(null);
		panelInventory.setPreferredSize(new Dimension(449, 300));
		panelInventory.setMaximumSize(new Dimension(450, 300));
		panelInventory.setBounds(0, 0, 450, 300);
		
		lblNombre.setForeground(Color.WHITE);
		lblCantidad.setForeground(Color.WHITE);
		lblPrecioDeVenta.setForeground(Color.WHITE);
		
		//panel anadir
		panel_anadir.setBackground(Color.DARK_GRAY);
		panelInventory.addTab("Añadir", panel_anadir);
		//ubicacion y tamano
		GroupLayout gl_panel_anadir = new GroupLayout(panel_anadir);
		gl_panel_anadir.setHorizontalGroup(
			gl_panel_anadir.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_anadir.createSequentialGroup()
					.addGroup(gl_panel_anadir.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_anadir.createSequentialGroup()
							.addGap(77)
							.addGroup(gl_panel_anadir.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_anadir.createSequentialGroup()
									.addComponent(lblPrecioDeVenta, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtPrecioDeVenta))
								.addGroup(gl_panel_anadir.createSequentialGroup()
									.addComponent(lblCantidad)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtCantidad))
								.addGroup(gl_panel_anadir.createSequentialGroup()
									.addComponent(lblNombre)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel_anadir.createSequentialGroup()
							.addGap(180)
							.addComponent(btnAnadir)))
					.addContainerGap(82, Short.MAX_VALUE))
		);
		gl_panel_anadir.setVerticalGroup(
			gl_panel_anadir.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_anadir.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_panel_anadir.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_anadir.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCantidad)
						.addComponent(txtCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_anadir.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrecioDeVenta)
						.addComponent(txtPrecioDeVenta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addComponent(btnAnadir)
					.addContainerGap(59, Short.MAX_VALUE))
		);
		panel_anadir.setLayout(gl_panel_anadir);
		lblDireccion_1.setForeground(Color.WHITE);
		lblCantidad_1.setForeground(Color.WHITE);
		lblNumeroDelProducto.setForeground(Color.WHITE);
		lblNombre2.setForeground(Color.WHITE);
		lblPrecioDeVenta2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPrecioDeVenta2.setForeground(Color.WHITE);
		lblCantidad2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCantidad2.setForeground(Color.WHITE);
		lblNumeroDelProducto2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNumeroDelProducto2.setForeground(Color.WHITE);
		
		//panel buscar
		panel_buscar.setBackground(Color.DARK_GRAY);
		panelInventory.addTab("Buscar", null, panel_buscar, null);
		
			GroupLayout gl_panel_buscar = new GroupLayout(panel_buscar);
			gl_panel_buscar.setHorizontalGroup(
				gl_panel_buscar.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_buscar.createSequentialGroup()
						.addGap(178)
						.addComponent(btnBuscar)
						.addContainerGap(202, Short.MAX_VALUE))
					.addGroup(gl_panel_buscar.createSequentialGroup()
						.addGap(83)
						.addGroup(gl_panel_buscar.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel_buscar.createSequentialGroup()
								.addComponent(lblNombre2)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(comboNombre2, 0, 212, Short.MAX_VALUE))
							.addGroup(gl_panel_buscar.createSequentialGroup()
								.addGroup(gl_panel_buscar.createParallelGroup(Alignment.LEADING)
									.addComponent(lblDireccion_1)
									.addComponent(lblCantidad_1)
									.addComponent(lblNumeroDelProducto, Alignment.TRAILING))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel_buscar.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNumeroDelProducto2, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
									.addGroup(Alignment.TRAILING, gl_panel_buscar.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblPrecioDeVenta2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblCantidad2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)))))
						.addGap(99))
			);
			gl_panel_buscar.setVerticalGroup(
				gl_panel_buscar.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_buscar.createSequentialGroup()
						.addGap(55)
						.addGroup(gl_panel_buscar.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNombre2)
							.addComponent(comboNombre2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel_buscar.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNumeroDelProducto)
							.addComponent(lblNumeroDelProducto2))
						.addGap(18)
						.addGroup(gl_panel_buscar.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblCantidad2)
							.addComponent(lblCantidad_1))
						.addGap(18)
						.addGroup(gl_panel_buscar.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblDireccion_1)
							.addComponent(lblPrecioDeVenta2))
						.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
						.addComponent(btnBuscar)
						.addGap(47))
			);
			panel_buscar.setLayout(gl_panel_buscar);
		lblDireccion_2_2.setBounds(72, 100, 121, 14);
		lblDireccion_2_2.setForeground(Color.WHITE);
		lblNombre_1_1.setBounds(72, 60, 60, 14);
		lblNombre_1_1.setForeground(Color.WHITE);
		
		//panel eliminar
		panel_modificar.setBackground(Color.DARK_GRAY);
		panelInventory.addTab("Modificar", null, panel_modificar, null);
				txtPrecioDeVenta3.setLocation(211, 100);
				txtPrecioDeVenta3.setSize(new Dimension(143, 19));
				txtPrecioDeVenta3.setForeground(Color.BLACK);
				panel_modificar.setLayout(null);
				btnEliminar.setBounds(161, 144, 104, 23);
				panel_modificar.add(btnEliminar);
				panel_modificar.add(lblNombre_1_1);
				comboNombre3.setBounds(150, 58, 204, 19);
				panel_modificar.add(comboNombre3);
				panel_modificar.add(lblDireccion_2_2);
				panel_modificar.add(txtPrecioDeVenta3);
		
		JPanel panel_tabla = new JPanel();
		panel_tabla.setBackground(Color.DARK_GRAY);
		panelInventory.addTab("Tabla", null, panel_tabla, null);
		panel_tabla.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 425, 250);
		panel_tabla.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Producto", "Cantidad", "Precio"
			}
		));
		scrollPane.setViewportView(table);
		add(panelInventory);
	}
	
	Conexion con = new Conexion();
	private JTable table;
	public void fillCombo(JComboBox combo){
		
		PreparedStatement ps ;
		ResultSet res ;
		Connection conex = con.getConexion();
		combo.removeAllItems();
		try {   
            String sql = "SELECT * FROM articulos";
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
