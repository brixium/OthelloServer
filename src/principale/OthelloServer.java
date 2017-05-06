package principale;
import java.io.BufferedReader;
import rete.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Campo;
import view.TextInterface;
public class OthelloServer {
    private static int contatore;
    private static boolean color = false;    //false è nero, true è bianco
    public static void main(String[] args) {
        
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String i="";
        try {
            System.out.println("Vuoi essere server o client?");
            i=br.readLine();
            if(i.equalsIgnoreCase("server")|| i.contains("s")){
                System.out.println("Server in avvio...");
                Server s = new Server();
            }else if(i.equalsIgnoreCase("client")|| i.contains("c")){
                System.out.println("Client in avvio...");
                contatore++;
                Client cli = new Client();
            }else{
                System.out.println("Hai sbagliato a scrivere");
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}