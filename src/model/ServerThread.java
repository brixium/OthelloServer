package model;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerThread extends Thread {
    boolean color;
    private Socket s;

    public ServerThread(Socket s, boolean color) {
        this.s = s;
        this.color=color;
    }

    public void run() {
        
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
            
            while (true) {
                out.println(in.readLine());
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
        
    }
}