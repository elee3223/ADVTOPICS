import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class MyJavaFX extends Application {
   
  // the JVM constructs an instance of MyJavaFX using its no-arg constructor 
  // and invokes its start method
  @Override
  public void start(Stage primaryStage) {

    Button btOK = new Button("Click Me!");
    Scene scene = new Scene(btOK, 300, 30);
    primaryStage.setTitle("Primary Stage"); 
    primaryStage.setScene(scene); 
    primaryStage.show(); 

    Stage stage2 = new Stage();
    stage2.setTitle("Secondary Stage");
    stage2.setScene(new Scene(new Button("Welcome to JavaFX."), 300, 60));
    stage2.show();
  }
  
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) { 
    launch(args);
  }
}