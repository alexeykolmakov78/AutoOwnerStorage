package it.source.buisiness.dao;

import it.source.buisiness.model.AutoOwner;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Kolmakov Alexey on 06.08.2015.
 */
public class AutoOwnerDAO extends BaseDAO {

    private String TABLE = "AUTOOWNER";

    public AutoOwnerDAO() {
        super();
    }

    public List<AutoOwner> getAll() throws SQLException {
        List<AutoOwner> autoOwners = new ArrayList<>();
        String sql = SELECT_ALL + TABLE;
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Long id = rs.getLong("id");
            AutoOwner autoOwner = new AutoOwner(
                    id,
                    new AddressDAO().getById(rs.getLong("address_id")),
                    new PassportDAO().getById(rs.getLong("passport_id")),
                    new LicenceDAO().getById(rs.getLong("licence_id")),
                    new VehicleDAO().getListByOwnerId(id),
                    new OffenceDAO().getListByOwnerId(id)
            );
            autoOwners.add(autoOwner);
        }
        rs.close();
        stmt.close();
        return autoOwners;
    }

    public AutoOwner getById(Long id) throws SQLException {
        String sql = SELECT_ALL + TABLE + WHERE_ID;
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        AutoOwner autoOwner = new AutoOwner(
                id,
                new AddressDAO().getById(rs.getLong("address_id")),
                new PassportDAO().getById(rs.getLong("passport_id")),
                new LicenceDAO().getById(rs.getLong("licence_id")),
                new VehicleDAO().getListByOwnerId(id),
                new OffenceDAO().getListByOwnerId(id)
        );
        rs.close();
        stmt.close();
        return autoOwner;
    }

    public List<AutoOwner> listByParams(Map<String, Object> params) {
        return null;
    }

    public void update(Long id) {

    }

    public void delete(Long id) {

    }
}
