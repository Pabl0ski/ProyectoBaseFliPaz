package view;

import javax.swing.*;
import java.awt.*;

public class SectorPanel extends JPanel {
    private JTextField txtNombreSector;
    private JButton btnAgregarSector;
    private JList<String> listSectores;
    private DefaultListModel<String> listModel;

    public SectorPanel() {
        setLayout(new BorderLayout());
        initComponents();
    }

    private void initComponents() {
        // Panel para agregar un nuevo sector
        JPanel formPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        formPanel.add(new JLabel("Nombre del Sector:"));
        txtNombreSector = new JTextField(20);
        formPanel.add(txtNombreSector);
        btnAgregarSector = new JButton("Agregar Sector");
        formPanel.add(btnAgregarSector);
        add(formPanel, BorderLayout.NORTH);

        // Panel para visualizar los sectores agregados
        listModel = new DefaultListModel<>();
        listSectores = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(listSectores);
        add(scrollPane, BorderLayout.CENTER);
    }

    // Getters para utilizar en el controlador
    public JTextField getTxtNombreSector() {
        return txtNombreSector;
    }

    public JButton getBtnAgregarSector() {
        return btnAgregarSector;
    }

    public DefaultListModel<String> getListModel() {
        return listModel;
    }
}
