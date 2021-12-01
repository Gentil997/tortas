/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface PedidoServices {
  public List<PedidoDTO> consultar(); 
    public int crear(PedidoDTO pedidoDTO);
    public int actualizar(PedidoDTO pedidoDTO);
    public int eliminar(PedidoDTO pedidoDTO);  
}
