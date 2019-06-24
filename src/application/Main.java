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
import javafx.scene.text.Font;
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
        
        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        
        //------------------SPIELLOGIK------------------//
        
        btn1.setText("zum Eingang");
        storyta.setText("Du wurdest vom US-Milit�r beauftragt, im Parque National El Mirador in Guatemala einen vor kurzem entdeckten Mayatempel zu erforschen.\r\n" + 
        		"Ein paar Soldaten haben dich vor der Entdeckung abgesetzt und teilen dir mit, dass sie den Eingang der Ruine abgesperrt haben, damit Zivilisten hier kein dummes Zeug machen k�nnen.\r\n" + 
        		"");
        
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	if(graph1.gibStandort().equals("r1") && !graph1.gibRaetselAktiv()) {
            		graph1.RaetselAktivSetzen();
            		story = "Als du oben bei der Pyramide angekommen bist, bemerkst du, dass die Soldaten anscheinend vergessen haben, dir die Zugangsdaten zu geben und schon weggefahren sind.\r\n" + 
            				"Vielleicht kommst du den Benutzernamen und auf das Passwort von selbst.\r\n" + 
            				"Auf den Holzkisten neben der T�r stehen einige Namen, die du als NATO-Buchstaben entschl�sselst.\r\n" + 
            				"\"Mit diesen Buchstaben muss ich doch irgendwie auf den Benutzernamen kommen. Aber das sind nur sechs Buchstaben und der Benutzername hat acht...\" denkst du dir und �berlegst weiter.\r\n" + 
            				"\n--Gebe die L�sung in das Textfeld ein und klicke auf 'abschicken'.--";
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
            		story = "Vor der T�r befinden sich acht S�ulen mit jeweils einem Regler.\r\n" + 
            				"�Ein Code...� denkst du dir und �berlegst was f�r ein achtstelliger Code das wohl sein wird, als dir erst jetzt der Schriftzug �ber der T�r auff�llst.\r\n" + 
            				"�Hier folgt der Gang nach unten�.\r\n" + 
            				"\n--Gebe die Reihenfolge, in der du die Hebel bet�tigen willst als Zahlenfolge in das Textfeld ein und klicke auf 'abschicken'.--";
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
            		story = "Auf der Tafel stehen Rechnungen mit Symbolen. \"Und ich habe immer gedacht Mathe hab ich dann mal nach der Schule hinter mir\" denkst du dir genervt und machst dich an die Aufgaben."
            				+ "\n\n--Gebe die richtige L�sung des Gleichungssystems in das Textfeld ein und klicke auf 'abschicken'.--";
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
            		story = "Nach der Untersuchung des Raumes, welcher in der Mitte einen Brunnen stehen hat, begibst du dich zur n�chsten T�r mit einem Gedicht auf einer daneben h�ngenden Plakette. Anscheinend ist das hier das letzte R�tsel. Doch was f�r ein Wort wird im Gedicht gesucht?"
            				+ "\n\n--Gebe die richtige L�sung in das Textfeld ein und klicke auf 'abschicken'.--";
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
           				storyta.setText(story +"\nHatten die Maya nicht einen Kalender? Mit einem ber�hmten Datum?");
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
           				storyta.setText(story +"\nwenn ich die Zeichen mal mit Buchstaben ersetze ist es �bersichtlicher und ich kann die Gleichungen danach deutlich leichter l�sen...");
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
           				storyta.setText(story +"\nDas Wort ist auch ein Element im Periodensystem, das eine bestimmte Abk�rzung hat. Warum?");
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
                			storyta.setText("Gl�ckwunsch, du hast das R�tsel auf Anhieb gel�st!\nWillkommen in Raum 2!\nDu hast "+tips+" tip(s) abgerufen."
                					+ "\n\nEndlich betrittst den Tempel und erblickst diverse alte Vasen und Skulpturen. Doch die interessieren dich nicht. Denn deine Neugier zwingt dich schon zur n�chsten T�r, die sich aber nicht so einfach �ffnen l�sst.");
                		} else {
                			score = score+10;
                			System.out.println(score);
                			storyta.setText("Du hast " +(counter+1)+" Versuche ben�tigt. \nWillkommen in Raum 2!\nDu hast "+tips+" tip(s) abgerufen."
                					+ "\n\nEndlich betrittst den Tempel und erblickst diverse alte Vasen und Skulpturen. Doch die interessieren dich nicht. Denn deine Neugier zwingt dich schon zur n�chsten T�r, die sich aber nicht so einfach �ffnen l�sst.");
                		}
                		counter = 0;
                		tips = 0;
                		btn1.setText("zur T�re");
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
        			if(tf1.getText().toString().equalsIgnoreCase("21122012")) {
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
                			storyta.setText("Gl�ckwunsch, du hast das R�tsel auf Anhieb gel�st!\nWillkommen in Raum 3!\nDu hast "+tips+" tip(s) abgerufen."
                					+ "\n\nAuch hier befinden sich diverse alte kleinere Sch�tze. \"Die nehme ich mir dann auf dem R�ckweg mit.\" sagst du dir und f�hrst deine Erkundung fort.\r\n" + 
                					"Du schaffst es dich am Seil hochzuziehen und siehst eine Tafel neben der T�r.\r\n\n" + 
                					"");
                		} else {
                			score = score+10;
                			System.out.println(score);
                			storyta.setText("Du hast " +(counter+1)+" Versuche ben�tigt. \nWillkommen in Raum 3!\nDu hast "+tips+" tip(s) abgerufen."
                					+ "\nAuch hier befinden sich diverse alte kleinere Sch�tze. \"Die nehme ich mir dann auf dem R�ckweg mit.\" sagst du und f�hrst deine Erkundung fort.\r\n" + 
                					"Du schaffst es dich am Seil hochzuziehen und siehst eine Tafel neben der T�r.\r\n\n" + 
                					"");
                		}
                		counter = 0;
                		tips = 0;
                		btn1.setText("Tafel ansehen");
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
                			storyta.setText("Gl�ckwunsch, du hast das R�tsel auf Anhieb gel�st!\nWillkommen in Raum 4!\nDu hast "+tips+" tip(s) abgerufen."
                					+ "\n\nDu �ffnest die T�r, pl�tzlich fliegen dir ein paar Flederm�use entgegen. Du schreckst kurz auf und erinnerst dich, dass du schon viel schlimmere Dinge auf deinen Entdeckungstouren erlebst hast als ein paar Flederm�use.");
                		} else {
                			score = score+10;
                			System.out.println(score);
                			storyta.setText("Du hast " +(counter+1)+" Versuche ben�tigt. \nWillkommen in Raum 4!\nDu hast "+tips+" tip(s) abgerufen."
                					+ "\n\nDu �ffnest die T�r, pl�tzlich fliegen dir ein paar Flederm�use entgegen. Du schreckst kurz auf und erinnerst dich, dass du schon viel schlimmere Dinge auf deinen Entdeckungstouren erlebst hast als ein paar Flederm�use.");
                		}
                		counter = 0;
                		tips = 0;
                		btn1.setText("Raum erkunden");
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
                			storyta.setText("Willkommen in Raum 5, Du hast das Spiel durchgespielt!!\nGl�ckwunsch, du hast das R�tsel auf Anhieb gel�st!\nDu hast "+tips+" tip(s) abgerufen. \n\nDein Score ist "+score+".\n\nNachdem du das letzte R�tsel erfolgreich gel�st hast, gelangst du in einen Raum voller Sch�tze. Gold, Edelsteine und Diamanten zieren den Boden. Du beginnst z�gig deine Taschen mit den kostbaren Gegenst�nden vollzustopfen, sodass diese vor Reicht�mern nur so �berquellen. Immer mehr und mehr packst du in deine Beutel, bis du pl�tzlich ein dumpfes Ger�usch hinter dir h�rst. Als du dich erschreckt umdrehst, siehst du wie sich das Tor, durch das du die Schatzkammer betreten hast, sich beginnt zu schlie�en. Zeitgleich beginnen die gro�en S�ulen in der Kammer zu br�ckeln und drohen sichtlich jeden Moment einzubrechen. \r\n" + 
                					"Hastig packst du den mit Gold und Juwelen vollbepackten Beutel und sprintest zu der gro�en T�r, die den einzigen Ausweg aus diesem Raum zu verschlie�en droht. Doch du bist zu sp�t. Direkt vor deiner Nase schlie�t diese sich mit einem lauten Knarzen und du bist eingesperrt, umgeben von teuren Edelsteinen, in einer Kammer die in sich zusammenf�llt. Vergeblich trittst und h�mmerst du gegen das Tor, versuchst es irgendwie zu �ffnen, doch alle Bem�hungen helfen nichts. \r\n" + 
                					"Von der Decke fallen inzwischen immer gr��ere Steine und du wei�t, dass bald alles unter dem massiven Fels begraben sein wird, doch es gibt keinen Weg dem ganzen zu entkommen. Aber als pl�tzlich eine der gro�en S�ulen in sich zusammenbricht und unter lautem Krach auf den Boden aufschl�gt, entsteht dort ein Loch, das wohl in eine tiefergelegene Kammer f�hrt, die von hieraus nicht zug�nglich war. Ohne lang zu z�gern packst du deine Sch�tze und springst in das, von Dunkelheit gef�llte, Loch, bevor einer der Felsen dich begr�bt.\r\n" + 
                					"Aber Nanu � Was ruft unser Protagonist nur w�hrend seinem Sturz in den Tod? ��DIE CREDITS!�. Ach ja, stimmt, die Credits! Die hab ich vor lauter Programmieren v�llig vergessen... Hier sind sie: Ein paar Bildelemente stammen von flaticons.com, und geschrieben wurde dieses tolle Spiel von Florian, Rintschen, Johannes und Emil im Rahmen eines Informatikprojekts der Q11 2018/19 am Gymnasium Wendelstein. Vielen dank f�rs spielen!!!\r\n" + 
                					"");
                			System.out.println(score);
                		} else {
                			score = score+10;
                			storyta.setText("Du hast " +(counter+1)+" Versuche ben�tigt. \nWillkommen in Raum 5, Du hast das Spiel durchgespielt!!\nDu hast "+tips+" tip(s) abgerufen.\n\nDein Score ist "+score+".\n\nNachdem du das letzte R�tsel erfolgreich gel�st hast, gelangst du in einen Raum voller Sch�tze. Gold, Edelsteine und Diamanten zieren den Boden. Du beginnst z�gig deine Taschen mit den kostbaren Gegenst�nden vollzustopfen, sodass diese vor Reicht�mern nur so �berquellen. Immer mehr und mehr packst du in deine Beutel, bis du pl�tzlich ein dumpfes Ger�usch hinter dir h�rst. Als du dich erschreckt umdrehst, siehst du wie sich das Tor, durch das du die Schatzkammer betreten hast, sich beginnt zu schlie�en. Zeitgleich beginnen die gro�en S�ulen in der Kammer zu br�ckeln und drohen sichtlich jeden Moment einzubrechen. \r\n" + 
                					"Hastig packst du den mit Gold und Juwelen vollbepackten Beutel und sprintest zu der gro�en T�r, die den einzigen Ausweg aus diesem Raum zu verschlie�en droht. Doch du bist zu sp�t. Direkt vor deiner Nase schlie�t diese sich mit einem lauten Knarzen und du bist eingesperrt, umgeben von teuren Edelsteinen, in einer Kammer die in sich zusammenf�llt. Vergeblich trittst und h�mmerst du gegen das Tor, versuchst es irgendwie zu �ffnen, doch alle Bem�hungen helfen nichts. \r\n" + 
                				    "Von der Decke fallen inzwischen immer gr��ere Steine und du wei�t, dass bald alles unter dem massiven Fels begraben sein wird, doch es gibt keinen Weg dem ganzen zu entkommen. Aber als pl�tzlich eine der gro�en S�ulen in sich zusammenbricht und unter lautem Krach auf den Boden aufschl�gt, entsteht dort ein Loch, das wohl in eine tiefergelegene Kammer f�hrt, die von hieraus nicht zug�nglich war. Ohne lang zu z�gern packst du deine Sch�tze und springst in das, von Dunkelheit gef�llte, Loch, bevor einer der Felsen dich begr�bt.\r\n" + 
                				    "Aber Nanu � Was ruft unser Protagonist nur w�hrend seinem Sturz in den Tod? ��DIE CREDITS!�. Ach ja, stimmt, die Credits! Die hab ich vor lauter Programmieren v�llig vergessen... Hier sind sie: Ein paar Bildelemente stammen von flaticons.com, und geschrieben wurde dieses tolle Spiel von Florian, Rintschen, Johannes und Emil im Rahmen eines Informatikprojekts der Q11 2018/19 am Gymnasium Wendelstein. Vielen dank f�rs spielen!!!\r\n" + 
                					"");
                			System.out.println(score);
                		}
                		counter = 0;
                  		tips = 0;
                   		btn1.setText("---");
                		btn2.setText("---");
                		
                		//DANKE
                		Label danke = new Label();
                		danke.setLayoutX(645);
                        danke.setLayoutY(815);
                        danke.setText("Vielen dank f�r's Spielen!");
                        root.getChildren().add(danke);
                        danke.setFont(new Font("Calibri", 90));
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