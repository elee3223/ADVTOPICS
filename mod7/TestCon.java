package com.test;
// test MySQL is accessible with MySQL Connector/J
// 0. put mysql-connector-j-8.0.32.jar in the same folder as TestCon.java
// 1. Run from Visual Studio Code:
// add  mysql-connector-j-8.0.32.jar to Java Projects -> Reference libraries
// 2. Run from command line:
// javac TestCon.java
// java -classpath ".;mysql-connector-j-8.0.32.jar"   TestCon
import java.sql.*;

class TestCon {
  public static void main(String args[]) {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/test", "root", "your_password");
      if (con == null) {
        System.out.println("Something wrong with the database development environment.");
        return;
      } else {
        System.out.println("You are good to go.");
        con.close();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}