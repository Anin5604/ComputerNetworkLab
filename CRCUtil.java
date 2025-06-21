import java.util.*;
import java.net.*;
import java.io.*;
public class CRCUtil{
public static String xor(String a,String b){
int i;
String result="";
for(i=0;i<b.length();i++)
{
 	result+=(a.charAt(i)==b.charAt(i))?"0":"1";
}
return result;
}
public static String Createzeros(int count){
	int i;
	String zero="";
	for(i=0;i<count;i++)
	{
 	zero+='0';
	}

return zero;
}
public static String Mod2div(String dividend,String divisor){
	int i;
	int pick=divisor.length();
	String tmp=dividend.substring(0,pick);
	while(pick<dividend.length()){
		if(tmp.charAt(0)=='1')
		   {
			tmp=xor(divisor,tmp)+dividend.charAt(pick);
		  }		

		else{
			tmp=xor(Createzeros(divisor.length()),tmp)+dividend.charAt(pick);
		}
		pick++;
	tmp=tmp.substring(1);
	}
	
        if(tmp.charAt(0)=='1')
		   {
			tmp=xor(divisor,tmp);
		  }		

		else{
			tmp=xor(Createzeros(divisor.length()),tmp);

		}

	return tmp.substring(1);
}
public static String injectError(String data){
Random rand=new Random();
char lastChar = data.charAt(data.length() - 1);
String wrongdata=data.substring(0,data.length()-3)+"010";

return wrongdata;
}
public static boolean isValidData(String data,String key){


String remainder = Mod2div(data,key);

return !remainder.contains("1");
}
public static String encodedCodeword(String data,String key){
String appendeddata=data+Createzeros(key.length()-1);
String remainder = Mod2div(appendeddata,key);
String encodeddata=data+remainder;
return encodeddata;
}


} 
