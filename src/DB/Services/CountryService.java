package DB.Services;

import DB.Constants;
import DB.Model.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryService {

        private final PreparedStatement selectCountry;
        private final PreparedStatement selectCountryById;
        private final PreparedStatement insertCountry;
        private final PreparedStatement deleteCountryById;
        private final PreparedStatement updateCountryById;

        public CountryService(Connection connection) throws SQLException {
            selectCountry = connection.prepareStatement(Constants.SELECT_COUNTRY);
            selectCountryById = connection.prepareStatement(Constants.SELECT_COUNTRY_BY_ID);
            insertCountry = connection.prepareStatement(Constants.INSERT_COUNTRY);
            deleteCountryById = connection.prepareStatement(Constants.DELETE_COUNTRY_BY_ID);
            updateCountryById = connection.prepareStatement(Constants.UPDATE_COUNTRY_BY_ID);
        }

        public void close() throws SQLException {
            selectCountry.close();
        }

        public List<Country> getAll() {
            List<Country> res = new ArrayList<>();
            try {
                ResultSet resultSet = selectCountry.executeQuery();
                while (resultSet.next()) {
                    Country country = Country.countryFromResultSet(resultSet);
                    res.add(country);
                }

            } catch (SQLException e) {
                System.err.println("DB error: " + e.getMessage());
            }

            return res;
        }

        public Country getById(int id) {
            Country country = null;
            try {
                selectCountryById.setInt(1, id);
                ResultSet resultSet = selectCountryById.executeQuery();
                if (resultSet.next()) {
                    country = Country.countryFromResultSet(resultSet);
                }

            } catch (SQLException e) {
                System.err.println("DB error: " + e.getMessage());
            }
            return country;
        }

        public void insert(Country country) {
            try {
                insertCountry.clearParameters();
                insertCountry.setString(1, country.getCountryId());
                insertCountry.setString(2, country.getCountryName());
                insertCountry.setInt(3, country.getRegionId());
                insertCountry.executeUpdate();
            } catch (SQLException e) {
                System.err.println("DB error: " + e.getMessage());
            }
        }

        public void deleteById(int id) {
            try {
                deleteCountryById.clearParameters();
                deleteCountryById.setInt(1, id);
                deleteCountryById.executeUpdate();
            } catch (SQLException e) {
                System.err.println("DB error: " + e.getMessage());
            }

        }

        public void updateById(Country country, String countryId) {
            try {
                updateCountryById.clearParameters();
                updateCountryById.setString(1, country.getCountryName());
                updateCountryById.setInt(2, country.getRegionId());
                updateCountryById.setString(3, countryId);
                updateCountryById.executeUpdate();
            } catch (SQLException e) {
                System.err.println("DB error: " + e.getMessage());
            }
        }
    }


