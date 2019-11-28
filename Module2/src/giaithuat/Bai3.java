package giaithuat;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        //S=1+1/2+1/3+....+1/n
        Scanner input=new Scanner(System.in);
        double S=0;
        System.out.println("S=1+1/2+1/3+....+1/n");
        System.out.println("enter n");
        int n= input.nextInt();
        for (int i=1;i<=n;i++){
            S+=(double)1/i;
        }
        System.out.println("S= "+S);
    }
}
