package edu.duke.summer.server;

import java.io.*;
import java.sql.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class Server {

  private final int frontendPort = 12345;
  private ServerSocket frontendListener;
  private Socket frontendSocket;
  private InputStream in;
  private OutputStream out;

  /**
   * This constructs a server
   */
  public Server()  {}

  /**
   * This starts the server
   */
  public void runServer() {
    System.out.println("Ready to get connection!");
    while(true) {
      getConnection();
      break;
    }
    System.out.println("Service start!");
    startService();
  }

  /**
   * This tries to make a socket connection betweeen backend server and frontend website
   */
  public void getConnection() {
    while (true) {
      try {
        frontendListener = new ServerSocket(frontendPort);
        frontendSocket = frontendListener.accept();
        in = frontendSocket.getInputStream();
        out = frontendSocket.getOutputStream();
        System.out.println("Connected Successfully!");
        break;
      }
      catch (IOException e) {
        System.out.println("Frontend connection: " + e.toString());
        continue;
      }
    }
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
    try {
      FrontendMessage message = new FrontendMessage();
      //new MessageOperator().receiveMessage(message, in);
      Thread th = new Thread() {
        @Override()
        public void run() {
          try {
            handleFrontendMessage(message);
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

  /**
   * This handles messages sent from frontend website
   */
  public void handleFrontendMessage(FrontendMessage message) throws IOException {

  }


}
