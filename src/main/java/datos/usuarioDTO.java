/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author santi
 */
public class usuarioDTO {
    private String id;
    private String contraseña;

    public usuarioDTO() {
    }

    public usuarioDTO(String nid, String contraseña) {
        this.id = nid;
        this.contraseña = contraseña;
    }

    public String getid() {
        return id;
    }

    public void setid(String nid) {
        this.id = nid;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "usuarioDTO{" + "id=" + id + ", contrase\u00f1a=" + contraseña + '}';
    }

    
}
