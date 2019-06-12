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
	
	GRAPH graph1 = new GRAPH();
	

	
    @Override
    public void start(Stage primaryStage) throws Exception {
    	
 
    	
    	graph1.knotenEinfuegen(new RAUM("raum1", "r1", 1));
    	graph1.knotenEinfuegen(new RAUM("raum2", "r2", 2));
    	graph1.knotenEinfuegen(new RAUM("raum3", "r3", 3));
    	graph1.knotenEinfuegen(new RAUM("raum4", "r4", 4));
    	graph1.knotenEinfuegen(new RAUM("raum5", "r5", 5));
    	
    	graph1.standortSetzen("r1");
    	
    	System.out.println(graph1.gibStandort());
    	
    	Pane root = new Pane();

        Scene scene = new Scene(root, 1880, 950);

        primaryStage.setTitle("ADVENTURE");
        primaryStage.setScene(scene);
        primaryStage.show();
    	
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
        Image spielbeginnt = new Image("/text/spiel-beginnt.jpg");

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
        btn1.setText("start!");
        btn1.setLayoutX(384);
        btn1.setLayoutY(850);
        btn1.setPrefHeight(70);
        btn1.setPrefWidth(200);


        Button btn2 = new Button();
        btn2.setText("---");
        btn2.setLayoutX(604);
        btn2.setLayoutY(850);
        btn2.setPrefHeight(70);
        btn2.setPrefWidth(200);

        Button btn3 = new Button();
        btn3.setText("---");
        btn3.setLayoutX(824);
        btn3.setLayoutY(850);
        btn3.setPrefHeight(70);
        btn3.setPrefWidth(200);


        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        root.getChildren().add(btn3);

        
        
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	textfield.setImage(spielbeginnt);
            }
        });
        
        tfb.setOnAction(new EventHandler<ActionEvent>() {
        	@Override public void handle (ActionEvent e) {
                if(tf1.getText() == "test") {
                	System.out.println("richtig");
                } else {
                	System.out.println("falsch");
                }
        	}
        });
        

    }


    public static void main(String[] args) {
        launch(args);
    }
}
