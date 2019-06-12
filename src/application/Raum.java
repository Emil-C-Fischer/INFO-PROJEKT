package application;

class RAUM extends DE{
    private String bezeichnung;
    private String kuerzel;
    private int index; //in am
    private boolean standort;
    
    RAUM(String bez, String k, int i){
        bezeichnung = bez;
        kuerzel = k;
        index = i;
        standort = false;
    }
    
    int gibIndex(){
        return index;
    }
    
    String gibKuerzel(){
        return kuerzel;
    }
    
    String gibBezeichnung(){
        return bezeichnung;
    }
    
    boolean standortSetzen(boolean b){
        return standort = b;
    }
}