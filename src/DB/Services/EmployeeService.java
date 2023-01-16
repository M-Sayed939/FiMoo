package DB.Services;

import DB.Constants;
import DB.Exceptions;
import DB.Model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


    public class EmployeeService implements AutoCloseable {

        private final PreparedStatement selectEmployees;
        private final PreparedStatement selectEmployeeById;
        private final PreparedStatement insertEmployee;
        private final PreparedStatement updateEmployee;
        private final PreparedStatement deleteEmployee;

        public EmployeeService(Connection connection) throws SQLException {
            selectEmployees = connection.prepareStatement(Constants.SELECT_EMPLOYEES);
            selectEmployeeById = connection.prepareStatement(Constants.SELECT_EMPLOYEE_BY_ID);

            //Constant.INSERT_EMPLOYEE;
            insertEmployee = connection.prepareStatement(Constants.INSERT_EMPLOYEE);
            updateEmployee = connection.prepareStatement(Constants.UPDATE_EMPLOYEE_BY_ID);
            deleteEmployee = connection.prepareStatement(Constants.DELETE_EMPLOYEE_BY_ID);

        }

        @Override
        public void close() throws SQLException {
            selectEmployees.close();
        }

        public List<Employee> getAll() {
            List<Employee> res = new ArrayList<>();

            try {

                ResultSet resultSet = selectEmployees.executeQuery();

                while (resultSet.next()) {

                    Employee employee = new Employee();

                    employee.setId(resultSet.getInt("employee_id"));
                    employee.setFirstName(resultSet.getString("first_name"));
                    employee.setLastName(resultSet.getString("last_name"));
                    employee.setDepartmentId(resultSet.getInt("department_id"));

                    res.add(employee);

                }

            } catch (SQLException e) {
                System.err.println("DB error: " + e.getMessage());
            }

            return res;
        }
        public Employee getEmployeeById(int id) throws SQLException {
            selectEmployeeById.clearParameters();
            ResultSet resultSet = selectEmployeeById.executeQuery();
            if (resultSet.next()) {
                return Exceptions.employeeFromResultSet(resultSet);
            }
            throw new SQLException("Employee not found");
        }

        public void insert(Employee employee) {
            try {
                insertEmployee.clearParameters();
                insertEmployee.setInt(1, employee.getId());
                insertEmployee.setString(2, employee.getFirstName());
                insertEmployee.setString(3, employee.getLastName());
                insertEmployee.setString(4, employee.getEmail());
                insertEmployee.setString(5, employee.getPhoneNumber());
                insertEmployee.setDate(6, employee.getHireDate());
                insertEmployee.setString(7, employee.getJobId());
                insertEmployee.setDouble(8, employee.getSalary());
                insertEmployee.setDouble(9, employee.getCommission());
                insertEmployee.setInt(10, employee.getManagerId());
                insertEmployee.setInt(11, employee.getDepartmentId());
                insertEmployee.executeUpdate();
            } catch (SQLException e) {
                System.err.println("DB error: " + e.getMessage());
            }
        }

        public void update(Employee employee, int id) {
            //update hr.employees set first_name = ?, " +
            //            "last_name = ?, email = ?, phone_number = ?, hire_date = ?," +
            //            " job_id = ?, salary = ?, commission_pct = ?, manager_id = ?, " +
            //            "department_id = ? where employee_id = ?";
            try {
                updateEmployee.clearParameters();
                updateEmployee.setString(1, employee.getFirstName());
                updateEmployee.setString(2, employee.getLastName());
                updateEmployee.setString(3, employee.getEmail());
                updateEmployee.setString(4, employee.getPhoneNumber());
                updateEmployee.setDate(5, employee.getHireDate());
                updateEmployee.setString(6, employee.getJobId());
                updateEmployee.setDouble(7, employee.getSalary());
                updateEmployee.setDouble(8, employee.getCommission());
                updateEmployee.setInt(9, employee.getManagerId());
                updateEmployee.setInt(10, employee.getDepartmentId());
                updateEmployee.setInt(11, id);
                updateEmployee.executeUpdate();
            } catch (SQLException e) {
                System.err.println("DB error: " + e.getMessage());
            }
        }

        public void delete(int id)  {
            try {
                deleteEmployee.clearParameters();
                deleteEmployee.setInt(1, id);
                deleteEmployee.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
    }


