package rete;

import java.io.*;
import java.net.*;
public class Client {
    boolean color;
    public Client() throws IOException {
        try{
            Socket s = new Socket("127.0.0.1", 5555);
            BufferedReader sock_in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter sock_out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
            BufferedReader std_in = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter std_out = new PrintWriter(new OutputStreamWriter(System.out), true);
            for(int i=0; i!=-1; i++) {
                System.out.println("");
                sock_out.println(std_in.readLine());
                //std_out.println(sock_in.readLine());
                System.out.println(sock_in.readLine());
                
            }
        }catch(java.net.SocketException e){
            System.err.println(e);
        }
    }
}