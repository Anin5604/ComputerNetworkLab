import java.util.*;
import java.net.*;
import java.io.*;
public class CRCClient{
public static void main(String args[]) throws Exception{
Socket socket=new Socket("localhost",5000);

System.out.println("Server Connected..");
BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
System.out.println("Enter data:");
BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
String msg=input.readLine();
Scanner sc=new Scanner(System.in);
System.out.println("Do you want to inject error?yes/no : ");
String c=sc.next();
String generator="1001";
if (c.equalsIgnoreCase("yes")){
String msgwrong=CRCUtil.injectError(msg);

String codeword=CRCUtil.encodedCodeword(msgwrong,generator);
out.println(codeword);
String rem=codeword.substring(msgwrong.length(),codeword.length());
String outputserver=in.readLine();
System.out.println("Remainder gives : "+rem);
System.out.println("from server :"+outputserver);
}else{

String codeword=CRCUtil.encodedCodeword(msg,generator);
out.println(codeword);
String rem=codeword.substring(msg.length(),codeword.length());
String outputserver=in.readLine();
System.out.println("Remainder gives : "+rem);
System.out.println("from server :"+outputserver);

}
}




}