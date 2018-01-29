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
public class Precio {
    private String refPrecio;
    private float precio;

    public Precio() {
    }

    public Precio(String refPrecio, float precio) {
        this.refPrecio = refPrecio;
        this.precio = precio;
    }

    public String getRefPrecio() {
        return refPrecio;
    }

    public void setRefPrecio(String refPrecio) {
        this.refPrecio = refPrecio;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    
    
}
