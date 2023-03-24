package q1;

// Client.java
import java.io.*;
import java.net.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class BMIClient extends Application {
  DataOutputStream toServer = null;
  DataInputStream fromServer = null;

  @Override
  public void start(Stage primaryStage) {
    //prompt for weight
    GridPane paneForTextField = new GridPane();
    paneForTextField.setPadding(new Insets(5, 5, 5, 5)); 
    paneForTextField.setStyle("-fx-border-color: green");
    paneForTextField.add((new Label("Enter a weight: ")),0,0);

    TextField tf = new TextField();
    tf.setAlignment(Pos.BOTTOM_RIGHT);
    paneForTextField.add((tf),1,0);

    //prompt for height
    GridPane paneForTextField2 = new GridPane();
    paneForTextField2.setPadding(new Insets(5, 5, 5, 5)); 
    paneForTextField2.setStyle("-fx-border-color: green");
    paneForTextField2.add((new Label("Enter a height: ")),0,1);    

    TextField tf2 = new TextField();
    tf2.setAlignment(Pos.BOTTOM_RIGHT);
    paneForTextField2.add((tf2),1,1);

    //button to send information
    Button submit = new Button("Submit");
    
    //format pane with gridpane
    GridPane mainPane = new GridPane();
    TextArea ta = new TextArea();
    mainPane.add((new ScrollPane(ta)), 0, 2);
    mainPane.add((paneForTextField), 0, 0);
    mainPane.add((paneForTextField2), 0, 1);
    mainPane.add(submit, 1, 1);
    
    Scene scene = new Scene(mainPane, 550, 200);
    primaryStage.setTitle("Client");
    primaryStage.setScene(scene);
    primaryStage.show();
    
    submit.setOnAction(e -> {
      try {
        //declare variables and assign from input
        double weight = Double.parseDouble(tf.getText().trim());
        double height = Double.parseDouble(tf2.getText().trim());
  
        //write info to server
        toServer.writeDouble(weight);
        toServer.writeDouble(height);
        toServer.flush();
  
        //get info from server
        double BMI = fromServer.readDouble();
        String bmiStatus = fromServer.readUTF();
  
        //display input and output
        ta.appendText("Weight: " + weight + "\n");
        ta.appendText("Height: " + height + "\n");
        ta.appendText("BMI: " + BMI + '\n');
        ta.appendText("Status: " + bmiStatus);
      }
      catch (IOException ex) {
        System.err.println(ex);
      }
    });
  
    try {
      Socket socket = new Socket("localhost", 8000);
      fromServer = new DataInputStream(socket.getInputStream());
      toServer = new DataOutputStream(socket.getOutputStream());
    }
    catch (IOException ex) {
      ta.appendText(ex.toString() + '\n');
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}

