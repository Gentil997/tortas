/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import red.BaseDeDatos;

/**
 *
 * @author LENOVO
 */
public class PedidoDAO implements PedidoServices {

    public static final String SQL_CONSULTA = "SELECT idPedido,fechaPedido, fechaEnvio, estado, idEnvio, documento_cliente FROM pedido";
    public static final String SQL_INSERT = "INSERT INTO pedido (idPedido, fechaPedido, fechaEnvio, estado, idEnvio, documeto_cliente) VALUE(?,?,?,?,?,?)";
    public static final String SQL_DELETE = "DELETE FROM pedido WHERE idPedido = ?";
    public static final String SQL_UPDATE = "UPDATE pedido SET fechaEnvio = ?, estado = ? WHERE idPedido = ?";

    @Override
    public List<PedidoDTO> consultar() {
        Connection con = null;
        PreparedStatement sen = null;
        ResultSet res = null;
        PedidoDTO pedido = null;
        List<PedidoDTO> pedidos = new ArrayList<>();
        try {
            con = BaseDeDatos.getConnection();
            sen = con.prepareStatement(SQL_CONSULTA);
            res = sen.executeQuery();
            while (res.next()) {
                int idPedido = res.getInt("idPedido");
                Date fechaPedido = res.getDate("fechaPedido");
                Date fechaEnvio = res.getDate("fechaEnvio");
                Boolean estado = res.getBoolean("estado");
                int idEnvio = res.getInt("idEnvio");
                int documento_cliente = res.getInt("documento_cliente");
                pedido = new PedidoDTO(idPedido, fechaPedido, fechaEnvio, estado, idEnvio, documento_cliente);
                pedidos.add(pedido);
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
        return pedidos;
    }

    @Override
    public int crear(PedidoDTO pedidoDTO) {
        Connection con = null;
        PreparedStatement sen = null;
        int registros = 0;
        try {
            con = BaseDeDatos.getConnection();
            sen = con.prepareStatement(SQL_INSERT);
            sen.setInt(1, pedidoDTO.getIdPedido());
            sen.setDate(2, pedidoDTO.getFechaPedido());
            sen.setDate(3, pedidoDTO.getFechaEnvio());
            sen.setBoolean(4, pedidoDTO.getEstado());
            sen.setInt(5, pedidoDTO.getIdEnvio());
            sen.setInt(6, pedidoDTO.getDocumento_cliente());
            registros = sen.executeUpdate();

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
        return registros;
    }

    @Override
    public int actualizar(PedidoDTO pedidoDTO) {
        Connection con = null;
        PreparedStatement sen = null;
        int registros = 0;
        try {
            con = BaseDeDatos.getConnection();
            sen=con.prepareStatement(SQL_UPDATE);
            sen.setDate(1, pedidoDTO.getFechaEnvio());
            sen.setBoolean(2, pedidoDTO.getEstado());
            sen.setInt(3, pedidoDTO.getIdPedido());
            registros = sen.executeUpdate();
            
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
        return registros;
    }

    @Override
    public int eliminar(PedidoDTO pedidoDTO) {
        Connection con = null;
        PreparedStatement sen = null;
        int registros = 0;
        try {
            con = BaseDeDatos.getConnection();
            sen=con.prepareStatement(SQL_DELETE);
            sen.setInt(1, pedidoDTO.getIdPedido());            
            registros = sen.executeUpdate();    
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
        return registros;
    }

}
