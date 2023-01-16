package DB.Model;

import java.util.Date;

public class JobHistory {
        private int employeeId;
        private Date startData;
        private Date endData;
        private String jobId;
        private int departmentID;

        public int getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(int employeeId) {
            this.employeeId = employeeId;
        }

        public Date getStartData() {
            return startData;
        }

        public void setStartData(Date startData) {
            this.startData = startData;
        }

        public Date getEndData() {
            return endData;
        }

        public void setEndData(Date endData) {
            this.endData = endData;
        }

        public String getJobId() {
            return jobId;
        }

        public void setJobId(String jobId) {

            this.jobId = jobId;
        }

        public int getDepartmentID() {
            return departmentID;
        }

        public void setDepartmentID(int departmentID) {
            this.departmentID = departmentID;
        }

        @Override
        public String toString() {
            return "JobHistory{" +
                    "employeeId=" + employeeId +
                    ", startData=" + startData +
                    ", endData=" + endData +
                    ", jobId='" + jobId + '\'' +
                    ", departmentID=" + departmentID +
                    '}';
        }
    }


