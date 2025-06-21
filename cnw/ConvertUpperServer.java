import java.io.*;
import java.net.*;

class ConvertUpperServer{

public static void main (String args[]) throws IOException{

ServerSocket serverSocket=new ServerSocket(5000);
System.out.println("Waiting for Client");

Socket client=serverSocket.accept();
System.out.println("client connected");
BufferedReader in=new BufferedReader(new InputStreamReader(client.getInputStream()));
PrintWriter out=new PrintWriter(client.getOutputStream(),true);
String recievemsg=in.readLine();
out.println(recievemsg);
String uppr=recievemsg.toUpperCase();

out.println(uppr);



in.close();
out.close();

client.close();
serverSocket.close();



}




}