package principale;
import java.io.BufferedReader;
import rete.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
public class OthelloServer {
    private static int contatore;
    private static boolean  color=false;    //false è nero, true è bianco
    public static void main(String[] args) throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
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
        String i="";
        System.out.println("Vuoi essere server o client?");
        i=br.readLine();
        if(i.equalsIgnoreCase("server")){
            new Server();
        }else if(i.equalsIgnoreCase("client")){
            new Client();
        }
    }
}