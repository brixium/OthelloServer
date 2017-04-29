//classe che inzializza il campo inoltre gestisce i turni dei client
package model;
public class Partita {
    //dichiarazione del campo
    private Campo campo;
    //dichiarazione di una proprietà per gestire il turno
    boolean turno;
    //metodo getPartita: utile 
    boolean finita;
    public Partita(){
        finita=false;
        turno=false;
    }
    public Partita getPartita(){
        return this;
    }
    //metodo che ti assegna il turno
    public boolean getTurno(){
        return turno;
    }
}