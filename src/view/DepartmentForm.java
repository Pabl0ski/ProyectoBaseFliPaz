package view;

import controller.DepartmentController;
import model.Department;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class DepartmentForm extends JFrame {
    private JTextField departmentNameField;
    private DefaultListModel<Department> departmentListModel;
    private JList<Department> departmentList;

    public DepartmentForm() {
        setTitle("Department Management");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        departmentNameField = new JTextField();
        JButton addButton = new JButton("Add Department");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDepartment();
            }
        });

        departmentListModel = new DefaultListModel<>();
        departmentList = new JList<>(departmentListModel);
        loadDepartments();

        panel.add(departmentNameField, BorderLayout.NORTH);
        panel.add(new JScrollPane(departmentList), BorderLayout.CENTER);
        panel.add(addButton, BorderLayout.SOUTH);

        add(panel);
    }

    private void addDepartment() {
        String name = departmentNameField.getText();
        if (!name.isEmpty()) {
            Department department = new Department(name);
            DepartmentController departmentController = new DepartmentController();
            try {
                departmentController.addDepartment(department);
                departmentListModel.addElement(department);
                departmentNameField.setText("");
                JOptionPane.showMessageDialog(this, "Department added successfully!");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error adding department: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Department name cannot be empty.");
        }
    }

    private void loadDepartments() {
        DepartmentController departmentController = new DepartmentController();
        try {
            List<Department> departments = departmentController.getAllDepartments();
            for (Department dept : departments) {
                departmentListModel.addElement(dept);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading departments: " + e.getMessage());
        }
    }
}
