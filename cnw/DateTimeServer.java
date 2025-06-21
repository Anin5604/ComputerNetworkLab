import java.util.*;
import java.net.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Period;

class DateTimeServer{
	public static void main(String args[]) throws IOException{
		ServerSocket serversocket=new ServerSocket(5000);
		System.out.println("Waiting For Client...");
		while(true){
		Socket socket=serversocket.accept();
		System.out.println("Client Connected..");
		BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
		String msg=in.readLine();
		if(msg.equalsIgnoreCase("RQST")){
			LocalDateTime now=LocalDateTime.now();
			DateTimeFormatter format=DateTimeFormatter.ofPattern("dd-MM-yyyy  hh-mm-ss");
			String time=format.format(now);
			Period p= Period.of(2,5,7);
			LocalDateTime beftime=now.minus(p);
			String btime=format.format(beftime);
			out.println("Current time: "+time+"\n bEFORE 2 YEARS 5 MONTHS 7 DAYS TIME:"+btime);
			

		}
		else{
			out.println("Please Send A request");


			}
		}


}




}