package controller;

import model.ConexionDB;
import view.ClientePanel;
import view.LocalidadPanel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocalidadController {
    private LocalidadPanel localidadPanel;
    private ClientePanel clientePanel; // Agregamos referencia al panel de clientes

    public LocalidadController(LocalidadPanel localidadPanel, ClientePanel clientePanel) {
        this.localidadPanel = localidadPanel;
        this.clientePanel = clientePanel; // Guardamos referencia
        initController();
    }

    private void initController() {
        localidadPanel.getBtnAgregarLocalidad().addActionListener(e -> agregarLocalidad());
        cargarLocalidades();
    }

    private void agregarLocalidad() {
        String nombreLocalidad = localidadPanel.getTxtNombreLocalidad().getText().trim();
        if(nombreLocalidad.isEmpty()){
            JOptionPane.showMessageDialog(localidadPanel, "El nombre de la localidad no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(insertarLocalidadEnDB(nombreLocalidad)){
            localidadPanel.getListModel().addElement(nombreLocalidad);
            localidadPanel.getTxtNombreLocalidad().setText("");
            JOptionPane.showMessageDialog(localidadPanel, "Localidad agregada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            cargarLocalidades(); // Volvemos a cargar las localidades para actualizar la UI
        } else {
            JOptionPane.showMessageDialog(localidadPanel, "Error al agregar la localidad", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean insertarLocalidadEnDB(String nombreLocalidad) {
        String sql = "INSERT INTO localidades (nombre) VALUES (?)";
        try(Connection con = ConexionDB.getConexion();
            PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, nombreLocalidad);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // Método para cargar las localidades en la lista y en el ClientePanel
    private void cargarLocalidades() {
        List<String> localidades = new ArrayList<>();
        try (Connection con = ConexionDB.getConexion();
             PreparedStatement pst = con.prepareStatement("SELECT nombre FROM localidades");
             ResultSet rs = pst.executeQuery()) {

            localidadPanel.getListModel().clear(); // Limpia la lista antes de cargar nuevas localidades
            while (rs.next()) {
                String nombreLocalidad = rs.getString("nombre");
                localidades.add(nombreLocalidad);
                localidadPanel.getListModel().addElement(nombreLocalidad);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        // Actualizamos el JComboBox de ClientePanel
        clientePanel.cargarLocalidades(localidades);
    }
}
