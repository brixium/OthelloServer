package rete;
import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Partita;
import view.TextInterface;

public class OthelloThread extends Thread {
    private Socket s1;
    private Socket s2;
    private boolean turno;
    private Partita p;
    int mossa;
    TextInterface TI;
    
    //oggetti primo client
    BufferedReader in_1;
    PrintWriter out_1;
    String sc_1;
    //oggetto secondo client
    BufferedReader in_2;
    PrintWriter out_2;
    String sc_2;
    
// METODI    
    public OthelloThread(Socket s1, Socket s2) {
        try {
            this.turno=false;
            this.s1 = s1;
            this.s2 = s2;
            mossa=0;
            p = new Partita();
            TI=new TextInterface();
            in_1 = new BufferedReader(new InputStreamReader(s1.getInputStream()));
            out_1 = new PrintWriter(new OutputStreamWriter(s1.getOutputStream()), true);
            in_2 = new BufferedReader(new InputStreamReader(s2.getInputStream()));
            out_2 = new PrintWriter(new OutputStreamWriter(s2.getOutputStream()), true);
        } catch (IOException ex) {
            Logger.getLogger(OthelloThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // ATTENZIONE: ANDARE A CAPO SOLAMENTE QUANDO NECESSARIO
    public void run(){
        try {
            for(int j=0; true; j++){
                if(j==0){
                    out_1.println("false");
                    out_2.println("true");
                    //out_1.println(p);
                    //out_2.println(p);
                    //out_1.println("Sei il primo giocatore");
                    //out_2.println("Sei il secondo giocatore");
                }
                else{
                    try{
                        System.out.println("Esecuzione nr. "+mossa);
                        if(turno==false){
                        // flusso IN primo client
                        out_1.println("G1: Che cosa vuoi fare? Contatore: "+mossa);
                        sc_1=in_1.readLine();
                        sc_1=sc_1.trim();
                        String xS="", yS="";
                        if(CheckSyntax(sc_1)){
                            sc_1=sc_1.substring(1, 4);
                            System.out.println(sc_1);
                            String [] pos=sc_1.split(",");
                            for(int i=0; i<pos.length; i++){
                                xS=pos[0];
                                yS=pos[1];
                                System.out.println(pos[i]);
                            }
                        }
                        int x=Integer.parseInt(xS);
                        int y=Integer.parseInt(yS);
                        p.getCampo().setCasella(x, y, turno);
                        turno=!turno;
                        }else{
                            // flusso IN secondo client
                            out_2.println("G2: Che cosa vuoi fare? Contatore: "+mossa);
                            sc_2=in_2.readLine();
                            // flusso OUT secondo client
                            sc_2=sc_2.trim();
                            String xS="", yS="";
                            if(CheckSyntax(sc_2)){
                                sc_2=sc_2.substring(1, 4);
                                System.out.println(sc_2);
                                String [] pos=sc_2.split(",");

                                for(int i=0; i<pos.length; i++){
                                    xS=pos[0];
                                    yS=pos[1];
                                    System.out.println(pos[i]);
                                }
                            }
                            int x=Integer.parseInt(xS);
                            int y=Integer.parseInt(yS);
                            p.getCampo().setCasella(x, y, turno);
                            turno=!turno;
                            //System.out.println(":"+mossa/2+";");
                        }
                        mossa++;
                        System.out.println(turno + "; "+mossa);
                        TI.Stampa(p.getCampo());
                        System.out.println("Dopo si blocca");
                    }catch(java.lang.NumberFormatException e){
                        System.err.println(e);
                    }catch(java.lang.StringIndexOutOfBoundsException ex){
                        System.err.println(ex);
                    }catch(java.lang.ArrayIndexOutOfBoundsException exc){
                        System.err.println(exc);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(OthelloThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("");
    }
    public boolean CheckSyntax(String s){
        if(s.startsWith("(") && s.endsWith(")")){
            return true;
        }else{
            return false;
        }
    }
    public int getMossa(){
        return mossa;
    }
    public boolean getTurno(){
        return turno;
    }
}