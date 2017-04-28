package model;

public class Campo {
    Casella cs[][] = new Casella[8][8];
    public Campo(){
        for(int r=0; r<8; r++){
            for(int c=0; c<8; c++){
            //casella  3-3
                if(r==3 && c==3 ){
                    cs[r][c] = new Casella(r,c,true,false);  
                }else{
                    cs[r][c] = new Casella(r,c,false,false); 
                }
            //casella 3-4
                if(r==3 && c==4 ){
                    cs[r][c] = new Casella(r,c,true,true);  
                }else{
                    cs[r][c] = new Casella(r,c,false,false); 
                }
            //casella 4-3
                if(r==4 && c==3 ){
                    cs[r][c] = new Casella(r,c,true,true);  
                }else{
                    cs[r][c] = new Casella(r,c,false,false); 
                }
            //casella 4-4
                if(r==4 && c==4 ){
                    cs[r][c] = new Casella(r,c,true,false);  
                }else{
                    cs[r][c] = new Casella(r,c,false,false); 
                }
            }
        }
    }
    public Campo getCampo(){
        return this;       
    }
    public void stampaCampo(){
        for(int r=0; r<8; r++){
            for(int co=0; co<8; co++){
                cs[r][co].printCasella();
                
            }
            System.out.println();
        }
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
