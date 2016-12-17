/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatServer.Logic;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Martin Anderson
 */
public class MessageDistributor {
    
        
    
        public void DistributeToAll(String message, ArrayList<PrintWriter> clientOutputStreams) {
        Iterator iterator = clientOutputStreams.iterator();
        while (iterator.hasNext()) {
            try {
                //spreading message to all, by means of each client's PrintWriter
                PrintWriter writer = (PrintWriter) iterator.next();
                writer.println(message);
                writer.flush();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
