package giaithuat;

import java.util.Scanner;

public class bai5 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        double S=0;
        System.out.println("S=1+1/3!+1/5!+…..+1/(2n-1)!");
        System.out.println("enter n");
        int n= input.nextInt();
        int giaiThua=1;
        for (int i=1;i<=n;i++){
            giaiThua*=(2*i-1);
            S+=(double)1/giaiThua;
        }
        System.out.println("S= "+S);
    }

}
