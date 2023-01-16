package DB.Services;

import DB.Constants;
import DB.Exceptions;
import DB.Model.Region;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegionService implements AutoCloseable {

    private final PreparedStatement selectRegion;
    private final PreparedStatement selectRegionById;
    private final PreparedStatement insertRegion;
    private final PreparedStatement deleteRegionById;
    private final PreparedStatement updateRegionById;

    public RegionService(Connection connection) throws SQLException {
        selectRegion = connection.prepareStatement(Constants.SELECT_REGION);
        selectRegionById = connection.prepareStatement(Constants.SELECT_REGIONS_BY_ID);
        insertRegion = connection.prepareStatement(Constants.INSERT_REGIONS);

        deleteRegionById = connection.prepareStatement(Constants.DELETE_REGIONS_BY_ID);
        updateRegionById = connection.prepareStatement(Constants.UPDATE_REGIONS_BY_ID);
    }

    @Override
    public void close() throws SQLException {
        selectRegion.close();
    }

    public List<Region> getAll() {
        List<Region> res = new ArrayList<>();

        try {

            ResultSet resultSet = selectRegion.executeQuery();

            while (resultSet.next()) {
                res.add(Exceptions.resultSetToRegion(resultSet));
            }

        } catch (SQLException e) {
            System.err.println("DB error: " + e.getMessage());
        }

        return res;
    }

    public Region getById(int id) {
        Region region = null;

        try {

            selectRegionById.clearParameters();
            selectRegionById.setInt(1, id);

            ResultSet resultSet = selectRegionById.executeQuery();

            if (resultSet.next()) {

                region = new Region();

                region.setRegionId(resultSet.getInt("RegionId"));
                region.setRegionName(resultSet.getString("RegionName"));

            }

        } catch (SQLException e) {
            System.err.println("DB error: " + e.getMessage());
        }


        return region;
    }

    public void insert(Region region) throws SQLException {
        insertRegion.clearParameters();
        //"insert INTO HR.departments  VALUES ( $1 , $2 , $3 , $4)";
        insertRegion.setInt(1, region.getRegionId());
        insertRegion.setString(2, region.getRegionName());
        insertRegion.executeQuery();
    }

    public void deleteById(int id) throws SQLException {
        deleteRegionById.clearParameters();
        deleteRegionById.setInt(1 , id);
        deleteRegionById.executeQuery();
    }

    public void updateById(Region department) throws SQLException {
        updateRegionById.clearParameters();
        updateRegionById.setString(1,department.getRegionName());
        updateRegionById.setInt(2 , department.getRegionId());
        updateRegionById.executeQuery();
    }
}



