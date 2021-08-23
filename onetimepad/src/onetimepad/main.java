package onetimepad;
import java.util.*;
/**
 *
 * @author alifm
 */ 

public class main {
   public static void main(String args[]) {
      Scanner s = new Scanner(System.in);
      char[] text = new char[100];
      int[] asciiCode = new int[100];
      char[] key = {'T','H','E','K','T','H','E','K','T','H','E','K','T','H','E','K','T','H','E','K','T','H','E','K'};
      int[] encryptNum;
      int[] decryptNum;
      String encryptText = " ";
      String decryptText = " ";
      
      System.out.print("Enter text you want to cypher: ");
      String a = s.next();
      String temp = rep(a);
      
      for(int i =0;i<temp.length();i++){
          char character = temp.charAt(i);
          int ascii = (int) character;
          asciiCode[i] = ascii;
          System.out.println(asciiCode[i]);
      }
      
      text = temp.toCharArray();
      
      int num = text.length;
      
      char[] keyArray = new char[20];
      
      System.arraycopy(key, 0, keyArray, 0, num);
      
      String keyString = String.valueOf(keyArray);
      System.out.println(keyString);
      
      int[] asciiCodeKey = new int[20];
      
      for(int i =0;i<num;i++){
          char character2 = keyString.charAt(i);
          int ascii2 = (int) character2;
          asciiCodeKey[i] = ascii2;
          System.out.println(asciiCodeKey[i]);
      }
      
      for (int i = 0; i < num; i++){ 
         System.out.print(keyArray[i]+" ");
      }
      
      encryptNum = encrypt(asciiCode,asciiCodeKey,num);
      decryptNum = decrypt(asciiCodeKey,encryptNum,num);
      
      encryptText = asciiToString(encryptNum,num);
      System.out.println(" ");
      decryptText = asciiToString(decryptNum,num);
   }
   
   public static int[] encrypt(int[] asciiCode,int[] asciiCodeKey,int num)
   {
       int[] add = new int[num];
       int[] mod = new int[num];
       
       for(int i =0;i<add.length;i++)
       {
           add[i] = asciiCode[i]+asciiCodeKey[i];
           System.out.println(add[i]);
           if(add[i]>155)
               mod[i] = add[i]%91;
           else
               mod[i] = (add[i]-65);
           System.out.println(mod[i]);
       }
       return mod;
   }
   
   public static int[] decrypt(int[] asciiCodeKey,int[] encryptNum,int num)
   {
       int[] minus = new int[num];
       int[] mod = new int[num];
       
       for(int i=0;i<minus.length;i++)
       {
           minus[i] = encryptNum[i]-asciiCodeKey[i];
           System.out.println(minus[i]);
           if(minus[i]<0)
               mod[i]=minus[i]+91;
           else
               mod[i]=minus[i]+65;
           System.out.println(mod[i]);
       }   
       return mod;
   }
   
   public static String asciiToString(int[] encryptNum,int num){
       String str=" ";
       
       for(int i:encryptNum)
       {
           str = Character.toString((char)i);
           System.out.print(str);
       }
       return str;
   }
   
   
   public static String rep(String str) //Convert to UpperCase
	{
            
            for(int i=0;i<str.length();i++)
            {
		if(Character.isLowerCase(str.charAt(i)))
		{
                    str=str.substring(0,i)+str.substring(i, i+1).toUpperCase()+str.substring(i+1);
		}
            }
	System.out.println(str);
                return str;
	}
}
