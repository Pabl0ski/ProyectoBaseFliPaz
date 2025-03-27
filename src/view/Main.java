package view;

import controller.LocalidadController;
import controller.SectorController;

import javax.swing.*;

public class Main extends JFrame {
    private JTabbedPane tabbedPane;
    private ClientePanel clientePanel;
    private SectorPanel sectorPanel;
    private LocalidadPanel localidadPanel;

    public Main() {
        setTitle("Gestión de Clientes, Sectores y Localidades");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        initComponents();
        // Integración de controladores: instanciamos los controladores pasando los paneles correspondientes
        new SectorController(sectorPanel);
        new LocalidadController(localidadPanel);
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
            new Main().setVisible(true);
        });
    }
}
