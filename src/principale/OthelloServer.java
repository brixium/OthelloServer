package principale;
import java.io.BufferedReader;
import rete.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import model.Campo;
import view.Console;
public class OthelloServer {
    private static int contatore;
    private static boolean color = false;    //false è nero, true è bianco
    public static void main(String[] args) throws IOException{
        Campo c= new Campo();
        Console c1= new Console();
        c1.Stampa(c);
        /*
        
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String i="";
        while(true){
            System.out.println("Vuoi essere server o client?");
            i=br.readLine();
            if(i.equalsIgnoreCase("server")){ 
                System.out.println("Server in avvio...");
                Server s = new Server();
            }else if(i.equalsIgnoreCase("client")){
                System.out.println("Client in avvio...");
                contatore++;
                Client c = new Client(color);
            }else{
                System.out.println("Hai sbagliato a scrivere");
            }
        }
        
        /*
        ServerSocket ss = new ServerSocket(6666);
        while (true) {
            if(contatore%2==0){
                color=false;
            }else{
                color=true;
            }
            new ServerThread(ss.accept(), color).start();
            contatore++;
        }
        */
    }
}
