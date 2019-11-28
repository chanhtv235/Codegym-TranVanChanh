package giaithuat;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.println("Enter month mm");
        int month=input.nextInt();
        System.out.println("Enter year yyyy");
        int year =input.nextInt();

        switch (month){
            case 2:
                if (leapYear(year)){
                    System.out.println("thang "+month+" nam"+year+" co 29 ngay");
                }else {
                    System.out.println("thang "+month+" nam "+year+" co 28 ngay");
                }
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("thang "+month+" nam "+year+" co 31 ngay ");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("thang "+month+" nam "+year+" co 30 ngay ");
                break;
            default:
                System.out.println(" Ban da nhap sai thang ");
        }
    }
    static boolean leapYear(int year){
        if (year%400==0){
            return true;
        }else if (year%4==0&&year%100!=0){
            return true;
        }else {
            return false;
        }
    }
}
