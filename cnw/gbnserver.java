import java.util.*;
import java.io.*;
import java.net.*;
class gbnserver{
public static void main(String args[])throws Exception{
ServerSocket ss=new ServerSocket(5000);
System.out.println("Waiting for client..");
Socket client=ss.accept();
System.out.println("Connected..");
DataOutputStream dos=new DataOutputStream (client.getOutputStream());
DataInputStream dis=new DataInputStream (client.getInputStream());
int frame,expectedframe=0;
while(true){
frame=dis.readInt();

if (frame==-1)
{
break;
}
if(frame==expectedframe){
System.out.println("Recieved Frame:"+expectedframe);

dos.writeInt(frame);
expectedframe++;

}
else{

dos.writeInt(expectedframe-1);
System.out.println("discarded Frame:"+expectedframe);
}
}

}}