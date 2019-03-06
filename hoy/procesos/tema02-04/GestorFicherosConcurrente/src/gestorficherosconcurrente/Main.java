package gestorficherosconcurrente;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        final int MAX_FICHEROS  = 2;
        final int MAX_HILOS     = 40;
        GestorFicherosConcurrente gestorFicheros;
        gestorFicheros = new GestorFicherosConcurrente(MAX_FICHEROS);
        
        Thread hilos[]=new Thread[MAX_HILOS];
        for (int i=0; i<MAX_HILOS; i++){
            Escritor escritor=
                    new Escritor (gestorFicheros, "Hilo "+i);
            hilos[i]=new Thread(escritor);
            hilos[i].start();
        }
        for (int i=0; i<MAX_HILOS; i++){
            hilos[i].join();
        }
        System.out.println("Fin del programa");
    }

}
