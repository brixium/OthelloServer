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
    public void setCasella(int x, int y, boolean color){
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                System.out.println("["+cs[i][j]+"]");
            }
            System.out.println();
        }
        System.out.println(x+" "+y);
        System.out.println(cs[x][y]);
        cs[x][y].getCasella().getPedina().setColore(color); // genera eccezione
    }
    public boolean PossibileMossa(){
        boolean mossa=false;
        
        for(int riga=0;riga<8; riga++){
            for(int colonna=0; colonna<8; colonna++){
                
                if(cs[riga][colonna].getOccupata()){
                    cs[riga][colonna].getPedina().getColore();
                    
                    //controllo alto sx
                    if(cs[riga-1][colonna-1].getOccupata() && (cs[riga-1][colonna-1].getPedina().getColore() != cs[riga][colonna].getPedina().getColore())){                        
                        //controllo alto centr
                        if(cs[riga-1][colonna].getOccupata() && (cs[riga-1][colonna].getPedina().getColore() != cs[riga][colonna].getPedina().getColore())){
                            //controllo alto dx
                            if(cs[riga-1][colonna+1].getOccupata() && (cs[riga-1][colonna+1].getPedina().getColore() != cs[riga][colonna+1].getPedina().getColore())){
                                //controllo sx
                                if(cs[riga][colonna-1].getOccupata() && (cs[riga][colonna-1].getPedina().getColore() != cs[riga][colonna].getPedina().getColore())){
                                    //controllo dx
                                    if(cs[riga][colonna+1].getOccupata() && (cs[riga][colonna+1].getPedina().getColore() != cs[riga][colonna].getPedina().getColore())){
                                        //controllo basso sx
                                        if(cs[riga+1][colonna-1].getOccupata() && (cs[riga+1][colonna-1].getPedina().getColore() != cs[riga][colonna].getPedina().getColore())){
                                            //controllo basso centr
                                            if(cs[riga+1][colonna].getOccupata() && (cs[riga][colonna].getPedina().getColore() != cs[riga][colonna].getPedina().getColore())){
                                                //controllo basso dx
                                                if(cs[riga+1][colonna+1].getOccupata() && (cs[riga][colonna+1].getPedina().getColore() != cs[riga][colonna].getPedina().getColore())){
                                                    
                                                } 
                                            }
                                        }       
                                    }                      
                                }   
                            }  
                        }
                    }                  
                }          
                if(cs[riga][colonna].getOccupata()){ 
                    if(cs[riga][colonna].getPedina().getColore()){
                    }
                }
                        
            }
        }
        return mossa;
    }
}