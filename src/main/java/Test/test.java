/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import datos.clienteDAO;
import datos.clienteDTO;
import datos.usuarioDAO;
import datos.usuarioDTO;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author santi
 */
public class test {
    public static void main(String[] args) {
        clienteDAO ad = new clienteDAO();
        ad.crear(new clienteDTO ("Pepito perez","Av del rio casa b 34","Luego de cruzar por el d1","PepitoP",555555555));
        List<clienteDTO> clientes = new ArrayList();
        clientes = ad.consultar();
        
        usuarioDAO op = new usuarioDAO();
        op.crear(new usuarioDTO ("juanjose","dfdqw"));
        List<usuarioDTO> usuarios = new ArrayList();
        usuarios = op.consultar();
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println("es igual a= "+usuarios.get(i).getid());
            
        }
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println("resultado= "+clientes.get(i).getNombres());
            
        }
    }
}
