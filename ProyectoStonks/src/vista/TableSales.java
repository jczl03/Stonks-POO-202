package vista;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableSales extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public TableSales() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 430, 278);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Cliente", "Articulo", "Unidades", "Precio", "Fecha"
			}
		));
		scrollPane.setViewportView(table);

	}
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

}
