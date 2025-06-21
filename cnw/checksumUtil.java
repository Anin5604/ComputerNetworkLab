import java.util.*;

import java.net.*;
 import java.io.*;

public class checksumUtil{

public static int calculatedchecksum(String data){
int sum=0;
for(char ch : data.toCharArray())
{
sum=sum+(int) ch;

}
sum=(~sum);

return 0xFFFF & sum;

}


}
