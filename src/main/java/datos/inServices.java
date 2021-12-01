/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;

import java.util.List;

/**
 *
 * @author raulg
 */
public interface inServices {
    
    public List<inPedidoDTO> consultar();
    public int crear(inPedidoDTO inDTO);
    public int actualizar(inPedidoDTO inDTO);
    public int eliminar(inPedidoDTO inDTO);
    
}
