/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

//import static datos.PedidoDAO.SQL_CONSULTA;
//import static datos.PedidoDAO.SQL_INSERT;
//import static datos.PedidoDAO.SQL_UPDATE;
import java.sql.Connection;
//import java.sql.Date;
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
public class EnvioDAO implements EnvioServices{
    
    public static final String SQL_CONSULTA = "SELECT idEnvio, costo, idPedido_pedido FROM informacionenvio";
    public static final String SQL_INSERT = "INSERT INTO informacionenvio (idEnvio, costo, idPedido_pedido) VALUE(?,?,?)";
    public static final String SQL_DELETE = "DELETE FROM informacionenvio WHERE idEnvio = ?";
    public static final String SQL_UPDATE = "UPDATE informacionenvio SET costo = ?, idPedido_pedido = ? WHERE idEnvio = ?";

    @Override
    public List<EnvioDTO> consultar() {
        Connection con = null;
        PreparedStatement sen = null;
        ResultSet res = null;
        EnvioDTO envio = null;
        List<EnvioDTO> envios = new ArrayList<>();
        try {
            con = BaseDeDatos.getConnection();
            sen = con.prepareStatement(SQL_CONSULTA);
            res = sen.executeQuery();
            while (res.next()) {
                int idEnvio = res.getInt("idEnvio");
                int costo = res.getInt("costo");
                int idPedido_pedido = res.getInt("idPedido_pedido");
                envio = new EnvioDTO(idEnvio, costo, idPedido_pedido);
                envios.add(envio);
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
        return envios;
    }

    @Override
    public int crear(EnvioDTO envioDTO) {
        Connection con = null;
        PreparedStatement sen = null;
        int registros = 0;
        try {
            con = BaseDeDatos.getConnection();
            sen = con.prepareStatement(SQL_INSERT);
            sen.setInt(1, envioDTO.getIdEnvio());
            sen.setInt(2, envioDTO.getCosto());
            sen.setInt(3, envioDTO.getIdPedido_pedido());            
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
    public int actualizar(EnvioDTO envioDTO) {
        Connection con = null;
        PreparedStatement sen = null;
        int registros = 0;
        try {
            con = BaseDeDatos.getConnection();
            sen=con.prepareStatement(SQL_UPDATE);
            sen.setInt(1, envioDTO.getCosto());
            sen.setInt(2, envioDTO.getIdPedido_pedido());
            sen.setInt(3, envioDTO.getIdEnvio());
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
    public int eliminar(EnvioDTO envioDTO) {
        Connection con = null;
        PreparedStatement sen = null;
        int registros = 0;
        try {
            con = BaseDeDatos.getConnection();
            sen=con.prepareStatement(SQL_DELETE);
            sen.setInt(1, envioDTO.getIdEnvio());            
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
