import java.util.*;

import java.net.*;
 import java.io.*;

public class checksumUtilServer{
public static void main(String args[]) throws IOException{
ServerSocket ss=new  ServerSocket (5000);
System.out.println("Waiting for client...");
Socket client=ss.accept();
System.out.println(" client connected ...");

DataInputStream dis=new DataInputStream (client.getInputStream());
String recievedata=dis.readUTF();

int calcchecksum=checksumUtil.calculatedchecksum(recievedata);
int recievchecksum=dis.readInt();
if(recievchecksum==calcchecksum){
System.out.println("data recieved correctly "+recievedata);
System.out.println(recievchecksum);
}
else{
System.out.println("data has error "+recievedata);
}
ss.close();
}
}

