package controller;

import model.Cliente;
import model.ConexionDB;
import view.ClientePanel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteController {
    private ClientePanel clientePanel;

    public ClienteController(ClientePanel clientePanel) {
        this.clientePanel = clientePanel;
        // Aquí puedes añadir ActionListener al botón de guardar para recoger datos de la vista y guardarlos en la BD.
    }

    public boolean guardarCliente(Cliente cliente) {
        String sql = "INSERT INTO clientes (id_cliente, nombre_empresa, email, pagina_web, telefono, nombre_contacto, instagram, facebook, canal_youtube, sector_id, localidad_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = ConexionDB.getConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, cliente.getIdCliente());
            pst.setString(2, cliente.getNombreEmpresa());
            pst.setString(3, cliente.getEmail());
            pst.setString(4, cliente.getPaginaWeb());
            pst.setString(5, cliente.getTelefono());
            pst.setString(6, cliente.getNombreContacto());
            pst.setString(7, cliente.getInstagram());
            pst.setString(8, cliente.getFacebook());
            pst.setString(9, cliente.getCanalYoutube());
            pst.setInt(10, cliente.getSectorId());
            pst.setInt(11, cliente.getLocalidadId());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
