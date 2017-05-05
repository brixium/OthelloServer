//classe che inzializza il campo inoltre gestisce i turni dei client
package model;
public class Partita {
    // PROPRIETA'
    
    //dichiarazione del campo
    private Campo campo=new Campo();
    //dichiarazione di una proprietà per gestire il turno
    private boolean turno;
    //metodo getPartita: utile 
    private boolean finita;
    
    //METODI
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
    public Campo getCampo(){
        return campo;
    }
    public boolean isFinita(){
        return finita;
    }
}