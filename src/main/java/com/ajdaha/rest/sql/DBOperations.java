package com.ajdaha.rest.sql;

import com.ajdaha.rest.models.SalesMan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 19-Nov-17.
 */
public class DBOperations {
    Connection connection;
    PreparedStatement ps;

    public List<SalesMan> getSalesMans() {
        List<SalesMan> salesManList = new ArrayList<>();
        connect();
        try {
            ps = connection.prepareStatement("SELECT TOP 20 LOGICALREF,CODE,NAME,0,0 FROM LG_006_KSCARD ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SalesMan salesMan = new SalesMan(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
                salesManList.add(salesMan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close();
        return salesManList;
    }

    public void connect() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=mazarina2017", "Lenovo", "ejdaha9711");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
