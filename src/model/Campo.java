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
    public boolean possibile(){
        boolean b=false;
        for(int i=0;i<8; i++){
            for(int j=0; j<8; j++){
                if(cs[i][j].occupata==true){
                    if(){
                        
                    }
                }else{
                    System.out.println("No buono");
                }
            }
        }
        return b;
    }
}