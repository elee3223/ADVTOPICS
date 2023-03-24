package q2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.lang.Math;
import javafx.geometry.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;

public class InvestmentValueCalculator extends Application{

    private TextField investAmount = new TextField();
    private TextField numYears = new TextField();
    private TextField annualIntRate = new TextField();
    private TextField futureValue = new TextField();
    
    private Button btnCalculate = new Button("Calculate");

      @Override
  public void start(Stage primaryStage) {

    GridPane pane = new GridPane();
    pane.setHgap(5);
    pane.setVgap(5);

    //create labels and set different colors
    Label firstLine = new Label("Investment Amount:");
    firstLine.setTextFill(Color.PINK);
    firstLine.setFont(Font.font("Verdana"));
    Label secondLine = new Label("Number of Years:");
    secondLine.setTextFill(Color.BLUE);
    secondLine.setFont(Font.font("Arial"));
    Label thirdLine = new Label("Annual Interest Rate: ");
    thirdLine.setTextFill(Color.GREEN);
    thirdLine.setFont(Font.font("New Times Roman", null, FontPosture.ITALIC, 12));
    Label last = new Label("Future Value: ");
    last.setTextFill(Color.RED);
    last.setFont(Font.font("Verdana", FontWeight.BOLD, null, 13));

    //add textfields and labels to gridpane
    pane.add(firstLine, 0, 0);
    pane.add(investAmount, 1, 0);
    pane.add(secondLine, 0, 1);
    pane.add(numYears, 1, 1);
    pane.add(thirdLine, 0, 2);
    pane.add(annualIntRate, 1, 2);
    pane.add(last, 0, 3);
    pane.add(futureValue, 1, 3);
    futureValue.setEditable(false);

    //set button action and alignment
    btnCalculate.setOnAction(e -> calculate());
    pane.add(btnCalculate,1,4);
    investAmount.setAlignment(Pos.BOTTOM_RIGHT);
    numYears.setAlignment(Pos.BOTTOM_RIGHT);
    annualIntRate.setAlignment(Pos.BOTTOM_RIGHT);
    futureValue.setAlignment(Pos.BOTTOM_RIGHT);
    pane.setHalignment(btnCalculate, HPos.RIGHT);
    
    //customize button
    btnCalculate.setStyle("-fx-background-color: BLUE");

    //set padding
    pane.setAlignment(Pos.CENTER);
    pane.setPadding(new Insets(10));
    
    //set background image
    pane.setStyle("-fx-background-image: url('http://clipart-library.com/images/riLx4q5i8.jpg'); -fx-background-size: 250 250;");
    
          
    Scene scene = new Scene(pane);
    primaryStage.setTitle("Interest Calculator");
    primaryStage.setScene(scene);

    //set icon
    Image image = new Image("https://b2161880.smushcdn.com/2161880/wp-content/uploads/2017/09/Fotolia_162488305_Subscription_Monthly_M-768x480.jpg?lossy=1&strip=1&webp=1");
    primaryStage.getIcons().add(image);
    primaryStage.show();

  }

  private void calculate(){
    double deposit = Double.parseDouble(investAmount.getText());
    int years = Integer.parseInt(numYears.getText());
    double rate = Double.parseDouble(annualIntRate.getText());
    double monthlyRate = (rate/12)/100;
    
    double finalValue = deposit*(Math.pow((1+monthlyRate),(double)(years*12)));
    futureValue.setText(String.format("$%.2f", finalValue));
  }
  

  public static void main(String[] args) {
    launch(args);
  }
} 


    

