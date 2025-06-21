import java.io.*;
import java.net.*;
import java.time.*;
public class client1{
public static void main(String args[])
{
int port=5000;
String address="localhost";
try(Socket socket=new Socket(address,port)){
BufferedReader userinput=new BufferedReader(new InputStreamReader(System.in));
PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
BufferedReader  in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
System.out.println("Enter Sentence:");
String sent=userinput.readLine();
out.println(sent);
System.out.println("Sent to Server :"+sent);
String rev=in.readLine();
System.out.println("Recived :"+rev);
out.println("GET_DATETIME");
String response=in.readLine();
System.out.println("Current Date and time"+response);

}
catch(IOException e){
e.printStackTrace();
}
}
}