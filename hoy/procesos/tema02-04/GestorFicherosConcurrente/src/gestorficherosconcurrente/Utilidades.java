package gestorficherosconcurrente;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Utilidades {
    public static void escribirMensajeFichero(FileWriter f, String mensaje) throws IOException{
        f.write(mensaje);
        f.write(System.lineSeparator());
        f.flush();
    }
    public static int getNumAzar(int maximo){
        Random generador=new Random();
        int numAzar=generador.nextInt(maximo);
        return numAzar;
    }
    public static void esperarTiempoAzar(int segsMaximo) {
        Random generador=new Random();
        int msAzar=generador.nextInt(segsMaximo*1000);
        try {
                Thread.sleep(msAzar);
        } catch (InterruptedException ex) {
                System.out.println("Fallo la espera");
        }
    }
}
