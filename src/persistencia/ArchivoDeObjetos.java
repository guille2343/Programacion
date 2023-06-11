/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Cliente;
import java.io.*;
import Modelo.Producto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 *
 * @author German Ballestero
 */
public class ArchivoDeObjetos implements invCliente, invProducto {
    private File Archivo;
    private FileInputStream ArLectura;
    private FileOutputStream ArEscritura;
    private ListaCliente listaclientes;
    private ListaProducto listaProductos;

    public ArchivoDeObjetos(String nombre) {
       this.Archivo = new File (nombre);       
    }

    public ArchivoDeObjetos() {
        this("producto.obj");
    }    
   // @Override

    
    private void leerListaCliente()throws IOException{
        System.out.println("voy 3");
        if(!this.Archivo.exists()){
            this.listaclientes = new ListaCliente();
        }else{
            ObjectInputStream ois = null;
            try{
                System.out.println(this.Archivo);
                this.ArLectura = new FileInputStream(this.Archivo);
                System.out.println("voy 5");
                ois = new ObjectInputStream (this.ArLectura);
                System.out.println(ois.readObject());
                this.listaclientes = (ListaCliente) ois.readObject();
                System.out.println(this.listaclientes );
            }catch(IOException ioe){
                throw new IOException("El archivo no existe o no pudo ser leido");
            }catch(ClassNotFoundException ex){
                throw new IOException("El formato de archivo no es correcto, no es una lista de productos");
            }finally{
                if(ois != null){
                    ois.close();
                }
                if (this.ArLectura != null) {
                    this.ArLectura.close();
                }
            }
        }
        
    }
    
    
    private void leerListaProducto()throws IOException{
        
        if(!this.Archivo.exists()){
            this.listaProductos = new ListaProducto();
        }else{
            ObjectInputStream ois = null;
            try{
                this.ArLectura = new FileInputStream(this.Archivo);
                ois = new ObjectInputStream (this.ArLectura);
                this.listaProductos = (ListaProducto) ois.readObject();
            }catch(IOException ioe){
                throw new IOException("El archivo no existe o no pudo ser leido");
            }catch(ClassNotFoundException ex){
                throw new IOException("El formato de archivo no es correcto, no es una lista de productos");
            }finally{
                if(ois != null){
                    ois.close();
                }
                if (this.ArLectura != null) {
                    this.ArLectura.close();
                }
            }
        }    
    }
    
    private void guardarListaProducto() throws IOException {
        ObjectOutputStream oos = null;
        try {
            this.ArEscritura = new FileOutputStream(this.Archivo);
            oos = new ObjectOutputStream(this.ArEscritura);
            oos.writeObject(this.listaProductos);
            System.out.println("voy");
            System.out.println(this.listaProductos);
        } catch (IOException ioe) {
            throw new IOException("No es posible crear el archivo para escritura");
        } finally {
            if (oos != null) {
                oos.close();
            }
            if (this.ArEscritura != null) {
                this.ArEscritura.close();
            }
        }

    }
     
    private void guardarListaCliente() throws IOException {
        ObjectOutputStream oos = null;
        try {
            this.ArEscritura = new FileOutputStream(this.Archivo);
            oos = new ObjectOutputStream(this.ArEscritura);
            oos.writeObject(this.listaclientes);

        } catch (IOException ioe) {
            throw new IOException("No es posible crear el archivo para escritura");
        } finally {
            if (oos != null) {
                oos.close();
            }
            if (this.ArEscritura != null) {
                this.ArEscritura.close();
            }
        }

    }
    
    @Override
    public void registrarProducto(Producto p)throws IOException{
        this.leerListaProducto();
        this.listaProductos.registrarProducto(p);
        this.guardarListaProducto();
    }
    
    @Override
    public Producto buscarProducto(String codigo)throws IOException{
        this.leerListaProducto();
        return this.listaProductos.buscarProducto(codigo);
    }
    
    @Override
    public List<Producto> mostrarListaProducto()throws IOException{
        this.leerListaProducto();
        return this.listaProductos.mostrarListaProducto();
    }
    
    @Override
    public void registrarCliente(Cliente c)throws IOException{
        this.leerListaCliente();
        this.listaclientes.registrarCliente(c);
        this.guardarListaCliente();
    }
    
    @Override
    public Cliente buscarCliente(String codigo) throws IOException{
        this.leerListaCliente();
        return this.listaclientes.buscarCliente(codigo);
    }
    
    @Override
    public List<Cliente> mostrarListaCliente()throws IOException{
        this.leerListaCliente();
        System.out.println(this.listaclientes.mostrarListaCliente());
        return this.listaclientes.mostrarListaCliente();
                
    }
}
    


