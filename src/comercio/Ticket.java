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
public class Ticket {
    private String nv;
    private String nome;
    private float precioTotal;

    public Ticket() {
    }

    public Ticket(String nv, String nome, float precioTotal) {
        this.nv = nv;
        this.nome = nome;
        this.precioTotal = precioTotal;
    }

    public String getNv() {
        return nv;
    }

    public void setNv(String nv) {
        this.nv = nv;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    @Override
    public String toString() {
        return "Ticket{" + "nv=" + nv + ", nome=" + nome + ", precioTotal=" + precioTotal + '}';
    }
    
   
  
    
}
