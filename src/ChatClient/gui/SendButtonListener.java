/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatClient.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import javax.swing.JTextField;

/**
 *
 * @author Martin Anderson
 */
public class SendButtonListener implements ActionListener {
    JTextField outgoing;
    PrintWriter writer;
    
    
    public SendButtonListener(PrintWriter writer, JTextField outgoing){
        this.writer = writer;
        this.outgoing = outgoing;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        try {
            writer.println(outgoing.getText());
            writer.flush();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        outgoing.setText("");
        outgoing.requestFocus();
    }

}
