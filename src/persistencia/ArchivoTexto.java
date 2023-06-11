/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import Modelo.Cliente;
import Modelo.Producto;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author German Ballestero
 */
    public class ArchivoTexto/* implements invProducto */{
    private File archivo;
    private FileWriter aEscritura; 
    private Scanner aLectura;

    public ArchivoTexto() {
        this("Archivo.dat");
    }
    
    public ArchivoTexto(String name) {
        this.archivo = new File(name);
    }
    
    public void registrarProducto(Producto p)throws IOException{
        
    }
    
    public Producto buscarProducto(String codigo)throws IOException{
        
        return null;
        
    }
    
    public List<Producto> mostrarListaProducto()throws IOException{
        
        return null;
        
    }
}
