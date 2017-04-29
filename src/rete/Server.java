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
    public Server(Partita p) throws IOException {
        int conn=0;
       // boolean color=false;
        ServerSocket ss = new ServerSocket(5555);
        while (true) {
            new OthelloThread(ss.accept(),p, conn).start();
            conn++;
           // color=!color;
        }
    }
}
