package rete;
import model.*;
import java.io.*;
import java.net.*;
public class Client {
    boolean color;
    Partita p;
    String a;
    String fromserver;
    int controllo=0;
    int caux=0;
    /**
     * Costruttore: crea client per giocare
     * All'interno c'è un ciclo infinito per l'inserimento delle mosse e la ricezone dal server
     * @throws IOException 
     */
    public Client() {
        
    }
    /**
     * Inserimento di una stringa all'interno del client
     * @param a 
     */
    public void Inserimento(String a){
        a=this.a;
        // flusso OUT secondo client
        a=a.trim();
        String xS="", yS="";
        if(CheckSyntax(a)){
            a=a.substring(1, 4);
            System.out.println("Mossa: "+a);
            String [] pos=a.split(",");

            for(int i=0; i<pos.length; i++){
                xS=pos[0];
                yS=pos[1];
                //System.out.println(pos[i]);
            }
        }
        int x=Integer.parseInt(xS);
        int y=Integer.parseInt(yS);
        if(p.getCampo().PossibileMossa(x,y, false)){
            p.getCampo().setCasella(x, y, color);
            controllo++;
        }
    }
    public boolean CheckSyntax(String s){
        if(s.startsWith("(") && s.endsWith(")")){
            return true;
        }else{
            return false;
        }
    }
    public void avvio() throws IOException{
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
                    if(caux<controllo){
                        sock_out.println(a);
                        caux++;
                    }else{
                        a=std_in.readLine();
                        sock_out.println(a);    // Manda al server quello che legge
                    }
                    System.out.println("In attesa che il tuo avversario faccia una mossa...");
                    //std_out.println(sock_in.readLine());
                    a=sock_in.readLine();
                    System.out.println(a); // Printa quello che legge
                }
            }
        }catch(java.net.SocketException e){
            System.err.println(e);
        }
    }
}