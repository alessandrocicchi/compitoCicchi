package com.example;

public class MainClient {
    
    public static void main(String[] args) {
        
        Client client = new Client();
        client.connessioneConServer();
        client.comunicazioneConServer();
    }
}
