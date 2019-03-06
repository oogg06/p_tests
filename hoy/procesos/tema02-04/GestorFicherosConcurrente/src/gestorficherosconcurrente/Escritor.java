package gestorficherosconcurrente;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Escritor implements Runnable{

    GestorFicherosConcurrente gestor;
    String nombreHilo;

    public Escritor(GestorFicherosConcurrente gestor, String nombreHilo) {
        this.gestor = gestor;
        this.nombreHilo = nombreHilo;
    }
    
    
    
    public void escribirMensaje(String mensaje){
        /* Insistimos en pedir un fichero...*/
        FileWriter fichero;
        do {
            fichero =this.gestor.getFichero();
            System.out.println(this.nombreHilo+" reintentando...");
        }
        /* ...hasta que lo consigamos...*/
        while (fichero==null);
        try {
            /* Una vez conseguido, escribimos...*/
            Utilidades.escribirMensajeFichero(fichero, mensaje);
        } catch (IOException ex) {
            Logger.getLogger(Escritor.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*... y liberamos...*/
        this.gestor.liberarFichero(fichero);
    }
    @Override
    public void run() {
        int numMensajes=Utilidades.getNumAzar(10);
        System.out.println(this.nombreHilo+" ha decidido "
                + "escribir "+numMensajes+ "  mensajes ");
        /* Una vez decidido cuantos mensajes enviar, empezamos
        a escribir mensajes*/
        for (int i=0; i<numMensajes; i++){
            String mensaje=this.nombreHilo+": escribiendo...";
            this.escribirMensaje(mensaje);
            Utilidades.esperarTiempoAzar(3);
        }
        
    }

}
