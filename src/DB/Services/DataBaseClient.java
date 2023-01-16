package DB.Services;

import DB.Constants;
import DB.Model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class DataBaseClient implements AutoCloseable {

        private final Connection connection;
        private final EmployeeService employeeService;
        private final DepartmentService departmentService;
        private final JobGradesService JobGradesService;
        private final JobHistoryService JobHistoryService;
        private final JobService JobService ;
        private final LocationService LocationService;
        private final RegionService RegionsService;
        private final CountryService CountryService;

        public DataBaseClient() throws SQLException {
            connection = DriverManager.getConnection(Constants.DB_URL, Constants.USERNAME, Constants.PASSWORD);
            employeeService = new EmployeeService(connection);
            departmentService = new DepartmentService(connection);
            JobGradesService = new JobGradesService(connection);
            JobHistoryService = new JobHistoryService(connection);
            JobService = new JobService(connection);
            LocationService = new LocationService(connection);
            RegionsService = new RegionService(connection);
            CountryService = new CountryService(connection);
        }

        @Override
        public void close() throws SQLException {
            connection.close();
            employeeService.close();
            departmentService.close();
        }

        public List<Employee> getAllEmployees() {
            return employeeService.getAll();
        }

        public List<Country> getAllCountries() {
            return CountryService.getAll();
        }

        public List<Department> getAllDepartments() {
            return departmentService.getAll();
        }

        public Department getDepartmentById(int id) {
            return departmentService.getById(id);
        }

        public List<Region> getAllRegion() {
            return RegionsService.getAll();
        }

        public List<Location> getAllLocation() {
            return LocationService.getAll();
        }

        public List<JobHistory> getJobHistory() {
            return JobHistoryService.getAll();
        }

        public List<Job> getAllJobs() {
            return JobService.getAll();
        }

        public List<JobGrades> getAllJobGrades() {
            return JobGradesService.getAll();
        }


        public void insertDepartment(Department department) throws SQLException {
            departmentService.insert(department);
        }

        public void deleteDepartmentById(int id) throws SQLException {
            departmentService.deleteById(id);
        }

        public void updateDepartmentById(Department department) throws SQLException {
            departmentService.updateById(department);
        }

        public Employee getEmployeeById(int id) throws SQLException {
            return employeeService.getEmployeeById(id);
        }


        public void insertEmployee(Employee employee) {
            employeeService.insert(employee);
        }

        public void UpdateEmployeeById(Employee employee, int id) {
            employeeService.update(employee, id);
        }

        public void deleteEmployeeById(int id) {
            employeeService.delete(id);
        }

        public Country getCountryById(int id) {
            return CountryService.getById(id);
        }

        public void insertCountry(Country country) {
            CountryService.insert(country);
        }

        public void deleteCountryById(int id) {
            CountryService.deleteById(id);
        }

        public void updateCountryById(Country country, String countryId) {
            CountryService.updateById(country, countryId);
        }
        public JobGrades getJobGradesByGradeLevel(String gradeLevel) throws SQLException {
            return JobGradesService.getJobGradesByGradeLevel(gradeLevel);
        }

        public void insertJobGrades(JobGrades JobGrades) {

            JobGradesService.insert(JobGrades);
        }

        public void deleteJobGradesByGradeLevel(String gradeLevel) {

            JobGradesService.delete(gradeLevel);
        }

        public void updateJobGradesByGradeLevel( JobGrades JobGrades, String gradeLevel) {
            JobGradesService.updateByGradeLevel ( JobGrades, gradeLevel);
        }
        public void insertRegion(Region region) throws SQLException {
            RegionsService.insert(region);
        }

        public void deleteRegionById(int id) throws SQLException {
            RegionsService.deleteById(id);
        }

        public void updateRegionById(Region region) throws SQLException {
            RegionsService.updateById(region);
        }
        public Region getRegionById(int id) {
            return RegionsService.getById(id);
        }

        public void insertLocation(Location location) throws SQLException {
            LocationService.insert(location);
        }

        public void deleteLocationById(int id) throws SQLException {
            LocationService.deleteById(id);
        }

        public void updateLocationById(Location location) throws SQLException {
            LocationService.updateById(location);
        }
        public Location getLocationById(int id) {
            return LocationService.getById(id);
        }
    }



