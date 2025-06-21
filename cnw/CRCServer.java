import java.util.*;
import java.net.*;
import java.io.*;

public class 	CRCServer{
public static void main(String args []) throws IOException{

ServerSocket serversocket=new ServerSocket(5000);
System.out.println("Waiting for client ...");
Socket client=serversocket.accept();
System.out.println("client connectd.");
String generator="1001";
BufferedReader dis=new BufferedReader(new InputStreamReader(client.getInputStream()));
String receiveddata=dis.readLine();
boolean calccodevalid=CRCUtil.isvaliddata(receiveddata,generator);
if(calccodevalid){


System.out.println("CORRECT DATA "+receiveddata);

}
else{
System.out.println("NOT CORRECT DATA "+receiveddata);

}
}




}