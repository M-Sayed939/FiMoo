package DB.Services;

import DB.Constants;
import DB.Exceptions;
import DB.Model.JobGrades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

    public class JobGradesService implements AutoCloseable {

        private final PreparedStatement selectJobGrades;
        private final PreparedStatement insertJobGrades;
        private final PreparedStatement updateJobGrades;
        private final PreparedStatement deleteJobGrades;
        private final PreparedStatement selectJobGradesByGradeLevel;


        public JobGradesService(Connection connection) throws SQLException {
            selectJobGrades = connection.prepareStatement(Constants.SELECT_jobGrades);
            selectJobGradesByGradeLevel = connection.prepareStatement(Constants.SELECT_JobGrades_BY_GradeLevel);

            //Constant.INSERT_JobGrades;
            insertJobGrades = connection.prepareStatement(Constants.INSERT_JobGrades);
            updateJobGrades = connection.prepareStatement(Constants.UPDATE_JobGrades);
            deleteJobGrades = connection.prepareStatement(Constants.DELETE_JobGrades);

        }

        @Override
        public void close() throws SQLException {
            selectJobGrades.close();

        }

        public List<JobGrades> getAll() {
            List<JobGrades> res = new ArrayList<>();

            try {

                ResultSet resultSet = selectJobGrades.executeQuery();

                while (resultSet.next()) {

                    JobGrades JobGrades = new JobGrades();

                    JobGrades.setGradeLevel(resultSet.getString("GRADE_LEVEL"));
                    JobGrades.setHighestSal(resultSet.getInt("HIGHEST_SAL"));
                    JobGrades.setLowestSal(resultSet.getInt("LOWEST_SAL"));

                    res.add(JobGrades);

                }

            } catch (SQLException e) {
                System.err.println("DB error: " + e.getMessage());
            }

            return res;
        }
        public JobGrades getJobGradesByGradeLevel(String gradeLevel) throws SQLException {
            selectJobGradesByGradeLevel.clearParameters();
            ResultSet resultSet = selectJobGradesByGradeLevel.executeQuery();
            if (resultSet.next()) {
                return Exceptions.JobGradesFromResultSet(resultSet);
            }
            throw new SQLException("Employee not found");
        }

        public void updateByGradeLevel(JobGrades jobGrades, String gradeLevel) {

            try {
                updateJobGrades.clearParameters();
                updateJobGrades.setString(1, jobGrades.getGradeLevel());
                updateJobGrades.setInt(2, jobGrades.getHighestSal());
                updateJobGrades.setInt(3, jobGrades.getLowestSal());
                updateJobGrades.executeUpdate();
            } catch (SQLException e) {
                System.err.println("DB error: " + e.getMessage());
            }
        }

        public void delete(String gradeLevel) {
            try {
                deleteJobGrades.clearParameters();
                deleteJobGrades.setString(1, gradeLevel);
                deleteJobGrades.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        public void insert(JobGrades JobGrades) {
            try {
                insertJobGrades.clearParameters();
                insertJobGrades.setString(1, JobGrades.getGradeLevel());
                insertJobGrades.setInt(2, JobGrades.getHighestSal());
                insertJobGrades.setInt(3, JobGrades.getLowestSal());
                insertJobGrades.executeUpdate();
            } catch (SQLException e) {
                System.err.println("DB error: " + e.getMessage());
            }
        }
    }

