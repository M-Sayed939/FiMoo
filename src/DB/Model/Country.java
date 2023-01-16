package DB.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Country {
        private String countryId;
        private String countryName;
        private int regionId;

        public static Country countryFromResultSet(ResultSet resultSet) throws SQLException {
            Country c  = new Country();
            c.setCountryId(resultSet.getString(0));
            c.setCountryName(resultSet.getString(1));
            c.setRegionId(resultSet.getInt(2));
            return c ;
        }

        public String getCountryId() {
            return countryId;
        }

        public void setCountryId(String countryId) {
            this.countryId = countryId;
        }

        public String getCountryName() {
            return countryName;
        }

        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

        public int getRegionId() {
            return regionId;
        }

        public void setRegionId(int regionId) {
            this.regionId = regionId;
        }

        @Override
        public String toString() {
            return "Country{" +
                    "countryId='" + countryId + '\'' +
                    ", countryName='" + countryName + '\'' +
                    ", regionId=" + regionId +
                    '}';
        }
    }


