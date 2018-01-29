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
public class Ventas {
    private String nv;
    private String refProducto;
    private float Cantidade;

    public Ventas() {
    }

    public Ventas(String nv, String refProducto, float Cantidade) {
        this.nv = nv;
        this.refProducto = refProducto;
        this.Cantidade = Cantidade;
    }

    public String getNv() {
        return nv;
    }

    public void setNv(String nv) {
        this.nv = nv;
    }

    public String getRefProducto() {
        return refProducto;
    }

    public void setRefProducto(String refProducto) {
        this.refProducto = refProducto;
    }

    public float getCantidade() {
        return Cantidade;
    }

    public void setCantidade(float Cantidade) {
        this.Cantidade = Cantidade;
    }
    
}
