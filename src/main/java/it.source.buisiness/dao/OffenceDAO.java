package it.source.buisiness.dao;

import it.source.buisiness.model.Offence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Kolmakov Alexey on 06.08.2015.
 */
public class OffenceDAO extends BaseDAO {

    private final String TABLE = "OFFENCE";
    private final String WHERE_OWNER_ID = " WHERE AUTOOWNER_ID = ?";

    public List<Offence> getAll() throws SQLException {
        List<Offence> offences = new ArrayList<>();
        String sql = SELECT_ALL + TABLE;
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Offence offence = new Offence(
                    rs.getLong("id"),
                    rs.getDate("date"),
                    Offence.Type.valueOf(rs.getString("type"))
            );
            offences.add(offence);
        }
        rs.close();
        stmt.close();
        return offences;
    }

    public Offence getById(Long id) throws SQLException {
        String sql = SELECT_ALL + TABLE + WHERE_ID;
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        Offence offence = new Offence(
                rs.getLong("id"),
                rs.getDate("date"),
                Offence.Type.valueOf(rs.getString("type"))
        );
        rs.close();
        stmt.close();
        return offence;
    }

    public List<Offence> addressListByParams(Map<String, Object> params) {
        return null;
    }

    public void update(Long id) {

    }

    public void delete(Long id) {

    }

    public List<Offence> getListByOwnerId(Long id) throws SQLException {
        List<Offence> offences = new ArrayList<>();
        String sql = SELECT_ALL + TABLE + WHERE_OWNER_ID;
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Offence offence = new Offence(
                    rs.getLong("id"),
                    rs.getDate("date"),
                    Offence.Type.valueOf(rs.getString("type"))
            );
            offences.add(offence);
        }
        rs.close();
        ps.close();
        return offences;
    }
}
