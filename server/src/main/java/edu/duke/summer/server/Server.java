package edu.duke.summer.server;

import java.io.*;
import java.sql.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

import edu.duke.summer.shared.*;

public class Server {

  private final int frontendPort = 12345;
  private ServerSocket frontendListener;

  /**
   * This constructs a server
   */
  public Server()  {}

  /**
   * This starts the server
   */
  public void runServer() {
    System.out.println("Database setup!");
    new DatabaseOperator().setupDatabase();
    System.out.println("Service start!");
    startService();
  }


  /**
   * This starts to deal with messages from frontend website
   */
  public void startService() {
    Thread th = new Thread() {
      @Override()
      public void run() {
        receiveFrontendMessage();
      }
    };
    th.start();
  }

  /**
   * This receives messages sent from frontend website
   */
  public void receiveFrontendMessage() {
    while (true) {
      try {
        Socket frontendSocket = frontendListener.accept();
        Thread th = new Thread() {
          @Override()
          public void run() {
            try {
              InputStream in = frontendSocket.getInputStream();
              OutputStream out = frontendSocket.getOutputStream();
              Action action = new Action();
              new MessageOperator().receiveMessage(action, in);
              action.doAction();
            }
            catch (IOException e) {
              System.out.println("Message from frontend: " + e.toString());
            }
          }
        };
        th.start();
      }
      catch (Exception e) {
        System.out.println("Message from frontend: " + e.toString());
      }
    }
  }


}
