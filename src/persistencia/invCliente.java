/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import Modelo.Cliente;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author German Ballestero
 */
public interface invCliente {
    void registrarCliente(Cliente c)throws IOException;
    Cliente buscarCliente(String codigo) throws IOException;
    List<Cliente> mostrarListaCliente()throws IOException;

}
