package giaithuat;

import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        //S=15-1+1/2-1/3!+....+(-1)n  1/n!
        Scanner input=new Scanner(System.in);
        double S=15;
        System.out.println("S=15-1+1/2-1/3!+....+(-1)n  1/n!");
        System.out.println("enter n");
        int n= input.nextInt();
        int giaiThua_i=1;
        int amDuong=1;
        for (int i=1;i<=n;i++){
            amDuong*=-1;
            giaiThua_i*=i;
            S+=(double)amDuong*1/giaiThua_i;
        }
        System.out.println("S= "+S);
    }
}
