/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos; 

/**
 *
 * @author raulg
 */
public class inPedidoDTO {
    
    private int idPedido;
    private int idProducto;
    private String nombreProd;
    private int cantidad;
    private int costoxunidad;
    private int totalprecio;
    private int idPedido_pedido;

    public inPedidoDTO() {
    }

    public inPedidoDTO(int idPedido, int idProducto, String nombreProd, int cantidad, int costoxunidad, int totalprecio, int idPedido_pedido) {
        this.idPedido = idPedido;
        this.idProducto = idProducto;
        this.nombreProd = nombreProd;
        this.cantidad = cantidad;
        this.costoxunidad = costoxunidad;
        this.totalprecio = totalprecio;
        this.idPedido_pedido = idPedido_pedido;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCostoxunidad() {
        return costoxunidad;
    }

    public void setCostoxunidad(int costoxunidad) {
        this.costoxunidad = costoxunidad;
    }

    public int getTotalprecio() {
        return totalprecio;
    }

    public void setTotalprecio(int totalprecio) {
        this.totalprecio = totalprecio;
    }

    public int getIdPedido_pedido() {
        return idPedido_pedido;
    }

    public void setIdPedido_pedido(int idPedido_pedido) {
        this.idPedido_pedido = idPedido_pedido;
    }

    @Override
    public String toString() {
        return "inPedidoDTO{" + "idPedido=" + idPedido + ", idProducto=" + idProducto + ", nombreProd=" + nombreProd + ", cantidad=" + cantidad + ", costoxunidad=" + costoxunidad + ", totalprecio=" + totalprecio + ", idPedido_pedido=" + idPedido_pedido + '}';
    }

    
    }
