import java.io.*;
import java.net.*;
public class clientdatetime{
public static void main(String args[]) throws Exception
{
int port=6000;
String address="localhost";
try(Socket socket=new Socket(address,port)){

PrintWriter out=new PrintWriter(socket.getOutputStream());
BufferedReader input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
out.println("GET_TIMEDATE");
String date=input.readLine();
System.out.println("Current Time from Servr:"+date);
  

}
catch(IOException e){
e.printStackTrace();

}



}
}