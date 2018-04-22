/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketserver;

/**
 *
 * @author Edgar
 */
public class PortConnection {
    
    private static String portConnection;

    public PortConnection() {
        
        this.portConnection = "5000";
    }

    public static String getPortConnection() {
        return portConnection;
    }

    public static void setPortConnection(String portConnection) {
        PortConnection.portConnection = portConnection;
    }

}
