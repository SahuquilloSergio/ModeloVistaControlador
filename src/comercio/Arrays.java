/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comercio;

/**
 *
 * @author jose
 */
public class Arrays {
    public static String nomeProducto; // declaramos estas variables estaticas para facer a proba de usalas dende o metodo main, no main ao ser estatico so podemos acceder a variables estaticas 
    public static float precioProducto;
    
    // vamos a facer que se autocomplete o ticket cos datos dos arrays que temos sobre ventas, productos e prezos
    // primeiro creamos estos tres arrays
    Ventas[] listaVentas={new Ventas("1","rpro1",7f),new Ventas("2","rpro2",9f),new Ventas("3","rpro3",4f)};
    Producto[]listaProductos={new Producto("rpro3","uvas","rpre1"),new Producto("rpro1","peras","rpre3"),new Producto("rpro2","patatas","rpre2")};
    Precio[]listaPrecios={new Precio("rpre2",2f),new Precio("rpre1",5f),new Precio("rpre3",7f)};
    
 
    
    // metodo para a creación dun ticket 
    public Ticket crearTicket(String numeroVenta){
        
       Ticket ticket1=new Ticket(); // creamos un obxeto de tipo ticket que retornaremos co metodo 
        for (Ventas listaVenta : listaVentas) {
            if (numeroVenta.equalsIgnoreCase(listaVenta.getNv())) { // comparamos a referencia que metemos coa da posicion do bucle que recorre o array
                ticket1.setNv(numeroVenta); // insertamos no noso ticket o numero de venta coincidente
                for (Producto listaProducto : listaProductos) { // recorremos o array de prodcutos para poder acceder ao nome
                    if (listaVenta.getRefProducto().equalsIgnoreCase(listaProducto.getRefProducto())) { // comparamos o nome do producto que atopamos antes co da venta da posicion do bucle
                        ticket1.setNome(listaProducto.getNome()); // insertamos o nome do producto no noso ticket
                    }
                for (Precio listaPrecio : listaPrecios) { // recorremos por ultimo a nosa lista de prezos
                    if (listaProducto.getRefPrecio().equalsIgnoreCase(listaPrecio.getRefPrecio())) {  //comparamos a referencia do prezo para atopar o que desexamos
                         ticket1.setPrecioTotal(listaPrecio.getPrecio() * listaVenta.getCantidade());// calculamos o prezo total da venta, numero de unidades * precio da unidade
                        }
                    }
                }
            }
        }
        return ticket1; // retornamos un ticket cos datos introducidos
    }
    
    public  void utilizarNomePrecio(String referencia){ // metodo para facer a proba de acceder a variables dende o main, estas variables teñen que ser estaticas
        for(Producto produ:listaProductos){ // insertamos o nome na variable nomeProducto para comprobar se accedemos dende o main
            if (referencia.equalsIgnoreCase(produ.getRefProducto())){
               nomeProducto=produ.getNome();
            }
        
        for(Precio prec:listaPrecios){
            if(prec.getRefPrecio().equals(produ.getRefPrecio())){// insertamos o prezo dentro de prezoProducto para comprobar se accedemos a esta variable dende o main 
                precioProducto=prec.getPrecio();
            }
        }
    }
    }
    
}
