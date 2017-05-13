package model;

public class Casella {
    private int x;
    private int y;
    private Pedina p;
    private boolean occupata;
    public Casella(){
        occupata=false;
    }
    public Casella(int x, int y, boolean occupata, boolean colore){
        this.x=x;
        this.y=y;
        this.occupata=occupata;
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
    public Pedina getPedina(){
        return p;
    }
    public void setPedina(int x, int y, boolean occupata, boolean colore){
        this.x=x;
        this.y=y;
        this.occupata=occupata;
        if(occupata){
            p=new Pedina(colore);
        }
    }
    public boolean getOccupata(){
        return occupata;
    }
    /*
    public void inserimentocasella(int a,int b, boolean colore){
        x=a;
        y=b;
        if(campo.cs[x][y]==null){
            campo.cs[x][y].occupata=true;
            campo.cs[x][y].p.setColore(colore);
        }
        
    }
    */
    public void printCasella(){
        String occ=null;
        if(occupata){
            occ=" ";
            if(p.getColore()){
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