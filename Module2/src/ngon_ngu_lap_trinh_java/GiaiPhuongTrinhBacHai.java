package ngon_ngu_lap_trinh_java;

import java.util.Scanner;

public class GiaiPhuongTrinhBacHai {
    public static void main(String args[]){
        System.out.println("Linear Equation Resolver");
        System.out.println("Given a equation as 'a * x + b = 0', please enter constants:");
        double a;
        double b;
        double x;
        Scanner scanner =new Scanner(System.in);
        System.out.println("Nhap vao a: ");
        a = scanner.nextFloat();
        System.out.println("Nhap vao b: ");
        b = scanner.nextFloat();
        if (a!=0){
            x=-b/a;
            System.out.printf("Nghiem cua phuong trinh la %f ",x);
        }else {
            if (b==0){
                System.out.println("Phuong trinh vo so nghiem");
            }else {
                System.out.println("Phuowng trinh vo nghiem");
            }
        }

        }


    }

