package ngon_ngu_lap_trinh_java;

import com.sun.org.apache.xpath.internal.objects.XNumber;

import java.util.Scanner;

public class KiemTraSoNguyenTo {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao 1 so can kiem tra :");
        int number = scanner.nextInt();
        if (number<2){
            System.out.println( number+"khong phai la so nguyen to");
        }else {
            int i = 2;
            boolean check = true;
            while (i <= Math.sqrt(number)) {
                if (number % i == 0) {
                    check = false;
                    break;
                }
                i++;
            }
            if (check)
                System.out.println(number + " la so nguyento");
            else
                System.out.println(number + " khong phai la so nguyen to");
        }
    }


}
