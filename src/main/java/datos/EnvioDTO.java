/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author LENOVO
 */
public class EnvioDTO {
    private int idEnvio;
    private int costo;
    private int idPedido_pedido;

    public EnvioDTO(int idEnvio, int costo, int idPedido_pedido) {
        this.idEnvio = idEnvio;
        this.costo = costo;
        this.idPedido_pedido = idPedido_pedido;
    }

    public EnvioDTO() {
    }

    public int getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(int idEnvio) {
        this.idEnvio = idEnvio;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getIdPedido_pedido() {
        return idPedido_pedido;
    }

    public void setIdPedido_pedido(int idPedido_pedido) {
        this.idPedido_pedido = idPedido_pedido;
    }

    @Override
    public String toString() {
        return "EnvioDTO{" + "idEnvio=" + idEnvio + ", costo=" + costo + ", idPedido_pedido=" + idPedido_pedido + '}';
    }
    
}
