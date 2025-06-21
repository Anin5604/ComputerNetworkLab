import java.util.*;
import java.io.*;
import java.net.*;

public class StopWaitUtil
{

public static boolean isFramelost()
{
 
Random rand=new Random();

return rand.nextInt(10)<3;

}

public static boolean isAcklost()
{
 
 
Random rand=new Random();

return rand.nextInt(10)<2;

}


}