import java.io.*;
import java.net.*;
public class UpperServer{
public static void main(String[] args){

int port=5000;
try(ServerSocket serverSocket = new ServerSocket(port)){
System.out.println("Server is running \n");
while(true){
Socket socket=serverSocket.accept();
BufferedReader input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
PrintWriter output=new PrintWriter(socket.getOutputStream(),true);
String sentence=input.readLine();
System.out.println("Recieve from client "+sentence);
String Reversesentence=new StringBuilder(sentence).toString().toUpperCase();
output.println(Reversesentence);
System.out.println("Sent to client "+Reversesentence);
socket.close();
}
}catch(IOException e){

e.printStackTrace();
}


}


}