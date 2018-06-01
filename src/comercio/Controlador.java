package comercio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Controlador {
    String url = "BaseComercio.db";
    Connection c = null;
    
    
    /*
    Metodo conectar que nos permitira conectarnos a la base
    */
    public void connectar(){
          try {
            c = DriverManager.getConnection("jdbc:sqlite:"+url);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar", "Advertencia", JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /*
    Metodo desconectar para desconectarnos de la base
    */
    public void desconectar(){
             try {
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

