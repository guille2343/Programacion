/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Modelo.Cliente;
import Modelo.Producto;
import Persistencia.ArchivoDeObjetos;
import Persistencia.invCliente;
import Persistencia.invProducto;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author German Ballestero
 */
public class LogicaInventario {
    private invCliente datosCliente;
    private invProducto datosProducto;
    
    public LogicaInventario(){    
        this.datosCliente = new ArchivoDeObjetos("cliente.obj");
        this.datosProducto = new ArchivoDeObjetos("producto.obj");
    }
    
    public void registrarProducto(Producto p)throws IOException{
        this.datosProducto.registrarProducto(p);
    }
    
    public Producto buscarProducto(String codigo)throws IOException{
       return this.datosProducto.buscarProducto(codigo);
    }
    
    public List<Producto> mostrarListaProducto()throws IOException{
        return this.datosProducto.mostrarListaProducto();
    }
    
    public void registrarCliente(Cliente c)throws IOException{
        this.datosCliente.registrarCliente(c);
    }
    
    public Cliente buscarCliente(String codigo) throws IOException{
        return this.datosCliente.buscarCliente(codigo);
    }
    
    public List<Cliente> mostrarListaCliente()throws IOException{
        System.out.println("voy 2");
        return this.datosCliente.mostrarListaCliente();
    }
}


//https://github.com/guille2343/Programacion.git