package vista;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.Image;
import java.awt.Font;

public class FramePrincipal extends JFrame {

	private JPanel contentPane;
	private JButton btnVenta;
	private JButton btnCompra;
	private JButton btnClientes;
	private JButton btnProveedores;
	private JButton btnInventario;
	private JButton btnGraficas;
	private Container panel;
	private ImageIcon baner;

	public FramePrincipal() {
		setResizable(false);
                setIconImage(new ImageIcon(getClass().getResource("/vista/imagenes/icono.png")).getImage());
                setTitle("STONKS");
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 837, 508);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		ImageIcon prebaner=new ImageIcon((getClass().getResource("/vista/imagenes/Stonksbanner.png")));
		Image banerImage=prebaner.getImage();
                Image image2=banerImage.getScaledInstance(600,100,Image.SCALE_SMOOTH);
                baner=new ImageIcon(image2);
		btnVenta = new JButton("Venta");
		btnVenta.setBounds(63, 168, 217, 23);
		panel = new JPanel();
		panel.setBounds(348, 139, 450, 300);
		panel.setBackground(Color.DARK_GRAY);
		panel.setPreferredSize(new Dimension(450,300));
		btnCompra = new JButton("Compra");
		btnCompra.setBounds(63, 209, 217, 23);
		btnClientes = new JButton("Clientes");
		btnClientes.setBounds(63, 291, 217, 23);
		btnProveedores = new JButton("Proveedores");
		btnProveedores.setBounds(63, 250, 217, 23);
		btnInventario = new JButton("Inventario");
		btnInventario.setBounds(63, 332, 217, 23);
		btnGraficas = new JButton("Gráficas");
		btnGraficas.setBounds(63, 373, 217, 23);
		contentPane.setLayout(null);
		contentPane.add(btnGraficas);
		contentPane.add(btnCompra);
		contentPane.add(btnVenta);
		contentPane.add(btnProveedores);
		contentPane.add(btnClientes);
		contentPane.add(btnInventario);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(baner);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(118, 16, 600, 100);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Stonks 2020\u00AE|POO 2020-2|Created by Juliana Parra Caro,Andr\u00E9s Felipe Ni\u00F1o Tr\u00E9bol,Javier Esteban Pacativa Galindo,Juan Camilo Zambrano L\u00F3pez");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(130, 450, 624, 18);
		contentPane.add(lblNewLabel);
	}
	
	public void cambiarPanel(JTabbedPane oldPanel, JTabbedPane newPanel) {
		panel.remove(oldPanel);
		panel.add(newPanel);
		panel.validate();
	}
        //Metodos que he hecho xd

    public JButton getBtnVenta() {
        return btnVenta;
    }

    public JButton getBtnCompra() {
        return btnCompra;
    }

    public JButton getBtnClientes() {
        return btnClientes;
    }

    public JButton getBtnProveedores() {
        return btnProveedores;
    }

    public JButton getBtnInventario() {
        return btnInventario;
    }

    public JButton getBtnGraficas() {
        return btnGraficas;
    }
    private JPanel panelGraficos;
    private PanelInventory panelInventory;
    private PanelClient panelClient;
    private PanelSupplier panelSupplier;
    private PanelPurchase panelPurchase;
    private TableSales tableSale;
    
    public void validar(){
        this.panel.validate();
    }
    public void anadirPanel(JPanel panelad){
        this.panel.add(panelad);
    }
    public void unhidePanelGraficos(){
        this.panelGraficos.setVisible(true);
    }
    public void hidePanelGraficos(){
        this.panelGraficos.setVisible(false);
    }
    public void unhideTableSales(){
        this.tableSale.setVisible(true);
    }
    public void hideTableSales(){
        this.tableSale.setVisible(false);
    }
    
    public void unhidePanelInventory(){
        this.panelInventory.setVisible(true);
    }
    public void hidePanelInventory(){
        this.panelInventory.setVisible(false);
    }
    //Client
    public void addPanelGraficos(JPanel panelGraficos){
        this.panelGraficos=panelGraficos;
        this.panel.add(this.panelGraficos,0);
        
    }
    
    public void addPanelInventory(PanelInventory panel){
        this.panelInventory=panel;
        this.panel.add(this.panelInventory,0);
    }
    public void addPanelSupplier(PanelSupplier panelSupplier){
        this.panelSupplier=panelSupplier;
        panelSupplier.setSize(450,300);
        this.panel.add(this.panelSupplier,0);
    }
    public void addPanelPurchase(PanelPurchase panelPurchase){
        this.panelPurchase=panelPurchase;
        panelPurchase.setSize(450,300);
        this.panel.add(panelPurchase,0);
    }
    public void addPanelClient(PanelClient panelClient){
        this.panelClient=panelClient;
        panelClient.setSize(450,300);
        this.panel.add(this.panelClient,0);
    }
    public void addSaleTable(TableSales tableSale){
        this.tableSale=tableSale;
        tableSale.setSize(450,300);
        this.panel.add(this.tableSale,0);
    }
    public void unhidePanelClient(){
        this.panelClient.setVisible(true);
    }
    public void hidePanelClient(){
        this.panelClient.setVisible(false);
    }
    public void unhidePanelSupplier(){
        this.panelSupplier.setVisible(true);
    }
    public void hidePanelSupplier(){
        this.panelSupplier.setVisible(false);
    }
    public void unhidePanelPurchase(){
        this.panelPurchase.setVisible(true);
    }
    public void hidePanelPurchase(){
        this.panelPurchase.setVisible(false);
    }
    
    
    public void anadirButtonsActionListener(ActionListener al){
    btnVenta.addActionListener(al);
    btnCompra.addActionListener(al);
    btnClientes.addActionListener(al);
    btnProveedores.addActionListener(al);
    btnInventario.addActionListener(al);
    btnGraficas.addActionListener(al);
    }
}
