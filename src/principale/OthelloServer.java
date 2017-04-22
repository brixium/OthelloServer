package principale;
import model.*;
import java.io.IOException;
import java.net.ServerSocket;
public class OthelloServer {
    private static int contatore;
    private static boolean  color=false;    //false è nero, true è bianco
    public static void main(String[] args) throws IOException{
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
    }
}