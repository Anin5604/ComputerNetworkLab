import java.io.*;
import java.net.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Server2 {
    public static void main(String[] args) {
        try {
            // Create a server socket on port 5001
            ServerSocket serverSocket = new ServerSocket(5001);
            System.out.println("Server is running...");

            while (true) {
                // Accept client connection
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Get current date & time
                LocalDateTime now = LocalDateTime.now();
                LocalDateTime pastDate = now.minusYears(3).minusMonths(7).minusDays(19);

                // Format dates
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String currentDateTime = now.format(formatter);
                String pastDateTime = pastDate.format(formatter);

                // Send response
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                output.println(currentDateTime);
                output.println(pastDateTime);

                // Close connection
                output.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
