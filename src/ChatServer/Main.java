/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatServer;

import ChatServer.Logic.Logic;

/**
 *
 * @author Martin Anderson
 */

public class Main {

    public static void main(String[] args) {
        Logic logic = new Logic();
        logic.start();
    }
}
