import java.util.*;
import java.net.*;
import java.io.*;

public class ParityUtil{
	public static String addParity(String data){
		int count=0;
		for(char ch:data.toCharArray()){
			if(ch=='1')
			{
			 count++;
				}
			
		}

		char paritybit=(count%2==0)?'0':'1';
		String encoded=data+paritybit;
	return encoded;
}
public static char Paritybit(String data){
		int count=0;
		for(char ch:data.toCharArray()){
			if(ch=='1')
			{
			 count++;
				}
			
		}

		char paritybit=(count%2==0)?'0':'1';
		return paritybit;
}
public static boolean isValiddata(String data){
		int count=0;
		for(char ch:data.toCharArray()){
			if(ch=='1')
			{
			 count++;
			}
			
		}

return (count%2==0);
}
} 