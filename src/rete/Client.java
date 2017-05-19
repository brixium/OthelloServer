package rete;
import model.*;
import java.io.*;
import java.net.*;
public class Client {
    boolean color;
    Partita p;
    String a;
    String fromserver;
    public Client() throws IOException {
        try{
            p=new Partita();
            Socket s = new Socket("127.0.0.1", 5555);
            BufferedReader sock_in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter sock_out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
            BufferedReader std_in = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter std_out = new PrintWriter(new OutputStreamWriter(System.out), true);
            // esecuzione ciclo semi-infinito di client
            System.out.println(sock_in.readLine());
            // -J-Xmx2048m
            for(int i=0; i!=-1; i++) {
                if(i==0){
                    String ds =sock_in.readLine();
                    if(ds.equalsIgnoreCase("true")){
                        color=true;
                    }else{
                        color=false;
                    }
                    System.out.println(ds);
                    System.out.println("Colore: "+color);
                }
                else{
                    //p.
                    // fare dire al client la stringa
                    System.out.println("Fai la tua mossa!");
                    sock_out.println(std_in.readLine());
                    
                    System.out.println("In attesa che il tuo avversario faccia una mossa...");
                    //std_out.println(sock_in.readLine());
                    System.out.println(sock_in.readLine());
                }
            }
        }catch(java.net.SocketException e){
            System.err.println(e);
        }
    }
        public void Inserimento(String a){
            a=this.a;
         
    }
}
