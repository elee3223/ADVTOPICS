package com.test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.*;

public class SQL extends Application {
  //declare textfields, prepared statement, and connection that will be used
  private PreparedStatement pStmt;
  private Connection connection;
  private TextField tfID = new TextField();
  private TextField tfLName = new TextField();
  private TextField tfFName = new TextField();
  private TextField tfMI = new TextField();
  private TextField tfAddress = new TextField();
  private TextField tfCity = new TextField();
  private TextField tfState = new TextField();
  private TextField tfPhone = new TextField();
  private TextField tfEmail = new TextField();
  private Label lblStatus = new Label();
  
  @Override
  public void start(Stage primaryStage) {
    initializeDB();

    //spaces to seperate text fileds/labels in flowpane
    Region space = new Region();
    space.setPrefSize(450, 0);
    Region space1 = new Region();
    space1.setPrefSize(400, 0);
    Region space2 = new Region();
    space2.setPrefSize(180, 0);

    //buttons for functions
    Button btnView = new Button("View");
    Button btnInsert = new Button("Insert");
    Button btnUpdate = new Button("Update");
    Button btnClear = new Button("Clear");

    //add nodes to flowpane
    FlowPane pane = new FlowPane();
    pane.getChildren().addAll(lblStatus, space, new Label("ID"), tfID, space1, 
    new Label("Last Name"), tfLName, new Label("First Name"),
     tfFName, new Label("MI"), tfMI, new Label("Address"), tfAddress,
      new Label("City"), tfCity, new Label("State"), tfState,
      new Label("Telephone"), tfPhone, space2, new Label("Email"), tfEmail,
      btnView, btnInsert, btnUpdate, btnClear);

    VBox vBox = new VBox(10);
    vBox.getChildren().addAll(pane);
    
    tfID.setPrefColumnCount(9);
    tfLName.setPrefColumnCount(10);
    tfFName.setPrefColumnCount(10);
    tfMI.setPrefColumnCount(2);
    tfAddress.setPrefColumnCount(18);
    tfCity.setPrefColumnCount(12);
    tfState.setPrefColumnCount(2);
    tfPhone.setPrefColumnCount(10);
    tfEmail.setPrefColumnCount(35);

    //setting actions for buttons
    btnView.setOnAction(e -> ViewRecord());
    btnInsert.setOnAction(e -> InsertRecord());
    btnUpdate.setOnAction(e -> UpdateRecord());
    btnClear.setOnAction(e -> Clear());
    
    Scene scene = new Scene(vBox, 450, 300);
    primaryStage.setTitle("Staff Database");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  //connects with the database
  private void initializeDB() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      System.out.println("Driver loaded");

      connection = DriverManager.getConnection
        ("jdbc:mysql://localhost:3306/lab4", "root", "your_password");
      System.out.println("Database connected");
      lblStatus.setText("Database connected");

    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  //allows user to view an existing record
  private void ViewRecord() {
    String ID = tfID.getText();
    try {
      String queryString = "SELECT * FROM Staff WHERE ID = ?";
      pStmt = connection.prepareStatement(queryString);
      pStmt.setString(1, ID);
      ResultSet rset = pStmt.executeQuery();

      //if a record with the inputted ID is found, show all the attributes
      if (rset.next()) {
        tfLName.setText(rset.getString(2));
        tfFName.setText(rset.getString(3));
        tfMI.setText(rset.getString(4));
        tfAddress.setText(rset.getString(5));
        tfCity.setText(rset.getString(6));
        tfState.setText(rset.getString(7));
        tfPhone.setText(rset.getString(8));
        tfEmail.setText(rset.getString(9));

        lblStatus.setText("Record with ID " + ID + " found");

      } else {
        lblStatus.setText("Record with ID " + ID +" not found");
      }
    }
    catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  //inserts a new record to the database
  private void InsertRecord() {
    String ID = tfID.getText();

    try {
      //query string to send to database 
      String queryString = "INSERT INTO Staff (id, lastName, firstName, mi, address, city, state, telephone, email)" +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        //connects prepared statement
        pStmt = connection.prepareStatement(queryString);

        //inputs parameter values
        pStmt.setString(1, tfID.getText());
        pStmt.setString(2, tfLName.getText());
        pStmt.setString(3, tfFName.getText());
        pStmt.setString(4, tfMI.getText());
        pStmt.setString(5, tfAddress.getText());
        pStmt.setString(6, tfCity.getText());
        pStmt.setString(7, tfState.getText());
        pStmt.setString(8, tfPhone.getText());
        pStmt.setString(9, tfEmail.getText());
        pStmt.execute();
      
        lblStatus.setText("Record with ID " + ID + " has been inserted");

      } 
    
    catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  //updates an existing record
  private void UpdateRecord() {
    String ID = tfID.getText();

    try {
      //query string to send to database
      String queryString = "UPDATE staff SET lastName=?, firstName=?, mi=?, address=?, city=?, state=?, telephone=?, email=? WHERE id=?";

      //connects prepared statement
      pStmt = connection.prepareStatement(queryString);
      
      //input parameter values
      pStmt.setString(1, ID);
        pStmt.setString(2,tfLName.getText());
        pStmt.setString(3,tfFName.getText());
        pStmt.setString(4,tfMI.getText());
        pStmt.setString(5, tfAddress.getText() );
        pStmt.setString(6, tfCity.getText() );
        pStmt.setString(7, tfState.getText() );
        pStmt.setString(8, tfPhone.getText() );
        pStmt.setString(9, tfEmail.getText() );
        
        pStmt.executeUpdate();
      
        lblStatus.setText("Record with ID " + ID + " has been updated");

      } 
    
    catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  //clear all text fields
  private void Clear(){
    tfID.clear();
    tfLName.clear();
    tfFName.clear();
    tfMI.clear();
    tfAddress.clear();
    tfCity.clear();
    tfState.clear();
    tfPhone.clear();
    tfEmail.clear();
    lblStatus.setText(" ");
  }
  public static void main(String[] args) {
    launch(args);
  }
}