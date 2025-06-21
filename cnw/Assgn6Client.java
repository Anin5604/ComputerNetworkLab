import java.io.*;
import java.net.*;

public class Assgn6Client {
    public static void main(String[] args) {
        try {
            // Connect to the server at localhost on port 5000
            Socket socket = new Socket("localhost", 5000);
            
            // Read server response
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverResponse = input.readLine();
            
            System.out.println("Server Date & Time: " + serverResponse);

            // Close resources
            input.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
