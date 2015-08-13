package it.source.buisiness.dao;

import it.source.buisiness.model.Offence;
import it.source.buisiness.model.RTA;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Kolmakov Alexey on 06.08.2015.
 */
public class RTADAO extends BaseDAO {

    private final String TABLE = "RTA";
    private final String WHERE_VEHICLE_ID = " WHERE VEHICLE_ID = ?";

    public List<RTA> getAll() throws SQLException {
        List<RTA> rtaList = new ArrayList<>();
        String sql = SELECT_ALL + TABLE;
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            rtaList.add(newRTA(rs));
        }
        rs.close();
        stmt.close();
        return rtaList;
    }

    public RTA getById(Long id) throws SQLException {
        String sql = SELECT_ALL + TABLE + WHERE_ID;
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        RTA rta = newRTA(rs);
        rs.close();
        stmt.close();
        return rta;
    }

    public List<Offence> addressListByParams(Map<String, Object> params) {
        return null;
    }

    public void update(Long id) {

    }

    public void delete(Long id) {

    }

    public List<RTA> getListByVehicleId(Long id) throws SQLException {
        List<RTA> rtaList = new ArrayList<>();
        String sql = SELECT_ALL + TABLE + WHERE_VEHICLE_ID;
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            rtaList.add(newRTA(rs));
        }
        rs.close();
        stmt.close();
        return rtaList;
    }

    private RTA newRTA(ResultSet rs) throws SQLException {
        return new RTA(
                rs.getLong("id"),
                rs.getDate("date"),
                rs.getInt("code")
        );
    }
}
