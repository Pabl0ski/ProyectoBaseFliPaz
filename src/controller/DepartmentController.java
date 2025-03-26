package controller;

import model.DBConnection;
import model.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentController {
    public void addDepartment(Department department) throws SQLException {
        String sql = "INSERT INTO departments (name) VALUES (?)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, department.getName());
            stmt.executeUpdate();
        }
    }

    public List<Department> getAllDepartments() throws SQLException {
        List<Department> departments = new ArrayList<>();
        String sql = "SELECT * FROM departments";
        try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Department dept = new Department(rs.getInt("id"), rs.getString("name"));
                departments.add(dept);
            }
        }
        return departments;
    }
}