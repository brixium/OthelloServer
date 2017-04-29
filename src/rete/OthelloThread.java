package rete;
import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Partita;

public class OthelloThread extends Thread {
    private Socket s;
    private boolean colore;
    private Partita p;
    int contatore;
    public OthelloThread(Socket s, Partita p, int contatore) {
        this.p = p;
        this.s = s;
        this.contatore=contatore;
    }
    public void run() {
        //oggetti primo client
        BufferedReader in_1;
        PrintWriter out_1;
        //oggetto secondo client
        BufferedReader in_2;
        PrintWriter out_2;
        try {
            while (true) {
                // flusso primo client
                in_1 = new BufferedReader(new InputStreamReader(s.getInputStream()));
                out_1 = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
                // flusso secondo client
                in_2 = new BufferedReader(new InputStreamReader(s.getInputStream()));
                out_2 = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
                
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