/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import Modelo.Producto;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author German Ballestero
 */
public interface invProducto {
    void registrarProducto(Producto p)throws IOException;
    Producto buscarProducto(String codigo)throws IOException;
    List<Producto> mostrarListaProducto()throws IOException;
}
