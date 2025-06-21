import java.util.*;
import java.io.*;
import java.net.*;

class GBNServer{

public static void main (String args[])throws Exception{

ServerSocket serversocket=new ServerSocket(5000);
System.out.println("Waiting for client..");
Socket socket=serversocket.accept();
System.out.println("Connected client..");
DataOutputStream dos=new      DataOutputStream(socket.getOutputStream()); 
DataInputStream dis=new  DataInputStream(socket.getInputStream()); 

int expectedframe=0;
	while(true){
	int frame=dis.readInt();
	
	if(frame==-1)
          {
	break;
	}
	if(frame==expectedframe){
		System.out.println("Reciievedd frame"+frame);
	       dos.writeInt(frame);
              expectedframe++;
	}else{System.out.println("Discarded frame "+frame);
		dos.writeInt(expectedframe-1);
        }
       
	}
socket.close();
serversocket.close();
}




}