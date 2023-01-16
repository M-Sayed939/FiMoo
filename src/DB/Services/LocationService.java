package DB.Services;

import DB.Constants;
import DB.Model.Location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

    public class LocationService implements AutoCloseable {

        private final PreparedStatement selectLocation;
        private final PreparedStatement selectLocationById;
        private final PreparedStatement insertLocation;
        private final PreparedStatement deleteLocationById;
        private final PreparedStatement updateLocationById;

        public LocationService(Connection connection) throws SQLException {
            selectLocation = connection.prepareStatement(Constants.SELECT_LOCATION_BY_ID);
            selectLocationById = connection.prepareStatement(Constants.SELECT_LOCATION_BY_ID);
            insertLocation = connection.prepareStatement(Constants.INSERT_LOCATION);

            deleteLocationById = connection.prepareStatement(Constants.DELETE_LOCATION_BY_ID);
            updateLocationById = connection.prepareStatement(Constants.UPDATE_LOCATION_BY_ID);
        }

        @Override
        public void close() throws SQLException {
            selectLocation.close();
            ;
        }

        public List<Location> getAll() {
            List<Location> res = new ArrayList<>();

            try {

                ResultSet resultSet = selectLocation.executeQuery();

                while (resultSet.next()) {

                    Location location = new Location();

                    location.setCity(resultSet.getString("CITY"));
                    location.setCountryID(resultSet.getString("COUNTRY_ID"));
                    location.setLocationId(resultSet.getInt("LOCATION_ID"));
                    location.setPostalCode(resultSet.getString("POSTAL_CODE"));
                    location.setStateProvince(resultSet.getString("STATE_PROVINCE"));
                    location.setStreetAddress(resultSet.getString("STREET_ADDRESS"));

                    res.add(location);

                }

            } catch (SQLException e) {
                System.err.println("DB error: " + e.getMessage());
            }

            return res;
        }

        public Location getById(int id) {
            Location location= null;

            try {

                selectLocationById.clearParameters();
                selectLocationById.setInt(1, id);

                ResultSet resultSet = selectLocationById.executeQuery();

                if (resultSet.next()) {

                    location = new Location();


                    location.setLocationId(resultSet.getInt("LOCATION_ID"));
                    location.setStreetAddress(resultSet.getString("STREET_ADDRESS"));
                    location.setCountryID(resultSet.getString("COUNTRY_ID"));
                    location.setCity(resultSet.getString("CITY"));
                    location.setLocationId(resultSet.getInt("LOCATION_ID"));
                    location.setPostalCode(resultSet.getString("POSTAL_CODE"));
                    location.setStateProvince(resultSet.getString("STATE_PROVINCE"));
                    location.setStreetAddress(resultSet.getString("STREET_ADDRESS"));


                }

            } catch (SQLException e) {
                System.err.println("DB error: " + e.getMessage());
            }


            return location;
        }

        public void insert(Location location) throws SQLException {
            insertLocation.clearParameters();

            insertLocation.setInt(1, location.getLocationId());
            insertLocation.setString(2, location.getStreetAddress());
            insertLocation.setString(3, location.getPostalCode());
            insertLocation.setString(4, location.getCity());
            insertLocation.setString(5, location.getStateProvince());
            insertLocation.setString(6, location.getCountryID());
            insertLocation.executeQuery();
        }

        public void deleteById(int id) throws SQLException {
            deleteLocationById.clearParameters();
            deleteLocationById.setInt(1 , id);
            deleteLocationById.executeQuery();
        }

        public void updateById(Location location) throws SQLException {
//        "update HR.locations set " +
//                "street_address = ? , postal_code = ? , City = ?, state_province= ?, Country_id = ? where department_id = ?";
            updateLocationById.clearParameters();
            updateLocationById.setString(1,location.getStreetAddress());
            updateLocationById.setString(1,location.getPostalCode());
            updateLocationById.setString(1,location.getCity());
            updateLocationById.setString(1,location.getStateProvince());
            updateLocationById.setString(1,location.getCountryID());

            updateLocationById.executeQuery();
        }
    }


