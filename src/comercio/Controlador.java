package comercio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Controlador {
    String url = "BaseComercio.db";
    Connection c;
    Statement stmt,s1,s2,s3;
    ResultSet rs1,rs2,rs3;
    
    /*
    Metodo conectar que nos permitira conectarnos a la base
    */
    public void conectar(){
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
    
    /*
    Metodos de carga:
    Los 3 siguientes metodos cargaran los datos de la tabla en una jTable
    El primero cargará los productos
    El segundo cargará las ventas
    El tercero cargará los precios
    */
    public void cargarProductos(DefaultTableModel modelo){
        
        /*
        Nos conectamos a la base, por si ocurriese algun error y 
        nos hubiesemos desconectado previamente
        */
        
        this.conectar();
        
        /*
        Reseteamos las filas y las columnas de la tabla a 0
        */
        
        modelo.setColumnCount(0);
        modelo.setRowCount(0);
        

        try{
            
            /*
            Crearemos un statement con la sentencia a ejecutar y se lo mandamos
            al ResultSet con un executeQuery
            */
            
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Producto");
            
            /*
            Mediante el DefaultTableModel añadimos las columnas a la tabla
            con los valores que recibirá de la base
            */
            
            modelo.addColumn("Ref Producto");
            modelo.addColumn("Nombre Producto");
            modelo.addColumn("Ref Precio");
            
            /*
            Llenamos la tabla con los objetos de la base
            */
            while(rs.next()){
                modelo.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3)});
            }
            
        }catch(SQLException ex){
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.desconectar();
    }

public void cargarVentas(DefaultTableModel modelo){
        try{
            this.conectar();
            
            modelo.setColumnCount(0);
            modelo.setRowCount(0);
            
            /*
            Crearemos un statement con la sentencia a ejecutar y se lo mandamos
            al ResultSet con un executeQuery
            */
            
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Ventas");
            
            /*
            Mediante el DefaultTableModel añadimos las columnas a la tabla
            con los valores que recibirá de la base
            */
            
            modelo.addColumn("Ref Producto");
            modelo.addColumn("Nota");
            modelo.addColumn("Referencia");
            
            /*
            Llenamos la tabla con los objetos de la base
            */
            
            while(rs.next()){
                modelo.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3)});
            }
            
        }catch(SQLException ex){
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.desconectar();
    }

public void cargarPrecios(DefaultTableModel modelo){
        try{
            
            this.conectar();
            
            modelo.setColumnCount(0);
            modelo.setRowCount(0);
            
            /*
            Crearemos un statement con la sentencia a ejecutar y se lo mandamos
            al ResultSet con un executeQuery
            */
            
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Precio");
            
            /*
            Mediante el DefaultTableModel añadimos las columnas a la tabla
            con los valores que recibirá de la base
            */
            
            modelo.addColumn("Ref Precio");
            modelo.addColumn("Precio");
            
            /*
            Llenamos la tabla con los objetos de la base
            */
            while(rs.next()){
                modelo.addRow(new Object[]{rs.getString(1), rs.getString(2)});
            }
            
        }catch(SQLException ex){
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.desconectar();
    }
    
    
public void imprimirTicket(DefaultTableModel modelo, String lista){
        /*
        Nos conectamos a la base, por si nos hubiesemos desconectado
        previamente
        */
            this.conectar();
            
            /*
            Reseteamos las columnas
            */
            
            modelo.setColumnCount(0);
            modelo.setRowCount(0);
            
          try {  
            
            /*
            Creamos los statement
            */
            
            s1 = c.createStatement();
            s2 = c.createStatement();
            s3 = c.createStatement();
            
            /*
            Ejecutamos los statement
            */
            
            rs1 = s1.executeQuery("select * from Ventas where nVenta= " + lista + "");
            rs2 = s2.executeQuery("select * from ReferenciaProducto where refProducto in(select refProducto from Ventas where nVenta= " + lista + ")");
            rs3 = s3.executeQuery("select * from Precio where refPrecio in(select refPrecio from ReferenciaProducto where refProducto in(select refProducto from Ventas where nVenta= " + lista + "))");
            int Cantidad = rs1.getInt(3);
            int Pt = rs3.getInt(2);
            int PrecioTotal = Cantidad * Pt;
            
            /*
            Añadimos las columnas a la tabla
            */
            
            modelo.addColumn("NumVenta");
            modelo.addColumn("Nombre Producto");
            modelo.addColumn("Precio");
            
            /*
            Llenamos la tabla
            */
            
            while (rs1.next()) {
                modelo.addRow(new Object[]{rs1.getInt(2), rs2.getString(2), PrecioTotal});
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

