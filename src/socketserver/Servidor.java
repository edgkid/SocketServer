/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketserver;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.Base64;
import javax.imageio.ImageIO;
import static javax.swing.GroupLayout.Alignment.CENTER;
import javax.swing.Icon;
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
        String figura = "";
        
        int labelOriginWith = 0;
        int labelOriginHigh = 0;
        int labelImageWith = 0;
        int labelImageHigh= 0;
        ImageIcon icon = null;
        
        try{
           
            serverSocket = new ServerSocket(5000); 
            ViewServerSocketFrame viewServerSocketFrame = new ViewServerSocketFrame();
            viewServerSocketFrame.setVisible(true);
     
            //System.out.println("Ventana " + viewServerSocketFrame.screenSize.width + " X " + viewServerSocketFrame.screenSize.height);
            while (true){

                socket = serverSocket.accept();
                inputStreamReader = new InputStreamReader(socket.getInputStream());
                bufferReader = new BufferedReader(inputStreamReader);
                message = bufferReader.readLine();
                
                Base64.Decoder decoder = Base64.getDecoder();
                byte[] decodedByteArray = decoder.decode(message);
                BufferedImage image = ImageIO.read(new ByteArrayInputStream(decodedByteArray));

                System.out.println("tanaño anterior " + viewServerSocketFrame.getjImage().getWidth() + " X " + viewServerSocketFrame.getjImage().getHeight());
                
               if (count == 1){
                    labelWith = viewServerSocketFrame.screenSize.width / 2;
                    labelHigh = viewServerSocketFrame.screenSize.height;
                    positionX = (viewServerSocketFrame.screenSize.width / 3) - 100;
                    System.out.println("Cartas");
                    //figura = "carta";
               }
               if (count >= 2 && count < 22) {
                   
                   labelHigh = image.getHeight();
                   figura = "fila";
                   if (image.getWidth() >= viewServerSocketFrame.getWidth()){
                        labelWith = viewServerSocketFrame.getWidth();
                        positionX =0;
                        positionY = (viewServerSocketFrame.getHeight() / 2) - (image.getHeight() / 2) ;
                        //System.out.println("Filas Ajustadas");
                   }else{
                       labelWith = image.getWidth();
                       positionX = (viewServerSocketFrame.getWidth() / 2 ) - (image.getWidth() / 2);
                       positionY = (viewServerSocketFrame.getHeight() / 2) - (image.getHeight() / 2);
                       //System.out.println("Filas sin Ajustar");
                   }

               } 
                
               //System.out.println(count);

                viewServerSocketFrame.getjImage().setSize(labelWith, labelHigh);
                viewServerSocketFrame.getjImage().setLocation(positionX, positionY);
                
                viewServerSocketFrame.getjImage().setOpaque(true);
                viewServerSocketFrame.getjImage().setBackground(Color.red);

                icon = new ImageIcon(image);
                viewServerSocketFrame.getjImage().setIcon(icon);

                /*System.out.println("imagen " + image.getWidth() + " X " + image.getHeight());
                System.out.println("Label " + labelWith + " X " + labelHigh);
                System.out.println("Posición ( " + positionX +"," + positionY + " )");*/
               
              
                if (count >= 22){

                     System.out.println("reset");
                     count = 0;
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
