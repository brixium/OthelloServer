package model;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerThread extends Thread {

    private Socket s;

    public ServerThread(Socket s) {
        this.s = s;
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