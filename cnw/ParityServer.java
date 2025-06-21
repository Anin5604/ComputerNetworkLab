import java.util.*;
import java.io.*;
import java.net.*;
public class ParityServer{
public static void main(String args[]) throws IOException{

ServerSocket serversocket=new ServerSocket(5000);
System.out.println("Waiting for Client..");
Socket socket=serversocket.accept();

BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
PrintWriter out=new PrintWriter (socket.getOutputStream(),true);
String recievdata=in.readLine();
boolean isParity=ParityUtil.checkParity(recievdata);
if(isParity){

System.out.println("Recieved Data has not err Free From Error"
+ParityUtil.addParity(recievdata));
out.println("Recieved Data has not err Free From Error"
+ParityUtil.addParity(recievdata));
}
else{

System.out.println("Recieved Data  has  Error"
+ParityUtil.addParity(recievdata));
out.println("Recieved Data has  Error"
+ParityUtil.addParity(recievdata));
}

}


}