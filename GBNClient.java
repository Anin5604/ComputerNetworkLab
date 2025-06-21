import java.util.*;
import java.io.*;
import java.net.*;

class GBNClient{

public static void main (String args[]) throws Exception{

Socket socket=new Socket("localhost",5000);
DataOutputStream dos=new DataOutputStream(socket.getOutputStream()); 
DataInputStream dis=new DataInputStream(socket.getInputStream()); 
Scanner sc=new Scanner(System.in);
System.out.println("Enter number of frame: ");
int totalframe=sc.nextInt();
int i,ack;
int []frame=new int[totalframe];
for(i=0;i<totalframe;i++){
frame[i]=i;

}
int windowsize=4;
int base=0;

int nextSequence=0;
while(base<totalframe){

	while(nextSequence<base+windowsize && nextSequence<totalframe){
		dos.writeInt(frame[nextSequence]);
		
		
		System.out.println(" Transmitted  Frame: "+nextSequence);

	nextSequence++;
	}
Thread.sleep(400);
	ack=dis.readInt();
System.out.println("Recieved Ack:"+ack);
	base=ack+1;
	nextSequence=base;

}
dos.writeInt(-1);
socket.close();

}





}