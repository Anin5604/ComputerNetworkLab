import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import javax.imageio.ImageIO;
import javax.swing.*;
public class RemoteDesktopClient{
public static void main( String []args ) throws Exception{
	String serverIP="127.0.0.1";
	Socket socket=new Socket(serverIP,5000);
        DataInputStream dis=new DataInputStream(socket.getInputStream());
	JFrame frame=new JFrame("Remote Desktop Viewer");
	JLabel label =new JLabel();
	frame.getContentPane().add(label);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	frame.setVisible(true);
        while(true){
	 int size =dis.readInt();
	 byte[] imageBytes=new byte[size];
	dis.readFully(imageBytes);
	ByteArrayInputStream bais=new ByteArrayInputStream(imageBytes);
    BufferedImage image=ImageIO.read(bais);
   label.setIcon(new ImageIcon(image));  

          }


	}


}