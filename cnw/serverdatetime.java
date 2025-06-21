import java.io.*;
import java.net.*;
import java.time.*;
public class serverdatetime{
public static void main(String args[]) throws Exception
{
int port=6000;

try(ServerSocket Serversocket=new ServerSocket(port)){
while(true){
Socket socket=Serversocket.accept();

PrintWriter out=new PrintWriter(socket.getOutputStream());
BufferedReader input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
String request=input.readLine();
if("GET_TIMEDATE".equalsIgnoreCase(request)){
LocalDateTime now=LocalDateTime.now();
SimpleDateFormatt sdf=new SimpleDateFormatt("DD-MM-YYYY HH-mm-SS");
String current=sdf.now();
System.out.println("Current Time to client:"+current);
  out.println(current);
}
}
}
catch(IOException e){
e.printStackTrace();

}
}
}

