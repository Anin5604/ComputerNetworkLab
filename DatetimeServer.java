import java.util.*;
import java.net.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Period;
class DatetimeServer{
public static void main(String args[])throws Exception{
ServerSocket ss=new ServerSocket(6000);

System.out.println("Waiting for client...");
 Socket socket=ss.accept();
System.out.println("client connected ...");
BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
String msg=in.readLine();

if(msg.equalsIgnoreCase("RQST")){
LocalDateTime now=LocalDateTime.now() ;

DateTimeFormatter format=DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-SS"); 
String time=format.format(now);

System.out.println(time);
Period p=Period.of(2,5,7);
LocalDateTime t=now.minus(p);
String time1=format.format(t);
out.println("current date and time: "+time);
out.println("current date and time before 2 years 5 months 7 days :"+time1);
System.out.println(in.readLine());
String caps=msg.toUpperCase();

out.println("Capital :"+caps);
}
else{
out.println("please send request again ");

}

ss.close();
socket.close();

}
}