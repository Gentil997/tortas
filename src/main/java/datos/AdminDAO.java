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
public class AdminDAO implements AdminServices{
    public static final String SQL_CONSULTA = "SELECT id_Usuario ,nombreAdmin FROM admin";
    public static final String SQL_CREAR = "INSERT INTO admin (id_Usuario ,nombreAdmin) VALUES (?,?)";
    public static final String SQL_ELIMINAR = "DELETE FROM admin WHERE id = ?";
    public static final String SQL_ACTUALIZAR = "UPDATE admin SET nombreAdmin = ? WHERE id_Usuario = ? "; 
    
    
    
    @Override
    public List<AdminDTO> consultar() {
        
    Connection con = null;
        PreparedStatement sen = null;
        ResultSet res = null;
        AdminDTO admin = null;
        List<AdminDTO> admins = new ArrayList<>();
        try {
            con = BaseDeDatos.getConnection();
            sen = con.prepareStatement(SQL_CONSULTA);
            res = sen.executeQuery();
            while (res.next()) {
                String nombreAdmin= res.getString("nombreAdmin");
                String id_Usuario = res.getString("id_Usuario");
                admin= new AdminDTO(nombreAdmin,id_Usuario);
                admins.add(admin);
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
        return admins;
    }

    @Override
    public int crear(AdminDTO adminDTO) {
       Connection con = null;
        PreparedStatement sen = null;
        int c = 0;
        
        List<AdminDTO> admin = new ArrayList<>();
        try {
            con = BaseDeDatos.getConnection();
            sen = con.prepareStatement(SQL_CREAR);
            sen.setString(1, adminDTO.getId_Usuario());
            sen.setString(2, adminDTO.getNombreAdmin());
            
            
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
    public int actualizar(AdminDTO adminDTO) {
        Connection con = null;
        PreparedStatement sen = null;
        int c = 0;
        
        List<AdminDTO> admins = new ArrayList<>();
        try {
            con = BaseDeDatos.getConnection();
            sen = con.prepareStatement(SQL_ACTUALIZAR);
            
            
            sen.setString(1, adminDTO.getNombreAdmin());
            sen.setString(2, adminDTO.getId_Usuario());
            
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
    public int eliminar(AdminDTO adminDTO) {
       Connection con = null;
        PreparedStatement sen = null;
        int c = 0;
       try{
           con = BaseDeDatos.getConnection();
           sen = con.prepareStatement(SQL_ELIMINAR);
           
           sen.setString(1, adminDTO.getId_Usuario());
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
    

