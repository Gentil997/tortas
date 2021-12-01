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
 * @author santi
 */
public class usuarioDAO implements usuarioServices{
    public static final String SQL_CONSULTA = "SELECT id, contraseña FROM usuario";
    public static final String SQL_CREAR = "INSERT INTO usuario (id, contraseña) VALUES (?,?)";
    public static final String SQL_ELIMINAR = "DELETE FROM usuario WHERE id = ?";
    public static final String SQL_ACTUALIZAR = "UPDATE usuario SET contraseña = ? WHERE id = ? "; 
    
    
    
    
    @Override
    public List<usuarioDTO> consultar() {
        
    Connection con = null;
        PreparedStatement sen = null;
        ResultSet res = null;
        usuarioDTO usuario = null;
        List<usuarioDTO> usuarios = new ArrayList<>();
        try {
            con = BaseDeDatos.getConnection();
            sen = con.prepareStatement(SQL_CONSULTA);
            res = sen.executeQuery();
            while (res.next()) {
                String id = res.getString("id");
                String contraseña = res.getString("contraseña");
                usuario = new usuarioDTO(id,contraseña);
                usuarios.add(usuario);
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
        return usuarios;
    }

    @Override
    public int crear(usuarioDTO usuarioDTO) {
       Connection con = null;
        PreparedStatement sen = null;
        int c = 0;
        
        
        try {
            con = BaseDeDatos.getConnection();
            sen = con.prepareStatement(SQL_CREAR);
            sen.setString(1, usuarioDTO.getContraseña());
            sen.setString(2, usuarioDTO.getid());
            
            
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
    public int actualizar(usuarioDTO usuarioDTO) {
        Connection con = null;
        PreparedStatement sen = null;
        int c = 0;
        
        
        try {
            con = BaseDeDatos.getConnection();
            sen = con.prepareStatement(SQL_ACTUALIZAR);
            
            
            sen.setString(1, usuarioDTO.getid());
            sen.setString(2, usuarioDTO.getContraseña());
            
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
    public int eliminar(usuarioDTO usuarioDTO) {
       Connection con = null;
        PreparedStatement sen = null;
        int c = 0;
       try{
           con = BaseDeDatos.getConnection();
           sen = con.prepareStatement(SQL_ELIMINAR);
           
           sen.setString(1, usuarioDTO.getid());
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
    

