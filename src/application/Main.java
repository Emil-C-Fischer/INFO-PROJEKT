package application;

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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class Main extends Application {
	
	GRAPH graph1 = new GRAPH();
	int tips;
	int counter = 0;
	int score = 0;
	String story;
    
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
        tfb.setVisible(false);
     
        Label label1 = new Label();
        label1.setLayoutX(387);
        label1.setLayoutY(800);
        label1.setText("---");
        label1.setVisible(false);
        root.getChildren().add(label1);
        
        TextField tf1 = new TextField();
        tf1.setLayoutX(550);
        tf1.setLayoutY(800);
        tf1.setPrefWidth(473);
        tf1.setVisible(false);
        root.getChildren().add(tf1);
        
        Label label2 = new Label();
        label2.setLayoutX(1050);
        label2.setLayoutY(800);
        label2.setText("---");
        label2.setVisible(false);
        root.getChildren().add(label2);
        
        TextField tf2 = new TextField();
        tf2.setLayoutX(1186);
        tf2.setLayoutY(800);
        tf2.setPrefWidth(473);
        tf2.setVisible(false);
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
        btn2.setVisible(false);

        Button btn3 = new Button();
        btn3.setText("---");
        btn3.setLayoutX(824);
        btn3.setLayoutY(850);
        btn3.setPrefHeight(70);
        btn3.setPrefWidth(200);

        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        //root.getChildren().add(btn3);
        
        //------------------SPIELLOGIK------------------//
        
        btn1.setText("START");
        storyta.setText("vorstory");
        
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	if(graph1.gibStandort().equals("r1") && !graph1.gibRaetselAktiv()) {
            		graph1.RaetselAktivSetzen();
            		story = "Das ist das R�tsel! Gebe die L�sung in das Textfeld ein und klicke auf 'abschicken'.";
            		storyta.setText(story);
            		raum.setImage(raetsel1);
            		label1.setText("Benutzername:");
            		label1.setVisible(true);
            		label2.setText("Passwort:");
            		label2.setVisible(true);
            		btn1.setText("---");
            		btn1.setVisible(true);
            		btn2.setText("Tip");
            		btn2.setVisible(true);
            		tf1.setVisible(true);
            		tf2.setVisible(true);
            		btn1.setVisible(false);
            		tfb.setVisible(true);
            	} else if(graph1.gibStandort().equals("r2") && !graph1.gibRaetselAktiv()) {
            		graph1.RaetselAktivSetzen();
            		story = "Das ist das R�tsel! Gebe die Reihenfolge, in der du die Hebel bet�tigen willst in das Textfeld ein und klicke auf 'abschicken'.";
            		storyta.setText(story);
            		raum.setImage(raetsel2);
            		label1.setText("Eingabe:");
            		label1.setVisible(true);
            		tf1.setVisible(true);
            		btn1.setVisible(false);
            		btn2.setVisible(true);
            		tfb.setVisible(true);
            		btn1.setText("---");
            		btn2.setText("Tip");
            	} else if(graph1.gibStandort().equals("r3") && !graph1.gibRaetselAktiv()) {
            		graph1.RaetselAktivSetzen();
            		story = "Das ist das R�tsel! Gebe die richtige L�sung in das Textfeld ein und klicke auf 'abschicken'.";
            		storyta.setText(story);
            		raum.setImage(raetsel3);
            		label1.setText("Eingabe:");
            		btn1.setText("---");
            		btn2.setText("Tip");
            		btn1.setVisible(false);
            		btn2.setVisible(true);
            		label1.setVisible(true);
            		tf1.setVisible(true);
            		tfb.setVisible(true);
            	} else if(graph1.gibStandort().equals("r4") && !graph1.gibRaetselAktiv()) {
            		graph1.RaetselAktivSetzen();
            		story = "Das ist das R�tsel! Gebe die richtige L�sung in das Textfeld ein und klicke auf 'abschicken'.";
            		storyta.setText(story);
            		raum.setImage(raetsel4);
            		label1.setText("Eingabe:");
            		label1.setVisible(true);
            		tf1.setVisible(true);
            		tfb.setVisible(true);
            		btn1.setText("---");
            		btn1.setVisible(false);
            		btn2.setText("Tip");
            		btn2.setVisible(true);
            	}
            }
        });
        
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	if(graph1.gibStandort().equals("r1") && graph1.gibRaetselAktiv()) {
            		if(tips == 0) {
           				story = storyta.getText();
           				storyta.setText(story +"\nWer ist nochmal f�r die US-Streitkr�fte zust�ndig?");
           				tips++;
           				score = score-1;
           				System.out.println(score);
           			} else if (tips == 1) {
           				story = storyta.getText();
           				storyta.setText(story +"\nMensch, das Ergebnis kann doch nicht so schwer sein, leg dich doch nicht quer!");
           				tips++;
           				score = score-1;
           				System.out.println(score);
           			} else if (tips == 2) {
           				story = storyta.getText();
           				storyta.setText(story +"\nHast du's echt nicht begriffen? Es geht um die QUERSUMME!");
           				tips++;
           				score = score-1;
           				System.out.println(score);
           			} else if (tips <= 3) {
           				story = storyta.getText();
           				storyta.setText(story +"\nDu D�del! mehr Tips gibs nicht!");
           				score = score-1;
           				System.out.println(score);
           			}
            	} else if(graph1.gibStandort().equals("r2") && graph1.gibRaetselAktiv()) {
           			if(tips == 0) {
            			story = storyta.getText();
           				storyta.setText(story +"\nVielleicht l�sst sich aus den Zahlen ja ein Datum bilden.");
           				tips++;
           				score = score-1;
           				System.out.println(score);
           			} else if (tips == 1) {
           				story = storyta.getText();
           				storyta.setText(story +"\nHatten die Maya nicht einen Kalender? Mir einem ber�hmten Datum?");
           				tips++;
           				score = score-1;
           				System.out.println(score);
           			} else if (tips <= 2) {
           				story = storyta.getText();
           				storyta.setText(story +"\nDu D�del! mehr Tips gibs nicht!");
           				score = score-1;
           				System.out.println(score);
           			}
           		} else if(graph1.gibStandort().equals("r3") && graph1.gibRaetselAktiv()) {
            		if(tips == 0) {
           				story = storyta.getText();
           				storyta.setText(story +"\nMan kann diese Gleichungen doch als Rechnungen ansehen, oder?");
           				tips++;
           				score = score-1;
           				System.out.println(score);
           			} else if (tips == 1) {
           				story = storyta.getText();
           				storyta.setText(story +"\nwenn ich die Zeichen mal mit Buchstaben ersetze ist es dann �bersichtlicher und ich kann die Gleichungen danach l�sen...");
           				tips++;
           				score = score-1;
           				System.out.println(score);
            		} else if (tips <= 2) {
            			story = storyta.getText();
           				storyta.setText(story +"\nDu D�del! mehr Tips gibs nicht!");
           				score = score-1;
           				System.out.println(score);
           			}
            	} else if(graph1.gibStandort().equals("r4") && graph1.gibRaetselAktiv()) {
            		if(tips == 0) {
           				story = storyta.getText();
           				storyta.setText(story +"\nes ist also ein lateinisches Wort...");
           				tips++;
           				score = score-1;
           				System.out.println(score);
           			} else if (tips == 1) {
           				story = storyta.getText();
           				storyta.setText(story +"\nGold hat eine bestimmte Abk�rzung im Periodensystem. Warum?");
           				tips++;
           				score = score-1;
           				System.out.println(score);
           			} else if (tips <= 2) {
           				story = storyta.getText();
           				storyta.setText(story +"\nDu D�del! mehr Tips gibs nicht!");
           				score = score-1;
           				System.out.println(score);
           			}
           		}
            }
        });
        
        /*
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	
            }
        });
        */
        
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
                		label1.setVisible(false);
                		label2.setText("---");
                		label2.setVisible(false);
                		tf1.clear();
                		tf1.setVisible(false);
                		tf2.clear();
                		tf2.setVisible(false);
                		tfb.setVisible(false);
                		if (counter == 0) {
                			score = score+20;
                			System.out.println(score);
                			storyta.setText("Gl�ckwunsch, du hast das R�tsel auf Anhieb gel�st!\nWillkommen in Raum 2!\nDu hast "+tips+" tip(s) abgerufen.");
                		} else {
                			score = score+10;
                			System.out.println(score);
                			storyta.setText("Du hast " +(counter+1)+" Versuche ben�tigt. \nWillkommen in Raum 2!\nDu hast "+tips+" tip(s) abgerufen.");
                		}
                		counter = 0;
                		tips = 0;
                		btn1.setText("zum R�tsel");
                		btn2.setText("---");
                		btn2.setVisible(false);
                		btn1.setVisible(true);
        			} else {
        				story = storyta.getText();
        				storyta.setText(story + "\n-----Deine L�sung war leider falsch. probiere es noch einmal!-----");
        				tf1.clear();
        				tf2.clear();
        				counter ++;
        				score = score-2;
        				System.out.println(score);
        			}
        		} else if(graph1.gibStandort().equals("r2") && graph1.gibRaetselAktiv()) {
        			if(tf1.getText().toString().equalsIgnoreCase("21.12.2012")) {
        				graph1.RaetselInaktivSetzen();
        				graph1.standortSetzen("r3");
                		System.out.println(graph1.gibStandort());
                		minimap.setImage(minimap3);
                		raum.setImage(Raum3);
                		label1.setText("---");
                		label1.setVisible(false);
                		label2.setText("---");
                		tf1.clear();
                		tf1.setVisible(false);
                		tf2.clear();
                		if (counter == 0) {
                			score = score+20;
                			System.out.println(score);
                			storyta.setText("Gl�ckwunsch, du hast das R�tsel auf Anhieb gel�st!\nWillkommen in Raum 3!\nDu hast "+tips+" tip(s) abgerufen.");
                		} else {
                			score = score+10;
                			System.out.println(score);
                			storyta.setText("Du hast " +(counter+1)+" Versuche ben�tigt. \nWillkommen in Raum 3!\nDu hast "+tips+" tip(s) abgerufen.");
                		}
                		counter = 0;
                		tips = 0;
                		btn1.setText("zum R�tsel");
                		btn1.setVisible(true);
                		btn2.setText("---");
                		btn2.setVisible(false);
                		tfb.setVisible(false);
        			} else {
        				story = storyta.getText();
        				storyta.setText(story +"\n-----Deine L�sung war leider falsch. probiere es noch einmal!-----");
           				tf1.clear();
        				tf2.clear();
        				counter ++;
        				score = score-2;
        				System.out.println(score);
        			}
        		} else if(graph1.gibStandort().equals("r3") && graph1.gibRaetselAktiv()) {
        			if(tf1.getText().toString().equalsIgnoreCase("29")) {
        				graph1.RaetselInaktivSetzen();
        				graph1.standortSetzen("r4");
                		System.out.println(graph1.gibStandort());
                		minimap.setImage(minimap4);
                		raum.setImage(Raum4);
                		label1.setText("---");
                		label1.setVisible(false);
                		label2.setText("---");
                		tf1.clear();
                		tf1.setVisible(false);
                		tf2.clear();
                		if (counter ==0 ) {
                			score = score+20;
                			System.out.println(score);
                			storyta.setText("Gl�ckwunsch, du hast das R�tsel auf Anhieb gel�st!\nWillkommen in Raum 4!\nDu hast "+tips+" tip(s) abgerufen.");
                		} else {
                			score = score+10;
                			System.out.println(score);
                			storyta.setText("Du hast " +(counter+1)+" Versuche ben�tigt. \nWillkommen in Raum 4!\nDu hast "+tips+" tip(s) abgerufen.");
                		}
                		counter = 0;
                		tips = 0;
                		btn1.setText("zum R�tsel");
                		btn1.setVisible(true);
                		btn2.setText("---");
                		btn2.setVisible(false);
                		tfb.setVisible(false);
        			} else {
        				story = storyta.getText();
        				storyta.setText(story +"\n-----Deine L�sung war leider falsch. probiere es noch einmal!-----");
           				tf1.clear();
        				tf2.clear();
        				counter ++;
        				score = score-2;
        				System.out.println(score);
        			}
        		} else if(graph1.gibStandort().equals("r4") && graph1.gibRaetselAktiv()) {
            		if(tf1.getText().toString().equalsIgnoreCase("aurum")) {
            			graph1.RaetselInaktivSetzen();
           				graph1.standortSetzen("r5");
                   		System.out.println(graph1.gibStandort());
                   		minimap.setImage(minimap5);
                   		raum.setImage(Raum5);
                   		label1.setText("---");
                   		label1.setVisible(false);
                   		label2.setText("---");
                   		tf1.clear();
                   		tf1.setVisible(false);
                   		btn2.setVisible(false);
                   		tfb.setVisible(false);
                  		tf2.clear();
                  		if (counter == 0) {
                  			score = score+20;
                			storyta.setText("Willkommen in Raum 5, Du hast das Spiel durchgespielt!!\nGl�ckwunsch, du hast das R�tsel auf Anhieb gel�st!\nDu hast "+tips+" tip(s) abgerufen. \nDein Score ist "+score+".\nNachdem du das letzte R�tsel gel�st erfolgreich gel�st hast, gelangst du in einen Raum voller Sch�tze. Gold, Edelsteine und Diamanten zieren den Boden. Du beginnst z�gig deine Taschen mit den kostbaren Gegenst�nden vollzustopfen, sodass diese vor Reicht�mern nur so �berquellen. Immer mehr und mehr packst du in deine Beutel, bis du pl�tzlich ein dumpfes Ger�usch hinter dir h�rst. Als du dich erschreckt umdrehst, siehst du wie sich das Tor, durch das du die Schatzkammer betreten hast, sich beginnt zu schlie�en. Zeitgleich beginnen die gro�en S�ulen in der Kammer zu br�ckeln und drohen sichtlich jeden Moment einzubrechen. \r\n" + 
                					"Hastig packst du den mit Gold und Juwelen vollbepackten Beutel und sprintest zu der gro�en T�r, die den einzigen Ausweg aus diesem Raum zu verschlie�en droht. Doch du bist zu sp�t. Direkt vor deiner Nase schlie�t diese sich mit einem lauten Knarzen und du bist eingesperrt, umgeben von teuren Edelsteinen, in einer Kammer die in sich zusammenf�llt. Vergeblich trittst und h�mmerst du gegen das Tor, versuchst es irgendwie zu �ffnen, doch alle Bem�hungen helfen nichts. \r\n" + 
                					"Von der Decke fallen inzwischen immer gr��ere Steine und du wei�t, dass bald alles unter dem massiven Fels begraben sein wird, doch es gibt keinen Weg dem ganzen zu entkommen. Aber als pl�tzlich eine der gro�en S�ulen in sich zusammenbricht und unter lautem Krach auf den Boden aufschl�gt, entsteht dort ein Loch, das wohl in eine tiefergelegene Kammer f�hrt, die von hieraus nicht zug�nglich war. Ohne lang zu z�gern packst du deine Sch�tze und springst in das, von Dunkelheit gef�llte, Loch, bevor einer der Felsen dich begr�bt.\r\n" + 
                					"Aber Nanu � Was ruft unser Protagonist nur w�hrend seinem Sturz in den Tod? ��DIE CREDITS!�. Ach ja, stimmt, die Credits! Hier sind sie: Ein paar Bildelemente stammen von flaticons.com, und geschrieben wurde dieses kleine Spiel von Florian, Rintschen, Johannes und Emil im Rahmen eines Informatikprojekts der Q11 2018/19 am Gymnasium Wendelstein. Vielen dank f�rs spielen!!!\r\n" + 
                					"");
                			System.out.println(score);
                		} else {
                			score = score+10;
                			storyta.setText("Du hast " +(counter+1)+" Versuche ben�tigt. \nWillkommen in Raum 5, Du hast das Spiel durchgespielt!!\nDu hast "+tips+" tip(s) abgerufen.\nDein Score ist "+score+".\nNachdem du das letzte R�tsel gel�st erfolgreich gel�st hast, gelangst du in einen Raum voller Sch�tze. Gold, Edelsteine und Diamanten zieren den Boden. Du beginnst z�gig deine Taschen mit den kostbaren Gegenst�nden vollzustopfen, sodass diese vor Reicht�mern nur so �berquellen. Immer mehr und mehr packst du in deine Beutel, bis du pl�tzlich ein dumpfes Ger�usch hinter dir h�rst. Als du dich erschreckt umdrehst, siehst du wie sich das Tor, durch das du die Schatzkammer betreten hast, sich beginnt zu schlie�en. Zeitgleich beginnen die gro�en S�ulen in der Kammer zu br�ckeln und drohen sichtlich jeden Moment einzubrechen. \r\n" + 
                					"Hastig packst du den mit Gold und Juwelen vollbepackten Beutel und sprintest zu der gro�en T�r, die den einzigen Ausweg aus diesem Raum zu verschlie�en droht. Doch du bist zu sp�t. Direkt vor deiner Nase schlie�t diese sich mit einem lauten Knarzen und du bist eingesperrt, umgeben von teuren Edelsteinen, in einer Kammer die in sich zusammenf�llt. Vergeblich trittst und h�mmerst du gegen das Tor, versuchst es irgendwie zu �ffnen, doch alle Bem�hungen helfen nichts. \r\n" + 
                				    "Von der Decke fallen inzwischen immer gr��ere Steine und du wei�t, dass bald alles unter dem massiven Fels begraben sein wird, doch es gibt keinen Weg dem ganzen zu entkommen. Aber als pl�tzlich eine der gro�en S�ulen in sich zusammenbricht und unter lautem Krach auf den Boden aufschl�gt, entsteht dort ein Loch, das wohl in eine tiefergelegene Kammer f�hrt, die von hieraus nicht zug�nglich war. Ohne lang zu z�gern packst du deine Sch�tze und springst in das, von Dunkelheit gef�llte, Loch, bevor einer der Felsen dich begr�bt.\r\n" + 
                				    "Aber Nanu � Was ruft unser Protagonist nur w�hrend seinem Sturz in den Tod? ��DIE CREDITS!�. Ach ja, stimmt, die Credits! Hier sind sie: Ein paar Bildelemente stammen von flaticons.com, und geschrieben wurde dieses kleine Spiel von Florian, Rintschen, Johannes und Emil im Rahmen eines Informatikprojekts der Q11 2018/19 am Gymnasium Wendelstein. Vielen dank f�rs spielen!!!\r\n" + 
                					"");
                			System.out.println(score);
                		}
                		counter = 0;
                  		tips = 0;
                   		btn1.setText("---");
                		btn2.setText("---");
           			} else {
           				story = storyta.getText();
        				storyta.setText(story +"\n -----Deine L�sung war leider falsch. probiere es noch einmal!-----");
           				tf1.clear();
        				tf2.clear();
        				counter ++;
        				score = score-2;
        				System.out.println(score);
           			}
       			}
        	}
        });
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}