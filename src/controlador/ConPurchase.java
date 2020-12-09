package controlador;

import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;

import modelo.ConsultPurchase;
import modelo.Purchase;
import vista.PanelPurchase;

public class ConPurchase implements ActionListener{
	
	private Purchase purchase;
	private ConsultPurchase query;
	private PanelPurchase panel;
        
	//constructor
	public ConPurchase(Purchase purchase, ConsultPurchase query, PanelPurchase panel) {
		
		this.purchase = purchase;
		this.query = query;
		this.panel = panel;
		this.panel.getBtnAnadir().addActionListener(this);
		fillCombos();
                llenarTabla();
                panel.addChangeListener(e->actualizarTabla(e));
		
	}
        public void actualizarCombos(){
            panel.updateComboBox(panel.getComboProducto(),"articulos","nombre");
            panel.updateComboBox(panel.getComboProveedor(),"proveedores","nombre");
        }
        public void llenarTabla(){
            System.out.print("Se debió llenar\n");
            panel.cargarMatriz(query.getTableAsMatriz());
        }
        public void actualizarTabla(ChangeEvent ce){
            int selected=panel.getSelectedIndex();
            if(selected==1){
                panel.LimpiarFilas();
                llenarTabla();
            }
            
        }
	//method for initializing the view (title and location)
	//methods that listen to the clicks (events)
	public void actionPerformed(ActionEvent e){
		//Adding button
                
		if(e.getSource() == panel.getBtnAnadir()){
			try{
                            int idprod = query.getId("articulos","idarticulos",((String) panel.getComboProducto().getSelectedItem()));
                            int idprov = query.getId("proveedores","idproveedores",((String) panel.getComboProveedor().getSelectedItem()));
                            int cantidad = Integer.parseInt(panel.getTxtCantidad().getText().trim());

                            purchase.setIdproducto(idprod);
                            purchase.setProveedor(idprov);
                            purchase.setCantidad(cantidad);
                            purchase.setCostoIndividual(Integer.parseInt(panel.getTxtPrecioDeCompra().getText().trim()));
                            if(purchase.getCantidad()<0 || purchase.getCostoIndividual()<0){
                                throw new NumberFormatException();
                            }
                            clean();
                            if(query.register(purchase)){
                                    clean();
                                    JOptionPane.showMessageDialog(null, "Compra guardado");
                            }else {
                                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error. or favor intente nuevamente.");
                                    clean();
                            }
                        }catch(NumberFormatException exc){
                            JOptionPane.showMessageDialog(null, "Ha ocurrido un error. Debe ingresar una cantidad y precio de compra válido.");
                            clean();
                        }
			
		}
	}
	
	//method for cleaning the boxes
	public void clean(){
		panel.getTxtCantidad().setText(null);
		panel.getTxtPrecioDeCompra().setText(null);
	}
	
	public void fillCombos() {
			panel.fillCombo(panel.getComboProducto(),"articulos","nombre");
			panel.fillCombo(panel.getComboProveedor(),"proveedores","nombre");
	}
	
}
