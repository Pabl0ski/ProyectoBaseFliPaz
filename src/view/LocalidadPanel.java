package view;

import javax.swing.*;
import java.awt.*;

public class LocalidadPanel extends JPanel {
    private JTextField txtNombreLocalidad;
    private JButton btnAgregarLocalidad;
    private JList<String> listLocalidades;
    private DefaultListModel<String> listModel;

    public LocalidadPanel() {
        setLayout(new BorderLayout());
        initComponents();
    }

    private void initComponents() {
        // Panel para agregar una nueva localidad
        JPanel formPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        formPanel.add(new JLabel("Nombre de la Localidad:"));
        txtNombreLocalidad = new JTextField(20);
        formPanel.add(txtNombreLocalidad);
        btnAgregarLocalidad = new JButton("Agregar Localidad");
        formPanel.add(btnAgregarLocalidad);
        add(formPanel, BorderLayout.NORTH);

        // Panel para visualizar las localidades agregadas
        listModel = new DefaultListModel<>();
        listLocalidades = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(listLocalidades);
        add(scrollPane, BorderLayout.CENTER);
    }

    // Getters para utilizar en el controlador
    public JTextField getTxtNombreLocalidad() {
        return txtNombreLocalidad;
    }

    public JButton getBtnAgregarLocalidad() {
        return btnAgregarLocalidad;
    }

    public DefaultListModel<String> getListModel() {
        return listModel;
    }
}
