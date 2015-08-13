package it.source.buisiness.dao;

import it.source.buisiness.model.Address;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Kolmakov Alexey on 06.08.2015.
 */
public class AddressDAO extends BaseDAO {

    private final String TABLE = "ADDRESS";

    public List<Address> getAll() throws SQLException {
        List<Address> addresses = new ArrayList<>();
        String sql = SELECT_ALL + TABLE;
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Address address = new Address(
                    rs.getLong("id"),
                    rs.getInt("code"),
                    rs.getString("country"),
                    rs.getString("city"),
                    rs.getString("street")
            );
            addresses.add(address);
        }
        rs.close();
        stmt.close();
        return addresses;
    }

    public Address getById(Long id) throws SQLException {
        String sql = SELECT_ALL + TABLE + WHERE_ID;
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        Address address = new Address(
                rs.getLong("id"),
                rs.getInt("code"),
                rs.getString("country"),
                rs.getString("city"),
                rs.getString("street")
        );
        rs.close();
        stmt.close();
        return address;
    }

    public List<Address> addressListByParams(Map<String, Object> params) {
        return null;
    }

    public void update(Long id) {

    }

    public void delete(Long id) {

    }
}
