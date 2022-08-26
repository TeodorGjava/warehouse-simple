package com.ClassesAndFrames;


import java.sql.Connection;

import java.sql.SQLException;

public class DataBaseConnector extends Connector {


    protected DataBaseConnector() throws SQLException {
        super();
    }

    public Connection getConnection() {
        return this.connection;
    }

}
