package assignment4;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class risingFlag extends Application {
  private double y;
  private int speed;

  @Override
  public void start(Stage primaryStage) {
    Pane pane = new Pane();
    
    //set image and its dimensions
    ImageView imageView = new ImageView("https://upload.wikimedia.org/wikipedia/en/thumb/a/a4/Flag_of_the_United_States.svg/800px-Flag_of_the_United_States.svg.png?20151118161041");
    imageView.setFitHeight(84);
    imageView.setFitWidth(160);


    double flagHeight = imageView.getLayoutBounds().getHeight();
     pane.getChildren().add(imageView);

     //set y value and default speed
     imageView.setY((-flagHeight/2));
     speed = 2;

     Scene scene = new Scene(pane, 250, 200);
    primaryStage.setTitle("FlagRisingByPathTransition");
    primaryStage.setScene(scene);
    primaryStage.show();

    
    //thread for animation
    new Thread(new Runnable(){
        @Override
        public void run(){
          
            try{

                while(true){
                  
                  //if image's y-value is less than its min, then continue moving upward; else, set it to the bottom again (max)
                  if(imageView.getY() > (-flagHeight/2 - 200))
                    y = (imageView.getY() - speed);
                  else
                    y =(200 + flagHeight/2);

                    //if the up/down key is pressed, change the speed
                    scene.setOnKeyPressed( e -> {
                      if(e.getCode() == KeyCode.UP)
                        speed++;
                      if(e.getCode() == KeyCode.DOWN)
                        speed--;
                                
                    });
                    
                  //set the y-value
                Platform.runLater(()-> imageView.setY(y));
                Thread.sleep(20);
                }
            }
            catch(InterruptedException ex){}
              
                
        }
                  

    }).start();
    
    
    
  }
  
  public static void main(String[] args) {
    launch(args);
  }
}