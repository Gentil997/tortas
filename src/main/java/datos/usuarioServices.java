/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.List;

/**
 *
 * @author santi
 */
public interface usuarioServices {
    public List<usuarioDTO> consultar(); 
    public int crear(usuarioDTO usuarioDTO);
    public int actualizar(usuarioDTO usuarioDTO);
    public int eliminar(usuarioDTO usuarioDTO);
}
