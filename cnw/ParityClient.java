import java.util.*;
import java.io.*;
import java.net.*;
public class ParityClient{
public static void main(String args[]) throws IOException{

Socket socket=new Socket("localhost",5000);
System.out.println("Enter data: ");
BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
PrintWriter out=new PrintWriter (socket.getOutputStream(),true);
String data=in.readLine();
BufferedReader input=new BufferedReader(new InputStreamReader(socket.getInputStream()));

String msg=ParityUtil.addParity(data);
String msg1="01101";
out.println(msg1);

String recievdata=input.readLine();
System.out.println("Reciever says:"+recievdata);
}


}