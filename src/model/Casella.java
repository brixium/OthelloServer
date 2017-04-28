package model;

public class Casella {
    private int x;
    private int y;
    private Pedina p;
    boolean occupata;
    boolean colore;
    public Casella(){
        
    }
    public Casella(int x, int y, boolean occupata, boolean colore){
        this.x=x;
        this.y=y;
        this.occupata=occupata;
        this.colore=colore;
        if(occupata){
            p=new Pedina(colore);
            
        }
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public Casella getCasella(){
        return this;
    }
    public void printCasella(){
        String occ=null;
        if(occupata){
            occ=" ";
            if(colore){
                occ="N";
            }else{
                occ="B";
            }
        }else{
            occ="o";
        }
        System.out.print("[ "+occ+" ]");
    }
    
}
