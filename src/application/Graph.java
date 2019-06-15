package application;

class GRAPH{
    private KNOTEN[] knotenliste;
    private boolean[][] am;
    private int maxAnz;
    private int anz;
    private String standort;
    private boolean raetselAktiv;
    
    GRAPH(){
     maxAnz = 5;
     anz = 0;
     knotenliste = new KNOTEN[maxAnz];
     am = new boolean[maxAnz][maxAnz];
     for(int y=0; y<maxAnz; y++){
         for(int x=0; x<maxAnz; x++){
             am[x][y]=false;
            }
        }
    }
    
    void knotenEinfuegen(DE de){
        if(anz < maxAnz){
            knotenliste[anz] = new KNOTEN(de);
            anz++;
        } else {
            System.out.println("ERROR: maxAnz wurde überschritten!");
        }
    }
    
    void kanteEinfuegen(String quellRaum_kuerzel, String zielRaum_kuerzel){
            if(!(suchIndex(quellRaum_kuerzel) < 0) && !(suchIndex(zielRaum_kuerzel) < 0)){ 
                am[suchIndex(quellRaum_kuerzel)][suchIndex(zielRaum_kuerzel)] = true;
            }
        }
        
    void  kanteEntfernen(String quellRaum_kuerzel, String zielRaum_kuerzel){
        if(!(suchIndex(quellRaum_kuerzel) < 0) && !(suchIndex(zielRaum_kuerzel) < 0)){
                am[suchIndex(quellRaum_kuerzel)][suchIndex(zielRaum_kuerzel)] = false;
            }
    }
    
    void istKanteVorhanden(String quellRaum_kuerzel, String zielRaum_kuerzel){
        System.out.println(am[suchIndex(quellRaum_kuerzel)][suchIndex(zielRaum_kuerzel)]);
    }
    
    int suchIndex(String s){
        int i=0;
        int rw=-1;
        boolean gefunden = false;
        while(i<maxAnz && !gefunden){
            if(knotenliste[i].gibInhalt().gibKuerzel() == s){
                gefunden = true;
                rw = knotenliste[i].gibInhalt().gibIndex();
            } else {
                i++;
        }      
    }
        return rw;
}

    void amAusgeben(){
        for(int quell=0; quell<maxAnz; quell++){
            for(int ziel=0; ziel<maxAnz; ziel++){
                if(am[quell][ziel] == false){
                    System.out.print("false ");
                } else {
                    System.out.print("true ");
                }
            }
            System.out.println("");
        }
    }

    void standortSetzen(String kuerzel){
        int i=0;
        boolean standortGesetzt = false;
        String ausgabe = "ERROR: Raum mit Kuerzel '" + kuerzel + "' exestiert nicht!";
        while(i<maxAnz && !standortGesetzt){
            if(knotenliste[i].gibInhalt().gibKuerzel() == kuerzel){
                standortGesetzt = true;
                ausgabe = "Standort auf '" + kuerzel + "' gesetzt!";
                standort = knotenliste[i].gibInhalt().gibKuerzel();
            } else {
                i++;
            }
        }
        System.out.println(ausgabe);
    }
    
    String gibStandort(){
        return standort;
    }
    
    void RaetselAktivSetzen() {
    	knotenliste[suchIndex(standort)].gibInhalt().RaetselTrue();
    }
    
    void RaetselInaktivSetzen() {
    	knotenliste[suchIndex(standort)].gibInhalt().RaetselFalse();
    }
    
    boolean gibRaetselAktiv() {
    	return raetselAktiv = knotenliste[suchIndex(standort)].gibInhalt().gibRaetselAktiv();
    }   
}