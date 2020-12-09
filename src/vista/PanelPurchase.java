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
import javax.swing.JScrollPane;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

public class PanelPurchase extends JPanel {

	private JTextField txtCantidad = new JTextField();
	private JTextField txtPrecioDeCompra = new JTextField();
	
	private JTabbedPane panelPurchase = new JTabbedPane();
	
	private JPanel panel_anadir = new JPanel();
	private JPanel panel_tabla = new JPanel();
	
	private JButton btnAnadir = new JButton("Añadir");
	
	private JLabel lblNombre = new JLabel("Producto:");
	private JLabel lblCantidad = new JLabel("Cantidad:");
	private JLabel lblProveedor = new JLabel("Proveedor:");
	private JLabel lblPreciodeCompra = new JLabel("Precio de compra:");
	
	
	private JComboBox comboProducto = new JComboBox();
	private JComboBox comboProveedor = new JComboBox();
	private JTable table;
	
        
        public void cargarMatriz(String matriz[][]){
        DefaultTableModel model =(DefaultTableModel)table.getModel();
        model.setRowCount(matriz.length);//Num filas
        model.setColumnCount(5);//Num columnas
        int matrizlength=matriz.length;
        for(int i=0;i<matrizlength;i++){
            for(int j=0;j<matriz[i].length;j++){
                table.setValueAt(matriz[matrizlength-1-i][j], i, j);
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
            return this.panelPurchase.getSelectedIndex();
        }
        public void addChangeListener(ChangeListener cl){
            this.panelPurchase.addChangeListener(cl);
        }
	public JTextField getTxtCantidad() {
		return txtCantidad;
	}

	public JTextField getTxtPrecioDeCompra() {
		return txtPrecioDeCompra;
	}

	public JButton getBtnAnadir() {
		return btnAnadir;
	}

	public JComboBox getComboProducto() {
		return comboProducto;
	}


	public JComboBox getComboProveedor() {
		return comboProveedor;
	}


	public PanelPurchase() {
		setMinimumSize(new Dimension(450, 300));
		setMaximumSize(new Dimension(450, 300));
		setPreferredSize(new Dimension(450, 300));
		setLayout(null);
		panelPurchase.setBounds(0, 0, 449, 300);
		panelPurchase.setForeground(Color.DARK_GRAY);
		lblNombre.setForeground(Color.WHITE);
		lblCantidad.setForeground(Color.WHITE);
		lblProveedor.setForeground(Color.WHITE);
		lblPreciodeCompra.setForeground(Color.WHITE);
		
		//panel anadir
		panel_anadir.setBackground(Color.DARK_GRAY);
		panelPurchase.addTab("Añadir",panel_anadir);
        //posicion y tamano
		GroupLayout gl_panel_anadir = new GroupLayout(panel_anadir);
		gl_panel_anadir.setHorizontalGroup(
			gl_panel_anadir.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_anadir.createSequentialGroup()
					.addGap(67)
					.addGroup(gl_panel_anadir.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_anadir.createSequentialGroup()
							.addComponent(lblPreciodeCompra)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtPrecioDeCompra, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
						.addGroup(gl_panel_anadir.createSequentialGroup()
							.addComponent(lblCantidad)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtCantidad, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
						.addGroup(gl_panel_anadir.createSequentialGroup()
							.addComponent(lblProveedor)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboProveedor, 0, 218, Short.MAX_VALUE))
						.addGroup(gl_panel_anadir.createSequentialGroup()
							.addComponent(lblNombre)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboProducto, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)))
					.addGap(60))
				.addGroup(gl_panel_anadir.createSequentialGroup()
					.addGap(176)
					.addComponent(btnAnadir)
					.addContainerGap(185, Short.MAX_VALUE))
		);
		gl_panel_anadir.setVerticalGroup(
			gl_panel_anadir.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_anadir.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panel_anadir.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(comboProducto, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_anadir.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProveedor)
						.addComponent(comboProveedor, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_anadir.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCantidad)
						.addComponent(txtCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_anadir.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPreciodeCompra)
						.addComponent(txtPrecioDeCompra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addComponent(btnAnadir)
					.addContainerGap(44, Short.MAX_VALUE))
		);
		panel_anadir.setLayout(gl_panel_anadir);
		
		//panel tabla
		panel_tabla.setBackground(Color.DARK_GRAY);
		panelPurchase.addTab("Tabla",panel_tabla);
		panel_tabla.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 424, 250);
		panel_tabla.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Proveedor", "Producto", "Unidades", "Costo", "Fecha"
			}
		));
		scrollPane.setViewportView(table);
		add(panelPurchase);
	}
	
	public void fillCombo(JComboBox combo, String table, String column){
		Conexion con = new Conexion();
		PreparedStatement ps ;
		ResultSet res ;
		Connection conex = con.getConexion();
		combo.removeAllItems();
		try {   
            String sql = "SELECT * FROM "+table;
            ps = conex.prepareStatement(sql);
            res = ps.executeQuery();
            
            while(res.next()) {
            	combo.addItem(res.getString(column));
            }
            res.close();
        } 
        
        catch (SQLException e) {
            System.err.println(e.toString());
        }
               
    }
    public void updateComboBox(JComboBox combo, String table,String column){
            combo.removeAllItems();
            fillCombo(combo,table,column);
    }
}
