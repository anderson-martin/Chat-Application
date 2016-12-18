/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatClient.operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Martin Anderson
 */
public class SetUpNetworking {

    BufferedReader reader;
    PrintWriter writer;


    public SetUpNetworking() {
        establishConnection();
    }

    public void establishConnection() {
        try {
            Socket sock = new Socket("127.0.0.1", 5000);
            InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(sock.getOutputStream());
            System.out.println("networking established");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public BufferedReader getReader(){
        return this.reader;
    }
    
    public PrintWriter getWriter() {
        return this.writer;
    }
}
