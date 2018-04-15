/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketserver;

import java.awt.Color;
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
        int count = 0;
        String path = "";
        
        int labelOriginWith = 0;
        int labelOriginHigh = 0;
        int labelImageWith = 0;
        int labelImageHigh= 0;
        ImageIcon icon = null;
        
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
                
                
                viewServerSocketFrame.getjImage().setOpaque(true);
                viewServerSocketFrame.getjImage().setBackground(Color.red);
                //////Procesando imagenes
                Base64.Decoder decoder = Base64.getDecoder();
                byte[] decodedByteArray = decoder.decode(message);
                BufferedImage image = ImageIO.read(new ByteArrayInputStream(decodedByteArray));
 
               viewServerSocketFrame.getjImage().setSize(viewServerSocketFrame.getWidth() / 2, viewServerSocketFrame.getHeight());
               icon = new ImageIcon(image.getScaledInstance(viewServerSocketFrame.getjImage().getWidth(), viewServerSocketFrame.getHeight(), image.SCALE_DEFAULT));

                viewServerSocketFrame.getjImage().setAlignmentX(javax.swing.JLabel.CENTER);
                viewServerSocketFrame.getjImage().setAlignmentY(javax.swing.JLabel.CENTER);

                viewServerSocketFrame.getjImage().setIcon(icon);
            }
            
            
        }catch(IOException e){
            e.printStackTrace();
            
        }
        
    }
    
}
