package rete;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import model.Partita;
/**
 *
 * @author asolan.lorenzo
 */
public class Server {
    public Server() throws IOException {
        //Partita p = new Partita();
        //int conn=0;
        //boolean color=false;
        ServerSocket ss = new ServerSocket(5555);
        Socket s1 = new Socket();
        Socket s2 = new Socket();
        for (int conn=0; true; conn++) {
            if(conn%2==0){
                if(conn!=0){
                    System.out.println("Partita in creazione...; "+conn);
                    new OthelloThread(s1, s2).start();
                }
                s1=ss.accept();
                System.out.println("Connessione client 1 arrivata; "+conn);
            }else{
                s2=ss.accept();
                System.out.println("Connessione client 2 arrivata; "+conn);
            }
            System.out.println("Ciclo finito; "+conn);
            //conn++;
        }
        //System.err.println("Numero massimo di connessioni raggiunte (2)");
    }
}