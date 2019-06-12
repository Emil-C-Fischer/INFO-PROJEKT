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
	
	 private void loadRo1(){
		 graph1.standortSetzen("r1");
		 
	 }
	 
	 private void loadRo2(){
	 }
	 
	 private void loadRo3(){
	 }
	 
	 private void loadRo4(){
	 }
	 
	 private void loadRo5(){
	 }
	
	
    @Override
    public void start(Stage primaryStage) throws Exception {
    	
 
    	//Graph init
    	graph1.knotenEinfuegen(new RAUM("raum1", "r1", 1));
    	graph1.knotenEinfuegen(new RAUM("raum2", "r2", 2));
    	graph1.knotenEinfuegen(new RAUM("raum3", "r3", 3));
    	graph1.knotenEinfuegen(new RAUM("raum4", "r4", 4));
    	graph1.knotenEinfuegen(new RAUM("raum5", "r5", 5));
    	
    	graph1.standortSetzen("r1");
    	System.out.println(graph1.gibStandort());
    	
    	//Javafx init
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
        Image minimapph = new Image("/minimap/minimap1.jpg");
        Image minimap1 = new Image("/minimap/1 Tempel Minimap.jpg");
        Image minimap2 = new Image("/minimap/2. Raum Minimap.jpg");
        Image minimap3 = new Image("/minimap/3. Raum Minimap.jpg");
        Image minimap4 = new Image("/minimap/4. Raum Minimap.jpg");
        Image minimap5 = new Image("/minimap/2. Schatzkammer Minimap.jpg");
        
        Image Raum1 = new Image("/main/tempel1.jpg");
        Image testtext = new Image("/text/testtext.jpg");
        Image spielbeginnt = new Image("/text/spiel-beginnt.jpg");

        //picture fields
        ImageView raum = new ImageView();
        raum.setImage(Raum1);
        raum.setLayoutX(384);
        root.getChildren().add(raum);
        raum.setFitWidth(1496);

        ImageView minimap = new ImageView();
        minimap.setImage(minimapph);
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

        btn2.setText("raum ändern");
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	graph1.standortSetzen("r2");
            }
        });
        	
        
        //------------------SPIELLOGIK------------------//
        btn2.setText("raum ändern");
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	graph1.standortSetzen("r2");
            }
        });
        
        
        
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	if(graph1.gibStandort().equals("raum1")) {
            	textfield.setImage(spielbeginnt);
            	}
            }
        });
        
        
        tfb.setOnAction(new EventHandler<ActionEvent>() {
        	@Override public void handle (ActionEvent e) {
                if(tf1.getText().toString().equalsIgnoreCase("test")) {
                	tf1.setText("richtig");
                } else {
                	tf1.setText("falsch");
                }
        	}
        });
        
    }


    public static void main(String[] args) {
        launch(args);
    }
}
