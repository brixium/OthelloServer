package model;

public class Campo {
    Casella c[][] = new Casella[8][8];
    public Campo(){
        
    }
    public Campo getCampo(){
        return this;
    }
    public Casella[][] getCasella(){
        return c;
    }
    
    //posizione iniziale
    public void Start(){
        c[3][3].pedina.setColore(false); //bianco
        c[3][4].pedina.setColore(true); //nero
        c[4][3].pedina.setColore(false); //bianco
        c[4][4].pedina.setColore(true); //nero
    }
    
    
    
    
}
