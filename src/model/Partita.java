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
    /**
     * Costruttore per inizializzare la partita
     */
    public Partita(){
        finita=false;
        turno=false;
        
    }
    /**
     * Metodo che restituisce se stesso
     * @return oggetto di tipo Partita
     */
    public Partita getPartita(){
        return this;
    }
    //metodo che ti assegna il turno
    /**
     * restituisce il turno
     * @return true/false
     */
    public boolean getTurno(){
        return turno;
    }
    /**
     * restituisce l'oggetto di tipo campo dentro a Partita
     * @return Campo
     */
    public Campo getCampo(){
        return campo;
    }
    /**
     * Controlla se la partita è finita
     * @return true se è finita la partita / false se è in corso
     */
    public boolean isFinita(){
        return finita;
    }
}