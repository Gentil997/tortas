/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Date;

/**
 *
 * @author LENOVO
 */
public class PedidoDTO {
    private int idPedido;
    private Date fechaPedido;
    private Date fechaEnvio;
    private Boolean estado;
    private int idEnvio;
    private int documento_cliente;

    public PedidoDTO(int idPedido, Date fechaPedido, Date fechaEnvio, Boolean estado, int idEnvio, int documento_cliente) {
        this.idPedido = idPedido;
        this.fechaPedido = fechaPedido;
        this.fechaEnvio = fechaEnvio;
        this.estado = estado;
        this.idEnvio = idEnvio;
        this.documento_cliente = documento_cliente;
    }

    public PedidoDTO() {
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public int getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(int idEnvio) {
        this.idEnvio = idEnvio;
    }

    public int getDocumento_cliente() {
        return documento_cliente;
    }

    public void setDocumento_cliente(int documento_cliente) {
        this.documento_cliente = documento_cliente;
    }

    @Override
    public String toString() {
        return "PedidoDTO{" + "idPedido=" + idPedido + ", fechaPedido=" + fechaPedido + ", fechaEnvio=" + fechaEnvio + ", estado=" + estado + ", idEnvio=" + idEnvio + ", documento_cliente=" + documento_cliente + '}';
    }

    

    
    
    

    
    
    
}
