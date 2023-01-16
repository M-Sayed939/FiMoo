package DB;

public interface Constants {
    String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    String USERNAME = "system";
    String PASSWORD = "sys";
    String SELECT_COUNTRY = "select * from hr.Countries";

    String SELECT_Jobs = "select * from hr.job" ;
    String SELECT_jobGrades = "select * from hr.job_Grades";
    String SELECT_JobGrades_BY_GradeLevel = "select * from hr.job_Grades";
    String INSERT_JobGrades = "insert INTO HR.Countries  VALUES ( ? , ? , ?, ? )";
    String UPDATE_JobGrades = "delete from HR.job_Grades where gradeLevel = ?" ;
    String DELETE_JobGrades = "update HR.job_Grades set  GRADE_LEVEL =?," +
            " LOWEST_SAL= ? , HIGHEST_SAL = ?";

    String SELECT_EMPLOYEES = "select * from hr.employees";
    String SELECT_DEPARTMENTS = "select * from hr.departments";
    String SELECT_DEPARTMENT_BY_ID = "select * from hr.departments where department_id = ?";
    String INSERT_DEPARTMENT = "insert INTO HR.departments  VALUES ( ? , ? , ? , ?)";
    String DELETE_DEPARTMENT_BY_ID = "delete from HR.departments where department_id = ?" ;
    String UPDATE_DEPARTMENT_BY_ID = "update HR.departments set " +
            "department_name = ? , location_id = ? , manager_id = ? where department_id = ?";
    String SELECT_EMPLOYEE_BY_ID = "select * from hr.employees where employee_id = ?";
    String INSERT_EMPLOYEE = "insert INTO HR.employees  VALUES ( ? , ? , ?  )";
    String DELETE_EMPLOYEE_BY_ID = "delete from HR.employees where employee_id = ?" ;
    String UPDATE_EMPLOYEE_BY_ID = "update HR.employees set " +
            "first_name = ? , last_name = ? , department_id = ? where employee_id = ?";
    String SELECT_COUNTRY_BY_ID = "select * from hr.Countries where country_id = ?";
    String INSERT_COUNTRY = "insert INTO HR.Countries  VALUES ( ? , ? , ? )";
    String DELETE_COUNTRY_BY_ID = "delete from HR.Countries where country_id = ?" ;
    String UPDATE_COUNTRY_BY_ID = "update HR.Countries set " +
            "country_name = ? , region_id = ? where country_id = ?";

    String SELECT_REGION = "select * from hr.regions ";
    String SELECT_REGIONS_BY_ID = "select * from hr.regions where regions_id = ?";
    String INSERT_REGIONS = "insert INTO HR.departments  VALUES ( ? , ? )";
    String DELETE_REGIONS_BY_ID = "delete from HR.regions where regions_id = ?" ;
    String UPDATE_REGIONS_BY_ID = "update HR.departments set " +
            "regions_name = ? where regions_id = ?";


    String SELECT_LOCATION_BY_ID = "select * from hr.locations where location_id = ?";
    String INSERT_LOCATION = "insert INTO HR.locations  VALUES ( ? , ? , ? , ? , ? , ? )";
    String DELETE_LOCATION_BY_ID = "delete from HR.locations where location_id = ?" ;
    String UPDATE_LOCATION_BY_ID = "update HR.locations set " +
            "street_address = ? , postal_code = ? , City = ?, state_province= ?, country_id = ? where location_id = ?";

}
