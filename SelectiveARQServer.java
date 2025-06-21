import java.util.*;
import java.net.*;
import java.io.*;
class SelectiveARQServer{
public static void main(String args[]) throws Exception{

ServerSocket ss=new ServerSocket (5000);
System.out.println("Waiting for client..");
Socket socket=ss.accept();
DataInputStream dis=new DataInputStream(socket.getInputStream());
DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
int n=dis.readInt();
System.out.println("Expected number of Frame:" +n);
int i;
int recieved[]=new int[n];
int frame[]=new int[n]; 
for(i=0;i<n;i++)
{
recieved[i]=-1;
}
for(i=0;i<n;i++)
{
 frame[i]=dis.readInt();
if(Math.random()<0.8){
recieved[i]=frame[i];
dos.writeUTF("ACK");

}
else{
dos.writeUTF("NACK");

}

}
for(i=0;i<n;i++)
{
if(recieved[i]==-1)
{

dos.writeInt(frame[i]);
}


}

}
}