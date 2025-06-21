import java.util.*;
import java.io.*;
import java.net.*;

public class StopWaitClient
{
public static void main (String args[])throws IOException{
Socket s=new Socket("localhost",5000);

BufferedReader in=new BufferedReader(s.getInputStream());
PrintWriter out=new PrintWriter(s.getOutputStream(),true);
String msg=in.readLine();
int i=0;
String frame={"frame1","frame2","frame3","frame4","frame5"};
while(i<frame.length()){

out.println("FRAME :"+frame[i]);
if(msg.equalsIgnoreCase("ACK"){

out.println("Frame "+ i+"th"+frame[i]);

}
else{
out.println("not transmitted Frame "+ i+"th"+frame[i]);
}
i++;

}


}}}