package principale;
import model.*;
import java.io.IOException;
import java.net.ServerSocket;
public class OthelloServer {
    private int contatore;
    public static void main(String[] args) throws IOException{
        ServerSocket ss = new ServerSocket(6666);
        while (true) {
            new ServerThread(ss.accept()).start();
        }
    }
}