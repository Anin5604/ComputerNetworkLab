import java.net.*;
import java.io.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
class timeserver{
public static void main( String args[]) throws IOException{

ServerSocket serversocket=new ServerSocket(5000);
System.out.println("Waiting For Client..");

while (true){
Socket client=serversocket.accept();
System.out.println("Client Connected");
LocalDateTime now=LocalDateTime.now();
DateTimeFormatter format= DateTimeFormatter.ofPattern("dd-mm-yyyy HH-MM-SS");
PrintWriter out=new PrintWriter(client.getOutputStream(),true);
out.println("Current time:"+format.format(now));
out.close();
client.close();
serversocket.close();

}

}



}