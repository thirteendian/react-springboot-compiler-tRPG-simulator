package edu.duke.summer.server;

import java.io.*;
import java.sql.*;
import java.util.*;

public class DatabaseOperator {

  /**
   * This constructs a database operator
   */
  public DatabaseOperator() {}

  /**
   * This sets up tables in database
   */
  public void setupDatabase() {
    Connection connection = null;
    Statement stmt = null;
    try {
      Class.forName("org.postgresql.Driver");
      connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/dicerolling", "postgres", "postgres");
      connection.setAutoCommit(false);
      stmt = connection.createStatement();
      String sql = "CREATE TABLE AUTHENTICATION (" +
                   " EMAIL      CHAR(50)   PRIMARY KEY   NOT NULL," +
                   " USERNAME   CHAR(50)                 NOT NULL," +
                   " FIRST_NAME CHAR(50)                 NOT NULL," +
                   " LAST_NAME  CHAR(50)                 NOT NULL," +
                   " PASSOWRD   CHAR(50)                 NOT NULL);";
      sql += "CREATE TABLE GAME (" +
             " ID      SERIAL   PRIMARY KEY   NOT NULL," +
             " NAME    CHAR(50)               NOT NULL," +
             " CREATOR CHAR(50)               NOT NULL," +
             " CONSTRAINT CREATORSUPERFK FOREIGN KEY (CREATOR) REFERENCES" +
             " AUTHENTICATION(EMAIL) ON DELETE SET NULL ON UPDATE CASCADE);";
      stmt.executeUpdate(sql);
      stmt.close();
      connection.commit();
      connection.close();
    }
    catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
    }
      
  }

}
