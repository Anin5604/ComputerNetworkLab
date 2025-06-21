import java.util.*;
import java.net.*;
import java.io.*;



class SelectiveARQServer{
public static void main(String args[]) throws IOException{
ServerSocket serverSocket=new ServerSocket(5000);
System.out.println("Waiting for connection..");
Socket client=serverSocket.accept();
System.out.println("Client Connected..");

BufferedReader in=new BufferedReader(new InputStreamReader(client.getInputStream()));
System.out.println("Enter Number of Frame:");

int i;



}





}