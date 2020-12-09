package controlador;
import modelo.*;
import vista.*;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class PrincipalControl implements ActionListener{
    private FramePrincipal framePrincipal;
    private PanelSales frameSales;
    private ConClient controlCliente;
    private ConInventory controlInventory;
    private ConPurchase controlPurchase;
    private ConSale controlSale;
    private ConSupplier controlSupplier;
    private ControlGraficosPanel conGraficos;
    private PanelInventory panelInventory;
    private PanelClient panelClient;
    private PanelSupplier panelSupplier;
    private PanelPurchase panelPurchase;
    private Connection conexion;
    private ConsultInventory consultInventory;
    private ConsultClient consultClient;
    private ConsultSupplier consultSupplier;
    private ConsultSales consultSales;
    private ConsultPurchase consultPurchase;
    private GraficosPanel panelGraficos;
    private TableSales tablaSales;
    private Inventory inventory;
    private Client client;
    private Supplier supplier;
    private Purchase purchase;
    private JPanel      panelGraficas;
    public PrincipalControl(FramePrincipal frame,PanelSales frameSales,Connection conexion){
        this.framePrincipal=frame;
        this.conexion=conexion;
        this.frameSales=frameSales;
        //this.frameInventory=frameInventory;
        startModelo();
        startPanels();
        inicialControladorPrincipal();
        starControladores();
        startSalesFrameControl();
        anadirPaneles();
        hidePanels();
        
    }
    public void startSalesFrameControl(){
        controlSale=new ConSale(consultSales,frameSales);
    }
    public void startModelo(){
        inventory=new Inventory();
        client=new Client();
        supplier=new Supplier();
        purchase=new Purchase();
        consultInventory=new ConsultInventory(conexion);
        consultClient=new ConsultClient(conexion);
        consultPurchase=new ConsultPurchase(conexion);
        consultSupplier=new ConsultSupplier(conexion);
        consultSales=new ConsultSales(conexion);
        
    }
    public void inicialControladorPrincipal(){
        framePrincipal.anadirButtonsActionListener(this);
    }
    public void startPanels(){
        initSaleTable();
        initPanelPurchase();
        initPanelInventory();
        initPanelGraficas();
        initPanelClient();
        initPanelSupplier();
    }
    public void starControladores(){
        //this.controlInventory=new ConInventory(inventory,consultInventory,frameInventory);
        this.conGraficos= new ControlGraficosPanel(panelGraficos,conexion);
        
        this.controlInventory=new ConInventory(inventory,consultInventory,panelInventory);
        this.controlCliente=new ConClient(client,consultClient,panelClient);
        this.controlSupplier=new ConSupplier(supplier,consultSupplier,panelSupplier);
        this.controlPurchase=new ConPurchase(purchase,consultPurchase,panelPurchase);
        
    }
    public void anadirPaneles(){
        framePrincipal.addPanelClient(panelClient);
        framePrincipal.validar();
        framePrincipal.addPanelSupplier(panelSupplier);
        framePrincipal.validar();
        framePrincipal.addPanelPurchase(panelPurchase);
        framePrincipal.validar();
        framePrincipal.addPanelGraficos(panelGraficas);
        framePrincipal.validar();
        framePrincipal.addPanelInventory(panelInventory);
        framePrincipal.validar();
        framePrincipal.addSaleTable(tablaSales);
        framePrincipal.validar();
        framePrincipal.validate();
        //frame.validar();
    }
    public void initSaleTable(){
        tablaSales=new TableSales();
        tablaSales.cargarMatriz(consultSales.getTableAsMatriz());
        
    }
    public void updateSaleTable(){
        tablaSales.LimpiarFilas();
        tablaSales.cargarMatriz(consultSales.getTableAsMatriz());
    }
    public void initPanelGraficas(){
        panelGraficos= new GraficosPanel();
        panelGraficas=new JPanel();
        panelGraficas.setSize(450,300);
        panelGraficas.setLayout(null);
        panelGraficas.add(panelGraficos);
    }
    public void initPanelInventory(){
        panelInventory=new PanelInventory();
    }
    public void initPanelClient(){
        panelClient=new PanelClient();
    }
    public void initPanelSupplier(){
        panelSupplier=new PanelSupplier();
    }
    public void initPanelPurchase(){
        panelPurchase=new PanelPurchase();
    }
    public void hidePanels(){
        framePrincipal.hidePanelGraficos();
        framePrincipal.hidePanelInventory();
        framePrincipal.hidePanelClient();
        framePrincipal.hidePanelSupplier();
        framePrincipal.hidePanelPurchase();
        framePrincipal.hideTableSales();
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==framePrincipal.getBtnGraficas()){
            framePrincipal.hidePanelPurchase();
            framePrincipal.unhidePanelGraficos();
            framePrincipal.hidePanelInventory();
            framePrincipal.hidePanelClient();
            framePrincipal.hidePanelSupplier();
            framePrincipal.hideTableSales();
        }else if(e.getSource()==framePrincipal.getBtnInventario()){
            framePrincipal.hidePanelPurchase();
            framePrincipal.unhidePanelInventory();
            framePrincipal.hidePanelGraficos();
            framePrincipal.hidePanelClient();
            framePrincipal.hidePanelSupplier();
            framePrincipal.hideTableSales();
        }else if(e.getSource()==framePrincipal.getBtnClientes()){
            
            framePrincipal.unhidePanelClient();
            framePrincipal.hidePanelGraficos();
            framePrincipal.hidePanelSupplier();
            framePrincipal.hidePanelInventory();
            framePrincipal.hidePanelPurchase();
            framePrincipal.hideTableSales();
        }else if(e.getSource()==framePrincipal.getBtnProveedores()){
            controlSale.updateCombos();
            framePrincipal.unhidePanelSupplier();
            framePrincipal.hidePanelGraficos();
            framePrincipal.hidePanelClient();
            framePrincipal.hidePanelInventory();
            framePrincipal.hidePanelPurchase();
            framePrincipal.hideTableSales();
        }else if(e.getSource()==framePrincipal.getBtnVenta()){
            frameSales.setLocationRelativeTo(null);
            frameSales.setVisible(true);
            updateSaleTable();
            framePrincipal.hidePanelGraficos();
            framePrincipal.hidePanelClient();
            framePrincipal.hidePanelInventory();
            framePrincipal.hidePanelSupplier();
            framePrincipal.hidePanelPurchase();
            framePrincipal.unhideTableSales();
        }else if(e.getSource()==framePrincipal.getBtnCompra()){
            controlPurchase.actualizarCombos();
            framePrincipal.unhidePanelPurchase();
            framePrincipal.hidePanelGraficos();
            framePrincipal.hidePanelClient();
            framePrincipal.hidePanelInventory();
            framePrincipal.hidePanelSupplier();
            framePrincipal.hideTableSales();
        }else if(true){
            
        }
    }
    
}
