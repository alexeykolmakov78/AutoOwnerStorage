package it.source.buisiness.dao;

import it.source.buisiness.util.H2Connector;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Created by Kolmakov Alexey on 06.08.2015.
 */
public abstract class BaseDAO {
    protected final String SELECT_ALL = "SELECT * FROM ";
    protected final String WHERE_ID =  " WHERE ID = ?;";

    protected Connection conn;
    protected BaseDAO() {
        conn = H2Connector.getConnection();
    }

}
