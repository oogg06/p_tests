package distribuidormensajes;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class DistribuidorMensajes {
    ArrayList<Socket> receptores= new ArrayList<>();
    ArrayList<Socket> emisores  = new ArrayList<>();
    final int PUERTO_PARA_EMISORES   = 9876;
    final int PUERTO_PARA_RECEPTORES = 9877;
    
    public void servir() throws IOException{
        ServerSocket serverSocket;
        serverSocket=new ServerSocket(this.PUERTO_PARA_EMISORES);
        while (true){
            Socket emisor=serverSocket.accept();
            
            
        }
    }
    
    public static void main(String[] args) {
        
    }

}
