package it.source.buisiness.dao;

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
public class PassportDAO extends BaseDAO {

    private final String TABLE = "PASSPORT";

    public List<Passport> getAll() throws SQLException {
        List<Passport> passports = new ArrayList<>();
        String sql = SELECT_ALL + TABLE;
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            passports.add(newPassport(rs));
        }
        rs.close();
        stmt.close();
        return passports;
    }


    public Passport getById(Long id) throws SQLException {
        String sql = SELECT_ALL + TABLE + WHERE_ID;
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        Passport passport = newPassport(rs);
        rs.close();
        stmt.close();
        return passport;
    }

    public List<Passport> addressListByParams(Map<String, Object> params) {
        return null;
    }

    public void update(Long id) {

    }

    public void delete(Long id) {

    }

    private Passport newPassport(ResultSet rs) throws SQLException {
        return new Passport(
                rs.getLong("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("middle_name"),
                rs.getDate("date_of_birth"),
                rs.getString("serial_id"),
                rs.getDate("reg_date"),
                rs.getString("reg_by")
        );
    }
}
