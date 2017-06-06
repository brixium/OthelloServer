package model;

public class Campo {
    Casella cs[][] = new Casella[8][8];
    int mosse;
    public Campo(){
        mosse=1;
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
        /*
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                System.out.println("["+cs[i][j].getPedina()+"]");
            }
            System.out.println();
        }
        */
        System.out.println(x+" "+y);
        System.out.println(cs[x][y]);
        cs[x][y].setPedina(x, y, true, color); // genera eccezione
    }
    public boolean PossibileMossa(int r, int c, boolean col){
        boolean mossa=false; 
        
        for(int riga=0;riga<8; riga++){
            for(int colonna=0; colonna<8; colonna++){
                
                    //CONTROLLO IN BASSO A DESTRA
                    if(cs[riga][colonna].getOccupata() && cs[riga+1][colonna+1].getOccupata() && cs[riga][colonna].getPedina().getColore() != cs[riga+1][colonna+1].getPedina().getColore() && cs[riga+2][colonna+2].getOccupata()==false){
                        mossa = true;
                        System.out.println(cs[riga][colonna].getOccupata());
                        System.out.println(cs[riga+1][colonna+1].getOccupata());
                        System.out.println(cs[riga][colonna].getPedina().getColore());
                        System.out.println(cs[riga+1][colonna+1].getPedina().getColore());
                        System.out.println(cs[riga+2][colonna+2].getOccupata());
                        if(riga+2 == r && colonna+2 == c)
                            cs[riga+2][colonna+2].setPedina(r, c, true, col);
                        else
                            System.out.println("mossa non disponibile");
                    }
                    if(cs[riga][colonna].getOccupata() && cs[riga+1][colonna+1].getOccupata() && cs[riga+2][colonna+2].getOccupata() && cs[riga][colonna].getPedina().getColore() != (cs[riga+1][colonna+1].getPedina().getColore() && cs[riga+2][colonna+2].getPedina().getColore())  && cs[riga+3][colonna+3].getOccupata()==false){
                        mossa = true;
                        if(riga+3 == r && colonna+3 == c)
                            cs[riga+3][colonna+3].setPedina(r, c, true, col);
                        else
                            System.out.println("mossa non disponibile");
                    }
                    if(cs[riga][colonna].getOccupata() && cs[riga+1][colonna+1].getOccupata() && cs[riga+2][colonna+2].getOccupata() && cs[riga+3][colonna+3].getOccupata() && cs[riga][colonna].getPedina().getColore() != (cs[riga+1][colonna+1].getPedina().getColore() && cs[riga+2][colonna+2].getPedina().getColore() && cs[riga+3][colonna+3].getPedina().getColore()) && cs[riga+4][colonna+4].getOccupata()==false){
                        mossa = true;
                        if(riga+4 == r && colonna+4 == c)
                            cs[riga+4][colonna+4].setPedina(r, c, true, col);
                        else
                            System.out.println("mossa non disponibile");
                    }
                    if(cs[riga][colonna].getOccupata() && cs[riga+1][colonna+1].getOccupata() && cs[riga+2][colonna+2].getOccupata() && cs[riga+3][colonna+3].getOccupata() && cs[riga+4][colonna+4].getOccupata() && cs[riga][colonna].getPedina().getColore() != (cs[riga+1][colonna+1].getPedina().getColore() && cs[riga+2][colonna+2].getPedina().getColore() && cs[riga+3][colonna+3].getPedina().getColore() && cs[riga+4][colonna+4].getPedina().getColore()) && cs[riga+5][colonna+5].getOccupata()==false){
                        mossa = true;
                        if(riga+5 == r && colonna+5 == c)
                            cs[riga+5][colonna+5].setPedina(r, c, true, col);
                        else
                            System.out.println("mossa non disponibile");
                    }
                    if(cs[riga][colonna].getOccupata() && cs[riga+1][colonna+1].getOccupata() && cs[riga+2][colonna+2].getOccupata() && cs[riga+3][colonna+3].getOccupata() && cs[riga+4][colonna+4].getOccupata() && cs[riga+5][colonna+5].getOccupata() && cs[riga][colonna].getPedina().getColore() != (cs[riga+1][colonna+1].getPedina().getColore() && cs[riga+2][colonna+2].getPedina().getColore() && cs[riga+3][colonna+3].getPedina().getColore() && cs[riga+4][colonna+4].getPedina().getColore() && cs[riga+5][colonna+5].getPedina().getColore()) && cs[riga+6][colonna+6].getOccupata()==false){
                        mossa = true;
                        if(riga+6 == r && colonna+6 == c)
                            cs[riga+6][colonna+6].setPedina(r, c, true, col);
                        else
                            System.out.println("mossa non disponibile");
                    }
                    if(cs[riga][colonna].getOccupata() && cs[riga+1][colonna+1].getOccupata() && cs[riga+2][colonna+2].getOccupata() && cs[riga+3][colonna+3].getOccupata() && cs[riga+4][colonna+4].getOccupata() && cs[riga+5][colonna+5].getOccupata() && cs[riga+6][colonna+6].getOccupata() && cs[riga][colonna].getPedina().getColore() != (cs[riga+1][colonna+1].getPedina().getColore() && cs[riga+2][colonna+2].getPedina().getColore() && cs[riga+3][colonna+3].getPedina().getColore() && cs[riga+4][colonna+4].getPedina().getColore() && cs[riga+5][colonna+5].getPedina().getColore() && cs[riga+6][colonna+6].getPedina().getColore()) && cs[riga+7][colonna+7].getOccupata()==false){
                        mossa = true;
                        if(riga+7 == r && colonna+7 == c)
                            cs[riga+7][colonna+7].setPedina(r, c, true, col);
                        else
                            System.out.println("mossa non disponibile");
                    }                       
                    //FINE CONTROLLO 
                    
               
            }
        }
        return mossa; 
    }
    public int Move(int x, int y){
        int b=1;
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(cs[x-1][y-1].getOccupata()){ // in basso a sx
                    b=b*2;
                }
                if(cs[x][y-1].getOccupata()){   // in basso cnetrale
                    b=b*3;
                }
                if(cs[x+1][y-1].getOccupata()){ // in in basso a dx
                    b=b*5;
                }
                if(cs[x-1][y].getOccupata()){   // a sinistra
                    b=b*7;
                }
                if(cs[x+1][y].getOccupata()){   // a destra
                    b=b*11;
                }
                if(cs[x-1][y+1].getOccupata()){ // in alto a sx
                    b=b*13;
                }
                if(cs[x][y+1].getOccupata()){   // in alto al centro
                    b=b*17;
                }
                if(cs[x+1][y+1].getOccupata()){ // in alto a destra
                    b=b*19;
                }
            }
        }
        mosse=b;
        return b;
    }
}