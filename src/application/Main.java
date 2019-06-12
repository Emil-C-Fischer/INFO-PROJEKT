package application;

import java.awt.Insets;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class Main extends Application {
    boolean istgruen = false;

    @Override
    public void start(Stage primaryStage) throws Exception {


    	Pane root = new Pane();

        //Control panel
        TextField tf1 = new TextField ();
        tf1.setLayoutX(384);
        tf1.setLayoutY(800);
        tf1.setPrefWidth(1300);
        Button tfb = new Button();
        tfb.setText("---abschicken---");
        tfb.setLayoutX(1715);
        tfb.setLayoutY(800);
        root.getChildren().add(tf1);
        root.getChildren().add(tfb);

        //Picture declaration
        Image minimap1 = new Image("/minimap/minimap1.jpg");
        Image tempel1 = new Image("/main/tempel1.jpg");
        Image testtext = new Image("/text/testtext.jpg");

        //picture fields
        ImageView main = new ImageView();
        main.setImage(tempel1);
        main.setLayoutX(384);
        root.getChildren().add(main);
        main.setFitWidth(1496);

        ImageView minimap = new ImageView();
        minimap.setImage(minimap1);
        root.getChildren().add(minimap);

        ImageView textfield = new ImageView();
        textfield.setImage(testtext);
        root.getChildren().add(textfield);
        textfield.setLayoutY(384);

        //Buttons
        Button btn1 = new Button();
        btn1.setText("btn1");
        btn1.setLayoutX(384);
        btn1.setLayoutY(850);
        btn1.setPrefHeight(70);
        btn1.setPrefWidth(200);


        Button btn2 = new Button();
        btn2.setText("btn2");
        btn2.setLayoutX(604);
        btn2.setLayoutY(850);
        btn2.setPrefHeight(70);
        btn2.setPrefWidth(200);

        Button btn3 = new Button();
        btn3.setText("btn3");
        btn3.setLayoutX(824);
        btn3.setLayoutY(850);
        btn3.setPrefHeight(70);
        btn3.setPrefWidth(200);


        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        root.getChildren().add(btn3);


        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	//
            }
        });

        Scene scene = new Scene(root, 1880, 950);

        primaryStage.setTitle("ADVENTURE");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
