import java.util.*;

import java.net.*;
 import java.io.*;

public class checksumUtilClient{
public static void main(String args[]) throws Exception{
Scanner sc=new Scanner(System.in);
Socket client=new Socket("localhost",5000);
System.out.println("Enter string :");
DataOutputStream dos=new DataOutputStream  (client.getOutputStream());
DataInputStream dis=new DataInputStream (client.getInputStream());
String data=sc.nextLine();
dos.writeUTF(data);
int checksum=checksumUtil.calculatedchecksum(data);
dos.writeInt(checksum);
String msg=dis.readUTF();
dos.flush();

}
}