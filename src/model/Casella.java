package model;
/**
 * Classe per la casella
 * essa ha coordinate x, y, una pedina e se è occupata
 * @author asolan.lorenzo
 */
public class Casella {
    private int x;
    private int y;
    private Pedina p;
    private boolean occupata;
    /**
     * costruttore che mette la casella vuota
     */
    public Casella(){
        occupata=false;
    }
    /**
     * cotruttore che setta il colore alla pedina che occupa la casella
     * @param x
     * @param y
     * @param occupata
     * @param colore 
     */
    public Casella(int x, int y, boolean occupata, boolean colore){
        this.x=x;
        this.y=y;
        this.occupata=occupata;
        if(occupata){
            p=new Pedina(colore);
        }
    }
    /**
     * metodo che returna la posizione di x
     * @return 
     */
    public int getX(){
        return x;
    }
    /**
     *  metodo che returna la posizione di x
     * @return 
     */
    public int getY(){
        return y;
    }
    /**
     * metodo che returna la pedina
     * @return 
     */
    public Pedina getPedina(){
        return p;
    }
    /**
     * metodo per impostare una pedina 
     * @param x
     * @param y
     * @param occupata
     * @param colore 
     */
    public void setPedina(int x, int y, boolean occupata, boolean colore){
        this.x=x;
        this.y=y;
        this.occupata=occupata;
        if(occupata){
            p=new Pedina(colore);
        }
    }
    /**
     * mtodo che ritorna se e occupata o no
     * @return 
     */
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
    /**
     * mette bianco e nero nelle caselle occupate nella console
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