package controller;

import model.ConexionDB;
import view.SectorPanel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SectorController {
    private SectorPanel sectorPanel;

    public SectorController(SectorPanel sectorPanel) {
        this.sectorPanel = sectorPanel;
        initController();
    }

    private void initController() {
        sectorPanel.getBtnAgregarSector().addActionListener(e -> agregarSector());
        cargarSectores(); // Implementa este método si deseas cargar sectores existentes desde la BD.
    }

    private void agregarSector() {
        String nombreSector = sectorPanel.getTxtNombreSector().getText().trim();
        if(nombreSector.isEmpty()){
            JOptionPane.showMessageDialog(sectorPanel, "El nombre del sector no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Insertar en la base de datos
        if(insertarSectorEnDB(nombreSector)){
            // Agregar el sector a la lista visual
            sectorPanel.getListModel().addElement(nombreSector);
            sectorPanel.getTxtNombreSector().setText("");
            JOptionPane.showMessageDialog(sectorPanel, "Sector agregado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(sectorPanel, "Error al agregar el sector", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean insertarSectorEnDB(String nombreSector) {
        String sql = "INSERT INTO sectores (nombre) VALUES (?)";
        try(Connection con = ConexionDB.getConexion();
            PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, nombreSector);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private void cargarSectores() {
        // Aquí podrías implementar la carga de sectores desde la BD y añadirlos a sectorPanel.getListModel()
    }
}
