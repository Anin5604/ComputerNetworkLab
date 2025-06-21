import java.io.*;
import java.net.*;

public class Client2 {
    public static void main(String[] args) {
        try {
            // Connect to the server at localhost on port 5001
            Socket socket = new Socket("localhost", 5001);

            // Read server response
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String currentDateTime = input.readLine();
            String pastDateTime = input.readLine();
            
            System.out.println("Server Current Date & Time: " + currentDateTime);
            System.out.println("Server Date & Time (3 years, 7 months, 19 days ago): " + pastDateTime);

            // Close resources
            input.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
