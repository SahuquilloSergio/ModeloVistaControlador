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
    
    public void connectar(){
          try {
            c = DriverManager.getConnection("jdbc:sqlite:"+url);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar", "Advertencia", JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}