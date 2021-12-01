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
public class clienteDTO {
   private String nombres;
   private String direccion; 
   private String datosEnvio;
   private String id_Usuario;
   private int documento;

    public clienteDTO() {
    }

    public clienteDTO(String nombres, String direccion, String datosEnvio, String id_Usuario, int documento) {
        this.nombres = nombres;
        this.direccion = direccion;
        this.datosEnvio = datosEnvio;
        this.id_Usuario = id_Usuario;
        this.documento = documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDatosEnvio() {
        return datosEnvio;
    }

    public void setDatosEnvio(String datosEnvio) {
        this.datosEnvio = datosEnvio;
    }

    public String getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(String id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    @Override
    public String toString() {
        return "clienteDTO{" + "nombres=" + nombres + ", direccion=" + direccion + ", datosEnvio=" + datosEnvio + ", id_Usuario=" + id_Usuario + ", documento=" + documento + '}';
    }
   
   
}
