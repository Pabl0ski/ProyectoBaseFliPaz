package view;

import controller.LocalidadController;
import controller.SectorController;

import javax.swing.*;

public class MainFrame extends JFrame {
    private JTabbedPane tabbedPane;
    private ClientePanel clientePanel;
    private SectorPanel sectorPanel;
    private LocalidadPanel localidadPanel;

    public MainFrame() {
        setTitle("Gestión de Clientes, Sectores y Localidades");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        initComponents();
        new SectorController(sectorPanel);
        new LocalidadController(localidadPanel, clientePanel); // Pasamos clientePanel para actualizar localidades
    }

    private void initComponents() {
        tabbedPane = new JTabbedPane();

        clientePanel = new ClientePanel();
        sectorPanel = new SectorPanel();
        localidadPanel = new LocalidadPanel();

        tabbedPane.addTab("Clientes", clientePanel);
        tabbedPane.addTab("Sectores", sectorPanel);
        tabbedPane.addTab("Localidades", localidadPanel);

        add(tabbedPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}
