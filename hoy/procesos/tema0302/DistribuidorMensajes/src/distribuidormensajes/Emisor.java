package distribuidormensajes;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Random;

public class Emisor {
    public static void main(String[] args) throws IOException{
        final String ipServidor="127.0.0.1";
        final int    puertoEnvio=9876;
        String[] mensajes={
          "Prueba de texto", "Mensaje", "Canal abierto"  
        };
        InetSocketAddress direccion=
                new InetSocketAddress(ipServidor, puertoEnvio);
        Socket socket;
        socket=new Socket();
        socket.connect(direccion);
        PrintWriter flujoEscritura;
        flujoEscritura=Utilidades.getFlujoEscritura(socket);
        int max_mensajes=Utilidades.getNumAzar(mensajes.length);
        for (int i=0; i<max_mensajes; i++){
            int pos_mensaje=Utilidades.getNumAzar(max_mensajes);
            flujoEscritura.println(mensajes[pos_mensaje]);
            flujoEscritura.flush();
        }
    }
}
