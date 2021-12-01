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
public class AdminDTO {
    private String nombreAdmin;
    private String id_Usuario;

    public AdminDTO() {
    }

    public AdminDTO(String nombreAdmin, String id_Usuario) {
        this.nombreAdmin = nombreAdmin;
        this.id_Usuario = id_Usuario;
    }

    public String getNombreAdmin() {
        return nombreAdmin;
    }

    public void setNombreAdmin(String nombreAdmin) {
        this.nombreAdmin = nombreAdmin;
    }

    public String getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(String id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    @Override
    public String toString() {
        return "AdminDTO{" + "nombreAdmin=" + nombreAdmin + ", id_Usuario=" + id_Usuario + '}';
    }
    
}
