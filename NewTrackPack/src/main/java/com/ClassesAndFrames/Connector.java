package com.ClassesAndFrames;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Connector {
    Connection connection;

    protected Connector() throws SQLException {
        this.connection= DriverManager.getConnection("jdbc:h2:./DB/db;IFEXISTS=TRUE", "test", "test");
    }



}
