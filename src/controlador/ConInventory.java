package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;

import modelo.ConsultInventory;
import modelo.Inventory;
import vista.PanelInventory;

public class ConInventory implements ActionListener{
	
	private Inventory inventory;
	private ConsultInventory query;
	private PanelInventory frame;
	
	
	//constructor
	public ConInventory(Inventory inventory, ConsultInventory query, PanelInventory frame) {
		
		this.inventory = inventory;
		this.query = query;
		this.frame = frame;
		this.frame.getBtnBuscar().addActionListener(this);
		this.frame.getBtnAnadir().addActionListener(this);
		this.frame.getBtnEliminar().addActionListener(this);
                
		fillCombos();
                llenarTabla();
                this.frame.addChangeListener(ce->actualizarTabla(ce));
		
	}
        public void llenarTabla(){
            frame.cargarMatriz(query.getTableAsMatriz());
        }
        public void actualizarTabla(ChangeEvent ce){
            int selected=frame.getSelectedIndex();
            if(selected==3){
                frame.LimpiarFilas();
                llenarTabla();
            }
            
        }
	//method for initializing the view (title and location)
	
	//methods that listen to the clicks (events)
	public void actionPerformed(ActionEvent e){
		//Adding button
		if(e.getSource() == frame.getBtnAnadir()){
			inventory.setNombre(frame.getTxtNombre().getText());
			inventory.setCantidad(Integer.parseInt(frame.getTxtCantidad().getText()));
			inventory.setPrecio(Float.parseFloat(frame.getTxtPrecioDeVenta().getText()));
			if(query.register(inventory)){
				JOptionPane.showMessageDialog(null, "Nuevo artículo guardado");
				clean();
				fillCombos();
			}else {
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error. Debe anadir nombre y cantidad.");

			}
		}
		
		//Search button
		if(e.getSource() == frame.getBtnBuscar()){
			inventory.setNombre((String) frame.getComboNombre2().getSelectedItem());
			if(query.search(inventory)){
				frame.getLblNumeroDelProducto2().setText(String.valueOf(inventory.getIdproducto()));
				frame.getLblCantidad2().setText(String.valueOf(inventory.getCantidad()));	
				frame.getLblPrecioDeVenta2().setText(String.valueOf(inventory.getPrecio()));	
			}else {
				clean();
				JOptionPane.showMessageDialog(null, "Artículo no registrado");
			}
		}
		
		//Delete button
		//Modify button
		if(e.getSource() == frame.getBtnEliminar()){
			inventory.setNombre((String) frame.getComboNombre3().getSelectedItem());
			inventory.setPrecio(Float.parseFloat(frame.getTxtPrecioDeVenta3().getText()));
			if(query.update(inventory)){
				fillCombos();
				clean();
				JOptionPane.showMessageDialog(null, "Artículo modificado");
			}else {
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
			}
		}
	}
	
	//method for cleaning the boxes
	public void clean(){
		frame.getTxtNombre().setText(null);
		frame.getTxtCantidad().setText(null);
		frame.getTxtPrecioDeVenta().setText(null);
		frame.getLblNumeroDelProducto2().setText(null);
		frame.getLblCantidad2().setText(null);
		frame.getLblPrecioDeVenta2().setText(null);
		frame.getTxtPrecioDeVenta3().setText(null);	
	}
	public void fillCombos() {
		frame.fillCombo(frame.getComboNombre2());
		frame.fillCombo(frame.getComboNombre3());
		
	}
	
}
