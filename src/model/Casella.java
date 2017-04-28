package model;

public class Casella {
    private int x;
    private int y;
    Pedina pedina;
    Campo campo;
    public Casella(int x, int y){
        this.x=x;
        this.y=y;
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
    public void Occupata(){
        for(int i=0; i<8; i++){
            for(int h=0; h<8; h++){
                if(campo.c[i][h] != null){
                    System.out.println("#");
                }else{
                    System.out.println(" ");        
                } 
            }
        }
    }
}