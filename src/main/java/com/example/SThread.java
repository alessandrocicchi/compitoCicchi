package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;

public class SThread extends Thread{
    
    ServerSocket server= null;
    Socket client= null;
    BufferedReader messDaClient;
    DataOutputStream messVersoClient;
    boolean continua= true;
    int primoNumero;
    int secondoNumero;
    int operazione;
    double risultato;

    public SThread(Socket s){

        client=s;
    }

    public void comunicazione() {
        try {
            comunicazioneServerClient();
        } catch (Exception e) {
            System.out.println("Impossibile effetuare la comunicazione tra client e server");
        }
    }

    public void comunicazioneServerClient() throws Exception{

            messDaClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            messVersoClient = new DataOutputStream(client.getOutputStream());
            for(;;){
                //prendo il primo numero
                primoNumero=Integer.valueOf(messDaClient.readLine());
                //prendo il secondo numero
                secondoNumero=Integer.valueOf(messDaClient.readLine());
                //prendo l'operazione
                operazione=Integer.valueOf(messDaClient.readLine());

                switch(operazione){

                    //somma
                    case 1:

                    System.out.println("Hai scelto somma");
                    risultato=primoNumero+secondoNumero;
                    messVersoClient.writeDouble(risultato);

                    break;

                    //sottrazione
                    case 2:

                    System.out.println("Hai scelto sottrazione");
                    risultato=primoNumero-secondoNumero;
                    messVersoClient.writeDouble(risultato);

                    break;

                    //moltiplicazione

                    case 3:

                    System.out.println("Hai scelto moltiplicazione");
                    risultato=primoNumero*secondoNumero;
                    messVersoClient.writeDouble(risultato);

                    break;

                    //divisione
                    case 4:

                    System.out.println("Hai scelto divisione");
                    risultato=primoNumero/secondoNumero;
                    messVersoClient.writeDouble(risultato);

                    break;

                    default:

                    System.out.println("operazione inesistente");
                }
            }


    }
}
