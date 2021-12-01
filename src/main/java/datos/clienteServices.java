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
public interface clienteServices {
    public List<clienteDTO> consultar(); 
    public int crear(clienteDTO ClienteDTO);
    public int actualizar(clienteDTO ClienteDTO);
    public int eliminar(clienteDTO ClienteDTO); 

}
