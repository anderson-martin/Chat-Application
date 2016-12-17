/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatServer.Logic;

import ChatServer.Logic.MessageDistributor;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Martin Anderson
 */
public class ClientHandler implements Runnable {

    ArrayList<PrintWriter> clientOutputStreams;
    BufferedReader reader;

    public ClientHandler(Socket clientSOcket, ArrayList<PrintWriter> clientOutputStreams) {
        this.clientOutputStreams = clientOutputStreams;
        try {
            // reading client's message
            InputStreamReader steamReader = new InputStreamReader(clientSOcket.getInputStream());
            reader = new BufferedReader(steamReader);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void run() {
        String clientMessage;

        try {
            while ((clientMessage = reader.readLine()) != null) {
                //receieving client's message and showing them in Server's console
                System.out.println("read " + clientMessage);
                MessageDistributor distributor = new MessageDistributor();
                distributor.DistributeToAll(clientMessage, clientOutputStreams);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
