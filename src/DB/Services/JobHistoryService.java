package DB.Services;

import DB.Constants;
import DB.Model.JobHistory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

    public class JobHistoryService implements AutoCloseable {

        private final PreparedStatement selectJobHistory;

        public JobHistoryService(Connection connection) throws SQLException {
            selectJobHistory = connection.prepareStatement(Constants.SELECT_Jobs);
        }

        @Override
        public void close() throws SQLException {
            selectJobHistory.close();
            ;
        }

        public List<JobHistory> getAll() {
            List<JobHistory> res = new ArrayList<>();

            try {

                ResultSet resultSet = selectJobHistory.executeQuery();

                while (resultSet.next()) {

                    JobHistory jobHistroy = new JobHistory();

                    jobHistroy.setEmployeeId(resultSet.getInt("EMPLOYEE_ID"));
                    jobHistroy.setStartData(resultSet.getDate("START_DATE"));
                    jobHistroy.setEndData(resultSet.getDate("END_DATE"));
                    jobHistroy.setJobId(resultSet.getString("JOB_ID"));
                    jobHistroy.setDepartmentID(resultSet.getInt("DEPARTMENT_ID"));

                    res.add(jobHistroy);

                }

            } catch (SQLException e) {
//                System.err.println("DB error in query : " + Constants.SELECT_jobHistory);
                System.err.println("DB error: " + e.getMessage());
            }

            return res;
        }
    }


