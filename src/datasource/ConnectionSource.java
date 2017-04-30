package datasource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by aliubivyi on 17.04.17.
 */
public class ConnectionSource {
    private InitialContext initContext;
    private DataSource ds;
    private static ConnectionSource instance = new ConnectionSource();


    private ConnectionSource() {
        try {
            initContext = new InitialContext();
            ds = (DataSource) initContext.lookup("java:comp/env/jdbc/dictionary");
        } catch (NamingException e) {
        }

    }

    public static synchronized ConnectionSource getInstance() {
        return instance;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = ds.getConnection();
        } catch (SQLException e) {
        }
        return connection;
    }

}

