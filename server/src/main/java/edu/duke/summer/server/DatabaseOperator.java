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
   * This verifies the user identity
   */
  public boolean verifyUserInfo(String username, String password) {
    Connection connection = null;
    Statement stmt = null;
    boolean status = false;
    try {
      Class.forName("org.postgresql.Driver");
      connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/dicerolling", "postgres", "postgres");
      connection.setAutoCommit(false);
      stmt = connection.createStatement();
      String sql = "SELECT password FROM amazon_package WHERE username=" + username + ";";
      ResultSet res = stmt.executeQuery(sql);
      while (res.next()) {
        if (password.equals(res.getString("password"))) {
          status = true;
        }
      }
      res.close();
      stmt.close();
      connection.close();
    }
    catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
    }
    return status;
  }

}
