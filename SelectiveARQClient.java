import java.util.*;
import java.net.*;
import java.io.*;
class SelectiveARQClient{
public static void main(String args[])throws Exception{

Socket socket=new Socket("localhost",5000);
DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
DataInputStream dis=new DataInputStream(socket.getInputStream());
Scanner sc=new Scanner(System.in);
System.out.println("Enter Number of frames expected: ");
int n=sc.nextInt();
dos.writeInt(n);
int i;
int frame[]=new int[n];
boolean isAcked[]=new boolean[n];

for(i=0;i<n;i++){
frame[i]=i;
isAcked[i]=false;
}
for(i=0;i<n;i++){
dos.writeInt(frame[i]);
String response=dis.readUTF();

if(response.equalsIgnoreCase("ACK")){
isAcked[i]=true;
System.out.println("ACK Succesfully RECIEVED FOR : ACK"+frame[i]);
}
else{
 System.out.println("NACK RECIEVED FOR : NACK"+frame[i]);
}

}for(i=0;i<n;i++){

if(!isAcked[i])
{
dos.writeInt(frame[i]);
System.out.println("RETRANSMITTED LOST : frame"+frame[i]);
}
}

}

}