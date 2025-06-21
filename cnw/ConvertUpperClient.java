import java.io.*;
import java.net.*;
import java.util.*;
class ConvertUpperClient{

public static void main (String args[]) throws IOException{
Scanner sc=new Scanner(System.in);
Socket socket=new Socket("localhost",5000);
System.out.println("Enter Any Word:");
String w=sc.nextLine();

PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
out.println(w);
BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
String msg=in.readLine();
System.out.println("Recieved:"+msg);
BufferedReader input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
while((BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()))!=null){

System.out.println(msg);
}

in.close();
out.close();
socket.close();


}




}