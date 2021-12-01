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
public interface CarritoServices {
    public List<CarritoDTO> consultar(); 
    public int crear(CarritoDTO carritoDTO);
    public int actualizar(CarritoDTO carritoDTO);
    public int eliminar(CarritoDTO carritoDTO);
}
