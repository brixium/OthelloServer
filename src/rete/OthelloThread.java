package rete;
import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Partita;

public class OthelloThread extends Thread {
    private Socket s;
    private boolean turno;  
    private Partita p;
    int contatore;
    public OthelloThread(Socket s, Partita p, int contatore) {
        this.turno=false;
        this.p = p;
        this.s = s;
        this.contatore=contatore;
    }
    public void run(){
        //oggetti primo client
        BufferedReader in_1;
        PrintWriter out_1;
        //oggetto secondo client
        BufferedReader in_2;
        PrintWriter out_2;
        try {
            for(int j=0; true; j++){
                if(contatore%4==0){
                    // flusso IN primo client
                    in_1 = new BufferedReader(new InputStreamReader(s.getInputStream()));
                    contatore++;
                } else if(contatore%4==1){
                    // flusso OUT secondo client
                    out_2 = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
                    out_2.println("Unione ad una partita già creata in corso...");
                    contatore++;
                } else if(contatore%4==2){
                    // flusso IN secondo client
                    in_2 = new BufferedReader(new InputStreamReader(s.getInputStream()));

                    contatore++;
                } else if(contatore%4==3){
                    // flusso OUT secondo client
                    out_2 = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
                    out_2.println("Unione ad una partita già creata in corso...");
                    contatore++;
                }
                
                System.out.println(turno + "; "+contatore);
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
}