package ngon_ngu_lap_trinh_java;

import java.util.Scanner;

public class ChuyenDoiTienTe{
    public static void main(String[] args) {
        final int rate=23000;
        Scanner input =new Scanner(System.in);
        System.out.println("Enter USD");
        int USD=input.nextInt();
        int VND=USD*rate;
        System.out.printf("%d USD = %d VND",USD,VND);
    }
}
