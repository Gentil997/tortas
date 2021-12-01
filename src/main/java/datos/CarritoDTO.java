/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author Jaider Cardenas
 */
public class CarritoDTO {
private int idCarrito;
private int idProducto;
private int cantidad;
private int documento_cliente;

    public CarritoDTO() {
    }

    public CarritoDTO(int idCarrito, int idProducto, int cantidad, int documento_cliente) {
        this.idCarrito = idCarrito;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.documento_cliente = documento_cliente;
    }

    public int getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getDocumento_cliente() {
        return documento_cliente;
    }

    public void setDocumento_cliente(int documento_cliente) {
        this.documento_cliente = documento_cliente;
    }

    @Override
    public String toString() {
        return "CarritoDTO{" + "idCarrito=" + idCarrito + ", idProducto=" + idProducto + ", cantidad=" + cantidad + ", documento_cliente=" + documento_cliente + '}';
    }
    

}
