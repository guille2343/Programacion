/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author German Ballestero
 */
public class ListaProducto implements invProducto{
    private List<Producto> listaProductos;

    public ListaProducto() {
        this.listaProductos = new ArrayList();
    }
    
    
    
   @Override
   public void registrarProducto (Producto p){
       this.listaProductos.add(p);
   }
   
   @Override
   public Producto buscarProducto(String codigo){
       for (Producto p : listaProductos){
           if(p.getCodigo().equalsIgnoreCase(codigo)){
               return p;
           }
       }
       
       return null;
       
   }
   
   @Override
   public List<Producto> mostrarListaProducto(){
       return this.listaProductos;
   }
}
