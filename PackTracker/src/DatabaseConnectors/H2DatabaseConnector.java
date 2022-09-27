package com.ClassesAndFrames.DatabaseConnectors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class H2DatabaseConnector {
    Connection connection;

    protected H2DatabaseConnector() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:h2:./DB/db;IFEXISTS=TRUE", "test", "test");
    }


}
