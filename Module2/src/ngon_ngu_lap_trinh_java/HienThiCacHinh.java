package ngon_ngu_lap_trinh_java;

import java.util.Scanner;

public class HienThiCacHinh {
    public static void main(String[] args) {
        int choice=1;
        while(choice!= 0) {
            Scanner input = new Scanner(System.in);
            System.out.println("Menu");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle");
            System.out.println("3. Print isosceles triangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    for (int i=0;i<6;i++){
                        for (int k=0;k<10;k++){
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    break;
                case 2:
                    for (int i=0;i<10;i++){
                        for (int k=0;k<=i;k++){
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    break;
                case 3:
                    for (int i=0;i<10;i++){
                        for (int k=0;k<=10-i;k++){
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
