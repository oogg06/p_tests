package com.ies.servidorprotocolo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Cliente {

    public void autenticar(BufferedReader bfr,
                                 PrintWriter pw) throws IOException {
        pw.println("HOLa");
        pw.flush();
        String bienvenido=bfr.readLine();
        System.out.println("Recibi:"+bienvenido);
        String codigo=bfr.readLine();
        System.out.print("Recibi "+bienvenido);
        System.out.println(" y "+codigo);
        Integer numero=Integer.parseInt(codigo);
        int codigoValidacion=numero*2;
        pw.println("CODIGO");
        pw.println(codigoValidacion);
        pw.flush();
        String linea=bfr.readLine();
        System.out.println("El servidor contesto:"+linea);
    }

    public static void main(String[] args) {
        Cliente cliente;
        cliente = new Cliente();
        InetSocketAddress direccion;
        direccion = new InetSocketAddress("localhost",
                                          9876);
        Socket conexion;
        conexion = new Socket();
        try {
            conexion.connect(direccion);
            BufferedReader bfr;
            bfr = Utilidades.getFlujoLectura(conexion);
            PrintWriter pw;
            pw = Utilidades.getFlujoEscritura(conexion);
            cliente.autenticar(bfr, pw);
            pw.close();
            bfr.close();
            conexion.close();
        } catch (IOException e) {
            //Quiza el servidor no está encendido
            //Quizá lo esté pero su cortafuegos
            //impide conexiones
            //...
        }
    }
}