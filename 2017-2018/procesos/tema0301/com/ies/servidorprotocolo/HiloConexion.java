package com.ies.servidorprotocolo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class HiloConexion implements Runnable {
    BufferedReader bfr;
    PrintWriter pw;
    Socket socket;
    Random generador=new Random();
    public HiloConexion(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
        	
        	int codigoAzar=generador.nextInt(1000);
            bfr = Utilidades.getFlujoLectura(this.socket);
            pw = Utilidades.getFlujoEscritura(this.socket);
            String hola=bfr.readLine();
            if (!hola.equals("HOLA")){
            	pw.print("Lo siento, tu primera linea debe ser HOLA (en mayusculas)");
            	pw.print("He dejado de atender tu conexion");
            	pw.print(" por lo que es posible que tu cliente se quede \"bloqueado\".");
            	pw.println(" P�ralo y revisa tu c�digo");
            	pw.flush();
            	return ;
            }
            pw.println("BIENVENIDO");
            pw.println(codigoAzar);
            System.out.println("Enviando "+codigoAzar+" a un cliente");
            pw.flush();
            String codigo=bfr.readLine();
            String codigoValidado=bfr.readLine();
            if (!codigo.equals("CODIGO")){
            	System.out.println("No envio CODIGO");
            	pw.print("Lo siento, deberias haber enviado ");
            	pw.print("CODIGO (en may�sculas) seguido del numero "+(codigoAzar*2));
            	pw.print("que es el doble de "+codigoAzar);
            	pw.println(" que es el c�digo que te envi�. Vuelve a probar");
            	pw.flush();
            	return ;
            } //Fin del if
            Integer codigoRecibido=Integer.parseInt(codigoValidado);
            if ((codigoAzar*2)!=codigoRecibido){
            	System.out.println("No envi� el c�digo correcto");
            	pw.print("Recib� tu l�nea ");
            	pw.print("CODIGO pero deber�as haber enviado "+(codigoAzar*2));
            	pw.print("que es el doble de "+codigoAzar);
            	pw.println(" que es el c�digo que te envi�. Vuelve a probar");
            	pw.flush();
            	return ;
            }
            pw.print("Muy bien, puedes ense�ar esta ejecuci�n al profesor");
            pw.println(" para que apunte que has hecho bien este ejercicio");
            pw.flush();
        } catch (IOException e) {
            System.out.println("Hubo un fallo al enviar/recibir datos");
        }
    }
    //Fin del run
}