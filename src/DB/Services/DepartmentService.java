package DB.Services;

import DB.Constants;
import DB.Exceptions;
import DB.Model.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


    public class DepartmentService implements AutoCloseable {

        private final PreparedStatement selectDepartments;
        private final PreparedStatement selectDepartmentById;
        private final PreparedStatement insertDepartment;
        private final PreparedStatement deleteDepartmentById;
        private final PreparedStatement updateDepartmentById;


        public DepartmentService(Connection connection) throws SQLException {
            selectDepartments = connection.prepareStatement(Constants.SELECT_DEPARTMENTS);
            selectDepartmentById = connection.prepareStatement(Constants.SELECT_DEPARTMENT_BY_ID);
            insertDepartment = connection.prepareStatement(Constants.INSERT_DEPARTMENT);

            deleteDepartmentById = connection.prepareStatement(Constants.DELETE_DEPARTMENT_BY_ID);
            updateDepartmentById = connection.prepareStatement(Constants.UPDATE_DEPARTMENT_BY_ID);
        }

        @Override
        public void close() throws SQLException {
            selectDepartments.close();
        }

        public List<Department> getAll() {
            List<Department> res = new ArrayList<>();

            try {

                ResultSet resultSet = selectDepartments.executeQuery();

                while (resultSet.next()) {
                    res.add(Exceptions.resultSetToDepartment(resultSet));
                }

            } catch (SQLException e) {
                System.err.println("DB error: " + e.getMessage());
            }

            return res;
        }

        public Department getById(int id) {
            Department department = null;

            try {

                selectDepartmentById.clearParameters();
                selectDepartmentById.setInt(1, id);

                ResultSet resultSet = selectDepartmentById.executeQuery();

                if (resultSet.next()) {

                    department = new Department();

                    department.setDepartmentId(resultSet.getInt("department_id"));
                    department.setDepartmentName(resultSet.getString("department_name"));
                    department.setLocationId(resultSet.getInt("location_id"));
                    department.setManagerId(resultSet.getInt("manager_id"));

                }

            } catch (SQLException e) {
                System.err.println("DB error: " + e.getMessage());
            }


            return department;
        }

        public void insert(Department department) throws SQLException {
            insertDepartment.clearParameters();
            //"insert INTO HR.departments  VALUES ( $1 , $2 , $3 , $4)";
            insertDepartment.setInt(1, department.getDepartmentId());
            insertDepartment.setString(2, department.getDepartmentName());
            insertDepartment.setInt(3, department.getManagerId());
            insertDepartment.setInt(4, department.getLocationId());
            insertDepartment.executeQuery();
        }

        public void deleteById(int id) throws SQLException {
            deleteDepartmentById.clearParameters();
            deleteDepartmentById.setInt(1 , id);
            deleteDepartmentById.executeQuery();
        }

        public void updateById(Department department) throws SQLException {
//        "update HR.departments set " +
//                "department_name = ? , location_id = ? , manager_id = ? where department_id = ?";
            updateDepartmentById.clearParameters();
            updateDepartmentById.setString(1,department.getDepartmentName());
            updateDepartmentById.setInt(2 , department.getLocationId());
            updateDepartmentById.setInt(3,department.getManagerId());
            updateDepartmentById.setInt(4 , department.getDepartmentId());
            updateDepartmentById.executeQuery();
        }
    }


