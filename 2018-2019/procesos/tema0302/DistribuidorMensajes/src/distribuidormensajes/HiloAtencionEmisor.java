package distribuidormensajes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloAtencionEmisor implements Runnable{
    ArrayList<PrintWriter> flujosReceptores;
    Socket socketEmisor;
    BufferedReader flujoLectura;
    public HiloAtencionEmisor(ArrayList<PrintWriter> flujosReceptores, Socket socketEmisor) throws IOException {
        this.flujosReceptores   = flujosReceptores;
        this.socketEmisor       = socketEmisor;
        this.flujoLectura       = Utilidades.getFlujoLectura(
                socketEmisor);
    }
    
    public void distribuirMensaje(){
        try {
            String mensaje=this.flujoLectura.readLine();
            for (PrintWriter pw : flujosReceptores){
                pw.println(mensaje);
                pw.flush();
            }
        } catch (IOException ex) {
            System.out.println("No se recibio nada. ¿Socket cerrado?");
        }
    }
    @Override
    public void run() {
        while (true){
            this.distribuirMensaje();
        }
    }

}
