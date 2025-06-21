import java.net.*;
import java.io.*;
class timeclient{public static void main( String args[]) throws IOException{

Socket s=new Socket("localhost",5000);
BufferedReader input=new BufferedReader(new InputStreamReader(s.getInputStream()));
String time=input.readLine();
System.out.println(time);
input.close();
s.close();
}}