package gestorficherosconcurrente;

import java.io.FileWriter;
import java.io.IOException;

public class GestorFicherosConcurrente {
    private int MAX_FICHEROS;
    private FileWriter ficheros[];
    /* Usamos esto para saber si un cierto fichero está asignado
    a alguien o no */
    private boolean   [] ficheroAsignado;
    
    /**
     * 
     * @param MAX_FICHEROS Cantidad de ficheros a tener "en reserva"
     * @throws IOException 
     */
    public GestorFicherosConcurrente(int MAX_FICHEROS) throws IOException {
        this.MAX_FICHEROS   = MAX_FICHEROS;
        ficheroAsignado        = new boolean[MAX_FICHEROS];
        ficheros            = new FileWriter[this.MAX_FICHEROS];
        for (int i=0; i<this.MAX_FICHEROS; i++){
            ficheros[i]=new FileWriter("fich"+i+".txt");
        }
    }
    /**
     * Este método puede ser accedido por varios hilos a la vez
     * para intentar conseguir un fichero en el que escribir
     * 
     * @return un fichero para escribir en él 
     * o null si no hay ficheros libres
     */
    public synchronized FileWriter getFichero(){
        /* Vamos buscando en los ficheros...*/
        for (int i=0; i<this.MAX_FICHEROS; i++){
            /* ... y si vemos uno sin asignar...*/
            if (!ficheroAsignado[i]){
                /*... lo marcamos y lo devolvemos*/
                ficheroAsignado[i]=true;
                return ficheros[i];
            } /* Fin del if*/
        } /* Fin del for*/
        /* Si el bucle termina es que no había ficheros
        libres, devolvemos null*/
        return null;
    }
    public void liberarFichero(FileWriter fichero){
        /* Vamos buscando en los ficheros cual es la posicion
        del fichero pasado... */
        for (int i=0; i<this.MAX_FICHEROS; i++){
            /* ...y cuando lo encontremos...*/
            if (this.ficheros[i]==fichero){
                /* ... lo marcamos como no asignado...*/
                this.ficheroAsignado[i]=false;
            }
        } /* Fin del for*/
    }
    
    
    
    
}
