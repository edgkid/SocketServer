/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketserver;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Base64;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


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
    static BufferedImage image = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int positionX = 0;
        int positionY = 0;
        int labelWith = 0;
        int labelHigh = 0;
        int count = 0;
        
        ImageIcon icon = null;
        ViewServerCanvas viewServerCanvas = null;
        
        try{
           
            serverSocket = new ServerSocket(5000); 
            ViewServerSocketFrame viewServerSocketFrame = new ViewServerSocketFrame();
            viewServerSocketFrame.setVisible(true);
     
            while (true){

                socket = serverSocket.accept();
                inputStreamReader = new InputStreamReader(socket.getInputStream());
                bufferReader = new BufferedReader(inputStreamReader);
                message = bufferReader.readLine();
                
                Base64.Decoder decoder = Base64.getDecoder();
                byte[] decodedByteArray = decoder.decode(message);
                BufferedImage image = ImageIO.read(new ByteArrayInputStream(decodedByteArray));

                if (count == 0){
                    labelWith = viewServerSocketFrame.screenSize.width / 2;
                    labelHigh = viewServerSocketFrame.screenSize.height;
                    positionX = (viewServerSocketFrame.screenSize.width / 3) - 100;
                }
                if (count >= 1 && count < 11) {

                    labelHigh = image.getHeight();
                    if (image.getWidth() >= viewServerSocketFrame.getWidth()){
                         labelWith = viewServerSocketFrame.getWidth();
                         positionX =0;
                         positionY = (viewServerSocketFrame.getHeight() / 2) - (image.getHeight() / 2) ;
                    }else{
                        labelWith = image.getWidth();
                        positionX = (viewServerSocketFrame.getWidth() / 2 ) - (image.getWidth() / 2);
                        positionY = (viewServerSocketFrame.getHeight() / 2) - (image.getHeight() / 2);
                    }

                } 
               
               icon = new ImageIcon(image.getScaledInstance(labelWith, labelHigh, Image.SCALE_DEFAULT));
               viewServerCanvas = new ViewServerCanvas(labelWith, labelHigh, icon, positionX, positionY);
               viewServerCanvas.setVisible(true);

                if (count >= 11){

                     count = -1;
                     positionX = 0;
                     positionY = 0;
                 }
                
                count ++;
            }
            
            
        }catch(IOException e){
            e.printStackTrace();
            
        }
        
    }
    
}
