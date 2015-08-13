package it.source.buisiness.dao;

import it.source.buisiness.model.Licence;
import it.source.buisiness.model.Passport;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Kolmakov Alexey on 06.08.2015.
 */
public class LicenceDAO extends BaseDAO {

    private final String TABLE = "LICENCE";

    public List<Licence> getAll() throws SQLException {
        List<Licence> licences = new ArrayList<>();
        String sql = SELECT_ALL + TABLE;
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Licence licence = new Licence(
                    rs.getLong("id"),
                    rs.getString("serial_id"),
                    Licence.Category.valueOf(rs.getString("category")),
                    rs.getDate("reg_date"),
                    rs.getString("reg_by")
            );
            licences.add(licence);
        }
        rs.close();
        stmt.close();
        return licences;
    }

    public Licence getById(Long id) throws SQLException {
        String sql = SELECT_ALL + TABLE + WHERE_ID;
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        Licence licence = new Licence(
                rs.getLong("id"),
                rs.getString("serial_id"),
                Licence.Category.valueOf(rs.getString("category")),
                rs.getDate("reg_date"),
                rs.getString("reg_by")
        );
        rs.close();
        stmt.close();
        return licence;
    }

    public List<Passport> listByParams(Map<String, Object> params) {
        return null;
    }

    public void update(Long id) {

    }

    public void delete(Long id) {

    }
}
