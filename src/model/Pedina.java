package model;
public class Pedina {
    private boolean colore;//true se è nero false se è bianco
    /**
     * coatruttore che associa il parametro in ingresso con colore 
     * @param z 
     */
    public Pedina(boolean z){
        colore=z;
    }
    /**
     * Metodo che ritorna il colore
     * @return colore
     */
    public boolean getColore(){
        return colore;
    }
    /**
     * Metodo che setta il colore
     * @param colore 
     */
    public void setColore(boolean colore){
        this.colore=colore;
    }
    
}