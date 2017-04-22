package rete;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
/**
 *
 * @author asolan.lorenzo
 */
public class Server {
    public Server() throws IOException {

        ServerSocket ss = new ServerSocket(5555);
        while (true) {
            new EchoThread(ss.accept()).start();
        }
    }
}
