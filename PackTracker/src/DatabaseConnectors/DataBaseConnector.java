package com.ClassesAndFrames.DatabaseConnectors;


import java.sql.Connection;

import java.sql.SQLException;

public class DataBaseConnector extends H2DatabaseConnector {


    public DataBaseConnector() throws SQLException {
        super();
    }

    public Connection getConnection() {
        return this.connection;
    }

}
