import java.io.*;
import java.net.*;
import java.util.Date;

public class Assgn6Server {
    public static void main(String[] args) {
        try {
            // Create a server socket on port 5000
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server is running...");

            while (true) {
                // Accept client connection
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Send the current date & time
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                output.println(new Date().toString());

                // Close connection
                output.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
