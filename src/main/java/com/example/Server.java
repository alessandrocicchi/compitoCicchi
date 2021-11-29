package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {
    
    public BufferedReader messRicevuto;
    public OutputStream outVersoClient;

    public void connessioneClient(){

        try {
            ServerSocket server= new ServerSocket(6789);
            for(;;){
            System.out.println("S: Connessione effettuata");
            Socket socket= server.accept();
            SThread serverThread = new SThread(socket);
            serverThread.comunicazione();
            }
        } catch (IOException e) {
            
            System.out.println("S:Errore...Connessione non riuscita");
        }
    }
    

}
