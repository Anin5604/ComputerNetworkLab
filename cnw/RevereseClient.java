import java.io.*;
import java.net.*;

public class RevereseClient {
    public static void main(String[] args) {
        String Address = "localhost";
        int port = 5000;
        try (Socket socket = new Socket(Address, port)) {
            BufferedReader userinput = new BufferedReader(new InputStreamReader(System.in)); // Reads user input from  the console.
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);// sends input to server
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Reads input from the  server.
            System.out.println("Enter Sentence :"); // Prompt the user to enter a sentence.
            String sentence = userinput.readLine(); // Read the sentence from the console.
            output.println(sentence); // Send the sentence to the server.
            System.out.println("Sent to server :" + sentence); // Print the sent sentence.

            String Revsentence = input.readLine(); // Read the reversed sentence from the server.
            System.out.println("Recieved from server :" + Revsentence); // Print the received reversed sentence.
         } catch (IOException e) { // Handle any IO exceptions that may occur during the socket connection or data // transmission.
          System.out.println("Error in connection"); // Print an error message if an exception occurs.
         e.printStackTrace(); // Print the stack trace of the exception for debugging purposes.
        }

    }

}