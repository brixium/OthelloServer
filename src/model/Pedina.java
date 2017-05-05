package model;
public class Pedina {
    private boolean colore;//true se è nero false se è bianco
    public Pedina(boolean z){
        colore=z;
    }
    public boolean getColore(){
        return colore;
    }
    public void setColore(boolean colore){
        this.colore=colore;
    }
    
}
