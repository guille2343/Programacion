/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Cliente;
import Modelo.Producto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author German Ballestero
 */
public class ListaCliente implements invCliente, Serializable{
    private List<Cliente> listaCliente;

    public ListaCliente() {
    this.listaCliente = new ArrayList();
    }
    
    
    @Override
    public void registrarCliente(Cliente c){
        this.listaCliente.add(c);
    }
    
    @Override
    public Cliente buscarCliente(String codigo){
        for(Cliente c : listaCliente){
            if(c.getId().equalsIgnoreCase(codigo)){
                return c;
            }
        }
        
        return null;
        
    }
    
    @Override
    public List<Cliente> mostrarListaCliente(){
        return this.listaCliente;
    }
    

}
