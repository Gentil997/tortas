/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.List;

/**
 *
 * @author Jaider Cardenas
 */
public interface AdminServices {
    public List<AdminDTO> consultar(); 
    public int crear(AdminDTO adminDTO);
    public int actualizar(AdminDTO adminDTO);
    public int eliminar(AdminDTO adminDTO);
}
