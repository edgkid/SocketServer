/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketserver;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Edgar
 */
public class Servidor {
    
    static Socket socket;
    static ServerSocket serverSocket;
    static InputStreamReader inputStreamReader;
    static BufferedReader bufferReader;
    static String message;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int positionX = 0;
        int positionY = 0;
        int labelWith = 0;
        int count = 0;
        
        try{
           
            serverSocket = new ServerSocket(5000); 
            ViewServerSocketFrame viewServerSocketFrame = new ViewServerSocketFrame();
            viewServerSocketFrame.setVisible(true);
            
            positionX = viewServerSocketFrame.getjImage().getSize().width;
              
            while (true){

                labelWith = viewServerSocketFrame.getWidth() / 2;
                positionX = (viewServerSocketFrame.getWidth() / 3) - 100;

                viewServerSocketFrame.getjImage().setSize(labelWith, viewServerSocketFrame.getjImage().getHeight());
                viewServerSocketFrame.getjImage().setLocation(positionX, positionY);

                socket = serverSocket.accept();
                inputStreamReader = new InputStreamReader(socket.getInputStream());
                bufferReader = new BufferedReader(inputStreamReader);
                message = bufferReader.readLine();

                System.out.println(message);

                viewServerSocketFrame.getjImage().setText(message);
                
                
            }
            
            
        }catch(IOException e){
            e.printStackTrace();
            
        }
        
    }
    
}
