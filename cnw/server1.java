import java.io.*;
import java.net.*;
import java.time.*;
public class server1{
public static void main(String args[])
{
int port=5000;
try(ServerSocket Sersocket=new ServerSocket(port)){


while(true){
Socket socket=Sersocket.accept();
System.out.println("Server is Running :"+socket);
BufferedReader userinput=new BufferedReader(new InputStreamReader(System.in));

BufferedReader  in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
String sent=in.readLine();
System.out.println("from client :"+sent);



String rev=new StringBuilder(sent).reverse().toString();
out.println(rev);
System.out.println("Sent TO CLIENT  :"+rev);
String request=in.readLine();
if(in.equalsIgnoreCase()="GET_DATETIME"){
LocalDateTime time=LocalDateTime.now();
String  formatter=new DateFormatter( "dd-mm-yy hh-MM-ss");
System.out.println(formatter(now.LocalDateTime()));

}

socket.close();

}
}
catch(IOException e){
e.printStackTrace();
}
}
}