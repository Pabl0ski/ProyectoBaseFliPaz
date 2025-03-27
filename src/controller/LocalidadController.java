package controller;

import model.ConexionDB;
import view.LocalidadPanel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LocalidadController {
    private LocalidadPanel localidadPanel;

    public LocalidadController(LocalidadPanel localidadPanel) {
        this.localidadPanel = localidadPanel;
        initController();
    }

    private void initController() {
        localidadPanel.getBtnAgregarLocalidad().addActionListener(e -> agregarLocalidad());
        cargarLocalidades(); // Implementa este método para cargar las localidades existentes desde la BD.
    }

    private void agregarLocalidad() {
        String nombreLocalidad = localidadPanel.getTxtNombreLocalidad().getText().trim();
        if(nombreLocalidad.isEmpty()){
            JOptionPane.showMessageDialog(localidadPanel, "El nombre de la localidad no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Insertar en la base de datos
        if(insertarLocalidadEnDB(nombreLocalidad)){
            // Agregar la localidad a la lista visual
            localidadPanel.getListModel().addElement(nombreLocalidad);
            localidadPanel.getTxtNombreLocalidad().setText("");
            JOptionPane.showMessageDialog(localidadPanel, "Localidad agregada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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

    private void cargarLocalidades() {
        // Aquí podrías implementar la carga de localidades desde la BD y añadirlas a localidadPanel.getListModel()
    }
}
