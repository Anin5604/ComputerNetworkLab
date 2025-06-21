import java.util.*;
import java.net.*;
import java.io.*;

public class CRCClient{
public static void main(String args []) throws IOException{
Socket client=new Socket("localhost",5000);
PrintWriter dos=new PrintWriter(client.getOutputStream(),true);
BufferedReader dis=new BufferedReader(new InputStreamReader(System.in));
Scanner sc=new Scanner(System.in);
System.out.println("Enter Data: ");
String data=dis.readLine();
String generator="1001";

String codeword=CRCUtil.encodedData(data,generator);
System.out.println("Encoded data sent.."+codeword);
dos.println(codeword);
dos.close();
client.close();
}


}