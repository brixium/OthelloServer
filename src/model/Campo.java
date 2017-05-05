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
                
                if(cs[riga][colonna].occupata){
                    cs[riga][colonna].getPedina().getColore();
                    
                    //controllo alto sx
                    if(cs[riga-1][colonna-1].occupata && (cs[riga-1][colonna-1].getPedina().colore != cs[riga][colonna].getPedina().colore)){                        
                        //controllo alto centr
                        if(cs[riga-1][colonna].occupata && (cs[riga-1][colonna].getPedina().colore != cs[riga][colonna].getPedina().colore)){
                            //controllo alto dx
                            if(cs[riga-1][colonna+1].occupata && (cs[riga-1][colonna+1].getPedina().colore != cs[riga][colonna+1].getPedina().colore)){
                                //controllo sx
                                if(cs[riga][colonna-1].occupata && (cs[riga][colonna-1].getPedina().colore != cs[riga][colonna].getPedina().colore)){
                                    //controllo dx
                                    if(cs[riga][colonna+1].occupata && (cs[riga][colonna+1].getPedina().colore != cs[riga][colonna].getPedina().colore)){
                                        //controllo basso sx
                                        if(cs[riga+1][colonna-1].occupata && (cs[riga+1][colonna-1].getPedina().colore != cs[riga][colonna].getPedina().colore)){
                                            //controllo basso centr
                                            if(cs[riga+1][colonna].occupata && (cs[riga][colonna].getPedina().colore != cs[riga][colonna].getPedina().colore)){
                                                //controllo basso dx
                                                if(cs[riga+1][colonna+1].occupata && (cs[riga][colonna+1].getPedina().colore != cs[riga][colonna].getPedina().colore)){
                                                    
                                                } 
                                            }
                                        }       
                                    }                      
                                }   
                            }  
                        }
                    }                  
                }          
            }
        }
        return mossa;
    }
        
}
