package ngon_ngu_lap_trinh_java;

import java.util.Scanner;

public class SuDungToanTu {
    public static void main(String args[]){
        float width;
        float height;
        Scanner nhap=new Scanner(System.in);
        System.out.println("Enter Wight");
        width=nhap.nextFloat();
        System.out.println("Enter height");
        height=nhap.nextFloat();
        float area=width*height;
        System.out.println("Area =" + area);
    }
}
