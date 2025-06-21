import java.util.*;
import java.net.*;
import java.io.*;
import java.time.LocalDateTime;

class DatetimeClient{
public static void main(String args[]) throws Exception{

Socket socket=new Socket("localhost",6000);
BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
BufferedReader input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
System.out.println("Enter request(rqst) to show date and time : ");

String data=in.readLine();

out.println(data);
String msg;
while((msg=input.readLine())!=null){
System.out.println(msg);

}

socket.close();

}
}