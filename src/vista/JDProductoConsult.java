/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import Logica.LogicaInventario;
import Modelo.Cliente;
import Modelo.Producto;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author German Ballestero
 */
public class JDProductoConsult extends JDialog{
    private Container contenedor;

    private JLabel lbTipovehiculo;
    private JComboBox cmbTipo;

    private JTable tabla;
    private DefaultTableModel modeloTabla;
    private String[] titulos = {"CODIGO","NOMBRE", "CANTIDAD", "VALOR"};
    private String[][] datosTabla = null;
    private LogicaInventario logica;

    public JDProductoConsult(JFrame owner, String title, boolean modal) {
        super(owner, title, modal);
        this.logica = new LogicaInventario();
        this.initComponentes();
        //this.pack();
        this.setSize(900, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }

    private void initComponentes() {

        this.contenedor = this.getContentPane();
        this.setLayout(new BorderLayout());
        this.panelBusqueda();
        this.panelResultados();

    }

    private void panelBusqueda() {

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.contenedor.add(panel, BorderLayout.NORTH);

    }

    private void panelResultados() {

        JScrollPane panel = new JScrollPane();

        this.tabla = new JTable();
        this.modeloTabla = new DefaultTableModel(this.datosTabla, this.titulos);
        this.tabla.setModel(this.modeloTabla);

        panel.setViewportView(this.tabla);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.contenedor.add(panel, BorderLayout.CENTER);
        
        this.loadTable();

    }

    class EventoClickComboTIpo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            verOpcionSeleccionada();

        }

    }

    private void verOpcionSeleccionada() {

        loadTable();
        
    }

    public void loadTable() {

        try {
            System.out.println("voy");
            List<Producto> list = this.logica.mostrarListaProducto();
            System.out.println(list);
            this.datosTabla=new String[list.size()][];
            int i=0;
            String vehiculo = this.cmbTipo.getSelectedItem().toString();
            for(Producto p: list){
                String data[]=p.getDataForTable();
                if(vehiculo.equals(data[1])){
                  this.datosTabla[i]=p.getDataForTable();
                  i++;
                }
                 
            }
            this.modeloTabla.setDataVector(this.datosTabla, this.titulos);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar la tabla de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
    
}
