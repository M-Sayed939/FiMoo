package DB.Model;

import java.sql.Date;

public class Employee {
        private int id;
        private String lastName;
        private int departmentId;
        private String firstName;
        private String email;
        private String phoneNumber;
        private Date hireDate;
        private String jobId;
        private double salary;
        private double commission;
        private int managerId;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(int departmentId) {
            this.departmentId = departmentId;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public void setHireDate(Date hireDate) {
            this.hireDate = hireDate;
        }

        public Date getHireDate() {
            return hireDate;
        }

        public String getJobId() {
            return jobId;
        }

        public void setJobId(String jobId) {
            this.jobId = jobId;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public double getCommission() {
            return commission;
        }

        public void setCommission(double commission) {
            this.commission = commission;
        }

        public int getManagerId() {
            return managerId;
        }

        public void setManagerId(int managerId) {
            this.managerId = managerId;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", lastName='" + lastName + '\'' +
                    ", departmentId=" + departmentId +
                    ", firstName='" + firstName + '\'' +
                    ", email='" + email + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    ", hireDate='" + hireDate + '\'' +
                    ", jobId='" + jobId + '\'' +
                    ", salary=" + salary +
                    ", commission=" + commission +
                    ", managerId=" + managerId +
                    '}';
        }
    }


