package giaithuat;

import java.lang.reflect.Array;
import java.util.Scanner;

public class bai7 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("m=234=> S=2+3+4=9, P=2*3*4=24");
        System.out.println("enter n");
        String  m= input.nextLine();
        double S=0;
        double P=1;
        //char[]arr =m.toCharArray();
        for (int i=0;i<m.length();i++){
            char s1=m.charAt(i);
           S+=Integer.parseInt(String.valueOf(s1));
           P*=Integer.parseInt(String.valueOf(s1));
        }
        System.out.printf("S= %f , P = %f ",S,P);

    }
}