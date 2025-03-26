package controller;

import model.DBConnection;
import model.Employee;
import model.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeController {
    public void addEmployee(Employee employee) throws SQLException {
        String sql = "INSERT INTO employees (first_name, last_name1, last_name2, dni, salary, hire_date, department_id, photo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, employee.getFirstName());
            stmt.setString(2, employee.getLastName1());
            stmt.setString(3, employee.getLastName2());
            stmt.setString(4, employee.getDni());
            stmt.setDouble(5, employee.getSalary());
            stmt.setDate(6, employee.getHireDate());
            stmt.setInt(7, employee.getDepartment().getId());
            stmt.setBytes(8, employee.getPhoto());
            stmt.executeUpdate();
        }
    }

    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT e.*, d.name as dept_name FROM employees e JOIN departments d ON e.department_id = d.id";
        try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Department dept = new Department(rs.getInt("department_id"), rs.getString("dept_name"));
                Employee emp = new Employee(
                        rs.getString("first_name"),
                        rs.getString("last_name1"),
                        rs.getString("last_name2"),
                        rs.getString("dni"),
                        rs.getDouble("salary"),
                        rs.getDate("hire_date"),
                        dept,
                        rs.getBytes("photo")
                );
                emp.setId(rs.getInt("id"));
                employees.add(emp);
            }
        }
        return employees;
    }
}
