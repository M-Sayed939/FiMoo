package DB;

import DB.Model.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Exceptions {
        public static Department resultSetToDepartment(ResultSet resultSet) throws SQLException {
            Department department = new Department();
            department.setDepartmentId(resultSet.getInt("department_id"));
            department.setDepartmentName(resultSet.getString("department_name"));
            department.setLocationId(resultSet.getInt("location_id"));
            department.setManagerId(resultSet.getInt("manager_id"));
            return department;
        }

        public static Employee employeeFromResultSet(ResultSet resultSet) throws  SQLException {
            Employee employee = new Employee();
            employee.setId(resultSet.getInt("employee_id"));
            employee.setLastName(resultSet.getString("last_name"));
            employee.setDepartmentId(resultSet.getInt("department_id"));
            employee.setEmail(resultSet.getString("email"));
            employee.setCommission(resultSet.getDouble("commission_pct"));
            employee.setManagerId(resultSet.getInt("manager_id"));
            employee.setFirstName(resultSet.getString("first_name"));
            employee.setHireDate(resultSet.getDate("hire_date"));
            employee.setJobId(resultSet.getString("job_id"));
            employee.setPhoneNumber(resultSet.getString("phone_number"));
            employee.setSalary(resultSet.getDouble("salary"));
            return employee;
        }
        public static JobGrades JobGradesFromResultSet(ResultSet resultSet) throws  SQLException {
            JobGrades JobGrades = new JobGrades();
            JobGrades.setGradeLevel(resultSet.getString("grade_level"));
            JobGrades.setLowestSal(resultSet.getInt("lowest_sal"));
            JobGrades.setHighestSal(resultSet.getInt("highest_sal"));
            return JobGrades;
        }
        public static Region resultSetToRegion(ResultSet resultSet) throws SQLException {
            Region region = new Region();
            region.setRegionId(resultSet.getInt("region_id"));
            region.setRegionName(resultSet.getString("region_name"));
            return region;
        }
    }


