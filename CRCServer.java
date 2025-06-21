import java.util.*;
import java.net.*;
import java.io.*;
public class CRCServer{
public static void main(String args[]) throws Exception{
ServerSocket serversocket=new  ServerSocket(5000);
System.out.println("Waiting for Client..");
Socket client=serversocket.accept();
System.out.println("Client Connected..");
BufferedReader in=new BufferedReader(new InputStreamReader(client.getInputStream()));
PrintWriter out=new PrintWriter(client.getOutputStream(),true);

String generator="1001";
String recievedcodeword=in.readLine();
boolean validdata=CRCUtil.isValidData(recievedcodeword,generator);
String rem=CRCUtil. Mod2div(recievedcodeword,generator);
if(validdata){
out.println("Recieved correctly.. data "+recievedcodeword);
System.out.println("remainder calculated "+rem);
}
else{
out.println("not Recieved correctly.. data "+recievedcodeword);
System.out.println("remainder calculated "+rem);

}
}




}