package distribuidormensajes;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;


public class Utilidades {
 /* Obtiene un flujo de escritura
    a partir de un socket*/
    public static PrintWriter getFlujoEscritura
            (Socket s) throws IOException{
            OutputStream os= s.getOutputStream();
            PrintWriter pw=new PrintWriter(os);
            return pw;
    }
    /* Obtiene un flujo de lectura
    a partir de un socket*/
    public static BufferedReader
            getFlujoLectura(Socket s)
                            throws IOException{
            InputStream is=s.getInputStream();
            InputStreamReader isr=
                            new InputStreamReader(is);
            BufferedReader bfr=new BufferedReader(isr);
            return bfr;
    }
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
