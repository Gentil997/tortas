/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import red.BaseDeDatos;

/**
 *
 * @author raulg
 */
public class inPedidoDAO implements inServices {
    
    public static final String SQL_CONSULTA = "SELECT idPedido, idProducto, nombreProd, cantidad, costoxunidad, totalprecio, idPedido_pedido";
    public static final String SQL_INSERT = "INSERT INTO informacionenvio (idPedido, idProducto, nombreP, cantidad, costoxuni, totalPrecio, idPedido_pedido) VALUE (?,?,?,?,?,?,?)";
    public static final String SQL_DELETE ="DELETE FROM informacionenvio WHERE idPedido =?";
    public static final String SQL_UPDATE = "UPDATE informacionenvio SET idProducto = ?, nombreP = ?, cantidad = ?, costoxuni = ?, totalPrecio = ?, idPedido_pedido = ? WHERE idPedido = ?";
    
    

    @Override
    public List<inPedidoDTO> consultar() {

        Connection con = null;
        PreparedStatement sen =null;
        ResultSet res = null;
        inPedidoDTO in = null;
        List<inPedidoDTO> info = new ArrayList<>();
        try{
            con = BaseDeDatos.getConnection();
            sen = con.prepareStatement(SQL_CONSULTA);
            res = sen.executeQuery();
            while (res.next()){
                int idPedido = res.getInt("idPedido");
                int idProducto = res.getInt("costo");
                String nombreP = res.getNString("nombre");
                int cantidad = res.getInt("cantidad");
                int costoxunidad = res.getInt("Costoxunidad");
                int totalPrecio = res.getInt("totalPrecio");
                int idPedido_pedido = res.getInt("idPedido_pedido");
                info = (List<inPedidoDTO>) new inPedidoDTO(idPedido, idProducto, nombreP, cantidad, costoxunidad, totalPrecio, idPedido_pedido);
                info.add((inPedidoDTO) info);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try{
                BaseDeDatos.close(res);
                BaseDeDatos.close(sen);
                BaseDeDatos.close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return info;
    }

    @Override
    public int crear(inPedidoDTO inDTO) {
        Connection con = null;
        PreparedStatement sen =null;
        int registros = 0;
        try{
            con = BaseDeDatos.getConnection();
            sen = con.prepareStatement(SQL_INSERT);
            sen.setInt(1, inDTO.getIdPedido());
            sen.setInt(2, inDTO.getIdProducto());
            sen.setString(3, inDTO.getNombreProd());
            sen.setInt(4, inDTO.getCantidad());
            sen.setInt(5, inDTO.getCostoxunidad());
            sen.setInt(6, inDTO.getTotalprecio());
            sen.setInt(7, inDTO.getIdPedido_pedido());
            registros = sen.executeUpdate();
            } catch (SQLException ex) {
            Logger.getLogger(inPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);        
        }finally{
            try{
                BaseDeDatos.close(sen);
                BaseDeDatos.close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    @Override
    public int actualizar(inPedidoDTO inDTO) {
        Connection con = null;
        PreparedStatement sen =null;
        int registros = 0;
        try{
            con = BaseDeDatos.getConnection();
            sen = con.prepareStatement(SQL_UPDATE);
            sen.setInt(1, inDTO.getIdProducto());
            sen.setString(2, inDTO.getNombreProd());
            sen.setInt(3, inDTO.getCantidad());
            sen.setInt(4, inDTO.getCostoxunidad());
            sen.setInt(5, inDTO.getTotalprecio());
            registros = sen.executeUpdate();
            } catch (SQLException ex) {
            Logger.getLogger(inPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);        
        }finally{
            try{
                BaseDeDatos.close(sen);
                BaseDeDatos.close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    @Override
    public int eliminar(inPedidoDTO inDTO) {
        Connection con = null;
        PreparedStatement sen =null;
        int registros = 0;
        try{
            con = BaseDeDatos.getConnection();
            sen = con.prepareStatement(SQL_DELETE);
            sen.setInt(1, inDTO.getIdPedido());
            registros = sen.executeUpdate();
            } catch (SQLException ex) {
        }finally{
            try{
                BaseDeDatos.close(sen);
               BaseDeDatos.close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
}
