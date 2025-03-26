package view;

import controller.EmployeeController;
import controller.DepartmentController;
import model.Department;
import model.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class EmployeeForm extends JFrame {
    private JTextField firstNameField, lastName1Field, lastName2Field, dniField, salaryField, hireDateField;
    private JComboBox<Department> departmentComboBox;
    private JLabel photoLabel;
    private byte[] photoData;

    public EmployeeForm() {
        setTitle("Employee Management");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 2));

        panel.add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        panel.add(firstNameField);

        panel.add(new JLabel("Last Name 1:"));
        lastName1Field = new JTextField();
        panel.add(lastName1Field);

        panel.add(new JLabel("Last Name 2:"));
        lastName2Field = new JTextField();
        panel.add(lastName2Field);

        panel.add(new JLabel("DNI:"));
        dniField = new JTextField();
        panel.add(dniField);

        panel.add(new JLabel("Salary:"));
        salaryField = new JTextField();
        panel.add(salaryField);

        panel.add(new JLabel("Hire Date (YYYY-MM-DD):"));
        hireDateField = new JTextField();
        panel.add(hireDateField);

        panel.add(new JLabel("Department:"));
        departmentComboBox = new JComboBox<>();
        loadDepartments();
        panel.add(departmentComboBox);

        JButton uploadPhotoButton = new JButton("Upload Photo");
        uploadPhotoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                uploadPhoto();
            }
        });
        panel.add(uploadPhotoButton);

        photoLabel = new JLabel();
        panel.add(photoLabel);

        JButton saveButton = new JButton("Save Employee");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveEmployee();
            }
        });
        panel.add(saveButton);

        JButton manageDepartmentsButton = new JButton("Manage Departments");
        manageDepartmentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DepartmentForm();
            }
        });
        panel.add(manageDepartmentsButton);

        add(panel);
    }

    private void loadDepartments() {
        DepartmentController departmentController = new DepartmentController();
        try {
            List<Department> departments = departmentController.getAllDepartments();
            for (Department dept : departments) {
                departmentComboBox.addItem(dept);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading departments: " + e.getMessage());
        }
    }

    private void uploadPhoto() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (FileInputStream fis = new FileInputStream(file)) {
                photoData = fis.readAllBytes();
                photoLabel.setText("Photo uploaded: " + file.getName());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error uploading photo: " + e.getMessage());
            }
        }
    }

    private void saveEmployee() {
        String firstName = firstNameField.getText();
        String lastName1 = lastName1Field.getText();
        String lastName2 = lastName2Field.getText();
        String dni = dniField.getText();
        double salary = Double.parseDouble(salaryField.getText());
        Date hireDate = Date.valueOf(hireDateField.getText());
        Department department = (Department) departmentComboBox.getSelectedItem();

        Employee employee = new Employee(firstName, lastName1, lastName2, dni, salary, hireDate, department, photoData);
        EmployeeController employeeController = new EmployeeController();
        try {
            employeeController.addEmployee(employee);
            JOptionPane.showMessageDialog(this, "Employee saved successfully!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error saving employee: " + e.getMessage());
        }
    }
}