package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{


        Socket socket = new Socket("127.0.0.1", 3000);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        Scanner tastiera = new Scanner(System.in);

        while (true) {
            System.out.print("Scrivi qualcosa: ");
            String testoUtente= tastiera.nextLine();

            out.println(testoUtente);

            if (testoUtente.equals("exit")) {
                System.out.println("CLIENT: Chiudo l'applicazione.");
                break;
            }

            String risposta = in.readLine();
            System.out.println("Risposta del server: " + risposta);
        }
    }
}