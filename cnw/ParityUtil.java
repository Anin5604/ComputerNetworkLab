import java.util.*;
import java.io.*;
import java.net.*;
public class ParityUtil{
public static String addParity(String data){
int i, count=0;
char chars[]=data.toCharArray();
for(i=0;i<data.length();i++)
{
if(chars[i]=='1'){

count++;

}

}
char ch=(count%2==0)?'0':'1';
String encode=new String(chars)+ch;
return encode ;
}
public static boolean checkParity(String data){
int i,count=0;;char chars[]=data.toCharArray();
for(i=0;i<data.length();i++)
{
if(chars[i]=='1'){

count++;

}

}
return (count%2==0);
}




}
