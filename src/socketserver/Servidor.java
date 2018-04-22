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
import javax.swing.DefaultListModel;
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
    static ArrayList<String> arrayListAv = new ArrayList<String>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int positionX = 0;
        int positionY = 0;
        int labelWith = 0;
        int labelHigh = 0;
        int count = 0;
        
        PortConnection portConnection = new PortConnection();
        DefaultListModel listView = null;
        
        ImageIcon icon = null;
        ViewServerCanvas viewServerCanvas = null;
        ViewServerCanvas viewServerCanvasAux = null;
        ViewServerCanvas deleteComponent = null;
        
        fillAvList();
        
        try{
           
            serverSocket = new ServerSocket(Integer.parseInt(PortConnection.getPortConnection()));
            
            ViewServerSocketFrame viewServerSocketFrame = new ViewServerSocketFrame();
            viewServerSocketFrame.setVisible(true);
                
            listView = new DefaultListModel();
            
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
                    System.out.println("Carta");
                }
                if (count >= 1) {

                    labelHigh = image.getHeight();
                    if (image.getWidth() >= viewServerSocketFrame.getWidth()){
                         labelWith = viewServerSocketFrame.getWidth();
                         positionX =0;
                         positionY = (viewServerSocketFrame.getHeight() / 2) - (image.getHeight() / 2) ;
                         System.out.println("Fila Ajustada");
                    }else{
                        labelWith = image.getWidth();
                        positionX = (viewServerSocketFrame.getWidth() / 2 ) - (image.getWidth() / 2);
                        positionY = (viewServerSocketFrame.getHeight() / 2) - (image.getHeight() / 2);
                        System.out.println("Fila No Ajustada");
                    }

                } 
                
                if (count > 0){
                
                    viewServerCanvasAux = (ViewServerCanvas) listView.get(count-1);
                    viewServerCanvasAux.dispose();
                    
                }
               
               icon = new ImageIcon(image.getScaledInstance(labelWith, labelHigh, Image.SCALE_DEFAULT));
               viewServerCanvas = new ViewServerCanvas(labelWith, labelHigh, icon, positionX, positionY);
               
                
                if (count < 12){
                    listView.add(count,viewServerCanvas );
                    viewServerCanvas.setVisible(true);
                    
                    if (count > 0){
                        viewServerSocketFrame.getjLabelAv().setText(arrayListAv.get(count-1));
                    }

                }else{
                    count = -1;
                    positionX = 0;
                    positionY = 0;
                    for (int i = 0; i < listView.getSize(); i++){
                       deleteComponent = (ViewServerCanvas) listView.get(i);
                       deleteComponent.dispose();
                    }
                    listView.removeAllElements();
                    viewServerSocketFrame.getjLabelAv().setText("0");
                }
                
                System.out.println(count);
                count ++;

            }
  
        }catch(IOException e){
            e.printStackTrace();
            
        }
        
    }
    
    public static void fillAvList(){
        
        arrayListAv.add("0.1");
        arrayListAv.add("0.13");
        arrayListAv.add("0.17");
        arrayListAv.add("0.20");
        arrayListAv.add("0.25");
        arrayListAv.add("0.33");
        arrayListAv.add("0.40");
        arrayListAv.add("0.50");
        arrayListAv.add("0.63");
        arrayListAv.add("0.80");
        arrayListAv.add("1.00");
    
    }
    
}
