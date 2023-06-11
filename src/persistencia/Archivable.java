/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import Modelo.Cliente;
import Modelo.Producto;

/**
 *
 * @author German Ballestero
 */
public interface Archivable {
    String getDataFileFormat(Producto p, Cliente c);
    String[] getDataForTable(Producto p, Cliente c);
    
}
