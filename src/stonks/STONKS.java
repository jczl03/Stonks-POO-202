
package stonks;
import java.sql.*;
import vista.*;
import modelo.*;
import controlador.*;
public class STONKS {
    public static void main(String[] args) {
        Conexion c = new Conexion(); 
        Connection conexion=c.getConexion();
         
        
        FramePrincipal frameprincipal=new FramePrincipal();
        PanelSales frameSales=new PanelSales();
        PrincipalControl controlSupremo= new PrincipalControl(frameprincipal,frameSales,conexion);
        frameprincipal.setVisible(true);
        
    }
    
    
}