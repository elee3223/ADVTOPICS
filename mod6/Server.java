package q1;

// Server.java
import java.io.*;
import java.net.*;
import java.util.Date;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Server extends Application {
  private TextArea ta = new TextArea();
  
  private int clientNo = 0;
  private String host = "localhost";

  @Override
  public void start(Stage primaryStage) {
    Scene scene = new Scene(new ScrollPane(ta), 450, 200);
    primaryStage.setTitle("Server");
    primaryStage.setScene(scene);
    primaryStage.show();

    new Thread( () -> {
      try {
        ServerSocket serverSocket = new ServerSocket(8000);
        ta.appendText("BMI Server started at " + new Date() + '\n');
    
        while (true) {
          Socket socket = serverSocket.accept();
    
          clientNo++;
          
          Platform.runLater( () -> {
            ta.appendText("Starting thread for client " + clientNo + " at " + new Date() + '\n');

            InetAddress inetAddress = socket.getInetAddress();
            ta.appendText("Client " + clientNo + "'s host name is " + host + "\n");
            ta.appendText("Client " + clientNo + "'s IP Address is " + inetAddress.getHostAddress() + "\n");
          });
          
          new Thread(new HandleAClient(socket)).start();
        }
      }
      catch(IOException ex) {
        System.err.println(ex);
      }
    }).start();
  }
  
  class HandleAClient implements Runnable {
    private Socket socket;

    public HandleAClient(Socket socket) {
      this.socket = socket;
    }

    public void run() {
      try {
        DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
        DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

        while (true) {
          //declare variables and get info from client
            double weight = inputFromClient.readDouble();  
            double height = inputFromClient.readDouble(); 
            
            //declare new bmi with input and send info to client
            BMI bmi = new BMI(weight,height);
            outputToClient.writeDouble(bmi.getBMI());
            outputToClient.writeUTF(bmi.getStatus());
        
            Platform.runLater(() -> {
              ta.appendText("Weight received from client: " + weight + '\n');            
              ta.appendText("Height received from client: " + height + '\n');
              ta.appendText("BMI is: " + bmi.getBMI() + '\n'); 
              ta.appendText("Status: " + bmi.getStatus());
            });
        }
      }
      catch(IOException ex) {
        ex.printStackTrace();
      }
    }
  }
  
  public static void main(String[] args) {
    launch(args);
  }
}