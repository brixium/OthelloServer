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
    int contatore;
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
            contatore=0;
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
    
    public void run(){
        try {
            for(int j=0; true; j++){
                if(j==0){
                    out_1.println("false");
                    out_2.println("true");
                    TI.Stampa(p.getCampo());
                }
                else{
                    if(turno==false){
                        // flusso IN primo client
                        out_1.println("G1: Che cosa vuoi fare? Contatore: "+contatore);
                        sc_1=in_1.readLine();
                        
                        // flusso OUT secondo client
                        //out_1.println("Sei il primo giocatore");
                        turno=!turno;
                    }else{
                        // flusso IN secondo client
                        out_2.println("G2: Che cosa vuoi fare? Contatore: "+contatore);
                        sc_2=in_2.readLine();
                        
                        // flusso OUT secondo client
                        //out_2.println("Sei il secondo giocatore");
                        turno=!turno;
                    }
                    contatore++;
                    System.out.println(turno + "; "+contatore);
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
    public int getStatus(){
        return contatore;
    }
    public boolean getTurno(){
        return turno;
    }
}