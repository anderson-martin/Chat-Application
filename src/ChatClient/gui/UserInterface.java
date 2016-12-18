/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatClient.gui;

import ChatClient.operations.IncomingReader;
import ChatClient.operations.SetUpNetworking;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author Martin Anderson
 */
public class UserInterface {

    JTextArea incoming;
    JTextField outgoing;
    BufferedReader reader;
    PrintWriter writer;



    public void start() {
        JFrame frame = new JFrame("Chat Client");
        JPanel mainPanel = new JPanel();
        incoming = new JTextArea(15, 50);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);
        JScrollPane scroller = new JScrollPane(incoming);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        outgoing = new JTextField(20);
        JButton sendButton = new JButton("Send");

        mainPanel.add(scroller);
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        
        //establishing connection with server and using input & output streams
        SetUpNetworking networkSetup = new SetUpNetworking();
        reader = networkSetup.getReader();
        writer = networkSetup.getWriter();

        //writing user's text to the server 
        sendButton.addActionListener(new SendButtonListener(writer, outgoing));
        
        //reading incoming messages from server and updating gui
        Thread readerThread = new Thread(new IncomingReader(reader, incoming));
        readerThread.start();

        frame.setSize(650, 500);
        frame.setVisible(true);

    }

}
