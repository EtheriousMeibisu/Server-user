package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {

      String host = "127.0.0.1";
      int port = 8089;

      try (Socket clientSocket = new Socket(host, port);
           PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
           BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))){

          out.println("Julia");

          String resp = bufferedReader.readLine();
          System.out.println(resp);
      }catch (IOException e){
          e.printStackTrace();
      }
    }
}