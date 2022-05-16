package edu.duke.summer.server;

import java.io.*;
import java.sql.*;
import java.util.*;

public class MessageOperator {

   /**
   * This constructs a message operator
   */
  public MessageOperator() {}

  /**
   * This sends message to frontend website
   */ 
  public boolean sendMessage(String message, OutputStream output) throws IOException { 
    OutputStreamWriter outputWriter = new OutputStreamWriter(output);
    outputWriter.write(message);
    return true;
  }

  /**
   * This receives message from frontend website
   */ 
  public boolean receiveMessage(String message, InputStream input) throws IOException {
    InputStreamReader inputReader = new InputStreamReader(input);
    BufferedReader bufferReader = new BufferedReader(inputReader);
    message = bufferReader.readLine();
    return true; 
  }
}
