/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatClient.operations;

import java.io.BufferedReader;
import java.io.IOException;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Martin Anderson
 */
public class IncomingReader implements Runnable {

    JTextArea incoming;
    BufferedReader reader;

    public IncomingReader(BufferedReader reader, JTextArea incoming) {
        this.reader = reader;
        this.incoming = incoming;
    }

    public void run() {
        //reading incoming messages from server and updating gui
        String message;
        try {
            while ((message = reader.readLine()) != null) {
                System.out.println("client read " + message);
                incoming.append(message + "\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
