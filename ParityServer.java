import java.util.*;
import java.net.*;
import java.io.*;

 class ParityServer{

public static void main (String args[]) throws Exception{
ServerSocket ss=new ServerSocket(5000);
System.out.println("Waiting for client..");
Socket  socket =ss.accept();
System.out.println("Client connected");
BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
PrintWriter out=new PrintWriter(socket.getOutputStream(),true);

String codedata=in.readLine();
System.out.println("Recieved code word:"+codedata);
boolean isvaliddata=ParityUtil.isValiddata(codedata);
char  Paritybit=ParityUtil.Paritybit(codedata);
if(isvaliddata){
out.println("Data parity calculated "+Paritybit);

}
else{
out.println("Data parity calculated wrong data"+Paritybit);
}




}
} 