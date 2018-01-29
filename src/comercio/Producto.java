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
public class Producto {
    private String refProducto;
    private String nome;
    private String refPrecio;

    public Producto() {
    }

    public String getRefProducto() {
        return refProducto;
    }

    public void setRefProducto(String refProducto) {
        this.refProducto = refProducto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRefPrecio() {
        return refPrecio;
    }

    public void setRefPrecio(String refPrecio) {
        this.refPrecio = refPrecio;
    }

    public Producto(String refProducto, String nome, String refPrecio) {
        this.refProducto = refProducto;
        this.nome = nome;
        this.refPrecio = refPrecio;
    }
    
}
