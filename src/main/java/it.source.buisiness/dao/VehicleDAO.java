package it.source.buisiness.dao;

import it.source.buisiness.model.Vehicle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Kolmakov Alexey on 06.08.2015.
 */
public class VehicleDAO extends BaseDAO {

    private final String WHERE_OWNER_ID = " WHERE autoowner_id = ?";
    private final String TABLE = "VEHICLE";

    public VehicleDAO() {
        super();
    }

    public List<Vehicle> getAll() throws SQLException {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = SELECT_ALL + TABLE;
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Long id = rs.getLong("id");
            vehicles.add(newVehicle(rs));
        }
        rs.close();
        stmt.close();
        return vehicles;
    }

    public Vehicle getById(Long id) throws SQLException {
        String sql = SELECT_ALL + TABLE + WHERE_ID;
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        Vehicle vehicle = newVehicle(rs);
        rs.close();
        stmt.close();
        return vehicle;
    }

    //todo
    public List<Vehicle> vehicleListByParams(LinkedHashMap<String, String> params) throws SQLException {
        List<Vehicle> vehicles = new ArrayList<>();
        ArrayList<String> keys = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();

        String sql = SELECT_ALL + TABLE
                + " WHERE ID = ? AND BRAND LIKE ? AND REG_NUMBER LIKE ?";
        PreparedStatement stmt = conn.prepareStatement(sql);


        return vehicles;
    }

    public void update(Long id) {

    }

    public void delete(Long id) {

    }

    public List<Vehicle> getListByOwnerId(Long id) throws SQLException {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = SELECT_ALL + TABLE + WHERE_OWNER_ID;
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            vehicles.add(newVehicle(rs));
        }
        rs.close();
        stmt.close();
        return vehicles;


    }

    private Vehicle newVehicle(ResultSet rs) throws SQLException {
        Long id = rs.getLong("id");
        return Vehicle.newBuilder()
                .setId(id)
                .setBrand(rs.getString("brand"))
                .setModel(rs.getString("model"))
                .setRegistrationNumber(rs.getString("reg_number"))
//                .setOwner(new AutoOwnerDAO().getById(rs.getLong("autoowner_id")))
                .setOwnerID(rs.getLong("autoowner_id"))
                .setProductionDate(rs.getDate("production_date"))
                .setLastServiceDate(rs.getDate("last_service_date"))
                .setRtaList(new RTADAO().getListByVehicleId(id))
                .build();
    }
}
