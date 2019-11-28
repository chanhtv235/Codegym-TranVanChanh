package giaithuat;

import java.util.Scanner;

public class bai6 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        double S=1;
        System.out.println("S=n!!");
        System.out.println("enter n");
        int n= input.nextInt();
        if (n % 2 == 0) {
            System.out.println("chan");
            for (int i=2;i<=n;i+=2) {
                System.out.println(i);
                S *= i;
            }
        }else {
            for (int i=1;i<=n;i+=2) {
                S *= i;
            }
        }
        System.out.println("S= "+S);
    }
}
