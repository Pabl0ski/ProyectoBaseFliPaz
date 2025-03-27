package view;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ClientePanel extends JPanel {
    private JTextField txtNombre, txtApellido, txtEmail, txtTelefono;
    private JComboBox<String> comboLocalidad; // Para seleccionar la localidad
    private JComboBox<String> comboSector; // Para seleccionar el sector
    private JButton btnAgregarCliente;

    public ClientePanel() {
        setLayout(new GridLayout(7, 2, 5, 5)); // Ajustamos el layout
        initComponents();
    }

    private void initComponents() {
        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Apellido:"));
        txtApellido = new JTextField();
        add(txtApellido);

        add(new JLabel("Email:"));
        txtEmail = new JTextField();
        add(txtEmail);

        add(new JLabel("Teléfono:"));
        txtTelefono = new JTextField();
        add(txtTelefono);

        add(new JLabel("Localidad:"));
        comboLocalidad = new JComboBox<>();
        add(comboLocalidad);

        add(new JLabel("Sector:"));
        comboSector = new JComboBox<>();
        add(comboSector);

        btnAgregarCliente = new JButton("Agregar Cliente");
        add(btnAgregarCliente);
    }

    // Método para cargar localidades en el comboBox
    public void cargarLocalidades(List<String> localidades) {
        comboLocalidad.removeAllItems(); // Limpia el JComboBox antes de cargar nuevas localidades
        for (String localidad : localidades) {
            comboLocalidad.addItem(localidad);
        }
    }

    // Getters
    public JComboBox<String> getComboLocalidad() {
        return comboLocalidad;
    }

    public JButton getBtnAgregarCliente() {
        return btnAgregarCliente;
    }
}
