package com.example;

import java.io.*;
import java.net.*;

public class Client {
    
    public String nomeServer="localhost";
    public int portaServer= 6789;
    public Socket socket;
    public BufferedReader inputDaTastiera;
    public DataOutputStream messVersoServer;
    public BufferedReader messDaServer;
    String stringaClient;
    String stringaServer;
    boolean scelta=true;

    public Socket connessioneConServer(){

        System.out.println("Client connesso");

        try {
            inputDaTastiera = new BufferedReader(new InputStreamReader(System.in));
            socket = new Socket(nomeServer, portaServer);
            messVersoServer = new DataOutputStream(socket.getOutputStream());
            messDaServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return socket;
    }

    public void comunicazioneConServer(){
        while(scelta){
            try{
                //invio primo numero
            System.out.println("S: Dammi il primo numero");
            stringaClient=inputDaTastiera.readLine();
            messVersoServer.writeBytes(stringaClient);
            //risposta del server
            System.out.println("S: Dammi il secondo numero");
              //invio secondo numero
            stringaClient=inputDaTastiera.readLine();
            messVersoServer.writeBytes(stringaClient);
            //risposta del server
            System.out.println("S: Dimmi l'operazione che vuoi effettuare(1=somma, 2=sottrazione, 3=moltiplicazione, 4=divisione)");
              //invio operazione
            stringaClient=inputDaTastiera.readLine();
            messVersoServer.writeBytes(stringaClient);
            //stampa il risultato
            stringaServer=messDaServer.readLine();
            System.out.println("Il risultato dell'operazione è:" + stringaServer);
             //continuo operazione
            System.out.println("S: Vuoi effettuare un'altra operazione Y/N?");
            stringaClient=inputDaTastiera.readLine();
            if(stringaClient.equalsIgnoreCase("Y") || stringaClient.equalsIgnoreCase("SI")){
                scelta=true;
            }else if(stringaClient.equalsIgnoreCase("N") || stringaClient.equalsIgnoreCase("NO")){
                scelta= false;
                socket.close();
            }

            } catch (Exception e){

            e.getMessage();
            }
        }

        
    }
}
