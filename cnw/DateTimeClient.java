import java.util.*;
import java.net.*;
import java.io.*;


import java.time.Period;

class DateTimeClient{
	public static void main(String args[]) throws IOException{
		
		Socket socket=new Socket("localhost",5000);
		System.out.println("Enter Request (RQST) to show time and date: ");
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
		String rqst=in.readLine();
		out.println(rqst);
		BufferedReader input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String time;
		while((time=input.readLine())!=null){

		System.out.println(time);
}
		
		input.close();

		
		
	}

}


