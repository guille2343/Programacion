/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import Logica.LogicaInventario;
import Modelo.Producto;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jairo F
 */
public class JDProdctoRegistro extends JDialog implements ActionListener {

    private Container contenedor;

    private JLabel lbCodigo, lbNombre, lbValor, lbCantidad;

    private JButton btnguardar, btnCancelar, btnEliminar, btnEditar;

    private JTextField txtCodigo, txtNombre, txtValor, txtCantidad;

    private JComboBox cmbTipo;

    private LogicaInventario logica;

    public JDProdctoRegistro(JFrame owner, String title, boolean modal) {
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
        

        this.btnEliminar = new JButton("  Eliminar  ");
        this.btnEliminar.setEnabled(false);
        this.btnEditar = new JButton("  Editar  ");
        this.btnEditar.setEnabled(false);
        
        panelGrid.add(this.btnguardar);
        panelGrid.add(this.btnCancelar);
        panelGrid.add(this.btnEditar);
        panelGrid.add(this.btnEliminar);

        JPanel panel = new JPanel();
        panel.add(panelGrid);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        this.contenedor.add(panel, BorderLayout.EAST);

    }

    public void crearPanelDatos() {

        JPanel panelGrid = new JPanel();
        panelGrid.setLayout(new GridLayout(8, 2, 5, 5));

        this.lbCodigo = new JLabel("Codigo: ");
        this.lbNombre = new JLabel("Nombre: ");
        this.lbValor = new JLabel("Valor: ");
        this.lbCantidad = new JLabel("Cantidad: ");

        this.txtCodigo= new JTextField(20);

        this.txtNombre = new JTextField();
        this.txtValor = new JTextField();
        this.txtCantidad = new JTextField();

        panelGrid.add(this.lbCodigo);
        panelGrid.add(this.txtCodigo);

        panelGrid.add(this.lbNombre);
        panelGrid.add(this.txtNombre);

        panelGrid.add(this.lbValor);
        panelGrid.add(this.txtValor);

        panelGrid.add(this.lbCantidad);
        panelGrid.add(this.txtCantidad);

        panelGrid.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        this.contenedor.add(panelGrid, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.btnguardar) {   
            try {
                Producto v = new Producto(this.txtNombre.getText(),Integer.parseInt(this.txtCantidad.getText()),this.txtCodigo.getText(),Integer.parseInt(this.txtCantidad.getText()));
                this.logica.registrarProducto(v);
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
