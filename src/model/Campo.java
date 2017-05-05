package model;

public class Campo {
    Casella cs[][] = new Casella[8][8];
    public Campo(){
        for(int r=0; r<8; r++){
            for(int c=0; c<8; c++){
            //casella  3-3
                if(r==3 && c==3 ){
                    cs[r][c] = new Casella(r,c,true,false);  
                }
            //casella 3-4
                else if(r==3 && c==4 ){
                    cs[r][c] = new Casella(r,c,true,true);
                }
            //casella 4-3
                else if(r==4 && c==3 ){
                    cs[r][c] = new Casella(r,c,true,true);  
                }
            //casella 4-4
                else if(r==4 && c==4 ){
                    cs[r][c] = new Casella(r,c,true,false);  
                }               
                else{
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
        return cs;
    }
    public boolean PossibileMossa(){
        boolean mossa=false;
        
        for(int riga=0;riga<8; riga++){
            for(int colonna=0; colonna<8; colonna++){
                
                if(cs[riga][colonna].getOccupata()){
                    if(cs[riga][colonna].getPedina().getColore()){
                    }
                }
                        
            }
        }
        return mossa;
    }
        
}
