package DB.Services;

import DB.Constants;
import DB.Model.Job;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


    public class JobService implements AutoCloseable {

        private final PreparedStatement selectJobs;

        public JobService(Connection connection) throws SQLException {
            selectJobs = connection.prepareStatement(Constants.SELECT_Jobs);
        }

        @Override
        public void close() throws SQLException {
            selectJobs.close();
            ;
        }

        public List<Job> getAll() {
            List<Job> res = new ArrayList<>();

            try {

                ResultSet resultSet = selectJobs.executeQuery();

                while (resultSet.next()) {

                    Job job = new Job();

                    job.setJobID(resultSet.getString("JOB_ID"));
                    job.setJobTitle(resultSet.getString("JOB_TITLE"));
                    job.setMaxSalary(resultSet.getInt("MIN_SALARY"));
                    job.setMinSalary(resultSet.getInt("MAX_SALARY"));

                    res.add(job);

                }

            } catch (SQLException e) {
                System.err.println("DB error: " + e.getMessage());
            }

            return res;
        }
    }


