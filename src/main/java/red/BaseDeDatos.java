/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package red;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author santi
 */
public class BaseDeDatos {
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/tortas?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";  
    public static final String DB_USER = "root";
        public static final String DB_CLAVE = "Morenito10";
        
    public static DataSource getDataSource(){
    BasicDataSource bs = new BasicDataSource();   
    bs.setUrl(JDBC_URL);
    bs.setUsername(DB_USER);
    bs.setPassword(DB_CLAVE);
    bs.setInitialSize(5);
    return bs;
    }
    public static Connection getConnection() throws SQLException{
       return getDataSource().getConnection();
   } 
   
   public static void close(Connection con) throws SQLException{
       con.close();
   }
   
   public static void close(Statement stm) throws SQLException{
       stm.close();
   }
   
   public static void close(ResultSet res) throws SQLException{
       res.close();
   }
   public static void close(PreparedStatement ps) throws SQLException{
      ps.close(); 
   }
}
