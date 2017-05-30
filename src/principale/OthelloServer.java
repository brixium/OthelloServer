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
import view.GUI;
import view.TextInterface;
/**
 * Classe principale per l'avvio del programma
 * @author asolan.lorenzo
 */
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
                System.out.println("Vuoi avviare la GUI (G) o la view testuale? (T)");
                i=br.readLine();
                if(i.contains("g")){
                    GUI g = new GUI();
                }else if(i.contains("t")){
                    Client cli = new Client();
                    cli.avvio();
                }else{
                    System.out.println("Non ho capito");
                }
                System.out.println("Client in avvio...");
                contatore++;
            }else{
                System.out.println("Hai sbagliato a scrivere");
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}