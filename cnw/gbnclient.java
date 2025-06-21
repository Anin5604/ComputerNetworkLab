import java.util.*;
import java.io.*;
import java.net.*;
class gbnclient{
public static void main(String args[])throws Exception{

Scanner sc=new Scanner(System.in);
Socket client=new Socket("localhost",5000);
System.out.println("Connected..");
DataOutputStream dos=new DataOutputStream (client.getOutputStream());
DataInputStream dis=new DataInputStream (client.getInputStream());
System.out.println("Enter no. of frame:");
int n=sc.nextInt();
int base=0,i;
int windowsize=4;
int nextSeq=0;
int []frame=new int[n];

for(i=0;i<n;i++){
frame[i]=i;
}
while(base<n){

while(nextSeq<base+windowsize && nextSeq<n){
System.out.println("SENT FRAME:"+nextSeq);
dos.writeInt(frame[nextSeq]);
nextSeq++;
}

Thread.sleep(1000);
int ack=dis.readInt();
System.out.println("Recieved ACK:"+ack);
base=ack+1;
nextSeq=base;
}



dos.writeInt(-1);
client.close();

}


}