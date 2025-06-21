import java.io.*; //for input and output operations
import java.net.*; //for networking operations
public class RevereseServer{ //Server class to handle client requests and send back reversed strings
public static void main(String[] args){//Main method to start the server

int port=5000;//Port number on which the server will listen for incoming connections
try(ServerSocket serverSocket = new ServerSocket(port)){//Create a ServerSocket object to listen for incoming connections
System.out.println("Server is running \n");//Print a message indicating that the server is running
while(true){//Infinite loop to continuously accept client connections
Socket socket=serverSocket.accept();//Accept an incoming connection from a client
BufferedReader input=new BufferedReader(new InputStreamReader(socket.getInputStream())); //
PrintWriter output=new PrintWriter(socket.getOutputStream(),true);
String sentence=input.readLine(); // Read the sentence sent by the client
System.out.println("Recieve from client "+sentence); //Print the received sentence from the client
//UPPERCASE the received sentence using StringBuilder
//UPPERCASE CONVERT

String Reversesentence=(sentence).reverse().toString(); 
output.println(Reversesentence);//Send the reversed sentence back to the client
System.out.println("Sent to client "+Reversesentence); //Print the sent reversed sentence
//Close the socket connection after sending the response
socket.close();
}
}catch(IOException e){

e.printStackTrace();
}


}


}