package view;

import javax.swing.*;
import java.awt.*;

public class ClientePanel extends JPanel {
    private JTextField txtIdCliente, txtNombreEmpresa, txtEmail, txtPaginaWeb, txtTelefono;
    private JTextField txtNombreContacto, txtInstagram, txtFacebook, txtCanalYoutube;
    private JComboBox<String> cbSector, cbLocalidad;
    private JButton btnGuardar;

    public ClientePanel() {
        setLayout(new BorderLayout());
        initComponents();
    }

    private void initComponents() {
        JPanel formPanel = new JPanel(new GridLayout(0, 2, 5, 5));

        formPanel.add(new JLabel("ID Cliente:"));
        txtIdCliente = new JTextField();
        formPanel.add(txtIdCliente);

        formPanel.add(new JLabel("Nombre Empresa:"));
        txtNombreEmpresa = new JTextField();
        formPanel.add(txtNombreEmpresa);

        formPanel.add(new JLabel("Email:"));
        txtEmail = new JTextField();
        formPanel.add(txtEmail);

        formPanel.add(new JLabel("Página Web:"));
        txtPaginaWeb = new JTextField();
        formPanel.add(txtPaginaWeb);

        formPanel.add(new JLabel("Teléfono:"));
        txtTelefono = new JTextField();
        formPanel.add(txtTelefono);

        formPanel.add(new JLabel("Nombre Contacto:"));
        txtNombreContacto = new JTextField();
        formPanel.add(txtNombreContacto);

        formPanel.add(new JLabel("Instagram:"));
        txtInstagram = new JTextField();
        formPanel.add(txtInstagram);

        formPanel.add(new JLabel("Facebook:"));
        txtFacebook = new JTextField();
        formPanel.add(txtFacebook);

        formPanel.add(new JLabel("Canal YouTube:"));
        txtCanalYoutube = new JTextField();
        formPanel.add(txtCanalYoutube);

        formPanel.add(new JLabel("Sector:"));
        cbSector = new JComboBox<>(new String[]{
                "Centro_Estetica", "Centros_Fisioterapia", "Centros_TerapiasComplementarias",
                "Centros_TerapiasMedicas", "Clinicas/Esteticas", "Depilacion",
                "Manicura", "Peluquerias", "Talleres_Automocion"
        });
        formPanel.add(cbSector);

        formPanel.add(new JLabel("Localidad:"));
        cbLocalidad = new JComboBox<>(new String[]{
                "Almeria", "Avila", "Barcelona", "Bilbao", "Cadiz", "Ciudad_Real",
                "Cordoba", "Cuenca", "Gerona", "Granada", "Guadalajara", "Huelva",
                "Jaen", "LaCoruña", "Lerida", "Lugo", "Malaga", "Orense", "Pontevedra",
                "Salamanca", "SanSebastian", "Santander", "Segovia", "Sevilla", "Tarragona",
                "Teruel", "Toledo", "Valladolid", "Vitoria", "Zaragoza"
        });
        formPanel.add(cbLocalidad);

        add(formPanel, BorderLayout.CENTER);

        btnGuardar = new JButton("Guardar Cliente");
        add(btnGuardar, BorderLayout.SOUTH);

        // Aquí se pueden agregar validaciones de campos y mensajes para el usuario.
    }
}
