package ra.model.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToDB {
    private static final  String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/qlbh1";
    private static final String USER="root";
    private static final String PASSWORD = "";

    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void close(Connection conn ) throws SQLException {
        if (conn != null) {
            conn.close();
        }

    }
}
