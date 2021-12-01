/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;
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
 * @author santi
 */
public class clienteDAO implements clienteServices {

    public static final String SQL_CONSULTA = "SELECT nombres, direccion, datosEnvio, id_Usuario, documento FROM cliente";
    public static final String SQL_INSERT = "INSERT INTO cliente (nombres, direccion, datosEnvio, id_Usuario, documento) VALUE(?,?,?,?,?)";
    public static final String SQL_DELETE = "DELETE FROM cliente WHERE documento = ?";
    public static final String SQL_UPDATE = "UPDATE cliente SET nombres = ?, direccion = ?, datosEnvio = ?, id_Usuario = ? WHERE documento = ?";

    
    @Override
    public List<clienteDTO> consultar() {
        Connection con = null;
        PreparedStatement sen = null;
        ResultSet res = null;
        clienteDTO cliente = null;
        List<clienteDTO> clientes = new ArrayList<>();
        try {
            con = BaseDeDatos.getConnection();
            sen = con.prepareStatement(SQL_CONSULTA);
            res = sen.executeQuery();
            while (res.next()) {
                String nombres = res.getString("nombres");
                String direccion = res.getString("direccion");
                String datosEnvio = res.getString("datosEnvio");
                String id_Usuario = res.getString("id_Usuario");
                int documento = res.getInt("documento");
                cliente = new clienteDTO(nombres, direccion, datosEnvio, id_Usuario, documento);
                clientes.add(cliente);
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
        return clientes;
    }

    
    @Override
    public int crear(clienteDTO ClienteDTO) {
        Connection con = null;
        PreparedStatement sen = null;
        int registros = 0;
        try {
            con = BaseDeDatos.getConnection();
            sen = con.prepareStatement(SQL_INSERT);
            sen.setString(1, ClienteDTO.getNombres());
            sen.setString(2, ClienteDTO.getDireccion());
            sen.setString(3, ClienteDTO.getDatosEnvio());
            sen.setString(4,ClienteDTO.getId_Usuario());
            sen.setInt(5,ClienteDTO.getDocumento());
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
    public int actualizar(clienteDTO ClienteDTO) {
        Connection con = null;
        PreparedStatement sen = null;
        int registros = 0;
        try {
            con = BaseDeDatos.getConnection();
            sen=con.prepareStatement(SQL_UPDATE);
            sen.setString(1, ClienteDTO.getNombres());
            sen.setString(2, ClienteDTO.getDireccion());
            sen.setString(3,ClienteDTO.getDatosEnvio());
            sen.setString(4,ClienteDTO.getId_Usuario());
            sen.setInt(5,ClienteDTO.getDocumento());
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
    public int eliminar(clienteDTO ClienteDTO) {
        Connection con = null;
        PreparedStatement sen = null;
        int registros = 0;
        try {
            con = BaseDeDatos.getConnection();
            sen=con.prepareStatement(SQL_DELETE);
            sen.setInt(1, ClienteDTO.getDocumento());            
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
   

