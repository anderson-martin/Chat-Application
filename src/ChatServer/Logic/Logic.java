/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatServer.Logic;


import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Martin Anderson
 */
public class Logic {

    ArrayList<PrintWriter> clientOutputStreams;

    public void start() {
        clientOutputStreams = new ArrayList<>();
        try {
            //listening to any pootential client's request
            ServerSocket serverSock = new ServerSocket(5000);
            while (true) {

                //Assigns a new socket & PrintWriter to each client's request
                Socket clientSocket = serverSock.accept();
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                clientOutputStreams.add(writer);

                ClientHandler clientHandler = new ClientHandler(clientSocket, clientOutputStreams);
                //each client will be handled in its own thread
                Thread t = new Thread(clientHandler);
                t.start();
                System.out.println("got a connection");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
