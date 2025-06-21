import java.util.*;
import java.net.*;
import java.io.*;

public class CRCUtil{
public static String  xor(String a,String b){
String result="";
int i,count;
for(i=0;i<a.length();i++){
result+=((a.charAt(i)==b.charAt(i))?'0':'1');
}
return result;
}
public static String createZeros(int count){
int i;
String zero="";
for(i=0;i<count;i++)
{
zero+='0';
}
return zero;
}
public static String Mod2div(String dividend, String divisor) {
    int pick = divisor.length();
    String tmp = dividend.substring(0, pick);

    while (pick < dividend.length()) {
        if (tmp.charAt(0) == '1') {
            tmp = xor(divisor, tmp) + dividend.charAt(pick);
        } else {
            tmp = xor(createZeros(divisor.length()), tmp) + dividend.charAt(pick);
        }
        tmp = tmp.substring(1); // FIXED: remove processed bit
        pick++;
    }

    // Final step
    if (tmp.charAt(0) == '1') {
        tmp = xor(divisor, tmp);
    } else {
        tmp = xor(createZeros(divisor.length()), tmp);
    }
    tmp = tmp.substring(1); // FIXED
    return tmp;
}

public static boolean isvaliddata(String data, String key) {
    // Only perform modulo division on received data (do NOT append zeros again)
    String remainder = Mod2div(data, key);
    System.out.println(">> Server calculated remainder: " + remainder); // Debug
    return !remainder.contains("1");
}

public static String encodedData(String data,String key){
String appendData=data+createZeros(key.length()-1);
String remainder=Mod2div(appendData,key);
return data+remainder;
}

}