import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import javax.imageio.ImageIO;

public class RemoteDesktopServer{
	public static void main(String[]args) throws Exception
	{
		ServerSocket serverSocket=new ServerSocket(5000);
		System.out.println("Waiting for client to connect");
		Socket client=serverSocket.accept();
		System.out.println("Client Connected");
		DataOutputStream dos=new DataOutputStream (client.getOutputStream());
		Robot robot=new Robot();
		Rectangle screenRect=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		while(true)
		{
			BufferedImage image=robot.createScreenCapture(screenRect);
			ByteArrayOutputStream baos=new ByteArrayOutputStream ();
			ImageIO.write(image,"jpg",baos);
			byte[] bytes=baos.toByteArray();
			dos.writeInt(bytes.length);
			dos.write(bytes);
			dos.flush();
			Thread.sleep(100);
		}

    }

}
