package q1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class movingBall extends Application {
  private CirclePane circlePane = new CirclePane();

  @Override
  public void start(Stage primaryStage) {

    //set buttons
    HBox hBox = new HBox();
    hBox.setSpacing(10);
    hBox.setAlignment(Pos.CENTER);
    Button btnUp = new Button("Up");
    Button btnDown = new Button("Down");
    Button btnLeft = new Button("Left");
    Button btnRight = new Button("Right");
    hBox.getChildren().add(btnUp);
    hBox.getChildren().add(btnDown);
    hBox.getChildren().add(btnLeft);
    hBox.getChildren().add(btnRight);
    
    //set button actions
    btnUp.setOnAction(e -> {circlePane.up();});
    btnDown.setOnAction(e -> {circlePane.down();});
    btnLeft.setOnAction(e -> {circlePane.left();});
    btnRight.setOnAction(e -> {circlePane.right();});

    //create panes
    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(circlePane);
    borderPane.setBottom(hBox);
    BorderPane.setAlignment(hBox, Pos.CENTER);
    
    Scene scene = new Scene(borderPane, 300, 300);
    primaryStage.setTitle("ControlCircle");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  
  public static void main(String[] args) {
    launch(args);
  }
}

class CirclePane extends Pane {
    int rad = 50;
  private Circle circle = new Circle(rad); 
  
  public CirclePane() {

    //creates circle and add color
    getChildren().add(circle);
    circle.setStroke(Color.RED);
    circle.setFill(Color.YELLOW);
    circle.setCenterX(150);
    circle.setCenterY(100);
  }
  
  //translate up and check for border
  public void up() {
    circle.setCenterY(circle.getCenterY() > rad+10 ? circle.getCenterY() - 10 : rad);
  }
  
  //translate down and check for border
  public void down() {
    circle.setCenterY(circle.getCenterY() < (290 - rad) ? circle.getCenterY() + 10 : (300 - rad));
  }

  //translate left and check for border
  public void left() {
    circle.setCenterX(circle.getCenterX() > rad+10 ? circle.getCenterX() - 10 : rad);
  }

  //translate right and check for border
  public void right() {
    circle.setCenterX(circle.getCenterX() < (290 - rad) ? circle.getCenterX() + 10 : (300-rad));
  }
}
