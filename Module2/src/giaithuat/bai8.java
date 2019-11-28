package giaithuat;

import java.util.Scanner;

public class bai8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("UCLN va BCNH");
        System.out.println("enter a");
        int a = input.nextInt();
        System.out.println("enter b");
        int b = input.nextInt();
        System.out.println("UCLN of ("+a+","+b+") ="+UCLN(a,b));
        System.out.println("BCNN of ("+a+","+b+") ="+a*b/UCLN(a,b));
    }
   public static int UCLN(int a,int b){
       if (a==0||b==0){
           return a+b;
       }
       else {
           while (a!=b){
               if (a>b){
                   a -=b;
               }else {
                    b-=a;
               }
           }return a;
       }
   }
}
