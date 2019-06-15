package application;

import java.awt.Insets;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
        Button tfb = new Button();
        tfb.setText("---abschicken---");
        tfb.setLayoutX(1715);
        tfb.setLayoutY(800);
        root.getChildren().add(tfb);
         
        Label label1 = new Label();
        label1.setLayoutX(387);
        label1.setLayoutY(800);
        label1.setText("---");
        root.getChildren().add(label1);
        
        TextField tf1 = new TextField();
        tf1.setLayoutX(550);
        tf1.setLayoutY(800);
        tf1.setPrefWidth(473);
        root.getChildren().add(tf1);
        
        Label label2 = new Label();
        label2.setLayoutX(1050);
        label2.setLayoutY(800);
        label2.setText("---");
        root.getChildren().add(label2);
        
        TextField tf2 = new TextField();
        tf2.setLayoutX(1186);
        tf2.setLayoutY(800);
        tf2.setPrefWidth(473);
        root.getChildren().add(tf2);
        
        //textfield:story
        TextArea storyta = new TextArea();
        storyta.setLayoutY(389);
        storyta.setPrefHeight(540);
        storyta.setPrefWidth(374);
        storyta.setWrapText(true);
        storyta.setEditable(false);
        root.getChildren().add(storyta);

        //Picture declaration--------
        //Minimap
        Image minimapph = new Image("/minimap/minimap1.jpg");
        Image minimap1 = new Image("/minimap/m1.jpg");
        Image minimap2 = new Image("/minimap/m2.jpg");
        Image minimap3 = new Image("/minimap/m3.jpg");
        Image minimap4 = new Image("/minimap/m4.jpg");
        Image minimap5 = new Image("/minimap/m5.jpg");
        //raetsel
        Image raetsel1 = new Image("/raetsel/r1.jpg");
        Image raetsel2 = new Image("/raetsel/r2.jpg");
        Image raetsel3 = new Image("/raetsel/r3.jpg");
        Image raetsel4 = new Image("/raetsel/r4.jpg");
        //Raeume
        Image Raum1 = new Image("/raum/r1.jpg");
        Image Raum2 = new Image("/raum/r2.jpg");
        Image Raum3 = new Image("/raum/r3.jpg");
        Image Raum4 = new Image("/raum/r4.jpg");
        Image Raum5 = new Image("/raum/r5.jpg");

        //Imageviewer RAUM
        ImageView raum = new ImageView();
        raum.setImage(Raum1);
        raum.setLayoutX(384);
        root.getChildren().add(raum);
        raum.setFitWidth(1496);

        //ImageViewer MINIMAP
        ImageView minimap = new ImageView();
        minimap.setImage(minimap1);
        root.getChildren().add(minimap);
        
        //Buttons
        Button btn1 = new Button();
        btn1.setText("---");
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
        
        //------------------SPIELLOGIK------------------//
        
        btn1.setText("START");
        storyta.setText("vorstory");
        
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	if(graph1.gibStandort().equals("r1") && !graph1.gibRaetselAktiv()) {
            		graph1.RaetselAktivSetzen();
            		storyta.setText("Das ist das R�tsel! Gebe die L�sung in das Textfeld ein und klicke auf 'abschicken'.");
            		raum.setImage(raetsel1);
            		label1.setText("Benutzername:");
            		label2.setText("Passwort:");
            		btn1.setText("---");
            	} else if(graph1.gibStandort().equals("r2") && !graph1.gibRaetselAktiv()) {
            		graph1.RaetselAktivSetzen();
            		storyta.setText("Das ist das R�tsel! Gebe die Reihenfolge, in der du die Hebel bet�tigen willst in das Textfeld ein und klicke auf 'abschicken'.");
            		raum.setImage(raetsel2);
            		label1.setText("Eingabe:");
            		btn1.setText("---");
            	} else if(graph1.gibStandort().equals("r3") && !graph1.gibRaetselAktiv()) {
            		graph1.RaetselAktivSetzen();
            		storyta.setText("Das ist das R�tsel! Gebe die richtige L�sung in das Textfeld ein und klicke auf 'abschicken'.");
            		raum.setImage(raetsel3);
            		label1.setText("Eingabe:");
            		btn1.setText("---");
            	} else if(graph1.gibStandort().equals("r4") && !graph1.gibRaetselAktiv()) {
            		graph1.RaetselAktivSetzen();
            		storyta.setText("Das ist das R�tsel! Gebe die richtige L�sung in das Textfeld ein und klicke auf 'abschicken'.");
            		raum.setImage(raetsel4);
            		label1.setText("Eingabe:");
            		btn1.setText("---");
            	}
            }
        });
        
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {

            }
        });
        
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	
            }
        });
        
        tfb.setOnAction(new EventHandler<ActionEvent>() {
        	@Override public void handle (ActionEvent e) {
        		if(graph1.gibStandort().equals("r1") && graph1.gibRaetselAktiv()){
        			if(tf1.getText().toString().equalsIgnoreCase("Pentagon") && tf2.getText().toString().equalsIgnoreCase("92")) {
        				graph1.RaetselInaktivSetzen();
        				graph1.standortSetzen("r2");
                		System.out.println(graph1.gibStandort());
                		minimap.setImage(minimap2);
                		raum.setImage(Raum2);
                		label1.setText("---");
                		label2.setText("---");
                		tf1.clear();
                		tf2.clear();
                		storyta.setText("willkommen in Raum 2!");
                		btn1.setText("zum R�tsel");
        			} else {
        				storyta.setText("Das ist das R�tsel! Gebe die L�sung in das Textfeld ein und klicke auf 'abschicken'. -----Deine L�sung war leider falsch. probiere es noch einmal!-----");
        			}
        		} else if(graph1.gibStandort().equals("r2") && graph1.gibRaetselAktiv()) {
        			if(tf1.getText().toString().equalsIgnoreCase("21122012")) {
        				graph1.RaetselInaktivSetzen();
        				graph1.standortSetzen("r3");
                		System.out.println(graph1.gibStandort());
                		minimap.setImage(minimap3);
                		raum.setImage(Raum3);
                		label1.setText("---");
                		label2.setText("---");
                		tf1.clear();
                		tf2.clear();
                		storyta.setText("willkommen in Raum 3!");
                		btn1.setText("zum R�tsel");
        			} else {
        				storyta.setText("Das ist das R�tsel! Gebe die Reihenfolge, in der du die Hebel bet�tigen willst in das Textfeld ein und klicke auf 'abschicken'. -----Deine L�sung war leider falsch. probiere es noch einmal!-----");
        			}
        		} else if(graph1.gibStandort().equals("r3") && graph1.gibRaetselAktiv()) {
        			if(tf1.getText().toString().equalsIgnoreCase("42")) {
        				graph1.RaetselInaktivSetzen();
        				graph1.standortSetzen("r4");
                		System.out.println(graph1.gibStandort());
                		minimap.setImage(minimap4);
                		raum.setImage(Raum4);
                		label1.setText("---");
                		label2.setText("---");
                		tf1.clear();
                		tf2.clear();
                		storyta.setText("willkommen in Raum 4!");
                		btn1.setText("zum R�tsel");
        			} else {
        				storyta.setText("Das ist das R�tsel! Gebe die richtige L�sung in das Textfeld ein und klicke auf 'abschicken'. -----Deine L�sung war leider falsch. probiere es noch einmal!-----");
        			}
        		} else if(graph1.gibStandort().equals("r4") && graph1.gibRaetselAktiv()) {
            		if(tf1.getText().toString().equalsIgnoreCase("aurum")) {
            			graph1.RaetselInaktivSetzen();
           				graph1.standortSetzen("r5");
                   		System.out.println(graph1.gibStandort());
                   		minimap.setImage(minimap5);
                   		raum.setImage(Raum5);
                   		label1.setText("---");
                   		label2.setText("---");
                   		tf1.clear();
                  		tf2.clear();
                   		storyta.setText("willkommen in Raum 5!");
                   		btn1.setText("---");
           			} else {
           				storyta.setText("Das ist das R�tsel! Gebe die richtige L�sung in das Textfeld ein und klicke auf 'abschicken'. -----Deine L�sung war leider falsch. probiere es noch einmal!-----");
           			}
       			}
        	}
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
