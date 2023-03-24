package q2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import java.lang.Math;
import javafx.scene.shape.Circle;

public class WelcomeToJava extends Application {

  @Override 
  public void start(Stage primaryStage) {
    
    Pane pane = new Pane();
    pane.setPadding(new Insets(5, 5, 5, 5));

    String str = " WELCOME TO JAVA ";
    char[] sen = str.toCharArray();
    String[] let = new String[sen.length];

    int radius = 225;

    for(int i = 0; i < sen.length; i++){
      let[i] = String.valueOf(sen[i]);
      Text letter = new Text(230+(radius*Math.cos(Math.PI - (i*((2*Math.PI)/sen.length)))), 275-(radius*Math.sin(Math.PI - (i*((2*Math.PI)/sen.length)))), let[i]);
      letter.setFont(Font.font("Courier", FontWeight.BOLD, 60));     
      letter.setRotate(-90 + (i*(360/sen.length)));
      pane.getChildren().add(letter);
    }

    Circle cir = new Circle();
    cir.setCenterX(250);
    cir.setCenterY(250);
    cir.setRadius(200);
    cir.setFill(null);
    cir.setStroke(Color.RED);
    pane.getChildren().add(cir);
       
    Scene scene = new Scene(pane);
    primaryStage.setTitle("ShowText"); 
    primaryStage.setScene(scene); 
    primaryStage.show(); 
    primaryStage.setHeight(550);
    primaryStage.setWidth(550);
  }
  
  public static void main(String[] args) {
    launch(args);
  }

}
