package DB.Model;

public class JobGrades {
        private String GradeLevel;
        private int lowestSal;
        private int HighestSal;

        public String getGradeLevel() {
            return GradeLevel;
        }

        public void setGradeLevel(String gradeLevel) {
            GradeLevel = gradeLevel;
        }

        public int getLowestSal() {
            return lowestSal;
        }

        public void setLowestSal(int lowestSal) {
            this.lowestSal = lowestSal;
        }

        public int getHighestSal() {
            return HighestSal;
        }

        public void setHighestSal(int highestSal) {
            HighestSal = highestSal;
        }

        @Override
        public String toString() {
            return "JobGrades{" +
                    "GradeLevel='" + GradeLevel + '\'' +
                    ", lowestSal=" + lowestSal +
                    ", HighestSal=" + HighestSal +
                    '}';
        }
    }


