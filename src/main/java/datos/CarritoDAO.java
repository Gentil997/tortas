/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import red.BaseDeDatos;
/**
 *
 * @author Jaider Cardenas
 */
public class CarritoDAO implements CarritoServices{
    public static final String SQL_CONSULTA = "SELECT idCarrito,idProducto,cantidad, documento_cliente FROM carrito";
    public static final String SQL_CREAR = "INSERT INTO carrito (idCarrito,idProducto,cantidad, documento_cliente) VALUES (?,?,?,?)";
    public static final String SQL_ELIMINAR = "DELETE FROM carrito WHERE id = ?";
    public static final String SQL_ACTUALIZAR = "UPDATE carrito SET idProducto = ?, cantidad = ?, documento_cliente = ? WHERE idCarrito = ? "; 
    
   
    @Override
    public List<CarritoDTO> consultar() {
        Connection con = null;
        PreparedStatement sen = null;
        ResultSet res = null;
        CarritoDTO carrito = null;
        List<CarritoDTO> carritos = new ArrayList<>();
        try {
            con = BaseDeDatos.getConnection();
            sen = con.prepareStatement(SQL_CONSULTA);
            res = sen.executeQuery();
            while (res.next()) {
                int idCarrito= res.getInt("idCarrito");
                int idProducto = res.getInt("idProducto");
                int cantidad = res.getInt("cantidad");
                int documento_cliente = res.getInt("documento_cliente");
                carrito= new CarritoDTO(idCarrito,idProducto,cantidad, documento_cliente);
                carritos.add(carrito);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                BaseDeDatos.close(res);
                BaseDeDatos.close(sen);
                BaseDeDatos.close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return carritos;
    }

    @Override
    public int crear(CarritoDTO carritoDTO) {
                Connection con = null;
        PreparedStatement sen = null;
        int c = 0;
        
        List<CarritoDTO> carrito = new ArrayList<>();
        try {
            con = BaseDeDatos.getConnection();
            sen = con.prepareStatement(SQL_CREAR);
            sen.setInt(1, carritoDTO.getIdCarrito());
            sen.setInt(2, carritoDTO.getIdProducto());
            sen.setInt(3, carritoDTO.getCantidad());
            sen.setInt(4, carritoDTO.getDocumento_cliente());
            
            c = sen.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
               
                BaseDeDatos.close(sen);
                BaseDeDatos.close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
       return c; 
    }


    @Override
    public int actualizar(CarritoDTO carritoDTO) {
    Connection con = null;
        PreparedStatement sen = null;
        int c = 0;
        
        List<CarritoDTO> carritos = new ArrayList<>();
        try {
            con = BaseDeDatos.getConnection();
            sen = con.prepareStatement(SQL_ACTUALIZAR);
            
            sen.setInt(1, carritoDTO.getIdProducto());
            sen.setInt(2, carritoDTO.getCantidad());
            sen.setInt(3, carritoDTO.getDocumento_cliente());
            sen.setInt(4, carritoDTO.getIdCarrito());
            
            c = sen.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
               
                BaseDeDatos.close(sen);
                BaseDeDatos.close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
       return c;      
    
    }

    @Override
    public int eliminar(CarritoDTO carritoDTO) {
       Connection con = null;
        PreparedStatement sen = null;
        int c = 0;
       try{
           con = BaseDeDatos.getConnection();
           sen = con.prepareStatement(SQL_ELIMINAR);
           
           sen.setInt(1, carritoDTO.getIdCarrito());
           c = sen.executeUpdate();
          } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                BaseDeDatos.close(sen);
                BaseDeDatos.close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
       return c; 
    }
}
