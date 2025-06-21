import java.util.*;
import java.net.*;
import java.io.*;

 class ParityClient{

public static void main (String args[])throws Exception{
Socket socket=new Socket("localhost",5000);
BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
System.out.println("Enter Data: ");


String dta=input.readLine();
String codeword=ParityUtil.addParity(dta);String codeword2="110111";
System.out.println("code word:"+codeword);
out.println(codeword2);
String msg=in.readLine();
System.out.println("Server Says:"+msg);
}

} 