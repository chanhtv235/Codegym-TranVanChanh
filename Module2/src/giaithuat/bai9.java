package giaithuat;

import java.util.Arrays;
import java.util.Scanner;

public class bai9 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("thuc hien cong viec cua mot chuoi");
        System.out.println("enter String");
        String  string= input.nextLine();
        System.out.println("Sau khi dao: "+reverse(string));
        System.out.println("In hoa:  "+string.toUpperCase());
        System.out.println("In thuong:  "+string.toLowerCase());
        System.out.println("In ra chuoi dao nguoc in hoa va in thuong: "+toReverseUpperLower(string));
    }
    public static String reverse(String string){
        char[]arr=string.toCharArray();
        for (int i=0;i<arr.length/2;i++){
            char temp=arr[i];
            arr[i]= arr[arr.length-1-i];
            arr[arr.length-1-i]=temp;
        }
        String str=new String(arr);
        return str;
    }
    public static String toReverseUpperLower(String string){
        char[] array = string.toCharArray();
        String temp = "";
        for(int i = 0; i < array.length; i++)
        {
            int ascii = (int)array[i];

            if(ascii >= 65 && ascii <= 90)
            {
                temp += (char)(ascii += 32);
            }
            else if(ascii >= 97 && ascii <= 122)
            {
                temp += (char)(ascii -= 32);
            }
            else
            {
                temp += (char)ascii;
            }
        }
        return temp;
    }
//    public static String toUpcase(String string){
//        String temp=string.toUpperCase();
//        return temp;
//    }
}
