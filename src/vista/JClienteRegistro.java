/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import Logica.LogicaInventario;
import Modelo.Cliente;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author German Ballestero
 */
public class JClienteRegistro extends JDialog implements ActionListener{

    private Container contenedor;

    private JLabel lbId, lbNombre, lbTelefono, lbEdad,lbDirecccion;

    private JButton btnguardar, btnCancelar;

    private JTextField txtId, txtNombre, txtTelefono, txtEdad, txtDireccion;

    private JComboBox cmbTipo;

    private LogicaInventario logica;

    public JClienteRegistro(JFrame owner, String title, boolean modal) {
        super(owner, title, modal);
        this.logica = new LogicaInventario();
        this.initComponentes();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public void initComponentes() {

        this.contenedor = this.getContentPane();
        this.contenedor.setLayout(new BorderLayout());
        this.crearPanelDatos();
        this.panelBotones();

    }

    public void panelBotones() {

        JPanel panelGrid = new JPanel();
        panelGrid.setLayout(new GridLayout(5, 1, 5, 5));

        this.btnguardar = new JButton("   Guardar   ");
        this.btnguardar.addActionListener(this);
        this.btnCancelar = new JButton("  Cancelar  ");
        this.btnCancelar.addActionListener(this);
       
        
        panelGrid.add(this.btnguardar);
        panelGrid.add(this.btnCancelar);

        JPanel panel = new JPanel();
        panel.add(panelGrid);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        this.contenedor.add(panel, BorderLayout.EAST);

    }

    public void crearPanelDatos() {
        /*
            private String nombre;
            private String id;
            private long telefono;
            private int edad;
            private String direccion;
        */
        
        JPanel panelGrid = new JPanel();
        panelGrid.setLayout(new GridLayout(8, 2, 5, 5));

        this.lbId = new JLabel("Id: ");
        this.lbNombre = new JLabel("Nombre: ");
        this.lbTelefono = new JLabel("Telefono: ");
        this.lbEdad = new JLabel("Edad: ");
        this.lbDirecccion= new JLabel("Direccion: ");
        
        this.txtId= new JTextField(20);
        this.txtNombre = new JTextField();
        this.txtTelefono = new JTextField();
        this.txtEdad = new JTextField();
        this.txtDireccion = new JTextField();
        
        panelGrid.add(this.lbId);
        panelGrid.add(this.txtId);

        panelGrid.add(this.lbNombre);
        panelGrid.add(this.txtNombre);

        panelGrid.add(this.lbTelefono);
        panelGrid.add(this.txtTelefono);

        panelGrid.add(this.lbEdad);
        panelGrid.add(this.txtEdad);
        
        panelGrid.add(this.lbDirecccion);
        panelGrid.add(this.txtDireccion);

        panelGrid.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        this.contenedor.add(panelGrid, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.btnguardar) {   
            try {
                Cliente v = new Cliente(this.txtNombre.getText(),this.txtId.getText(),Integer.parseInt(this.txtTelefono.getText()),Integer.parseInt(this.txtEdad.getText()),this.txtDireccion.getText());
                this.logica.registrarCliente(v);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this,"registro exitoso", "Confirmacion",JOptionPane.INFORMATION_MESSAGE);
                this.cancelar();
            }
        } else if (e.getSource() == this.btnCancelar) {
            this.cancelar();
//            JOptionPane.showMessageDialog(this, "Click sobre cancelar");
        } else {
            //JOptionPane.showMessageDialog(this, "Click sobre combo");
            //this.activarComponentes();
        }

    }

    private void leerDatosVehiculo() {

    }


    
    private void cancelar(){
            /*this.txtPlaca.setText(null); 
            this.txtPrecioKm.setText(null);
            this.txtkmRenta.setText(null);
            this.txtKmDev.setText(null);*/
    }

    
    
}
