package rete;
import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OthelloThread extends Thread {
    private Socket s;
    public OthelloThread(Socket s) {
        this.s = s;
    }
    public void run() {
        
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
            String esse= in.readLine();
            boolean b;
            while (true) {
                if(esse.startsWith("(") && esse.endsWith(")")){
                    out.println(esse);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(OthelloThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean CheckSyntax(String s){
        if(s.startsWith("(") && s.endsWith(")")){
            return true;
        }else{
            return false;
        }
    }
}