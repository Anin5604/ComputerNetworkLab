import java.util.*;
import java.io.*;
import java.net.*;

public class StopWaitServer
{
public static void main (String args[])throws IOException{
ServerSocket ss=new ServerSocket(5000);
System.out.println("wait for client...");
Socket client=ss.accept();
BufferedReader in=new BufferedReader(ss.getInputStream());
PrintWriter out=new PrintWriter(ss.getOutputStream(),true);
String msgframe;

while((msgframe=in.readLine())!=null)
{
if(StopWaitUtil.isFramelost()){

	out.println("NACK");

	}else
	{
	out.println("ACK");


	}
	if(StopWaitUtil.isAcklost())
	{
	out.println("NACK");
	}
	else{
		out.println("ACK");
		}
}

}}}